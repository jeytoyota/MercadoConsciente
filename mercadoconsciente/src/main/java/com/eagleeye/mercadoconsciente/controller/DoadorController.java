package com.eagleeye.mercadoconsciente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eagleeye.mercadoconsciente.model.Alimento;
import com.eagleeye.mercadoconsciente.model.Doador;
import com.eagleeye.mercadoconsciente.repository.AlimentoRepository;
import com.eagleeye.mercadoconsciente.repository.DoadorRepository;
import com.eagleeye.mercadoconsciente.service.AuthenticationService;

@Controller
@RequestMapping("/doador")
public class DoadorController {

	@Autowired
	private DoadorRepository repository;
	
	@Autowired
	private AlimentoRepository alimentoRepository;
	
	@Autowired
	private MessageSource messages;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView  = new ModelAndView("doadores");
		List<Doador> doadores = repository.findAll();
		modelAndView.addObject("doadores", doadores);
		return modelAndView;
	}
	
	@GetMapping("/info/{id}")
	public ModelAndView listInfo(@PathVariable Long id) {
		ModelAndView modelAndView  = new ModelAndView("doador_info");
		Doador doador = repository.findById(id).get();
		System.out.println("/////////"+doador.getRazao());
		List<Alimento> alimentos = alimentoRepository.findByIdDoador(id);
		alimentos.forEach(a -> System.out.println("/////////"+a.getNome()));
		
		modelAndView.addObject("doador", doador);
		modelAndView.addObject("alimentos", alimentos);
		
		return modelAndView;
	}
	
	@RequestMapping("/new")
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("doador_form");
		model.addObject("doador", new Doador());
		return model;
	}
	@PostMapping
	public String save(@Valid Doador doador, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "doador_form";
		doador.setSenha(AuthenticationService.getPasswordEncoder().encode(doador.getSenha()));
		repository.save(doador);
		redirect.addFlashAttribute("message", messages.getMessage("doador.new.sucess", null, LocaleContextHolder.getLocale()));
		return "redirect:doador";
	}
	
}
