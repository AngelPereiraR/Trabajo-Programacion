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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CRUDEliminar extends JFrame {
	
	private JPanel contentPane;
	private JButton btnConfirmar, btnNegacion;
	private JLabel lblNewLabel;
	
	public CRUDEliminar(JTextField txtUsuario, ArrayList<Peliculas> crudArray, Peliculas pelicula) {
		setTitle("Eliminar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);

		btnConfirmar = new JButton("Sí");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				try {
					for(Peliculas p : crudArray) {
						if(p.getCodigo()==pelicula.getCodigo() && p.getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && 
								p.getGenero().equalsIgnoreCase(pelicula.getGenero())&& p.getUsuario().equalsIgnoreCase(pelicula.getUsuario()) && p.getRuta().equals(pelicula.getRuta()))
							index = crudArray.indexOf(p);
					}
					crudArray.remove(crudArray.get(index));
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una película de la tabla con anterioridad.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
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
		btnConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnConfirmar.setBounds(105, 79, 57, 27);
		contentPane.add(btnConfirmar);

		btnNegacion = new JButton("No");
		btnNegacion.addActionListener(new ActionListener() {
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
		btnNegacion.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNegacion.setBounds(226, 79, 67, 26);
		contentPane.add(btnNegacion);
		
		lblNewLabel = new JLabel("¿Seguro que desea eliminar esta película?");
		lblNewLabel.setBounds(123, 30, 272, 13);
		contentPane.add(lblNewLabel);
		
		Image imagen = new ImageIcon("TrabajoProgramacion/images/advertencia.png").getImage();
		ImageIcon img2=new ImageIcon(imagen.getScaledInstance(57, 51, Image.SCALE_SMOOTH));
		JLabel lblImagen = new JLabel(img2);
		lblImagen.setIcon(img2);
		lblImagen.setBounds(56, 11, 57, 51);
		contentPane.add(lblImagen);
		
		setVisible(true);
	}
}
