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
	private JTextField txtUsuario2, txtAnio, txtTitulo, txtGenero;
	private JButton btnConfirmar, btnVolver;
	private ArrayList<Peliculas> arrayPeliculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDIntroduccion frame = new CRUDIntroduccion(null, null);
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
	public CRUDActualizar(JTextField txtUsuario, ArrayList<Peliculas> crudArray, Peliculas pelicula) {

		// Mismo procedimiento que en detalles, la unica diferencia es que en vez de
		// JLabel, los campos se rellenan en un
		// JTextField
		// crudArray de la pelicula seleccionada para relacionarla con el array tendría
		// que tener los datos de esa película.

		setTitle("Actualizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		arrayPeliculas = crudArray;
		txtUsuario2 = txtUsuario;

		JLabel lblAnio = new JLabel("Año");
		lblAnio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAnio.setBounds(28, 30, 78, 52);
		contentPane.add(lblAnio);

		txtAnio = new JTextField();
		txtAnio.setBounds(116, 86, 192, 19);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		txtAnio.setText(String.valueOf(pelicula.getCodigo()));

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTitulo.setBounds(28, 76, 78, 41);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(116, 46, 192, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		txtTitulo.setText(pelicula.getTitulo());

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGenero.setBounds(28, 114, 89, 56);
		contentPane.add(lblGenero);

		txtGenero = new JTextField();
		txtGenero.setBounds(116, 132, 192, 19);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		txtGenero.setText(pelicula.getGenero());

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsuario.setBounds(28, 164, 78, 46);
		contentPane.add(lblUsuario);

		txtUsuario2 = new JTextField();
		txtUsuario2.setBounds(116, 177, 192, 19);
		contentPane.add(txtUsuario2);
		txtUsuario2.setColumns(10);
		txtUsuario2.setText(pelicula.getUsuario());

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblImagen.setBounds(28, 220, 78, 33);
		contentPane.add(lblImagen);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudArray.remove(new Peliculas(pelicula.getCodigo(), pelicula.getTitulo(),pelicula.getGenero(),pelicula.getUsuario()));
				crudArray.add(new Peliculas(Integer.parseInt(txtAnio.getText()), txtTitulo.getText(),
						txtGenero.getText(), txtUsuario2.getText()));

				Inicio ini = null;
				try {
					ini = new Inicio(txtUsuario, crudArray);
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
					ini = new Inicio(txtUsuario, crudArray);
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
