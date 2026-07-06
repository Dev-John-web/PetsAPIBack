package com.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entities.Servico;
import com.petshop.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico atualizar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deletar(Long id) {
        servicoRepository.deleteById(id);
    }
}