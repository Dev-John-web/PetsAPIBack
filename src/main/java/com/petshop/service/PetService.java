package com.petshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.petshop.DTO.PetDTO;
import com.petshop.entities.Cliente;
import com.petshop.entities.Pet;
import com.petshop.repository.ClienteRepository;
import com.petshop.repository.PetRepository;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final ClienteRepository clienteRepository;

    public PetService(PetRepository petRepository,
                      ClienteRepository clienteRepository) {

        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;

    }

    public List<PetDTO> listarTodos() {

        return petRepository.findAll()
                .stream()
                .map(PetDTO::convertToDTO)
                .collect(Collectors.toList());

    }

    public PetDTO buscarPorId(Long id) {

        return petRepository.findById(id)
                .map(PetDTO::convertToDTO)
                .orElse(null);

    }

    public PetDTO salvar(PetDTO dto) {

        Pet pet = PetDTO.convertToEntity(dto);

        if (dto.getClienteId() != null) {

            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow(() ->
                            new RuntimeException("Cliente não encontrado."));

            pet.setCliente(cliente);

        }

        pet = petRepository.save(pet);

        return PetDTO.convertToDTO(pet);

    }

    public PetDTO atualizar(Long id, PetDTO dto) {

        Pet pet = PetDTO.convertToEntity(dto);

        pet.setId(id);

        if (dto.getClienteId() != null) {

            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow(() ->
                            new RuntimeException("Cliente não encontrado."));

            pet.setCliente(cliente);

        }

        pet = petRepository.save(pet);

        return PetDTO.convertToDTO(pet);

    }

    public void deletar(Long id) {

        petRepository.deleteById(id);

    }

}