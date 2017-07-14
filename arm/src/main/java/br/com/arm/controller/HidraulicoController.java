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

import br.com.arm.controller.service.CadastroCanoService;
import br.com.arm.model.Cano;
import br.com.arm.repository.Canos;
import br.com.arm.repository.Categorias;
import br.com.arm.repository.filter.CanoFilter;

@Controller
@RequestMapping("/hidraulicos")
public class HidraulicoController {


	@Autowired
	private Categorias categorias;
	
	@Autowired
	private CadastroCanoService cadastroCanoService;
	
	@Autowired
	private Canos canos;
	
	@GetMapping("/categorias")
	public String inicio(){
		return "hidraulico/CadastroHidraulico";
	}
	
	@GetMapping("/categorias/cano/novo")
	public ModelAndView canoNovo(Cano cano){
		
		
		ModelAndView mv = new ModelAndView("hidraulico/CadastroCano");
		mv.addObject("categorias", categorias.findAll());
		return mv;
	}
	
	@PostMapping("/categorias/cano/novo")
	public ModelAndView salvarCano(@Valid Cano cano, BindingResult result,
			RedirectAttributes attributes){
		if (result.hasErrors()) {
			return canoNovo(cano);
		}
		
		cadastroCanoService.salvar(cano);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:/hidraulicos/categorias/cano/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CanoFilter canoFilter, BindingResult result){
		ModelAndView mv = new ModelAndView("hidraulico/PesquisaHidraulicos");
		mv.addObject("canos", canos.filtrar(canoFilter));
		return mv;
	}
	
	
}
