package com.example.dwbe_configuration_bean.service;


import com.example.dwbe_configuration_bean.dto.ReceitaRequestDTO;
import com.example.dwbe_configuration_bean.dto.ReceitaResponseDTO;
import com.example.dwbe_configuration_bean.dto.RegraNegocioException;
import com.example.dwbe_configuration_bean.model.Receita;
import com.example.dwbe_configuration_bean.repository.ConsultaRepository;
import com.example.dwbe_configuration_bean.repository.ReceitaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReceitaService {
    private ReceitaRepository receitaRepository;
    private ConsultaRepository consultaRepository;

    public ReceitaService(ReceitaRepository receitaRepository, ConsultaRepository consultaRepository){
        this.receitaRepository = receitaRepository;
        this.consultaRepository = consultaRepository;
    }

    private Receita toEntity(ReceitaRequestDTO receitaRequestDTO){
        Receita user = new Receita();
        user.setMedicamento(receitaRequestDTO.getMedicamento());
        user.setDosagem(receitaRequestDTO.getDosagem());
        user.setDuracaoDias(receitaRequestDTO.getDuracaoDias());
        user.setConsulta(receitaRequestDTO.getConsulta());
        return user;
    }

    private ReceitaResponseDTO toDTO(Receita receita){
        return ReceitaResponseDTO.builder()
                .id(receita.getId())
                .medicamento(receita.getMedicamento())
                .dosagem(receita.getDosagem())
                .duracaoDias(receita.getDuracaoDias())
                .consulta(receita.getConsulta())
                .build();
    }

    public ReceitaResponseDTO salvar(ReceitaRequestDTO receitaRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Receita receita = toEntity(receitaRequestDTO);
        Receita receitaSalva = this.receitaRepository.save(receita);
        return toDTO(receitaSalva);
    }

    public List<ReceitaResponseDTO> todos(){
        return this.receitaRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ReceitaResponseDTO porId(Long id){
        Receita receita = this.receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
        return toDTO(receita);
    }

    public ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto){
        Receita receita = receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
        receita.setMedicamento(dto.getMedicamento());
        receita.setDosagem(dto.getDosagem());
        receita.setDuracaoDias(dto.getDuracaoDias());
        receita.setConsulta(dto.getConsulta());
        Receita atualizado = receitaRepository.save(receita);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Receita receita = this.receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
        this.receitaRepository.delete(receita);
        return "Excluído com sucesso";
    }
}
