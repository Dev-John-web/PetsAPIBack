package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.ServicoDTO;
import com.petshop.service.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/servicos")
@Validated
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listarTodos() {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> salvar(@Valid @RequestBody ServicoDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicoService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> atualizar(@PathVariable Long id,
                                                @Valid @RequestBody ServicoDTO dto) {

        return ResponseEntity.ok(servicoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        servicoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}