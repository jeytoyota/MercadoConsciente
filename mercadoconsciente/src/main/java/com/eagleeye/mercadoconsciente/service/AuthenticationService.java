package com.eagleeye.mercadoconsciente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eagleeye.mercadoconsciente.model.Doador;
import com.eagleeye.mercadoconsciente.model.Receptor;
import com.eagleeye.mercadoconsciente.repository.DoadorRepository;
import com.eagleeye.mercadoconsciente.repository.ReceptorRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private DoadorRepository doadorRepository;
	
	@Autowired
	private ReceptorRepository receptorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Doador> doador = doadorRepository.findByEmail(username);
		if (doador.isEmpty()) {
			Optional<Receptor> receptor = receptorRepository.findByEmail(username);
			if (receptor.isEmpty()) throw new UsernameNotFoundException("user not found");
			return receptor.get();
		}
		return doador.get();
		
	}
	
	public static PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
