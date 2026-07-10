package com.petshop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.petshop.DTO.ClienteDTO;
import com.petshop.entities.Cliente;
import com.petshop.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<ClienteDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(ClienteDTO::convertToDTO)
                .collect(Collectors.toList());

    }

    public ClienteDTO buscarPorId(Long id) {

        Optional<Cliente> cliente = repository.findById(id);

        return cliente
                .map(ClienteDTO::convertToDTO)
                .orElse(null);

    }

    public ClienteDTO salvar(ClienteDTO dto) {

        Cliente cliente = ClienteDTO.convertToEntity(dto);

        cliente = repository.save(cliente);

        return ClienteDTO.convertToDTO(cliente);

    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {

        Cliente cliente = ClienteDTO.convertToEntity(dto);

        cliente.setId(id);

        cliente = repository.save(cliente);

        return ClienteDTO.convertToDTO(cliente);

    }

    public void deletar(Long id) {

        repository.deleteById(id);

    }

}