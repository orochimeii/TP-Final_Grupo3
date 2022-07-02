package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	ICursoService cursoService;
	
	@GetMapping("/listaCursos")
	public String verCursos(Model model) {
		if(cursoService.obtenerCursos().isEmpty()) {
			cursoService.agregarCurso(new Curso("Full Stack en Java", "Programación", LocalDate.of(2022, 8, 25), LocalDate.of(2022, 9, 25), 32, "Virtual", "Daniel Osvaldo"));
			cursoService.agregarCurso(new Curso("Adobe Photoshop", "Diseño Gráfico", LocalDate.of(2022, 8, 1), LocalDate.of(2022, 8, 31), 20, "Virtual", "Pablo Ledesma"));
			cursoService.agregarCurso(new Curso("Mecanografía", "Informática", LocalDate.of(2022, 7, 5), LocalDate.of(2022, 7, 9), 8, "Presencial", "Cristian Calleri"));
			cursoService.agregarCurso(new Curso("Excel", "Informática", LocalDate.of(2022, 7, 15), LocalDate.of(2022, 7, 30), 20, "Virtual", "Fernando Gago"));
		}
		model.addAttribute("cursosAlias", cursoService.obtenerCursos());
		return "lista_cursos";
	}
}
