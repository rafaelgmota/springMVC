package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cidade;

@Controller
public class CidadesController {
	
	@RequestMapping("/cidades/nova")
	public String novo(Cidade cidade) { //Spring adiciona como atributro automat		
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(value = "/cidades/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(cidade);
		}
		
		//Salvar no banco de dados ...
		
		attributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso"); //Atributos para redirect, cria uma seção temporaria
		return "redirect:/cidades/nova"; //Redirect
	}
}
