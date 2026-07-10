package com.petshop.DTO;

import com.petshop.entities.Pet;

public class PetDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String raca;
    private Long clienteId;

    public PetDTO() {
    }

    public PetDTO(Long id, String nome, String tipo, String raca, Long clienteId) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.clienteId = clienteId;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public static PetDTO convertToDTO(Pet pet) {

        Long clienteId = null;

        if (pet.getCliente() != null) {
            clienteId = pet.getCliente().getId();
        }

        return new PetDTO(
                pet.getId(),
                pet.getNome(),
                pet.getTipo(),
                pet.getRaca(),
                clienteId);

    }

    public static Pet convertToEntity(PetDTO dto) {

        Pet pet = new Pet();

        pet.setId(dto.getId());
        pet.setNome(dto.getNome());
        pet.setTipo(dto.getTipo());
        pet.setRaca(dto.getRaca());

        return pet;

    }

}