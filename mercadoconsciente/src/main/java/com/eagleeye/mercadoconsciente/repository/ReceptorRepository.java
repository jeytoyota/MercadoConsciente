package com.eagleeye.mercadoconsciente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleeye.mercadoconsciente.model.Receptor;

public interface ReceptorRepository extends JpaRepository<Receptor, Long>{

	Optional<Receptor> findByEmail(String username);

}
