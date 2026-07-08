package com.petshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PetDTO {

    private Long id;
    
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O tipo é obrigatório.")
    private String tipo;

    @NotBlank(message = "A raça é obrigatória.")
    private String raca;

    @NotNull(message = "O cliente é obrigatório.")
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
}
