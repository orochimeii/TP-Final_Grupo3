package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IEmpleadorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class LoginController {
	private static final Log LOGGER = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private IEmpleadorService empleadorService;
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("empleador", new Empleador());
		return "login";
	}
	
	@GetMapping("/registro/empleador")
	public String getRegistroEmpleador(Model model) {
		model.addAttribute("empleador", new Empleador());
		return "registro_empleador";
	}
	
	@PostMapping("/registro/empleador")
	public String registro(@Valid @ModelAttribute Empleador empleador, BindingResult result, Model model) {
		LOGGER.info(empleador.getEmail());
		if(result.hasErrors()) {
			return "redirect:/registro/empleador";
		}else {
			empleadorService.registrar(empleador);
		}
		return "redirect:/login";
	}
	
}
