package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvenioRequestDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private List<Consulta> consultas;
}
