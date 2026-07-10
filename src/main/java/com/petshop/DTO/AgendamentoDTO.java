package com.petshop.DTO;

import java.time.LocalDateTime;

import com.petshop.entities.Agendamento;

public class AgendamentoDTO {

    private Long id;
    private LocalDateTime dataHora;
    private Long petId;
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

    public static AgendamentoDTO convertToDTO(Agendamento agendamento) {

        return new AgendamentoDTO(
                agendamento.getId(),
                agendamento.getDataHora(),
                agendamento.getPet().getId(),
                agendamento.getServico().getId());

    }

    public static Agendamento convertToEntity(AgendamentoDTO dto) {

        Agendamento agendamento = new Agendamento();

        agendamento.setId(dto.getId());
        agendamento.setDataHora(dto.getDataHora());

        return agendamento;

    }

}