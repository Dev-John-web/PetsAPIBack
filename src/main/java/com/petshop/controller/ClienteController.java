package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.ClienteDTO;
import com.petshop.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {

        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {

        ClienteDTO dto = clienteService.buscarPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(
            @Valid @RequestBody ClienteDTO dto) {

        ClienteDTO cliente = clienteService.salvar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity.ok(
                clienteService.atualizar(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        clienteService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}