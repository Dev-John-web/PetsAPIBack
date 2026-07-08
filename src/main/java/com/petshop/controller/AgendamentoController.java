package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.AgendamentoDTO;
import com.petshop.service.AgendamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public List<AgendamentoDTO> listarTodos() {
        return agendamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public AgendamentoDTO buscarPorId(@PathVariable Long id) {
        return agendamentoService.buscarPorId(id);
    }

    @PostMapping
    public AgendamentoDTO salvar(@Valid @RequestBody AgendamentoDTO agendamentoDTO) {
        return agendamentoService.salvar(agendamentoDTO);
    }

    @PutMapping("/{id}")
    public AgendamentoDTO atualizar(@PathVariable Long id,
                                    @Valid @RequestBody AgendamentoDTO agendamentoDTO) {

        return agendamentoService.atualizar(id, agendamentoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
    }
}