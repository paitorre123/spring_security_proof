package com.mkyong.web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proof_spring_web.modelo.ConfiguracionModelo;
import proof_spring_web.modelo.Libro;

@Controller
@RequestMapping("/libro")
public class ControladorLibro {
	
	private Libro libro;
	private AnnotationConfigApplicationContext contexto;
	
	public ControladorLibro() {
		contexto = new AnnotationConfigApplicationContext(ConfiguracionModelo.class); 
		
	}
	
	@RequestMapping("/formularioLibro")
	public String formularioLibro(Model modelo) {
		this.libro= contexto.getBean("libro", Libro.class);
		//para para el cliente entre vistas
		modelo.addAttribute("libro", libro);
		return "formularioLibro";
	}
	
	@RequestMapping(value="/guardarLibro", method = RequestMethod.POST)    
    public String guardarLibro(@ModelAttribute("libro") Libro libro, Model modelo){    
        //dao.save(emp);
		System.out.println(libro.getFecha());
        return "redirect:/libro/formularioLibro";//will redirect to viewemp request mapping    
    } 

}
