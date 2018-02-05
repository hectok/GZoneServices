/**
 * 
 */
package com.gzone.ecommerce.model;



/**
 * @author hector.ledo.doval
 *
 */
public class Usuario {

	private Long idUsuario = null;
	private String usuario = null;
	private String correo = null;
	private String contrasena = null;
	private String nombre = null;
	private String apellido = null;
	private String descripcion = null;
	private Long localizacion = null;
	
	
	public Usuario() {
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getLocalizacion() {
		return localizacion;
	}
	
	public void setLocalizacion(Long localizacion) {
		this.localizacion = localizacion;
	}
	
	
}
