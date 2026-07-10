package com.petshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petshop.DTO.ClienteDTO;
import com.petshop.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {

        ClienteDTO dto = service.buscarPorId(id);

        if (dto == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO dto) {

        return ResponseEntity.ok(service.salvar(dto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();

    }

}