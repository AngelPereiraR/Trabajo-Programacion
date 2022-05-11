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

public class Estadisticas extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver, btnRuta;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>();
	private int[] matrizNumGeneros;

	/**
	 * Create the frame.
	 */
	public Estadisticas(JTextField txtUsuario, ArrayList<Peliculas> crudArray) {
		setTitle("Estadisticas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 212, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("IPhone 5s", new Double(20));
		dataset.setValue("SamSung Grand", new Double(20));
		dataset.setValue("MotoG", new Double(40));
		dataset.setValue("Nokia Lumia", new Double(10));

		JFreeChart chart = ChartFactory.createPieChart(// char t

				"Mobile Sales", // title
				dataset, // data
				true, // include legend
				true, false);

		ChartPanel panel = new ChartPanel(chart);

		// Creamos la ventana
		JFrame ventana = new JFrame("Grafica");
		ventana.setVisible(true);
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.add(panel);
*/
		btnVolver = new JButton("Volver");
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
		btnVolver.setBounds(202, 279, 106, 33);
		contentPane.add(btnVolver);

		

	}

	//java.awt.event.ActionEvent evt
	 public void jButtonAction(ArrayList<Peliculas> crudArray, int[] matrizNumGeneros) {
	 
		// ----   Boton de acción del gráfico   ------
		 
		// Accedo a los generos del arrayList escogidos del comboBox y
		// almaceno de datos desde un bucle for para guardarlos en una matriz de enteros
			String[] generos = Inicio.getGeneroPelicula();
			for (int i = 0; i < generos.length; i++) {
				int numGen = 0;
				for (Peliculas p : crudArray) {
					if (p.getGenero().equalsIgnoreCase(generos[i]))
						numGen++;
					matrizNumGeneros[i] = numGen;
				}
			}
		 
			
		// JFreeChart grafico_circular = new JFreeChart();
		
	 }

}
