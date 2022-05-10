package examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Estadisticas extends JFrame {

	private JPanel contentPane;
	private JLabel txtUsuario2, txtAnio, txtTitulo, txtGenero;
	private JButton btnConfirmar, btnVolver, btnRuta;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estadisticas frame = new Estadisticas(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Estadisticas(JTextField txtUsuario, ArrayList<Peliculas> crudArray, Peliculas pelicula) {
		//JLabel
		
		//JFreeChart
		
		//crudArray
		
		//Tabla de peliculas por genero
		
		//Accedo a los generos del arrayList escogidos del comboBox
		
		
		
		
		
		
	}
	
}

