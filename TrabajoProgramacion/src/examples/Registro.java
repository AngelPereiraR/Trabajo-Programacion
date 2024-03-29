package examples;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Registro extends JFrame {

	private File f = new File("TrabajoProgramacion/usuarios.txt");
	private JPanel contentPane;
	private JLabel usuario, contrasena, telefono;
	private JTextField txtUsuario, txtContrasena, txtTelefono;
	private JButton btnRegistro, btnVolver;
	private File fb;
	private ObjectInputStream is = null;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>(), arrayPeliculasFichero = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public Registro() {
		super("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);
		
		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario");
		usuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel1.add(usuario);
		txtUsuario = new JTextField(20);
		panel1.add(txtUsuario);
		getContentPane().add(panel1);
		
		JPanel panel2 = new JPanel();
		contrasena = new JLabel("Contrase�a");
		contrasena.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel2.add(contrasena);
		txtContrasena = new JTextField(20);
		panel2.add(txtContrasena);
		getContentPane().add(panel2);
		
		JPanel panel3 = new JPanel();
		telefono = new JLabel("Tel�fono");
		telefono.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel3.add(telefono);
		txtTelefono = new JTextField(20);
		panel3.add(txtTelefono);
		getContentPane().add(panel3);
		
		JPanel panel4 = new JPanel();
		btnRegistro = new JButton("Registrar");
		btnRegistro.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel4.add(btnRegistro);
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel4.add(btnVolver);
		getContentPane().add(panel4);
		
		ManejadorBotones escuchador = new ManejadorBotones();
		btnRegistro.addActionListener(escuchador);
		btnVolver.addActionListener(escuchador);
		
		setVisible(true);
	}
	
	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton escogido = (JButton) e.getSource();
			
			if(escogido.equals(btnRegistro)) {
				try {
					boolean existe = false;
					if (f.exists()) {
						if (f.isFile()) {
							BufferedReader br = new BufferedReader(new FileReader(f));
							String linea = br.readLine();
							while (linea != null) {
								String[] datos = linea.split(";");
								if (txtUsuario.getText().equals(datos[0]) && txtContrasena.getText().equals(datos[1]) && txtTelefono.getText().equals(datos[2])) {
									existe = true;
								}
								linea = br.readLine();
							}
							br.close();
							if (existe == true) {
								JOptionPane.showMessageDialog(Registro.this, "Ya existe un usuario con esos credenciales.");
							} else {
								FileWriter fw = new FileWriter(f, true);
								fw.write(txtUsuario.getText() + ";" + txtContrasena.getText() + ";" + txtTelefono.getText() + "\n");
								fw.close();
								fb = new File("TrabajoProgramacion/peliculas");
								if (fb.exists()) {
									is = new ObjectInputStream(new FileInputStream(fb));
									try {
										arrayPeliculasFichero = (ArrayList<Peliculas>) is.readObject();
										while (arrayPeliculas != null) {
											arrayPeliculas.addAll(arrayPeliculasFichero);
											arrayPeliculasFichero = (ArrayList<Peliculas>) is.readObject();
										}
									}
									catch (Exception ex) {}
								}
								Inicio frame = new Inicio(txtUsuario, arrayPeliculasFichero);
								frame.setVisible(true);
								dispose();
							}
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else if(escogido.equals(btnVolver)) {
				Bienvenido frame = new Bienvenido();
				frame.setVisible(true);
				dispose();
			}
			
		}
		
	}

}
