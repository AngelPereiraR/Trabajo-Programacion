package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JLabel usuario, lblFiltro;
	private JTextField txtUsuario;
	private JButton detalles, introducir, actualizar, eliminar, estadistica, salir;
	private JTable tabla;
	private JComboBox comboFiltros;
	private DefaultTableModel dt;
	private File fb;
	private ObjectOutputStream os = null;
	private ObjectInputStream is = null;
	private ArrayList<Peliculas> arrayPeliculas = new ArrayList<>();
	private ArrayList<Peliculas> listOrdenada = new ArrayList<>();
	private Peliculas peliSelec;
	private static String[] matrizGeneros = { "Ciencia Ficción", "Terror", "Drama", "Aventura", "Acción", "Comedia",
			"Romántica", "Suspense" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Inicio(JTextField txtUsuario, ArrayList<Peliculas> arrayPeliculas)
			throws ClassNotFoundException, IOException {
		super("Películas");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);

		if (arrayPeliculas == null) {
			arrayPeliculas = new ArrayList<>();
		}

		this.arrayPeliculas = arrayPeliculas;
		this.listOrdenada = arrayPeliculas;

		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario:");
		this.txtUsuario = new JTextField(20);
		this.txtUsuario.setEditable(false);
		this.txtUsuario.setText(txtUsuario.getText());
		panel1.add(usuario);
		panel1.add(this.txtUsuario);
		add(panel1);

		JPanel panelF = new JPanel();
		lblFiltro = new JLabel("Ordenar tabla por: ");
		panelF.add(lblFiltro);

		String[] filtros = { "Título A-Z", "Título Z-A", "Género A-Z", "Año" };
		comboFiltros = new JComboBox(filtros);
		comboFiltros.setMaximumRowCount(4);
		comboFiltros.setSelectedIndex(0);
		comboFiltros.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evento) {
				if (comboFiltros.getSelectedItem().equals("Título A-Z")) {
					listOrdenada = (ArrayList<Peliculas>) listOrdenada.stream()
							.sorted(Comparator.comparing(Peliculas::getTitulo)).collect(Collectors.toList());
					try {
						rellenarTabla();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (comboFiltros.getSelectedItem().equals("Título Z-A")) {
					listOrdenada = (ArrayList<Peliculas>) listOrdenada.stream()
							.sorted(Comparator.comparing(Peliculas::getTitulo).reversed()).collect(Collectors.toList());
					try {
						rellenarTabla();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (comboFiltros.getSelectedItem().equals("Género A-Z")) {
					listOrdenada = (ArrayList<Peliculas>) listOrdenada.stream()
							.sorted(Comparator.comparing(Peliculas::getGenero)).collect(Collectors.toList());
					try {
						rellenarTabla();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (comboFiltros.getSelectedItem().equals("Año")) {
					listOrdenada = (ArrayList<Peliculas>) listOrdenada.stream()
							.sorted(Comparator.comparing(Peliculas::getCodigo)).collect(Collectors.toList());
					try {
						rellenarTabla();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		panelF.add(comboFiltros);
		add(panelF);

		JPanel panel2 = new JPanel();
		tabla = new JTable();
		tabla.setFillsViewportHeight(true);
		rellenarTabla();
		tabla.setFillsViewportHeight(true);
		panel2.add(new JScrollPane(tabla));
		add(panel2);

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

		JPanel panel6 = new JPanel();
		salir = new JButton("Salir");
		panel6.add(salir);
		add(panel6);

		tabla.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				JTable table = (JTable) Mouse_evt.getSource();
				Point point = Mouse_evt.getPoint();
				int row = table.rowAtPoint(point);
				if (Mouse_evt.getClickCount() == 1) {
					int anioSelec = Integer.parseInt((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
					String tituloSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);
					String generoSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 2);
					String usuarioSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 3);
					String rutaSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 4);
					peliSelec = new Peliculas(anioSelec, tituloSelec, generoSelec, usuarioSelec, rutaSelec);
				}
			}
		});

		ManejadorBoton mb = new ManejadorBoton();
		detalles.addActionListener(mb);
		introducir.addActionListener(mb);
		actualizar.addActionListener(mb);
		eliminar.addActionListener(mb);
		estadistica.addActionListener(mb);
		salir.addActionListener(mb);

	}

	// para acceder desde otra clase. pero tengo dudas si acceder desde el mismo
	// atributo llamandolo public.

	public static String[] getGeneroPelicula() {
		return matrizGeneros;
	}

	public void rellenarTabla() throws IOException, ClassNotFoundException {
		dt = new DefaultTableModel();
		String[] columnas = { "AÑO", "TÍTULO", "GÉNERO", "USUARIO", "RUTA IMAGEN" };
		dt.setColumnIdentifiers(columnas);
		try {
			for (Peliculas p : listOrdenada) {
				String codigo = String.valueOf(p.getCodigo());
				String titulo = p.getTitulo();
				String genero = p.getGenero();
				String usuario = p.getUsuario();
				String ruta = p.getRuta();

				Object[] fila = new Object[5];

				fila[0] = codigo;
				fila[1] = titulo;
				fila[2] = genero;
				fila[3] = usuario;
				fila[4] = ruta;

				dt.addRow(fila);
			}
		} catch (Exception ex) {
		}
		tabla.setModel(dt);
	}

	private class ManejadorBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton selec = (JButton) e.getSource();
			if (selec.equals(detalles)) {
				CRUDDetalles frame = new CRUDDetalles(txtUsuario, arrayPeliculas, peliSelec);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			} else if (selec.equals(introducir)) {
				CRUDIntroduccion frame = new CRUDIntroduccion(txtUsuario, arrayPeliculas, matrizGeneros);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();

			} else if (selec.equals(actualizar)) {
				CRUDActualizar frame = new CRUDActualizar(txtUsuario, arrayPeliculas, peliSelec, matrizGeneros);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			} else if (selec.equals(eliminar)) {
				CRUDEliminar frame = new CRUDEliminar(txtUsuario, arrayPeliculas, peliSelec);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();

			} else if (selec.equals(estadistica)) {

			} else if (selec.equals(salir)) {
				try {
					fb = new File("TrabajoProgramacion/peliculas");
					os = new ObjectOutputStream(new FileOutputStream(fb));
				} catch (Exception ex) {
				}
				try {
					os.writeObject(arrayPeliculas);
					os.close();
				} catch (IOException e1) {
				}
				System.exit(0);
			}
		}

	}

}
