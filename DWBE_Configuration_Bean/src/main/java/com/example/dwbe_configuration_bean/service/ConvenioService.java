package com.example.dwbe_configuration_bean.service;


import com.example.dwbe_configuration_bean.dto.ConvenioRequestDTO;
import com.example.dwbe_configuration_bean.dto.ConvenioResponseDTO;
import com.example.dwbe_configuration_bean.dto.RegraNegocioException;
import com.example.dwbe_configuration_bean.model.Convenio;
import com.example.dwbe_configuration_bean.repository.ConsultaRepository;
import com.example.dwbe_configuration_bean.repository.ConvenioRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConvenioService {
    private ConvenioRepository convenioRepository;
    private ConsultaRepository consultaRepository;

    public ConvenioService(ConvenioRepository convenioRepository, ConsultaRepository consultaRepository){
        this.convenioRepository = convenioRepository;
        this.consultaRepository = consultaRepository;
    }

    private Convenio toEntity(ConvenioRequestDTO convenioRequestDTO){
        Convenio user = new Convenio();
        user.setNome(convenioRequestDTO.getNome());
        user.setCnpj(convenioRequestDTO.getCnpj());
        return user;
    }

    private ConvenioResponseDTO toDTO(Convenio convenio){
        return ConvenioResponseDTO.builder()
                .id(convenio.getId())
                .nome(convenio.getNome())
                .cnpj(convenio.getCnpj())
                .build();
    }

    public ConvenioResponseDTO salvar(ConvenioRequestDTO convenioRequestDTO){
        //Nada pra verifica, ja que não tem obrigatorio
        Convenio convenio = toEntity(convenioRequestDTO);
        Convenio convenioSalvo = this.convenioRepository.save(convenio);
        return toDTO(convenioSalvo);
    }

    public List<ConvenioResponseDTO> todos(){
        return this.convenioRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ConvenioResponseDTO porId(Long id){
        Convenio convenio = this.convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convenio não encontrado"));
        return toDTO(convenio);
    }

    public ConvenioResponseDTO atualizar(Long id, ConvenioRequestDTO dto){
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convenio não encontrado"));
        convenio.setNome(dto.getNome());
        convenio.setCnpj(dto.getCnpj());
        Convenio atualizado = convenioRepository.save(convenio);
        return toDTO(atualizado);
    }

    public String exclui(Long id){
        Convenio convenio = this.convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convenio não encontrado"));
        this.convenioRepository.delete(convenio);
        return "Excluído com sucesso";
    }
}
