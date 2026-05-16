package com.example.dwbe_configuration_bean.controller;


import com.example.dwbe_configuration_bean.dto.MedicoRequestDTO;
import com.example.dwbe_configuration_bean.dto.MedicoResponseDTO;
import com.example.dwbe_configuration_bean.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }
    @PostMapping
    public MedicoResponseDTO salvar(@RequestBody @Valid MedicoRequestDTO medico){
        return this.medicoService.salvar(medico);
    }
    @GetMapping("{id}")
    public MedicoResponseDTO porId(@PathVariable Long id){
        return this.medicoService.porId(id);
    }
    @GetMapping
    public List<MedicoResponseDTO> todos(){
        return this.medicoService.todos();
    }
    @PutMapping("{id}")
    public MedicoResponseDTO atualiar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO medico){
        return this.medicoService.atualizar(id, medico);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id){
        return this.medicoService.exclui(id);
    }
}
