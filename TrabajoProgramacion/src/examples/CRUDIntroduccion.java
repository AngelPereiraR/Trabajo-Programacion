package examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CRUDIntroduccion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDIntroduccion frame = new CRUDIntroduccion(null, null, null, null);
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
	public CRUDIntroduccion(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono, ArrayList<Peliculas> crudArray) {
		setTitle("INTRODUCCI\u00D3N DE DATOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLabelAno = new JLabel("A\u00F1o");
		JLabelAno.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelAno.setBounds(28, 30, 78, 52);
		contentPane.add(JLabelAno);
		
		JLabel JLabelTitulo = new JLabel("T\u00EDtulo");
		JLabelTitulo.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelTitulo.setBounds(28, 76, 78, 41);
		contentPane.add(JLabelTitulo);
		
		JLabel JLabelGenero = new JLabel("G\u00E9nero");
		JLabelGenero.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelGenero.setBounds(28, 114, 89, 56);
		contentPane.add(JLabelGenero);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 164, 78, 46);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 86, 213, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(116, 46, 213, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 132, 213, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 177, 213, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel JLabelImagen = new JLabel("Imagen");
		JLabelImagen.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelImagen.setBounds(28, 220, 78, 33);
		contentPane.add(JLabelImagen);
		
		JButton BotonConfirmar = new JButton("Confirmar");
		BotonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//crudArray.add(new Peliculas())
				
				Inicio ini = null;
			try {
				ini = new Inicio(txtUsuario, txtContrasena, txtTelefono);
			} catch (ClassNotFoundException | IOException e1) {}
			ini.setVisible(true);
			ini.setLocationRelativeTo(null);
			dispose();
			}
		});
		BotonConfirmar.setFont(new Font("Calibri", Font.PLAIN, 20));
		BotonConfirmar.setBounds(28, 279, 138, 41);
		contentPane.add(BotonConfirmar);
		
		JButton ButtonVolver = new JButton("Volver");
		ButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ini = null;
				try {
					ini = new Inicio(txtUsuario, txtContrasena, txtTelefono);
				} catch (ClassNotFoundException | IOException e1) {}
				ini.setVisible(true);
				ini.setLocationRelativeTo(null);
				dispose();
			}
		});
		ButtonVolver.setFont(new Font("Calibri", Font.PLAIN, 20));
		ButtonVolver.setBounds(202, 279, 127, 41);
		contentPane.add(ButtonVolver);
	}
}
