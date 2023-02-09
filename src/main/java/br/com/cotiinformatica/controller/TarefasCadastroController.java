package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefasCadastroController {

	@RequestMapping(value = "/tarefas-cadastro")
	
	public ModelAndView cadastro() {
		
		ModelAndView modelAndView = new ModelAndView("tarefas-cadastro");
		
		return modelAndView;
	}
}
