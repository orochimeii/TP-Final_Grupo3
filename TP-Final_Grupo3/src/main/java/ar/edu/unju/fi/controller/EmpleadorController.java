package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
public class EmpleadorController {
	
	@Autowired
	private IEmpleadorService empleadorService;
	
	@GetMapping("/empleadores")
	public ModelAndView getListaEmpleadores() {
		ModelAndView mav = new ModelAndView("lista_empleadores");
		mav.addObject("empleadores", empleadorService.getEmpleadores());
		return mav;
	}
}
