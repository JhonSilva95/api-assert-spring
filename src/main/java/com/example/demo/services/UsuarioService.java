 package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.adapters.UsuarioAdapter;
import com.example.demo.dtos.UsuarioDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioServiceInterfaz{
	
		private static final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@Autowired
		private UsuarioAdapter usuarioAdapter;
		
		public List<UsuarioModel> obtenerUsuarios() {
			return (List<UsuarioModel>) usuarioRepository.findAll();
		}		
		
		public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
			// 1. convertir dto a model
			UsuarioModel usuarioModel = usuarioAdapter.convertirDTOaModel(usuario);
			// 2. guardar usuario
			
			
			usuarioModel = this.usuarioRepository.save(usuarioModel);
			UsuarioDTO usuarioDTO = usuarioAdapter.convertirModelADTO(usuarioModel);
			return usuarioDTO;
		}
		
		public Optional<UsuarioModel> optenerPorId(Long id) {
			return usuarioRepository.findById(id);
		}
		
		public List<UsuarioModel> optenerPorPrioridad(Integer prioridad) {
			return usuarioRepository.findByPrioridad(prioridad);
			
		}
		
		
		public boolean eliminarUsuario(Long id) {
			try {
				usuarioRepository.deleteById(id);
				return true;
			} catch (Exception err) {
				LOG.error("Error a la hora de eliminar el usuario ", err);
				return false;
			}
			
		}
		
}
