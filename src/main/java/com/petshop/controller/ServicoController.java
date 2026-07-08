package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.ServicoDTO;
import com.petshop.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<ServicoDTO> listarTodos() {
        return servicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ServicoDTO buscarPorId(@PathVariable Long id) {
        return servicoService.buscarPorId(id);
    }

    @PostMapping
    public ServicoDTO salvar(@RequestBody ServicoDTO servicoDTO) {
        return servicoService.salvar(servicoDTO);
    }

    @PutMapping("/{id}")
    public ServicoDTO atualizar(@PathVariable Long id,
                                @RequestBody ServicoDTO servicoDTO) {

        return servicoService.atualizar(id, servicoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        servicoService.deletar(id);
    }
}