package com.example.dwbe_configuration_bean.controller;


import com.example.dwbe_configuration_bean.dto.ReceitaRequestDTO;
import com.example.dwbe_configuration_bean.dto.ReceitaResponseDTO;
import com.example.dwbe_configuration_bean.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    private ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }
    @PostMapping
    public ReceitaResponseDTO salvar(@RequestBody @Valid ReceitaRequestDTO receita){
        return this.receitaService.salvar(receita);
    }
    @GetMapping("{id}")
    public ReceitaResponseDTO porId(@PathVariable Long id){
        return this.receitaService.porId(id);
    }
    @GetMapping
    public List<ReceitaResponseDTO> todos(){
        return this.receitaService.todos();
    }
    @PutMapping("{id}")
    public ReceitaResponseDTO atualiar(@PathVariable Long id, @RequestBody @Valid ReceitaRequestDTO receita){
        return this.receitaService.atualizar(id, receita);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id){
        return this.receitaService.exclui(id);
    }
}
