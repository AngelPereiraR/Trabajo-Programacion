package examples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import examples.CRUDIntroduccion.InsertImg;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;

public class CRUDActualizar extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario2, txtAnio, txtTitulo, txtGenero;
	private JButton btnConfirmar, btnVolver, btnRuta;
	private ArrayList<Peliculas> arrayPeliculas;

	/**
	 * Create the frame.
	 */
	public CRUDActualizar(JTextField txtUsuario, ArrayList<Peliculas> crudArray, Peliculas pelicula, String [] matrizGeneros) {
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
		//lblAnio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAnio.setBounds(28, 67, 78, 52);
		contentPane.add(lblAnio);

		txtAnio = new JTextField();
		txtAnio.setBounds(116, 86, 192, 19);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		txtAnio.setText(String.valueOf(pelicula.getCodigo()));

		JLabel lblTitulo = new JLabel("Título");
		//lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTitulo.setBounds(28, 21, 78, 41);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(116, 34, 192, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		txtTitulo.setText(pelicula.getTitulo());

		JLabel lblGenero = new JLabel("Género");
		//lblGenero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGenero.setBounds(28, 114, 89, 56);
		contentPane.add(lblGenero);

		JComboBox comboBox = new JComboBox(matrizGeneros);
		comboBox.setBounds(116, 134, 192, 21);
		comboBox.setMaximumRowCount(7);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evento) {
				JComboBox combo = (JComboBox) evento.getSource();
			}
		});
		
		txtGenero = new JTextField();
		txtGenero.setBounds(116, 132, 192, 19);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		txtGenero.setText(pelicula.getGenero());

		JLabel lblUsuario = new JLabel("Usuario");
		//lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsuario.setBounds(28, 164, 78, 46);
		contentPane.add(lblUsuario);

		txtUsuario2 = new JTextField();
		txtUsuario2.setBounds(116, 177, 192, 19);
		contentPane.add(txtUsuario2);
		txtUsuario2.setColumns(10);
		txtUsuario2.setText(pelicula.getUsuario());

		JLabel lblImagen = new JLabel("Imagen");
		//lblImagen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblImagen.setBounds(28, 220, 78, 33);
		contentPane.add(lblImagen);
		
		Icon lupa = new ImageIcon("TrabajoProgramacion/images/lupa.png");
		
		btnRuta = new JButton("",lupa);
		btnRuta.setToolTipText("Buscar archivo");
		btnRuta.setBackground(new Color(238,238,238));
		btnRuta.setBorderPainted(false);
		btnRuta.setBounds(116, 222, 51, 46);
		getContentPane().add(btnRuta);
		InsertImg insertImg = new InsertImg();
		btnRuta.addActionListener(insertImg);
		

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				for(Peliculas p : crudArray) {
					
					//aquí falla algo
					if(p.getCodigo()==pelicula.getCodigo() && p.getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && 
							p.getGenero().equalsIgnoreCase(pelicula.getGenero())&& p.getUsuario().equalsIgnoreCase(pelicula.getUsuario()) && p.getRuta().equals(pelicula.getRuta()))
						index = crudArray.indexOf(p);
				}
				crudArray.remove(crudArray.get(index));
				//aqui falla algo también
				crudArray.add(new Peliculas(Integer.parseInt(txtAnio.getText()), txtTitulo.getText(),
						(String) comboBox.getSelectedItem(), txtUsuario2.getText(), btnRuta.getText()));

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
		//btnConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
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
		//btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnVolver.setBounds(202, 279, 106, 33);
		contentPane.add(btnVolver);
	}

	public class InsertImg implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton jtname = (AbstractButton) e.getSource();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			fileChooser.setFileFilter(soloImg);

			fileChooser.showSaveDialog(null);
			
			String ficheroNombre = fileChooser.getSelectedFile().getName();

			Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();
			
			jtname.setText("TrabajoProgramacion/images/" + ficheroNombre);
			
			File imagenes = new File(jtname.getText());
			
			Path destination = imagenes.toPath();

			try {
				Files.copy(sourcer, destination);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
