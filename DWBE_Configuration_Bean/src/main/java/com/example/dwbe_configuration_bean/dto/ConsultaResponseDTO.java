package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Convenio;
import com.example.dwbe_configuration_bean.model.Medico;
import com.example.dwbe_configuration_bean.model.Paciente;
import com.example.dwbe_configuration_bean.model.Receita;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ConsultaResponseDTO {
    private Long id;
    private Date dataHora;
    private String motivo;
    private Double valor;
    private Paciente paciente;
    private Medico medico;
    private Convenio convenio;
    private Receita receita;
}
