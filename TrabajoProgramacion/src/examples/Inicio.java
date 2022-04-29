package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JLabel usuario, titulo;
	private JTextField txtUsuario;
	private JButton detalles, introducir, actualizar, eliminar, estadistica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio(null, null, null);
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
	public Inicio(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono) {
		super("Películas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario:");
		this.txtUsuario = new JTextField(20);
		this.txtUsuario.setEditable(false);
		this.txtUsuario.setText(txtUsuario.getText());
		panel1.add(usuario);
		panel1.add(this.txtUsuario);
		add(panel1);
		//panel2...
		//JTable...
		JPanel panel3 = new JPanel();
		detalles = new JButton("Detalles");
		introducir = new JButton("Introducir película");
		JPanel panel4 = new JPanel();
		actualizar = new JButton("Actualizar película");
		eliminar = new JButton("Eliminar película");
		panel3.add(detalles);
		panel3.add(introducir);
		add(panel3);
		panel4.add(actualizar);
		panel4.add(eliminar);
		add(panel4);
		JPanel panel5 = new JPanel();
		estadistica = new JButton("Estadísticas");
		panel5.add(estadistica);
		add(panel5);
	}

}
