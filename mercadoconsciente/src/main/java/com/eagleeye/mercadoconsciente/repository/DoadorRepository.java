package com.eagleeye.mercadoconsciente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleeye.mercadoconsciente.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long>{

	Optional<Doador> findByEmail(String username);

}
