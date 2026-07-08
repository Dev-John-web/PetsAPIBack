package com.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.ServicoDTO;
import com.petshop.entities.Servico;
import com.petshop.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    // Entity -> DTO
    private ServicoDTO converterDTO(Servico servico) {

        return new ServicoDTO(
                servico.getId(),
                servico.getNome(),
                servico.getPreco()
        );
    }

    // DTO -> Entity
    private Servico converterEntity(ServicoDTO dto) {

        Servico servico = new Servico();

        servico.setId(dto.getId());
        servico.setNome(dto.getNome());
        servico.setPreco(dto.getPreco());

        return servico;
    }

    // Listar todos
    public List<ServicoDTO> listarTodos() {

        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoDTO> servicosDTO = new ArrayList<>();

        for (Servico servico : servicos) {
            servicosDTO.add(converterDTO(servico));
        }

        return servicosDTO;
    }

    // Buscar por ID
    public ServicoDTO buscarPorId(Long id) {

        Servico servico = servicoRepository.findById(id).orElse(null);

        if (servico == null) {
            return null;
        }

        return converterDTO(servico);
    }

    // Salvar
    public ServicoDTO salvar(ServicoDTO dto) {

        Servico servico = converterEntity(dto);

        servico = servicoRepository.save(servico);

        return converterDTO(servico);
    }

    // Atualizar
    public ServicoDTO atualizar(Long id, ServicoDTO dto) {

        Servico servico = converterEntity(dto);

        servico.setId(id);

        servico = servicoRepository.save(servico);

        return converterDTO(servico);
    }

    // Deletar
    public void deletar(Long id) {
        servicoRepository.deleteById(id);
    }
}