package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	
	private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);
	
	@Autowired
	private IEmpleadorService empleadorService;
	
	
	@GetMapping("/empleadores")
	public ModelAndView getListaEmpleadores() {
		ModelAndView mav = new ModelAndView("lista_empleadores");
		mav.addObject("empleadores", empleadorService.getEmpleadores());
		return mav;
	}
	
	@GetMapping("/registro")
	public String getRegistroEmpleador(Model model) {
		model.addAttribute("empleador", new Empleador());
		return "registro_empleador";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute Empleador empleador, BindingResult result, Model model) {
		//LOGGER.info(empleador.getEmail());
		if(result.hasErrors()) {
			model.addAttribute("empleador", empleador);
			return "registro_empleador";
		}else {
			empleadorService.registrar(empleador);
		}
		return "redirect:/login/empleador";
	}
	
	@GetMapping("/ver")
	public String verEmpleador(Model model, Authentication authentication) {
		LOGGER.info(authentication.getName());
		Empleador empleador = empleadorService.findByCuit(authentication.getName());
		model.addAttribute("empleador", empleador);
		return "ver_empleador";
	}
	
	@GetMapping("/editar")
	public String editarEmpleador(Model model, Authentication authentication) {
		LOGGER.info(authentication.getName());
		Empleador empleador = empleadorService.findByCuit(authentication.getName());
		model.addAttribute("empleador", empleador);
		return "editar_empleador";
	}
	
	@PostMapping("/editar")
	public ModelAndView editar(@Validated @ModelAttribute("empleador") Empleador empleador, BindingResult bindingResult, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			ModelAndView modeloVista = new ModelAndView("editar_empleador");
			modeloVista.addObject("empleador", empleador);
			return modeloVista;
	}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/inicio");
		empleadorService.registrar(empleador);
		return modeloVista;
	}
}
