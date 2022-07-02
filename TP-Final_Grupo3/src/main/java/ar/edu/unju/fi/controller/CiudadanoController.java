package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICiudadanoService;

@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@GetMapping("/registro")
	public String getRegistroCiudadano(Model model) {
		model.addAttribute("ciudadano", new Ciudadano());
		return "registro_ciudadano";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute Ciudadano ciudadano, BindingResult result, Model model) {
		LOGGER.info(ciudadano.getDni());
		if(result.hasErrors()) {
			return "redirect:/ciudadano/registro";
		}else {
			ciudadanoService.registrar(ciudadano);
		}
		return "redirect:/login/ciudadano";
	}
}
