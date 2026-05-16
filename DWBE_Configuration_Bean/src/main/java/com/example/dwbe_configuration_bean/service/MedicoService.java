package com.example.dwbe_configuration_bean.service;


import com.example.dwbe_configuration_bean.dto.MedicoRequestDTO;
import com.example.dwbe_configuration_bean.dto.MedicoResponseDTO;
import com.example.dwbe_configuration_bean.dto.RegraNegocioException;
import com.example.dwbe_configuration_bean.model.Medico;
import com.example.dwbe_configuration_bean.repository.ConsultaRepository;
import com.example.dwbe_configuration_bean.repository.MedicoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MedicoService {
    private MedicoRepository medicoRepository;
    private ConsultaRepository consultaRepository;

    public MedicoService(MedicoRepository medicoRepository, ConsultaRepository consultaRepository){
        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;
    }

    private Medico toEntity(MedicoRequestDTO medicoRequestDTO){
        Medico user = new Medico();
        user.setNome(medicoRequestDTO.getNome());
        user.setEspecialidade(medicoRequestDTO.getEspecialidade());
        user.setCrm(medicoRequestDTO.getCrm());
        user.setConsultas(medicoRequestDTO.getConsultas());
        return user;
    }

    private MedicoResponseDTO toDTO(Medico medico){
        return MedicoResponseDTO.builder()
                .id(medico.getId())
                .nome(medico.getNome())
                .especialidade(medico.getEspecialidade())
                .crm(medico.getCrm())
                .consultas(medico.getConsultas())
                .build();
    }

    public MedicoResponseDTO salvar(MedicoRequestDTO medicoRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Medico medico = toEntity(medicoRequestDTO);
        Medico medicoSalvo = this.medicoRepository.save(medico);
        return toDTO(medicoSalvo);
    }

    public List<MedicoResponseDTO> todos(){
        return this.medicoRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public MedicoResponseDTO porId(Long id){
        Medico medico = this.medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Medico não encontrado"));
        return toDTO(medico);
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Medico não encontrado"));
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
        medico.setConsultas(dto.getConsultas());
        Medico atualizado = medicoRepository.save(medico);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Medico medico = this.medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Medico não encontrado"));
        this.medicoRepository.delete(medico);
        return "Excluído com sucesso";
    }
}
