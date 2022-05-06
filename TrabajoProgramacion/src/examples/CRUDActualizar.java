package examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;

public class CRUDActualizar extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario, txtContrasena, txtTelefono;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnConfirmar, btnVolver;
	private ArrayList<Peliculas> arrayPeliculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDIntroduccion frame = new CRUDIntroduccion(null, null, null, null);
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
	public CRUDActualizar(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono,
			ArrayList<Peliculas> crudArray) {
		
		//Mismo procedimiento que en detalles, la unica diferencia es que en vez de JLabel, los campos se rellenan en un 
		// JTextField
		//crudArray de la pelicula seleccionada para relacionarla con el array tendr�a que tener los datos de esa pel�cula.
		
		arrayPeliculas = crudArray;
		
		setTitle("Actualizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLabelAno = new JLabel("A�o");
		JLabelAno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelAno.setBounds(28, 30, 78, 52);
		contentPane.add(JLabelAno);

		JLabel JLabelTitulo = new JLabel("T�tulo");
		JLabelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelTitulo.setBounds(28, 76, 78, 41);
		contentPane.add(JLabelTitulo);

		JLabel JLabelGenero = new JLabel("G�nero");
		JLabelGenero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelGenero.setBounds(28, 114, 89, 56);
		contentPane.add(JLabelGenero);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 164, 78, 46);
		contentPane.add(lblNewLabel);
		
		//Una vez con la pelicula seleccionada usamos la implementaci�n para rellenar los campos.
		//Como lo que hemos almacenado en el array es un Objeto peliculas, usamos los m�todos de la clase con el mismo nombre.
				
		// Para el grupo
		//Necesito acceder al Objeto pelicula de la creada en el array
		//Uso esto pero no me funciona, crudArray.getClass(); estoy pillado con esto.
		//Una vez dentro, acceder a los m�todos de la clase pelicula getTitulo, getCodigo..etc para rellenar los campos.

		textField_1 = new JTextField();
		textField_1.setBounds(116, 86, 192, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//int codigo = Integer.parseInt(textField_1.getText());

		textField = new JTextField();
		textField.setBounds(116, 46, 192, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		String titulo = textField_1.getText();

		textField_2 = new JTextField();
		textField_2.setBounds(116, 132, 192, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		String genero = textField_1.getText();

		
		textField_3 = new JTextField(); 
		textField_3.setBounds(116, 177, 192, 19);
		contentPane.add(textField_3); 
		textField_3.setColumns(10); 
		textField_3.setText(txtUsuario.getText());
		
		
	

		JLabel JLabelImagen = new JLabel("Imagen");
		JLabelImagen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelImagen.setBounds(28, 220, 78, 33);
		contentPane.add(JLabelImagen);

		//Usuario -- Realmente si ya accedemos al Usuario creado en el Array esto no hace falta
		// pero est� puesto para que no de error en el commit.
		// ??
		//int codeUsuario = Integer.parseInt(txtTelefono.getText());
		//Usuario user = new Usuario(txtUsuario.getText(),txtContrasena.getText(), codeUsuario);
		
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//crudArray.add(new Peliculas(codigo, titulo, genero, user));

				Inicio ini = null;
				try {
					ini = new Inicio(txtUsuario, txtContrasena, txtTelefono, crudArray);
				} catch (ClassNotFoundException | IOException e1) {
				}
				ini.setVisible(true);
				ini.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnConfirmar.setBounds(28, 279, 115, 33);
		contentPane.add(btnConfirmar);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ini = null;
				try {
					ini = new Inicio(txtUsuario, txtContrasena, txtTelefono, crudArray);
				} catch (ClassNotFoundException | IOException e1) {
				}
				ini.setVisible(true);
				ini.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnVolver.setBounds(202, 279, 106, 33);
		contentPane.add(btnVolver);

		ManejadorBotones escuchador = new ManejadorBotones();
		btnConfirmar.addActionListener(escuchador);
		btnVolver.addActionListener(escuchador);
	}

	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton escogido = (JButton) e.getSource();

		
			if (escogido.equals(btnConfirmar)) {
				Inicio frame = null;
				try {
					frame = new Inicio(textField, textField, textField, arrayPeliculas);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			} else if (escogido.equals(btnVolver)) {
				Inicio frame = null;
				try {
					frame = new Inicio(textField, textField, textField, arrayPeliculas);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}

		}

	}

	/*
	 * public class InsertImg implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { AbstractButton jtname
	 * = null; if (jtname.getText().equals("")) { ImageIcon icon = new
	 * ImageIcon("images/warning.png"); JOptionPane.showMessageDialog(null,
	 * "The crypto name cant be empty", "", JOptionPane.ERROR_MESSAGE, icon); } else
	 * {
	 * 
	 * JFileChooser fileChooser = new JFileChooser();
	 * fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	 * 
	 * FileNameExtensionFilter soloImg = new
	 * FileNameExtensionFilter("JPG & PNG Images", "png", "png");
	 * fileChooser.setFileFilter(soloImg);
	 * 
	 * fileChooser.showSaveDialog(null);
	 * 
	 * File imagenes = new File("images/" + jtname.getText() + ".png");
	 * 
	 * Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath(); Path
	 * destination = imagenes.toPath();
	 * 
	 * try { if (!imagenes.exists()) Files.copy(sourcer, destination); } catch
	 * (IOException e1) { e1.printStackTrace(); } }
	 * 
	 * } }
	 */
}
