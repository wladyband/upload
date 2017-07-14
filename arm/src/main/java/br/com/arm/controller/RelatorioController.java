package br.com.arm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

	@GetMapping("/home")
	public String inicio(){
		return "home/Relatorios";
	}
	

}
