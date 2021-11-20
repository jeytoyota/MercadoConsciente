package com.eagleeye.mercadoconsciente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Alimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome do Alimento obrigatório.")
	private String nome;
	
	@NotNull(message = "Quantidade do Alimento obrigatório.")
	@Min(value = 0, message = "Quantidade não pode ser inferior a 0.")
	private double quantidade;
	
	@ManyToOne
	private Doador doador;
}
