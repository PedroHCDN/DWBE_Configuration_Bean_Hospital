package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Consulta;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConvenioResponseDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private List<Consulta> consultas;
}
