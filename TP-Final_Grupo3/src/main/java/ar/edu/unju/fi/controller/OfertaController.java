package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.service.ICiudadanoService;
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
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
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
	
	@GetMapping("/oferta/{id}")
	public ModelAndView getOfertaPage(@PathVariable(value="id")Long id, Authentication authentication) {
		ModelAndView mav = new ModelAndView("ver_oferta");
		Optional<Oferta> oferta = ofertaService.findById(id);
		mav.addObject("oferta", oferta.get());
		LOGGER.info(oferta.get());
		return mav;
	}
	
	@GetMapping("/oferta/editar/{id}")
	public ModelAndView getEditarOfertaPage(@PathVariable(value="id")Long id, Authentication authentication) {
		ModelAndView mav = new ModelAndView("editar_ofertas");
		Optional<Oferta> oferta = ofertaService.findById(id);
		mav.addObject("oferta", oferta.get());
		LOGGER.info(oferta.get());
		return mav;
	}
	
	@PostMapping("/oferta/editar/{id}")
	public ModelAndView editarOferta(@Validated @ModelAttribute("oferta") Oferta oferta, @PathVariable(value="id")Long id, BindingResult bindingResult, Principal principal ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+oferta);
			ModelAndView mav = new ModelAndView("editar_oferta");
			mav.addObject("oferta", oferta);
			return mav;
		}
		Empleador empleador = empleadorService.findByCuit(principal.getName());
		oferta.setEmpleador(empleador);
		ModelAndView mav = new ModelAndView("redirect:/oferta/editar/{id}");
		LOGGER.info("datos de ofeerta: "+oferta);
		ofertaService.update(oferta);
		return mav;
		
	}
	
	@GetMapping("/oferta/eliminar/{id}")
	public ModelAndView getEliminarOfertaPage(@PathVariable(value="id")Long id, Authentication authentication) {
		ofertaService.eliminar(id);
		ModelAndView mav = new ModelAndView("redirect:/ofertas");
		return mav;
	}
	
	@GetMapping("/oferta/postular/{id}")
	public ModelAndView postularAOfertaPage(@PathVariable(value="id")Long id, Principal principal) {
		Optional<Oferta> oferta = ofertaService.findById(id);
		Ciudadano ciudadano = ciudadanoService.findByDni(principal.getName());
		boolean postulado = false;
		
		for (Oferta o : ciudadano.getOfertas()) {
			if(o.getId() == id) {
				postulado = true;
			}
		}
		
		if(!postulado) {
			ciudadano.getOfertas().add(oferta.get());
			LOGGER.info(ciudadano.getOfertas());
			ofertaService.crear(oferta.get());
			ModelAndView mav = new ModelAndView("redirect:/ofertas");
			return mav;
		}else {			
			ModelAndView mav = new ModelAndView("redirect:/ofertas");
			LOGGER.info(oferta.get());
			return mav;
		}
	}
	
	@GetMapping("/misPostulaciones")
	public String verMisPostulaciones(Model model, Authentication authentication) {
		Ciudadano ciudadano = ciudadanoService.findByDni(authentication.getName());
		model.addAttribute("vacio", ciudadano.getOfertas().isEmpty());
		model.addAttribute("postulaciones", ciudadano.getOfertas());
		return "mis_postulaciones";
	}
}
