package com.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.PetDTO;
import com.petshop.entities.Cliente;
import com.petshop.entities.Pet;
import com.petshop.exception.ResourceNotFoundException;
import com.petshop.repository.ClienteRepository;
import com.petshop.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Entity -> DTO
    private PetDTO converterDTO(Pet pet) {

        Long clienteId = null;

        if (pet.getCliente() != null) {
            clienteId = pet.getCliente().getId();
        }

        return new PetDTO(
                pet.getId(),
                pet.getNome(),
                pet.getTipo(),
                pet.getRaca(),
                clienteId
        );
    }

    // DTO -> Entity
    private Pet converterEntity(PetDTO dto) {

        Pet pet = new Pet();

        pet.setId(dto.getId());
        pet.setNome(dto.getNome());
        pet.setTipo(dto.getTipo());
        pet.setRaca(dto.getRaca());

        if (dto.getClienteId() != null) {

            Cliente cliente = clienteRepository
                    .findById(dto.getClienteId())
                    .orElse(null);

            pet.setCliente(cliente);
        }

        return pet;
    }

    // Listar todos
    public List<PetDTO> listarTodos() {

        List<Pet> pets = petRepository.findAll();
        List<PetDTO> petsDTO = new ArrayList<>();

        for (Pet pet : pets) {
            petsDTO.add(converterDTO(pet));
        }

        return petsDTO;
    }

    // Buscar por ID
    public PetDTO buscarPorId(Long id) {

        Pet pet = petRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Pet não encontrado."));

        if (pet == null) {
            return null;
        }

        return converterDTO(pet);
    }

    // Salvar
    public PetDTO salvar(PetDTO dto) {

        Pet pet = converterEntity(dto);

        pet = petRepository.save(pet);

        return converterDTO(pet);
    }

    // Atualizar
    public PetDTO atualizar(Long id, PetDTO dto) {

        Pet pet = converterEntity(dto);

        pet.setId(id);

        pet = petRepository.save(pet);

        return converterDTO(pet);
    }

    // Deletar
    public void deletar(Long id) {
        petRepository.deleteById(id);
    }

}