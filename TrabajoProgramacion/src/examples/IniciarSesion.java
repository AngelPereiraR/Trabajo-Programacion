package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JLabel usuario, contrasena;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
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
	public IniciarSesion() {
		super("Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario");
		panel1.add(usuario);
		txtUsuario = new JTextField(20);
		panel1.add(txtUsuario);
		add(panel1);
		
		JPanel panel2 = new JPanel();
		contrasena = new JLabel("Contraseña");
		panel2.add(contrasena);
		txtContrasena = new JPasswordField(20);
		panel2.add(txtContrasena);
		add(panel2);
		
		JPanel panel3 = new JPanel();
		btnIniciar = new JButton("Iniciar Sesión");
		panel3.add(btnIniciar);
		add(panel3);
		
		ManejadorBotones escuchador = new ManejadorBotones();
		btnIniciar.addActionListener(escuchador);
	}
	
	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton escogido = (JButton) e.getSource();
			//Cambio al obtener la contraseña
			//Recupera la contraseña como array de char y pasa el array a un String
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
								//Cambio en la comparacion de la clave
								if (txtUsuario.getText().equals(datos[0]) && pass.equals(datos[1])) {
									existe = true;
								}
								linea = br.readLine();
							}
							br.close();
							if (existe == true) {
								Inicio frame = new Inicio(txtUsuario, txtContrasena, null, null);
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
