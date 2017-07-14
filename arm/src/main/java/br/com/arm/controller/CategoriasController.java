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

import br.com.arm.controller.service.CadastroCategoriaService;
import br.com.arm.controller.service.exception.NomeCategoriaCadastradoException;
import br.com.arm.model.Categoria;


@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CadastroCategoriaService cadastroEstiloService;
		
	@GetMapping("/novo")
	public ModelAndView novo(Categoria categoria) {
		return new ModelAndView("categoria/CadastroCategoria");
	}
	
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(categoria);
		}
		
		try {
			cadastroEstiloService.salvar(categoria);
		} catch (NomeCategoriaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(categoria);
}
		attributes.addFlashAttribute("mensagem", "Categoria salvo com sucesso");
		return new ModelAndView("redirect:/categorias/novo");
	}

	

}
