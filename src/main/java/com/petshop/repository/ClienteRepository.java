package com.petshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Busca clientes pelo nome
    List<Cliente> findByNome(String nome);

    // Busca clientes que contenham parte do nome
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    // Busca um cliente pelo e-mail
    Optional<Cliente> findByEmail(String email);

    // Verifica se existe um cliente com determinado e-mail
    boolean existsByEmail(String email);

}
