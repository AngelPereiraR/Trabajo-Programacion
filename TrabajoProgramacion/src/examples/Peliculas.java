package examples;

import java.io.Serializable;

import javax.swing.Icon;

public class Peliculas implements Serializable {
	private int codigo;
	private String titulo, genero;
	private Usuario usuario;
	private Icon foto;
	
	public Peliculas(int codigo, String titulo, String genero, Icon foto, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
		this.usuario = usuario;
		this.foto = foto;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Icon getFoto() {
		return foto;
	}

	public void setFoto(Icon foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Pelicula: Título " + titulo + "\nGénero: " + genero + "\n" + usuario + "\n";
	}
}
