package com.eagleeye.mercadoconsciente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eagleeye.mercadoconsciente.model.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{

	@Query(value = "from Alimento a WHERE a.doador.id = ?1")
	List<Alimento> findByIdDoador(Long id);

}
