package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	ICursoService cursoService;
	
	@GetMapping("/listaCursos")
	public String verCursos(Model model) {
		model.addAttribute("cursosAlias", cursoService.obtenerCursos());
		return "lista_cursos";
	}
	
}
