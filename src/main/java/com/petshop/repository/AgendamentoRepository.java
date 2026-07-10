package com.petshop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Busca agendamentos por data e hora
    List<Agendamento> findByDataHora(LocalDateTime dataHora);

}
