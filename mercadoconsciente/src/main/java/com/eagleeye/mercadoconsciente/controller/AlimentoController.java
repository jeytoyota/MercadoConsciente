package com.eagleeye.mercadoconsciente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eagleeye.mercadoconsciente.model.Alimento;
import com.eagleeye.mercadoconsciente.repository.AlimentoRepository;

@Controller
@RequestMapping("/alimentos")
public class AlimentoController {

	@Autowired
	private AlimentoRepository repository;
	
	@Autowired
	private MessageSource messages;
	
	@GetMapping("{id}")
	public ModelAndView list(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("alimentos");
		List<Alimento> alimentos = repository.findByIdDoador(id);
		modelAndView.addObject("idDoador", id);
		modelAndView.addObject("alimentos", alimentos);
		return modelAndView;
	}
	
	@PostMapping
	public String save(Alimento alimento, RedirectAttributes redirect) {
		repository.save(alimento);
		redirect.addFlashAttribute("message", messages.getMessage("doador.new.sucess", null, LocaleContextHolder.getLocale()));
		return "redirect:alimentos";
	}
}
