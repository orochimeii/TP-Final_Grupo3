package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class OfertaController {
	
	private static final Log LOGGER = LogFactory.getLog(OfertaController.class);

	@Autowired
	private IOfertaService ofertaService;
	
	@Autowired
	private IEmpleadorService empleadorService;
	
	@GetMapping("/ofertas")
	public ModelAndView getOfertaPage(Model model, Authentication authentication) {
		ModelAndView mav = null;
		LOGGER.info(authentication.getAuthorities());
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority c: authorities) {
			if(c.getAuthority().equalsIgnoreCase("empleador")) {
				Empleador empleador = empleadorService.findByCuit(authentication.getName());
				mav = new ModelAndView("lista_ofertas");
				mav.addObject("ofertas", empleador.getOfertas());
			}else {
				mav = new ModelAndView("lista_ofertas");
				mav.addObject("ofertas", ofertaService.getOfertas());
			}
		}
		return mav;
	}
	
	@GetMapping("/crear_oferta")
	public String getCrearOfertaPage(Model model) {
		model.addAttribute("oferta", new Oferta());
		model.addAttribute("empleador", new Empleador());
		return "crear_ofertas";
	}
	
	@PostMapping("/crear_oferta")
	public String registro(@Valid @ModelAttribute Oferta oferta, Principal principal, BindingResult result, Model model) {
		LOGGER.info(principal.getName());
		if(result.hasErrors()) {
			return "redirect:/crear_oferta";
		}else {
			Empleador empleador = empleadorService.findByCuit(principal.getName());
			oferta.setEmpleador(empleador);
			ofertaService.crear(oferta);
		}
		return "redirect:/ofertas";
	}
}
