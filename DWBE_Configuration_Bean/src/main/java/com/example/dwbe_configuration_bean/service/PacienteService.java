package com.example.dwbe_configuration_bean.service;


import com.example.dwbe_configuration_bean.dto.PacienteRequestDTO;
import com.example.dwbe_configuration_bean.dto.PacienteResponseDTO;
import com.example.dwbe_configuration_bean.dto.RegraNegocioException;
import com.example.dwbe_configuration_bean.model.Paciente;
import com.example.dwbe_configuration_bean.repository.ConsultaRepository;
import com.example.dwbe_configuration_bean.repository.PacienteRepository;
import com.example.dwbe_configuration_bean.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;
    private ProntuarioRepository prontuarioRepository;
    private ConsultaRepository consultaRepository;

    public PacienteService(PacienteRepository pacienteRepository, ProntuarioRepository prontuarioRepository, ConsultaRepository consultaRepository){
        this.pacienteRepository = pacienteRepository;
        this.prontuarioRepository = prontuarioRepository;
        this.consultaRepository = consultaRepository;
    }

    private Paciente toEntity(PacienteRequestDTO pacienteRequestDTO){
        Paciente user = new Paciente();
        user.setNome(pacienteRequestDTO.getNome());
        user.setCpf(pacienteRequestDTO.getCpf());
        user.setTelefone(pacienteRequestDTO.getTelefone());
        user.setProntuario(pacienteRequestDTO.getProntuario());
        user.setConsultas(pacienteRequestDTO.getConsultas());
        return user;
    }

    private PacienteResponseDTO toDTO(Paciente paciente){
        return PacienteResponseDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .cpf(paciente.getCpf())
                .telefone(paciente.getTelefone())
                .prontuario(paciente.getProntuario())
                .consultas(paciente.getConsultas())
                .build();
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO pacienteRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Paciente paciente = toEntity(pacienteRequestDTO);
        Paciente pacienteSalvo = this.pacienteRepository.save(paciente);
        return toDTO(pacienteSalvo);
    }

    public List<PacienteResponseDTO> todos(){
        return this.pacienteRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public PacienteResponseDTO porId(Long id){
        Paciente paciente = this.pacienteRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado"));
        return toDTO(paciente);
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado"));
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        paciente.setProntuario(dto.getProntuario());
        paciente.setConsultas(dto.getConsultas());
        Paciente atualizado = pacienteRepository.save(paciente);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Paciente paciente = this.pacienteRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado"));
        this.pacienteRepository.delete(paciente);
        return "Excluído com sucesso";
    }
}
