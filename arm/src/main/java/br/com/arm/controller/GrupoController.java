package br.com.arm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.arm.model.Grupo;
import br.com.arm.repository.Grupos;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private Grupos grupos;

	@GetMapping("/novo")
	public ModelAndView novo(Grupo grupo) {
		return new ModelAndView("grupo/CadastroGrupo");
	}

	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Grupo grupo, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(grupo);
		}

		grupos.save(grupo);
		attributes.addFlashAttribute("mensagem", "Grupo salvo com sucesso");
		return new ModelAndView("redirect:/grupos/novo");

	}
}
