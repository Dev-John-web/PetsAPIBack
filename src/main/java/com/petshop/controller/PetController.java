package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.PetDTO;
import com.petshop.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<PetDTO> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/{id}")
    public PetDTO buscarPorId(@PathVariable Long id) {
        return petService.buscarPorId(id);
    }

    @PostMapping
    public PetDTO salvar(@RequestBody PetDTO petDTO) {
        return petService.salvar(petDTO);
    }

    @PutMapping("/{id}")
    public PetDTO atualizar(@PathVariable Long id,
                            @RequestBody PetDTO petDTO) {

        return petService.atualizar(id, petDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        petService.deletar(id);
    }
}