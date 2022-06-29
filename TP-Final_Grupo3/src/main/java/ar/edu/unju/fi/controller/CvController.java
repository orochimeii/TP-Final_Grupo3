package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.CV;
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
	
	@PostMapping("")
	public ModelAndView ahre(@Validated @ModelAttribute("cvAlias") CV cv, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView modeloVista = new ModelAndView("crear_cv");
			modeloVista.addObject("cvAlias", cv);
			return modeloVista;
		}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/login");
		return modeloVista;
	}
	
}
