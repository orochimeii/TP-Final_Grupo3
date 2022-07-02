package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
			return "redirect:/empleador/registro";
		}else {
			empleadorService.registrar(empleador);
		}
		return "redirect:/login/empleador";
	}
}
