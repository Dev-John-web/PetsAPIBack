package com.petshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petshop.DTO.AgendamentoDTO;
import com.petshop.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> buscar(@PathVariable Long id) {

        AgendamentoDTO dto = service.buscarPorId(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> salvar(@RequestBody AgendamentoDTO dto) {

        return ResponseEntity.ok(service.salvar(dto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> atualizar(@PathVariable Long id,
                                                    @RequestBody AgendamentoDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();

    }

}