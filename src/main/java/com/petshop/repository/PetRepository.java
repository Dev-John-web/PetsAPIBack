package com.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNome(String nome);

    List<Pet> findByTipo(String tipo);

    List<Pet> findByRaca(String raca);

    List<Pet> findByClienteId(Long clienteId);

}