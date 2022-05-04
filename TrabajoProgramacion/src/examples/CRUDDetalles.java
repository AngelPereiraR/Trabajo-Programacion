package examples;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CRUDDetalles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDDetalles frame = new CRUDDetalles(null, null, null, null);
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
	public CRUDDetalles(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono, ArrayList<Peliculas> crudArray) {
		setTitle("Detalles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLabelAno = new JLabel("A\u00F1o");
		JLabelAno.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelAno.setBounds(39, 38, 75, 38);
		contentPane.add(JLabelAno);
		
		JLabel JLabelTitulo = new JLabel("T\u00EDtulo");
		JLabelTitulo.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelTitulo.setBounds(39, 86, 75, 30);
		contentPane.add(JLabelTitulo);
		
		JLabel JLabelGenero = new JLabel("G\u00E9nero");
		JLabelGenero.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelGenero.setBounds(39, 126, 75, 38);
		contentPane.add(JLabelGenero);
		
		JLabel JLabelUsuario = new JLabel("Usuario");
		JLabelUsuario.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelUsuario.setBounds(39, 174, 99, 38);
		contentPane.add(JLabelUsuario);
		
		JLabel JLabelImagen = new JLabel("Imagen");
		JLabelImagen.setFont(new Font("Calibri", Font.PLAIN, 20));
		JLabelImagen.setBounds(39, 222, 75, 30);
		contentPane.add(JLabelImagen);
		
		JButton JButtonConfirmar = new JButton("Cofirmar");
		JButtonConfirmar.setFont(new Font("Calibri", Font.PLAIN, 20));
		JButtonConfirmar.setBounds(39, 280, 116, 50);
		contentPane.add(JButtonConfirmar);
		
		JButton JButtonVolver = new JButton("Volver");
		JButtonVolver.setFont(new Font("Calibri", Font.PLAIN, 20));
		JButtonVolver.setBounds(178, 280, 124, 50);
		contentPane.add(JButtonVolver);
		
		textField = new JTextField();
		textField.setBounds(124, 47, 178, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 91, 178, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 135, 177, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 183, 178, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 227, 178, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}

}
