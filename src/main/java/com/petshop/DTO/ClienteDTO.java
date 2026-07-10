package com.petshop.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.petshop.entities.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private List<PetDTO> pets = new ArrayList<>();

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PetDTO> getPets() {
        return pets;
    }

    public void setPets(List<PetDTO> pets) {
        this.pets = pets;
    }

    public static ClienteDTO convertToDTO(Cliente cliente) {

        ClienteDTO dto = new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail());

        if (cliente.getPets() != null) {

            dto.setPets(cliente.getPets()
                    .stream()
                    .map(PetDTO::convertToDTO)
                    .collect(Collectors.toList()));

        }

        return dto;

    }

    public static Cliente convertToEntity(ClienteDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());

        return cliente;

    }

}