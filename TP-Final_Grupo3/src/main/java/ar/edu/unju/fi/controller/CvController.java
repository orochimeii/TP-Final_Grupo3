package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ICVService;

@Controller
@RequestMapping("/cv")
public class CvController {

	
	@Autowired
	ICVService cvService;
	
	@GetMapping("/crear")
	public String getFormularioPage(Model model) {
		model.addAttribute("cvAlias", cvService.crearCV());
		return "crear_cv";
	}
	
	
	
}
