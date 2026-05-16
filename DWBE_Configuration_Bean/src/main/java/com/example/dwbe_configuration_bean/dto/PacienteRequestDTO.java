package com.example.dwbe_configuration_bean.dto;


import com.example.dwbe_configuration_bean.model.Consulta;
import com.example.dwbe_configuration_bean.model.Prontuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteRequestDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private Prontuario prontuario;
    private List<Consulta> consultas;
}
