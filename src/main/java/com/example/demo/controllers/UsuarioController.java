 package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UsuarioDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioModel> obtenerusuarios() {
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody @Valid UsuarioDTO usuario) {
		return ResponseEntity.ok(this.usuarioService.guardarUsuario(usuario));
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> optenerUsuarioPorId(@PathParam("id") Long id) {
		return this.usuarioService.optenerPorId(id);
	}
	
	//buscar por parametros
	@GetMapping("/prioridad")
	public List<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
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
