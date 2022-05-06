package examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CRUDDetalles extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario, txtContrasena, txtTelefono;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDDetalles frame = new CRUDDetalles(null, null, null, null);
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
	public CRUDDetalles(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono, ArrayList<Peliculas> crudArray) {
		
		//crudArray de la pelicula seleccionada para relacionarla con el array tendría que tener los datos de esa película.
		
		setTitle("Detalles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.txtUsuario = txtUsuario;
		this.txtContrasena = txtContrasena;
		this.txtTelefono = txtTelefono;
		this.arrayPeliculas = arrayPeliculas;
		
		
		//Una vez con la pelicula seleccionada usamos la implementación para rellenar los campos.
		//Como lo que hemos almacenado en el array es un Objeto peliculas, usamos los métodos de la clase con el mismo nombre.
		
		// Para el grupo
		//Necesito acceder al Objeto pelicula de la creada en el array
		//Uso esto pero no me funciona, crudArray.getClass(); 
		//Una vez dentro, acceder a los métodos de la clase pelicula getTitulo, getCodigo..etc para rellenar los campos.
		
		JLabel JLabelTitulo = new JLabel("Aquí va el título");
		JLabelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelTitulo.setBounds(39, 22, 75, 30);
		contentPane.add(JLabelTitulo);
		
		JLabel JLabelAno = new JLabel("Aquí va el año");
		JLabelAno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelAno.setBounds(39, 50, 75, 38);
		contentPane.add(JLabelAno);
		
		JLabel JLabelGenero = new JLabel("Aquí va el género");
		JLabelGenero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelGenero.setBounds(39, 86, 75, 30);
		contentPane.add(JLabelGenero);
		
		//Para el usuario es siguiendo con el procedimiento de antes, acceder al usuario 
		// y usar el método getUsuario para rellenar el nombre aquí abajo
		
		JLabel JLabelUsuario = new JLabel("Aquí va el usuario");
		JLabelUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelUsuario.setBounds(39, 116, 75, 38);
		contentPane.add(JLabelUsuario);
		
		JLabel JLabelImagen = new JLabel("Aquí va la imagen");
		JLabelImagen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelImagen.setBounds(60, 177, 192, 30);
		contentPane.add(JLabelImagen);
		
		JButton JButtonVolver = new JButton("Volver");
		JButtonVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JButtonVolver.setBounds(81, 260, 106, 38);
		contentPane.add(JButtonVolver);
		ManejadorBoton mb = new ManejadorBoton();
		JButtonVolver.addActionListener(mb);
		
	}
	private class ManejadorBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Inicio frame;
			try {
				frame = new Inicio(txtUsuario, txtContrasena, txtTelefono,arrayPeliculas );
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}
		
	}
}
