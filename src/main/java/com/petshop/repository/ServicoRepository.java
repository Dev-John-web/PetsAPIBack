package com.petshop.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByNome(String nome);

    List<Servico> findByNomeContainingIgnoreCase(String nome);

    List<Servico> findByPreco(BigDecimal preco);

}