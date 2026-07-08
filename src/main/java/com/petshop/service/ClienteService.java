package com.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.ClienteDTO;
import com.petshop.entities.Cliente;
import com.petshop.exception.ResourceNotFoundException;
import com.petshop.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Entity -> DTO
    private ClienteDTO converterDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }

    // DTO -> Entity
    private Cliente converterEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());

        return cliente;
    }

    // Listar todos
    public List<ClienteDTO> listarTodos() {

        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clientesDTO.add(converterDTO(cliente));
        }

        return clientesDTO;
    }

    // Buscar por ID
    public ClienteDTO buscarPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Cliente não encontrado."));

        if (cliente == null) {
            return null;
        }

        return converterDTO(cliente);
    }

    // Salvar
    public ClienteDTO salvar(ClienteDTO dto) {

        Cliente cliente = converterEntity(dto);

        cliente = clienteRepository.save(cliente);

        return converterDTO(cliente);
    }

    // Atualizar
    public ClienteDTO atualizar(Long id, ClienteDTO dto) {

        Cliente cliente = converterEntity(dto);
        cliente.setId(id);

        cliente = clienteRepository.save(cliente);

        return converterDTO(cliente);
    }

    // Deletar
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

}