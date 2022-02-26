 package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModels;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

		@Autowired
		UsuarioRepository usuarioRepository;
		//realiza un listado de usuarios
		public ArrayList<UsuarioModels> obtenerUsuarios() {
			return (ArrayList<UsuarioModels>) usuarioRepository.findAll();
		}
		
		//guardar usuario y/o editar
		public UsuarioModels guardarUsuario(UsuarioModels usuario) {
			return usuarioRepository.save(usuario);
		}
		//busca usuario por id
		public Optional<UsuarioModels> optenerPorId(Long id) {
			return usuarioRepository.findById(id);
		}
		//busca un usuario por la prioridad
		public ArrayList<UsuarioModels> optenerPorPrioridad(Integer prioridad) {
			return usuarioRepository.findByPrioridad(prioridad);
			
		}
		
		
		//realizar la eliminiacion de un usuario
		public boolean eliminarUsuario(Long id) {
			try {
				usuarioRepository.deleteById(id);
				return true;
			} catch (Exception err) {
				return false;
			}
		}
		
}
