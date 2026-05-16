package com.example.dwbe_configuration_bean.controller;


import com.example.dwbe_configuration_bean.dto.*;
import com.example.dwbe_configuration_bean.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("bean")
public class BeanController {

    @Autowired
    @Qualifier("Paciente")
    private Paciente pacientePadrao;

    @Autowired
    @Qualifier("Prontuario")
    private Prontuario prontuarioPadrao;

    @Autowired
    @Qualifier("Consulta")
    private Consulta consultaPadrao;

    @Autowired
    @Qualifier("Medico")
    private Medico medicoPadrao;

    @Autowired
    @Qualifier("Convenio")
    private Convenio convenioPadrao;

    @Autowired
    @Qualifier("Receita")
    private Receita receitaPadrao;

    @GetMapping
    public Paciente getPaciente() {
        pacientePadrao.setProntuario(prontuarioPadrao);
        List<Consulta> consultas = new ArrayList<>();
        consultaPadrao.setMedico(medicoPadrao);
        consultaPadrao.setConvenio(convenioPadrao);
        consultaPadrao.setReceita(receitaPadrao);
        consultas.add(consultaPadrao);
        pacientePadrao.setConsultas(consultas);
        return pacientePadrao;
    }
}
