package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JLabel usuario, contrasena;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnIniciar;
	private File fb;
	private ObjectInputStream is = null;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>(), arrayPeliculasFichero = new ArrayList<>();
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		super("Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);
		
		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario ");
		usuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel1.add(usuario);
		txtUsuario = new JTextField(12);
		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel1.add(txtUsuario);
		getContentPane().add(panel1);
		
		JPanel panel2 = new JPanel();
		contrasena = new JLabel("Contraseña");
		contrasena.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel2.add(contrasena);
		txtContrasena = new JPasswordField(13);
		txtContrasena.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel2.add(txtContrasena);
		getContentPane().add(panel2);
		
		JPanel panel3 = new JPanel();
		btnIniciar = new JButton("Iniciar Sesión");
		btnIniciar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel3.add(btnIniciar);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel3.add(btnNewButton);
		getContentPane().add(panel3);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Bienvenido frame = new Bienvenido();
				frame.setVisible(true);
				dispose();
				
			}
		});
		//btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(200, 414, 91, 21);
		//contentPane.add(btnVolver);
		
		ManejadorBotones escuchador = new ManejadorBotones();
		btnIniciar.addActionListener(escuchador);
		
		
		
		setVisible(true);
	}
	
	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton escogido = (JButton) e.getSource();
			char[] arrayC = txtContrasena.getPassword();
			String pass = new String(arrayC);
			if(escogido.equals(btnIniciar)) {
				try {
					File f = new File("TrabajoProgramacion/usuarios.txt");
					boolean existe = false;
					if (f.exists()) {
						if (f.isFile()) {
							BufferedReader br = new BufferedReader(new FileReader(f));
							String linea = br.readLine();
							while (linea != null) {
								String[] datos = linea.split(";");
								if (txtUsuario.getText().equals(datos[0]) && pass.equals(datos[1])) {
									existe = true;
								}
								linea = br.readLine();
							}
							br.close();
							if (existe == true) {
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
								Inicio frame = new Inicio(txtUsuario, arrayPeliculas);
								frame.setVisible(true);
								dispose();
							} else {
								JOptionPane.showMessageDialog(IniciarSesion.this, "No existe ningún usuario con ambos credenciales.");
							}
						}
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
	}

}
