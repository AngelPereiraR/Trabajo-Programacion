package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IniciarRegistrar extends JFrame {

	private JPanel contentPane;
	private JLabel usuario, contrasena;
	private JTextField txtUsuario, txtContrasena;
	private JButton btnRegistro, btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarRegistrar frame = new IniciarRegistrar();
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
	public IniciarRegistrar() {
		super("Iniciar o Registrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 550, 300);
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
		txtContrasena = new JTextField(20);
		panel2.add(txtContrasena);
		add(panel2);
		
		JPanel panel3 = new JPanel();
		btnRegistro = new JButton("Registrar Usuario");
		panel3.add(btnRegistro);
		btnIniciar = new JButton("Iniciar Sesión");
		panel3.add(btnIniciar);
		add(panel3);
		
		ManejadorBotones escuchador = new ManejadorBotones();
		btnRegistro.addActionListener(escuchador);
		btnIniciar.addActionListener(escuchador);
	}
	
	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton escogido = (JButton) e.getSource();
			
			if(escogido.equals(btnRegistro)) {
				Registro frame = new Registro();
				frame.setVisible(true);
			} else if(escogido.equals(btnIniciar)) {
				try {
					File f = new File("usuarios.txt");
					boolean existe = false;
					if (f.exists()) {
						if (f.isFile()) {
							BufferedReader br = new BufferedReader(new FileReader(f));
							String linea = br.readLine();
							while (linea != null) {
								String[] datos = linea.split(";");
								if (txtUsuario.getText().equals(datos[0]) && txtContrasena.getText().equals(datos[1])) {
									existe = true;
								}
								linea = br.readLine();
							}
							br.close();
							if (existe == true) {
								Inicio frame = new Inicio(txtUsuario, txtContrasena, null);
								frame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(IniciarRegistrar.this, "No existe ningún usuario con ambos credenciales.");
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
