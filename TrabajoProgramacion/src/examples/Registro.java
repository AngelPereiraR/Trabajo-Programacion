package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {

	private File f = new File("usuarios.txt");
	private JPanel contentPane;
	private JLabel usuario, contrasena, telefono;
	private JTextField txtUsuario, txtContrasena, txtTelefono;
	private JButton btnRegistro, btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		super("Registro");
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
		txtContrasena = new JTextField(20);
		panel2.add(txtContrasena);
		add(panel2);
		
		JPanel panel3 = new JPanel();
		telefono = new JLabel("Telefono");
		panel3.add(telefono);
		txtTelefono = new JTextField(20);
		panel3.add(txtTelefono);
		add(panel3);
		
		JPanel panel4 = new JPanel();
		btnRegistro = new JButton("Registrar");
		panel4.add(btnRegistro);
		btnVolver = new JButton("Volver");
		panel4.add(btnVolver);
		add(panel4);
		
		ManejadorBotones escuchador = new ManejadorBotones();
		btnRegistro.addActionListener(escuchador);
		btnVolver.addActionListener(escuchador);
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
								Inicio frame = new Inicio(txtUsuario, txtContrasena, txtTelefono);
								frame.setVisible(true);
							}
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else if(escogido.equals(btnVolver)) {
				Bienvenido frame = new Bienvenido();
				frame.setVisible(true);
			}
			
		}
		
	}

}
