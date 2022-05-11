package examples;

import java.io.Serializable;

public class Peliculas implements Serializable {
	private int codigo;
	private String titulo, genero;
	private String usuario;
	private String ruta;
	
	public Peliculas(int codigo, String titulo, String genero, String usuario, String ruta) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
		this.usuario = usuario;
		this.ruta = ruta;
	}

	public Peliculas() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Pelicula:\nAño:"+codigo+" \nTítulo: " + titulo + "\nGénero: " + genero + "\n" + usuario + "\n";
	}
}
