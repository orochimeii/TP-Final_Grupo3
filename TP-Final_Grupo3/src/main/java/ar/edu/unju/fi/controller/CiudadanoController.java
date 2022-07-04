package ar.edu.unju.fi.controller;

import java.time.LocalDate;

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
		if(result.hasErrors() || ciudadano.getFechaDeNacimiento().until(LocalDate.now()).getYears() < 18) {
			LOGGER.info("Todos los campos son requeridos");
			return "redirect:/ciudadano/registro";
		}else {				
			ciudadanoService.registrar(ciudadano);
			LOGGER.info("Ciudadano registrado");
		}
		return "redirect:/login/ciudadano";
	}
	
	@GetMapping("/oferta/:id")
	public String getOfertaPage(Model model ) {
		return null;
	}
}
