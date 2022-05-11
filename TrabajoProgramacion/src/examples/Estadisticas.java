package examples;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
*/
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;

public class Estadisticas extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver, btnRuta;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>();
	private int[] matrizNumGeneros;

	/**
	 * Create the frame.
	 */
	public Estadisticas(JTextField txtUsuario, ArrayList<Peliculas> crudArray, String[] matrizGeneros) {
		// Creamos la ventana
		super("Estadísticas");
		
		setSize(524, 477);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);*/

		matrizNumGeneros = new int[matrizGeneros.length];
		for (int i = 0; i < matrizGeneros.length; i++) {
			int numGen = 0;
			for (Peliculas p : crudArray) {
				if (p.getGenero().equalsIgnoreCase(matrizGeneros[i]))
					numGen++;
				matrizNumGeneros[i] = numGen;
			}
		}

		// matrizGeneros = { "Ciencia Ficción", "Terror", "Drama", "Aventura", "Acción",
		// "Comedia", "Romántica", "Suspense" };

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Ciencia Ficción", new Integer(matrizNumGeneros[0]));
		dataset.setValue("Terror", new Integer(matrizNumGeneros[1]));
		dataset.setValue("Drama", new Integer(matrizNumGeneros[2]));
		dataset.setValue("Aventura", new Integer(matrizNumGeneros[3]));
		dataset.setValue("Comedia", new Integer(matrizNumGeneros[4]));
		dataset.setValue("Romántica", new Integer(matrizNumGeneros[5]));
		dataset.setValue("Suspense", new Integer(matrizNumGeneros[6]));

		JFreeChart chart = ChartFactory.createPieChart(// char t

				"Peliculas por Género", // title
				dataset, // data
				true, // include legend
				true, false);
		getContentPane().setLayout(null);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 512, 404);

		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
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
		//btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnVolver.setBounds(186, 414, 91, 21);
		//contentPane.add(btnVolver);
		
		
		
		
		
		
		
		setVisible(true);


	}

}
