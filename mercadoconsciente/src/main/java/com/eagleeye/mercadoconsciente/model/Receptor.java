package com.eagleeye.mercadoconsciente.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Receptor implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Campo CNPJ é obrigatório")
	private String cnpj;
	
	@NotBlank(message = "Campo Razão Social é obrigatório")
	private String razao;
	
	@NotBlank(message = "Campo Logradouro é obrigatório")
	private String logradouro;
	
	@NotBlank(message = "Campo Telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "Campo E-mail é obrigatório")
	@Email(message = "{user.email.invalid}")
	private String email;
	
	@NotBlank(message = "Campo Senha é obrigatório")
	private String senha;
	
	private String admin;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
