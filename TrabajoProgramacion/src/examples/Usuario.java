package examples;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String usuario, clave;
	private int telefono;
	
	public Usuario(String usuario, String clave, int telefono) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.telefono = telefono;
	}

	public Usuario() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Usuario: " + usuario + " Teléfono: " + telefono;
	}
}
