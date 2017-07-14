package br.com.arm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.arm.controller.service.CadastroSubCategoriaService;
import br.com.arm.controller.service.exception.NomeSubCategoriaJaCadastradaException;
import br.com.arm.model.SubCategoria;
import br.com.arm.repository.Categorias;
import br.com.arm.repository.SubCategorias;

@Controller
@RequestMapping("/subcategorias")
public class SubCategoriasController {
	
	@Autowired
	private Categorias categorias; 
	
	
	@Autowired
	private SubCategorias subCategorias; 
	
	@Autowired
	private CadastroSubCategoriaService cadastroSubCategoriaService;
	
	
	@GetMapping("/nova")
	public ModelAndView nova(SubCategoria subCategoria){
		ModelAndView mv = new ModelAndView("subcategoria/CadastroSubCategoria");
		mv.addObject("categorias", categorias.findAll());
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SubCategoria> pesquisarPorCodigoCategoria(
			@RequestParam(name = "categoria", defaultValue = "-1") Long codigoCategoria){
		try {
			Thread.sleep(500);
			} catch (InterruptedException e) { }
		return subCategorias.findByCategoriaCodigo(codigoCategoria);
	}

	@PostMapping("/nova")
	public ModelAndView salvar(@Valid SubCategoria subCategoria, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()) {
			return nova(subCategoria);
		}
		
		try {
			cadastroSubCategoriaService.salvar(subCategoria);
		} catch (NomeSubCategoriaJaCadastradaException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return nova(subCategoria);
		}

		return new ModelAndView("redirect:/subcategorias/nova");
	}
	

}
