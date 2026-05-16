package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Consulta;
import com.example.dwbe_configuration_bean.model.Prontuario;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Prontuario prontuario;
    private List<Consulta> consultas;
}
