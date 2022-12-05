package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.services.PersonaService;

@Controller
@Slf4j
public class ControlardorInicio {
	
//	@Value("${index.saludo}")
//	private String _saludo;
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		log.info("ejecutando el controlador Spring MVC");
		
		var personas = personaService.listaPersonas();
		
//		model.addAttribute("mensajePba", "Este es un mensaje de prueba de springBoot MVC ");
//		model.addAttribute("saludo", _saludo);
		model.addAttribute("personas",personas);
		
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Persona persona) {
//		personaService.guardar(persona);
		return "modificar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errores) {
		if(errores.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Persona persona, Model model) {
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
	}
}
