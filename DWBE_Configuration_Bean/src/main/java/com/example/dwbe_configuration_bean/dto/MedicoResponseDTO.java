package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Consulta;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String especialidade;
    private String crm;
    private List<Consulta> consultas;
}
