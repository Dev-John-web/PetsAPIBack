package com.petshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.petshop.DTO.AgendamentoDTO;
import com.petshop.entities.Agendamento;
import com.petshop.entities.Pet;
import com.petshop.entities.Servico;
import com.petshop.repository.AgendamentoRepository;
import com.petshop.repository.PetRepository;
import com.petshop.repository.ServicoRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final PetRepository petRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoService(AgendamentoRepository repository,
                              PetRepository petRepository,
                              ServicoRepository servicoRepository) {

        this.repository = repository;
        this.petRepository = petRepository;
        this.servicoRepository = servicoRepository;

    }

    public List<AgendamentoDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(AgendamentoDTO::convertToDTO)
                .collect(Collectors.toList());

    }

    public AgendamentoDTO buscarPorId(Long id) {

        return repository.findById(id)
                .map(AgendamentoDTO::convertToDTO)
                .orElse(null);

    }

    public AgendamentoDTO salvar(AgendamentoDTO dto) {

        Agendamento agendamento = AgendamentoDTO.convertToEntity(dto);

        Pet pet = petRepository.findById(dto.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado."));

        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado."));

        agendamento.setPet(pet);
        agendamento.setServico(servico);

        agendamento = repository.save(agendamento);

        return AgendamentoDTO.convertToDTO(agendamento);

    }

    public AgendamentoDTO atualizar(Long id, AgendamentoDTO dto) {

        Agendamento agendamento = AgendamentoDTO.convertToEntity(dto);

        agendamento.setId(id);

        Pet pet = petRepository.findById(dto.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado."));

        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado."));

        agendamento.setPet(pet);
        agendamento.setServico(servico);

        agendamento = repository.save(agendamento);

        return AgendamentoDTO.convertToDTO(agendamento);

    }

    public void deletar(Long id) {

        repository.deleteById(id);

    }

}