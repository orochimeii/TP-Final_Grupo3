package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfertaController {
	
@GetMapping("/ofertas")
public String getOfertaPage() {
	return "lista_ofertas";
}
}
