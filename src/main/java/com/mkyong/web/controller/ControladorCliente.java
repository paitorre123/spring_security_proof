package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import proof_spring_web.modelo.Cliente;
import proof_spring_web.modelo.ConfiguracionModelo;

@Controller
@RequestMapping("/cliente")
public class ControladorCliente {
	
	
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private AnnotationConfigApplicationContext contexto;
	
	public ControladorCliente() {
		listaClientes = new ArrayList<Cliente>();
		contexto = new AnnotationConfigApplicationContext(ConfiguracionModelo.class); 
		
	}
	
	@GetMapping("/formularioCliente")
	public String formularioCliente(Model modelo) {
		this.cliente= contexto.getBean("cliente", Cliente.class);
		//para para el cliente entre vistas
		modelo.addAttribute("cliente", cliente);
		return "formularioCliente";
	}
	
	@RequestMapping(value="/guardarCliente", method = RequestMethod.POST)    
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente, Model modelo){    
        //dao.save(emp);
		listaClientes.add(cliente);
		modelo.addAttribute("listaClientes", listaClientes); 
        return "procesarFormularioCliente";//will redirect to viewemp request mapping    
    } 

	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@ModelAttribute("cliente") Cliente cliente) {
		return "procesarFormularioCliente";
	}
	
	@RequestMapping("/verFormularioCliente")
	public String verFormularioCliente(@RequestParam("rutCliente")String rutCliente, Model model) {
		System.out.println(rutCliente);
		return "formularioCliente";
	}
	@RequestMapping("/almacenarFormularioCliente")
	public String almacenarFormularioCliente(HttpServletRequest request, Model modelo) {
		String rut = request.getParameter("rutCliente");  
		String nombre = request.getParameter("nombreCliente"); 
		
		modelo.addAttribute("mensajeDeAlmacenaje", "Se almacena la info de: "+ nombre + "...");
		return "procesarFormularioCliente";
	}
	
	
	/**********************
	 * GETTERS AND SETTERS*
	 **********************/
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
