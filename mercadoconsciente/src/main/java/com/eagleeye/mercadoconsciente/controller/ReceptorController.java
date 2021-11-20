package com.eagleeye.mercadoconsciente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eagleeye.mercadoconsciente.model.Doador;
import com.eagleeye.mercadoconsciente.model.Receptor;
import com.eagleeye.mercadoconsciente.repository.ReceptorRepository;
import com.eagleeye.mercadoconsciente.service.AuthenticationService;

@Controller
@RequestMapping("/receptor")
public class ReceptorController {

	@Autowired
	private ReceptorRepository repository;
	
	@Autowired
	private MessageSource messages;
		
	@RequestMapping("/new")
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("receptor_form");
		model.addObject("receptor", new Receptor());
		return model;
	}
	@PostMapping
	public String save(@Valid Receptor receptor, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "receptor_form";
		receptor.setSenha(AuthenticationService.getPasswordEncoder().encode(receptor.getSenha()));
		repository.save(receptor);
		redirect.addFlashAttribute("message", messages.getMessage("receptor.new.sucess", null, LocaleContextHolder.getLocale()));
		return "redirect:doador";
	}
}
