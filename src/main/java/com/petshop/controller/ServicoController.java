package com.petshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petshop.DTO.ServicoDTO;
import com.petshop.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> buscar(@PathVariable Long id) {

        ServicoDTO dto = service.buscarPorId(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<ServicoDTO> salvar(@RequestBody ServicoDTO dto) {

        return ResponseEntity.ok(service.salvar(dto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> atualizar(@PathVariable Long id,
                                                @RequestBody ServicoDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();

    }

}