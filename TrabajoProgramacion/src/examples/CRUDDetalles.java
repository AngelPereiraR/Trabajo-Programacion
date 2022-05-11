package examples;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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

public class CRUDDetalles extends JFrame {

	private JPanel contentPane;
	private JLabel txtUsuario2, txtAnio, txtTitulo, txtGenero;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public CRUDDetalles(JTextField txtUsuario, ArrayList<Peliculas> crudArray, Peliculas pelicula) {
		setTitle("Detalles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);

		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsuario.setBounds(261, 10, 78, 46);
		contentPane.add(lblUsuario);

		txtUsuario2 = new JLabel(pelicula.getUsuario());
		txtUsuario2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtUsuario2.setBounds(349, 26, 192, 19);
		contentPane.add(txtUsuario2);
		

		JLabel lblAnio = new JLabel("Año:");
		lblAnio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAnio.setBounds(261, 115, 78, 52);
		contentPane.add(lblAnio);

		txtAnio = new JLabel(String.valueOf(pelicula.getCodigo()));
		txtAnio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtAnio.setBounds(360, 132, 192, 19);
		contentPane.add(txtAnio);
	
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTitulo.setBounds(261, 67, 78, 41);
		contentPane.add(lblTitulo);

		txtTitulo = new JLabel(pelicula.getTitulo());
		txtTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTitulo.setBounds(349, 78, 192, 19);
		contentPane.add(txtTitulo);
		
		JLabel lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGenero.setBounds(261, 175, 89, 56);
		contentPane.add(lblGenero);

		txtGenero = new JLabel(pelicula.getGenero());
		txtGenero.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtGenero.setBounds(360, 196, 192, 19);
		contentPane.add(txtGenero);
		
		Image imagen = new ImageIcon(pelicula.getRuta()).getImage();
		ImageIcon img2=new ImageIcon(imagen.getScaledInstance(167, 232, Image.SCALE_SMOOTH));
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(img2);
		lblImagen.setBounds(40, 26, 167, 232);
		contentPane.add(lblImagen);
		
	
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
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVolver.setBounds(374, 264, 106, 33);
		contentPane.add(btnVolver);
		
		setVisible(true);
	}
}
