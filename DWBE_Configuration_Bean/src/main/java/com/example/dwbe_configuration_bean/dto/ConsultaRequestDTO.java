package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Convenio;
import com.example.dwbe_configuration_bean.model.Medico;
import com.example.dwbe_configuration_bean.model.Paciente;
import com.example.dwbe_configuration_bean.model.Receita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDTO {
    private Long id;
    private Date dataHora;
    private String motivo;
    private Double valor;
    private Paciente paciente;
    private Medico medico;
    private Convenio convenio;
    private Receita receita;
}
