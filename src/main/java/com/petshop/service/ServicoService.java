package com.petshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.petshop.DTO.ServicoDTO;
import com.petshop.entities.Servico;
import com.petshop.repository.ServicoRepository;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<ServicoDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(ServicoDTO::convertToDTO)
                .collect(Collectors.toList());

    }

    public ServicoDTO buscarPorId(Long id) {

        return repository.findById(id)
                .map(ServicoDTO::convertToDTO)
                .orElse(null);

    }

    public ServicoDTO salvar(ServicoDTO dto) {

        Servico servico = ServicoDTO.convertToEntity(dto);

        servico = repository.save(servico);

        return ServicoDTO.convertToDTO(servico);

    }

    public ServicoDTO atualizar(Long id, ServicoDTO dto) {

        Servico servico = ServicoDTO.convertToEntity(dto);

        servico.setId(id);

        servico = repository.save(servico);

        return ServicoDTO.convertToDTO(servico);

    }

    public void deletar(Long id) {

        repository.deleteById(id);

    }

}