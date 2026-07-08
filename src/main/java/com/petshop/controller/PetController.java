package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.PetDTO;
import com.petshop.service.PetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pets")
@Validated
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> listarTodos() {
        return ResponseEntity.ok(petService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(petService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PetDTO> salvar(@Valid @RequestBody PetDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(petService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> atualizar(@PathVariable Long id,
                                            @Valid @RequestBody PetDTO dto) {

        return ResponseEntity.ok(petService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        petService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}