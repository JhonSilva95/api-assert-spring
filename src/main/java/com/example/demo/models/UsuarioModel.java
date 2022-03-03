package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer edad;
	private String email;
	private Integer prioridad;
	public Long getId() {
		return id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
	
}
