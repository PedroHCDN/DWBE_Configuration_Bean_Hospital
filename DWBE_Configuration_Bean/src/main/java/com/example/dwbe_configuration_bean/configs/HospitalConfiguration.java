package com.example.dwbe_configuration_bean.configs;


import com.example.dwbe_configuration_bean.dto.*;
import com.example.dwbe_configuration_bean.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HospitalConfiguration {

    @Bean("Paciente")
    public Paciente getPacientePadrao() {
        Paciente p = new Paciente();
        p.setNome("Paciente Padrão");
        p.setCpf("1234-5678-10");
        p.setTelefone("1111-2222");

        return p;
    }

    @Bean("Prontuario")
    public Prontuario getProntuarioPadrao() {
        Prontuario p = new Prontuario();
        p.setAlergia("Alergia Padrão");
        p.setObservacoes("Observações Teste");
        p.setTipoSanguineo("P+");

        return p;
    }

    @Bean(name = "Consulta")
    public Consulta getConsultaPadrao() {
        Consulta c = new Consulta();
        c.setId(1L);
        c.setDataHora(java.sql.Date.valueOf("2023-04-27"));
        c.setMotivo("Motivo padrão");
        c.setValor(10.00);

        return c;
    }

    @Bean("Medico")
    public Medico getMedicoPadrao() {
        Medico m = new Medico();
        m.setId(1L);
        m.setNome("Medico Padrão");
        m.setEspecialidade("Especialidade Padrão");
        m.setCrm("CRM Padrão");

        return m;
    }

    @Bean("Convenio")
    public Convenio getConvenioPadrao() {
        Convenio c = new Convenio();
        c.setId(1L);
        c.setNome("Covenio Padrão");
        c.setCnpj("CNPJ Padrão");

        return c;
    }

    @Bean("Receita")
    public Receita getReceitaPadrao() {
        Receita r = new Receita();
        r.setId(1L);
        r.setMedicamento("Medicamento Padrão");
        r.setDosagem("Dosagem Padrão");
        r.setDuracaoDias(4);

        return r;
    }
}
