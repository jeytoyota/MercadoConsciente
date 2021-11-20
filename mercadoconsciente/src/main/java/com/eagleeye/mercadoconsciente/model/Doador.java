package com.eagleeye.mercadoconsciente.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Doador implements UserDetails {

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
	
	@Size(min = 6, message = "{user.password.size}")
	private String senha;
	
	private String admin;

	@OneToMany(mappedBy = "doador")
	private List<Alimento> alimentos;

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
