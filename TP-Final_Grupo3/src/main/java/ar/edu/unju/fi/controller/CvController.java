package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICVService;
import ar.edu.unju.fi.service.ICiudadanoService;

@Controller
@RequestMapping("/cv")
public class CvController {

	
	@Autowired
	ICVService cvService;
	
	@Autowired
	ICiudadanoService ciudadanoService;
	
	@GetMapping("/crear")
	public String getFormularioPage(Model model) {
		model.addAttribute("cvAlias", cvService.crearCV());
		return "crear_cv";
	}
	
	@PostMapping("/crear")
	public ModelAndView cargarCurriculo(@Validated @ModelAttribute("cvAlias") CV cv, BindingResult bindingResult, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			ModelAndView modeloVista = new ModelAndView("crear_cv");
			modeloVista.addObject("cvAlias", cv);
			return modeloVista;
		}
		
		Ciudadano ciudadano = ciudadanoService.findByDni(authentication.getName());
		
		if(ciudadano.getCv()==null) {
			ciudadano.setCv(cv);
			cv.setCiudadano(ciudadano);
			
			ciudadanoService.registrar(ciudadano);
		}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/inicio");
		return modeloVista;
	}
	
	@GetMapping("/editar")
	public String editarCV(Model model, Authentication authentication) {
		Ciudadano ciudadano = ciudadanoService.findByDni(authentication.getName());
		model.addAttribute("cvAlias", ciudadano.getCv());
		return "editar_cv";
	}
	
	@PostMapping("/editar")
	public ModelAndView editar(@Validated @ModelAttribute("cvAlias") CV cv, BindingResult bindingResult, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			ModelAndView modeloVista = new ModelAndView("editar_cv");
			modeloVista.addObject("cvAlias", cv);
			return modeloVista;
		}
		
		cvService.guardarCV(cv);
		
		ModelAndView modeloVista = new ModelAndView("redirect:/inicio");
		return modeloVista;
	}
	
	@GetMapping("/ver")
	public String verCV(Model model, Authentication authentication) {
		Ciudadano ciudadano = ciudadanoService.findByDni(authentication.getName());
		model.addAttribute("cvAlias", ciudadano.getCv());
		return "ver_cv";
	}
}
