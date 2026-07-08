package com.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petshop.dto.ClienteDTO;
import com.petshop.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ClienteDTO salvar(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.salvar(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizar(@PathVariable Long id,
                                @RequestBody ClienteDTO clienteDTO) {

        return clienteService.atualizar(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}