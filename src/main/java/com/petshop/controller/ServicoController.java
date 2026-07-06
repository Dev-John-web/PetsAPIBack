package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petshop.entities.Servico;
import com.petshop.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> listarTodos() {
        return servicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Servico buscarPorId(@PathVariable Long id) {
        return servicoService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Servico salvar(@RequestBody Servico servico) {
        return servicoService.salvar(servico);
    }

    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody Servico servico) {
        servico.setId(id);
        return servicoService.atualizar(servico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        servicoService.deletar(id);
    }
}