package examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CRUDIntroduccion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario2, txtAnio, txtTitulo, txtGenero;
	private JButton btnConfirmar, btnVolver, btnRuta;
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
	public CRUDIntroduccion(JTextField txtUsuario, ArrayList<Peliculas> crudArray) {
		setTitle("Creaci�n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario2 = txtUsuario;
		arrayPeliculas = crudArray;

		JLabel JLabelAno = new JLabel("A�o");
		JLabelAno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelAno.setBounds(28, 30, 78, 41);
		contentPane.add(JLabelAno);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(116, 46, 192, 19);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);

		JLabel JLabelTitulo = new JLabel("T�tulo");
		JLabelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelTitulo.setBounds(28, 76, 78, 52);
		contentPane.add(JLabelTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(116, 92, 192, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel JLabelGenero = new JLabel("G�nero");
		JLabelGenero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelGenero.setBounds(28, 114, 89, 56);
		contentPane.add(JLabelGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(116, 132, 192, 19);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 164, 78, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel(txtUsuario.getText());
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsuario.setBounds(116, 177, 192, 25);
		contentPane.add(lblUsuario);

		JLabel JLabelImagen = new JLabel("Imagen");
		JLabelImagen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JLabelImagen.setBounds(28, 220, 78, 33);
		contentPane.add(JLabelImagen);
		
		btnRuta = new JButton("");
		btnRuta.setToolTipText("Buscar archivo");
		btnRuta.setBounds(116, 225, 192, 19);
		getContentPane().add(btnRuta);
		InsertImg insertImg = new InsertImg();
		btnRuta.addActionListener(insertImg);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudArray.add(new Peliculas(Integer.parseInt(txtAnio.getText()), txtTitulo.getText(), txtGenero.getText(), JLabelImagen.getText(), btnRuta.getText()));

				Inicio ini = null;
				try {
					ini = new Inicio(txtUsuario, crudArray);
				} catch (ClassNotFoundException | IOException e1) {}
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
	
	
	public class InsertImg implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton jtname = (AbstractButton) e.getSource();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			fileChooser.setFileFilter(soloImg);

			fileChooser.showSaveDialog(null);

			Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();
			
			jtname.setText(sourcer.toString());
			
			File imagenes = new File(jtname.getText());
			
			Path destination = imagenes.toPath();

			try {
				if (!imagenes.exists())
					Files.copy(sourcer, destination);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	 
	 
}
