package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	@Autowired
	ICursoService cursoService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	
	/*El siguiente modulo nos permite crear los cursos como listarlos
	 * Si no existen cursos, los crea y luego los muestras. Si ya hay cursos cargados simplemente los muestra
	 * */
	@GetMapping("/listaCursos")
	public String verCursos(Model model) {
		LOGGER.info("Listar cursos");
		if(cursoService.obtenerCursos().isEmpty()) {
			LOGGER.info("No existen cursos, por lo cual se crean");
			cursoService.agregarCurso(new Curso("Full Stack en Java", "Programación", LocalDate.of(2022, 8, 25), LocalDate.of(2022, 9, 25), 32, "Virtual", "Daniel Osvaldo"));
			cursoService.agregarCurso(new Curso("Adobe Photoshop", "Diseño Gráfico", LocalDate.of(2022, 8, 1), LocalDate.of(2022, 8, 31), 20, "Virtual", "Pablo Ledesma"));
			cursoService.agregarCurso(new Curso("Mecanografía", "Informática", LocalDate.of(2022, 7, 5), LocalDate.of(2022, 7, 9), 8, "Presencial", "Cristian Calleri"));
			cursoService.agregarCurso(new Curso("Excel", "Informática", LocalDate.of(2022, 7, 15), LocalDate.of(2022, 7, 30), 20, "Virtual", "Fernando Gago"));
		}
		model.addAttribute("cursosAlias", cursoService.obtenerCursos());
		return "lista_cursos";
	}
	
	/*El siguiente modulo nos inscribir al usuario loggeado en un curso seleccionado
	 * Busca entre todos los cursos y verifica que no este ya inscripto
	 * En caso de estarlo, simplemente se lo redirecciona a la lista de sus cursos
	 * */
	@GetMapping("/inscribirse/{id}")
	public ModelAndView inscribirse(@PathVariable(value="id") Long id, Authentication authentication) {
		Ciudadano ciudadano = ciudadanoService.findByDni(authentication.getName());
		boolean inscripto=false;
		
		for (Curso curso : ciudadano.getCursos()) {
			if(curso.getId()==id) {
				inscripto=true;
			}
		}
		
		if(inscripto==false) {
			LOGGER.info("Un ciudadano se inscribe a un curso");
			ModelAndView modeloVista = new ModelAndView("redirect:/curso/cursos");
			Curso curso = cursoService.buscarCurso(id);
			ciudadano.getCursos().add(curso);
			cursoService.agregarCurso(curso);
			return modeloVista;
		}else {
			LOGGER.info("El ciudadano ya esta inscripto");
			ModelAndView modeloVista = new ModelAndView("redirect:/curso/cursos");
			return modeloVista;
		}
		
	}
	
	/*El siguiente modulo permite al usuario loggeado ver los cursos donde esta registrado
	 * */
	@GetMapping("/cursos")
	public String verMisCursos(Authentication authentication, Model model){
		LOGGER.info("Ver los cursos de: "+authentication.getName());
		Ciudadano ciudadano = ciudadanoService.findByDni(authentication.getName());
		model.addAttribute("vacio", ciudadano.getCursos().isEmpty());
		model.addAttribute("cursosAlias", ciudadano.getCursos());
		return "mis_cursos";
	}
	
}
