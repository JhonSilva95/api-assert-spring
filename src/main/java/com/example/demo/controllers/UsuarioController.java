package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModels;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ArrayList<UsuarioModels> obtenerusuarios() {
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping
	public UsuarioModels guardarUsuario(@RequestBody UsuarioModels usuario) {
		return this.usuarioService.guardarUsuario(usuario);		
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModels> optenerUsuarioPorId(Long id) {
		return this.usuarioService.optenerPorId(id);
	}
	
	//buscar por parametros
	@GetMapping("/consulta")
	public ArrayList<UsuarioModels> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
		return this.usuarioService.optenerPorPrioridad(prioridad);

	}
	
	@DeleteMapping(path ="/{id}")
	public String eliminarPorId(@PathVariable("id")  long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if (ok) {
			return "se elimino el usuario " + id;
		}else {
			return "no se pudo eliminar el usuario " + id;
		}

	}
}
