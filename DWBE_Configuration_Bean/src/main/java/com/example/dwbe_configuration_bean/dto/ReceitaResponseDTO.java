package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaResponseDTO {
    private Long id;
    private String medicamento;
    private String dosagem;
    private Integer duracaoDias;
    private Consulta consulta;
}
