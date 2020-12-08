package co.edu.ufps.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.demo.model.Persona;
import co.edu.ufps.demo.service.PersonaService;

@Controller
public class PersonaContoller {
	
	
	private PersonaService personaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", personaService.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id")Long id, Model model) {
		if(id !=null) {
			model.addAttribute("persona", personaService.get(id));	
		}
		return "save";
	}
	
	@PostMapping
	public String save(Persona persona, Model model) {
		personaService.save(persona);
		return "redirect:/";
	}
	
	public String delete(@PathVariable Long id, Model model) {
		personaService.delete(id);
		return "redirect:/";
	}
}
