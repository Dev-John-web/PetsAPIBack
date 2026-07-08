package com.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.AgendamentoDTO;
import com.petshop.entities.Agendamento;
import com.petshop.entities.Pet;
import com.petshop.entities.Servico;
import com.petshop.repository.AgendamentoRepository;
import com.petshop.repository.PetRepository;
import com.petshop.repository.ServicoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    // Entity -> DTO
    private AgendamentoDTO converterDTO(Agendamento agendamento) {

        Long petId = null;
        Long servicoId = null;

        if (agendamento.getPet() != null) {
            petId = agendamento.getPet().getId();
        }

        if (agendamento.getServico() != null) {
            servicoId = agendamento.getServico().getId();
        }

        return new AgendamentoDTO(
                agendamento.getId(),
                agendamento.getDataHora(),
                petId,
                servicoId
        );
    }

    // DTO -> Entity
    private Agendamento converterEntity(AgendamentoDTO dto) {

        Agendamento agendamento = new Agendamento();

        agendamento.setId(dto.getId());
        agendamento.setDataHora(dto.getDataHora());

        if (dto.getPetId() != null) {
            Pet pet = petRepository.findById(dto.getPetId()).orElse(null);
            agendamento.setPet(pet);
        }

        if (dto.getServicoId() != null) {
            Servico servico = servicoRepository.findById(dto.getServicoId()).orElse(null);
            agendamento.setServico(servico);
        }

        return agendamento;
    }

    // Listar
    public List<AgendamentoDTO> listarTodos() {

        List<Agendamento> lista = agendamentoRepository.findAll();
        List<AgendamentoDTO> listaDTO = new ArrayList<>();

        for (Agendamento agendamento : lista) {
            listaDTO.add(converterDTO(agendamento));
        }

        return listaDTO;
    }

    // Buscar por ID
    public AgendamentoDTO buscarPorId(Long id) {

        Agendamento agendamento = agendamentoRepository.findById(id).orElse(null);

        if (agendamento == null) {
            return null;
        }

        return converterDTO(agendamento);
    }

    // Salvar
    public AgendamentoDTO salvar(AgendamentoDTO dto) {

        Agendamento agendamento = converterEntity(dto);

        agendamento = agendamentoRepository.save(agendamento);

        return converterDTO(agendamento);
    }

    // Atualizar
    public AgendamentoDTO atualizar(Long id, AgendamentoDTO dto) {

        Agendamento agendamento = converterEntity(dto);

        agendamento.setId(id);

        agendamento = agendamentoRepository.save(agendamento);

        return converterDTO(agendamento);
    }

    // Deletar
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}