package com.petshop.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AgendamentoDTO {

    private Long id;
    
    @NotNull(message = "A data é obrigatória.")
    @Future(message = "A data deve ser futura.")
    private LocalDateTime dataHora;

    @NotNull(message = "O pet é obrigatório.")
    private Long petId;

    @NotNull(message = "O serviço é obrigatório.")
    private Long servicoId;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, LocalDateTime dataHora, Long petId, Long servicoId) {
        this.id = id;
        this.dataHora = dataHora;
        this.petId = petId;
        this.servicoId = servicoId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}
    
    
}