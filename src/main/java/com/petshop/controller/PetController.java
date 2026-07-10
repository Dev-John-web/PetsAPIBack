package com.petshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petshop.DTO.PetDTO;
import com.petshop.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> buscar(@PathVariable Long id) {

        PetDTO dto = service.buscarPorId(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<PetDTO> salvar(@RequestBody PetDTO dto) {

        return ResponseEntity.ok(service.salvar(dto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> atualizar(@PathVariable Long id,
                                            @RequestBody PetDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();

    }

}