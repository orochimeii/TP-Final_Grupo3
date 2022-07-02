package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class LoginController {
	private static final Log LOGGER = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login/empleador")
	public String getLoginEmpleador(Model model) {
		LOGGER.info("empleador login");
		model.addAttribute("empleador", new Empleador());
		return "login_empleador";
	}
	
	@GetMapping("/login/ciudadano")
	public String getLoginCiudadano(Model model) {
		LOGGER.info("ciudadano login");
		model.addAttribute("ciudadano", new Ciudadano());
		return "login_ciudadano";
	}
	
}
