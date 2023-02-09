package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefasConsultasController {

	@RequestMapping(value = "/tarefas-consulta")

	public ModelAndView consulta() {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		return modelAndView;
	}
}
