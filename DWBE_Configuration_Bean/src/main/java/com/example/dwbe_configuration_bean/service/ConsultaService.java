package com.example.dwbe_configuration_bean.service;



import com.example.dwbe_configuration_bean.dto.ConsultaRequestDTO;
import com.example.dwbe_configuration_bean.dto.ConsultaResponseDTO;
import com.example.dwbe_configuration_bean.dto.RegraNegocioException;
import com.example.dwbe_configuration_bean.model.Consulta;
import com.example.dwbe_configuration_bean.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;
    private ReceitaRepository receitaRepository;
    private ConvenioRepository convenioRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository, ConvenioRepository convenioRepository){
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.receitaRepository = receitaRepository;
        this.convenioRepository = convenioRepository;
    }

    private Consulta toEntity(ConsultaRequestDTO consultaRequestDTO){
        Consulta user = new Consulta();
        user.setDataHora(consultaRequestDTO.getDataHora());
        user.setMotivo(consultaRequestDTO.getMotivo());
        user.setValor(consultaRequestDTO.getValor());
        user.setPaciente(consultaRequestDTO.getPaciente());
        user.setMedico(consultaRequestDTO.getMedico());
        user.setConvenio(consultaRequestDTO.getConvenio());
        user.setReceita(consultaRequestDTO.getReceita());
        return user;
    }

    private ConsultaResponseDTO toDTO(Consulta consulta){
        return ConsultaResponseDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .motivo(consulta.getMotivo())
                .valor(consulta.getValor())
                .paciente(consulta.getPaciente())
                .medico(consulta.getMedico())
                .convenio(consulta.getConvenio())
                .receita(consulta.getReceita())
                .build();
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO consultaRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Consulta consulta = toEntity(consultaRequestDTO);
        Consulta consultaSalvo = this.consultaRepository.save(consulta);
        return toDTO(consultaSalvo);
    }

    public List<ConsultaResponseDTO> todos(){
        return this.consultaRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ConsultaResponseDTO porId(Long id){
        Consulta consulta = this.consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada"));
        return toDTO(consulta);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada"));
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());
        consulta.setPaciente(dto.getPaciente());
        consulta.setMedico(dto.getMedico());
        consulta.setConvenio(dto.getConvenio());
        consulta.setReceita(dto.getReceita());
        Consulta atualizado = consultaRepository.save(consulta);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Consulta consulta = this.consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada"));
        this.consultaRepository.delete(consulta);
        return "Excluído com sucesso";
    }
}
