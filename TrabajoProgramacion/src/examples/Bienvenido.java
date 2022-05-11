package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Bienvenido extends JFrame {

	private JPanel contentPane;
	private JPanel panel1, panel2, panel3;
	private JLabel bienvenido;
	private JButton btnReg, btnIni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido frame = new Bienvenido();
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
	public Bienvenido() {
		super("Bienvenido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);
		
		panel1 = new JPanel();
		bienvenido = new JLabel("Bienvenid@ a Cinema Paradise");
		bienvenido.setFont(new Font("Segoe Print", Font.BOLD, 20));
		panel1.add(bienvenido);
		getContentPane().add(panel1);
		
		panel3 = new JPanel();
		JLabel lblImagen = new JLabel();
		Icon imagen = new ImageIcon("TrabajoProgramacion/images/cine.png");
		lblImagen.setIcon(imagen);
		panel3.add(lblImagen);
		getContentPane().add(panel3);

		panel2 = new JPanel();
		btnReg = new JButton("Registrar Usuario");
		btnReg.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnIni = new JButton("Iniciar Sesión");
		btnIni.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel2.add(btnReg);
		panel2.add(btnIni);
		getContentPane().add(panel2);
		
		ManejadorBotones escuchador = new ManejadorBotones();
		btnReg.addActionListener(escuchador);
		btnIni.addActionListener(escuchador);
		
	}
	
	private class ManejadorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton escogido = (JButton) e.getSource();
			
			if(escogido.equals(btnReg)) {
				Registro frame = new Registro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			} else if(escogido.equals(btnIni)) {
				IniciarSesion frame = new IniciarSesion();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
			
		}
		
	}

}
