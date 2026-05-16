package com.example.dwbe_configuration_bean.controller;


import com.example.dwbe_configuration_bean.dto.ConsultaRequestDTO;
import com.example.dwbe_configuration_bean.dto.ConsultaResponseDTO;
import com.example.dwbe_configuration_bean.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService){
        this.consultaService = consultaService;
    }
    @PostMapping
    public ConsultaResponseDTO salvar(@RequestBody @Valid ConsultaRequestDTO consulta){
        return this.consultaService.salvar(consulta);
    }
    @GetMapping("{id}")
    public ConsultaResponseDTO porId(@PathVariable Long id){
        return this.consultaService.porId(id);
    }
    @GetMapping
    public List<ConsultaResponseDTO> todos(){
        return this.consultaService.todos();
    }
    @PutMapping("{id}")
    public ConsultaResponseDTO atualiar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO consulta){
        return this.consultaService.atualizar(id, consulta);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id){
        return this.consultaService.exclui(id);
    }
}
