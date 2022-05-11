package examples;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Estadisticas extends JFrame {

	private int[] matrizNumGeneros;

	/**
	 * Create the frame.
	 */
	public Estadisticas(JTextField txtUsuario, ArrayList<Peliculas> crudArray, String[] matrizGeneros) {
		super("Estadísticas");
		
		setSize(524, 477);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);

		matrizNumGeneros = new int[matrizGeneros.length];
		for (int i = 0; i < matrizGeneros.length; i++) {
			int numGen = 0;
			for (Peliculas p : crudArray) {
				if (p.getGenero().equalsIgnoreCase(matrizGeneros[i]))
					numGen++;
				matrizNumGeneros[i] = numGen;
			}
		}

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Ciencia Ficción", new Integer(matrizNumGeneros[0]));
		dataset.setValue("Terror", new Integer(matrizNumGeneros[1]));
		dataset.setValue("Drama", new Integer(matrizNumGeneros[2]));
		dataset.setValue("Aventura", new Integer(matrizNumGeneros[3]));
		dataset.setValue("Acción", new Integer(matrizNumGeneros[4]));
		dataset.setValue("Comedia", new Integer(matrizNumGeneros[5]));
		dataset.setValue("Romántica", new Integer(matrizNumGeneros[6]));
		dataset.setValue("Suspense", new Integer(matrizNumGeneros[7]));

		JFreeChart chart = ChartFactory.createPieChart(

				"Peliculas por Género",
				dataset,
				true,
				true, false);
		getContentPane().setLayout(null);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 512, 404);

		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
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
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnVolver.setBounds(200, 414, 91, 21);
		
		setVisible(true);


	}

}
