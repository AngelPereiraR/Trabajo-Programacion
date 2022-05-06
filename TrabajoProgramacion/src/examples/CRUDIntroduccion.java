package examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CRUDIntroduccion extends JFrame {

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
	public CRUDIntroduccion(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono,
			ArrayList<Peliculas> crudArray) {
		setTitle("Creación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		arrayPeliculas = crudArray;

		JLabel JLabelAno = new JLabel("Año");
		JLabelAno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelAno.setBounds(28, 30, 78, 52);
		contentPane.add(JLabelAno);

		JLabel JLabelTitulo = new JLabel("Título");
		JLabelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelTitulo.setBounds(28, 76, 78, 41);
		contentPane.add(JLabelTitulo);

		JLabel JLabelGenero = new JLabel("Género");
		JLabelGenero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelGenero.setBounds(28, 114, 89, 56);
		contentPane.add(JLabelGenero);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 164, 78, 46);
		contentPane.add(lblNewLabel);

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
		textField_3.setEditable(false);
	

		JLabel JLabelImagen = new JLabel("Imagen");
		JLabelImagen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelImagen.setBounds(28, 220, 78, 33);
		contentPane.add(JLabelImagen);

		//Usuario
		//int codeUsuario = Integer.parseInt(txtTelefono.getText());
		//Usuario user = new Usuario(txtUsuario.getText(),txtContrasena.getText(), codeUsuario);
		
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Es importante este dato, porque aquí es donde se guardan los datos creados en el array
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
					frame = new Inicio(txtUsuario, txtContrasena, txtTelefono, arrayPeliculas);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
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
				dispose();
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
