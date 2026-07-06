package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petshop.entities.Pet;
import com.petshop.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pet buscarPorId(@PathVariable Long id) {
        return petService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Pet salvar(@RequestBody Pet pet) {
        return petService.salvar(pet);
    }

    @PutMapping("/{id}")
    public Pet atualizar(@PathVariable Long id, @RequestBody Pet pet) {
        pet.setId(id);
        return petService.atualizar(pet);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        petService.deletar(id);
    }
}