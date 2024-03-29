package examples;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

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
	private static String[] matrizGeneros = { "Ciencia Ficci�n", "Terror", "Drama", "Aventura", "Acci�n", "Comedia",
			"Rom�ntica", "Suspense" };

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Inicio(JTextField txtUsuario, ArrayList<Peliculas> arrayPeliculas)
			throws ClassNotFoundException, IOException {
		super("Pel�culas");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		Image icono = Toolkit.getDefaultToolkit().getImage("TrabajoProgramacion/images/claqueta.png");
		setIconImage(icono);

		if (arrayPeliculas == null) {
			arrayPeliculas = new ArrayList<>();
		}

		this.arrayPeliculas = arrayPeliculas;
		this.listOrdenada = arrayPeliculas;

		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario:");
		usuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.txtUsuario = new JTextField(20);
		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		this.txtUsuario.setEditable(false);
		this.txtUsuario.setText(txtUsuario.getText());
		panel1.add(usuario);
		panel1.add(this.txtUsuario);
		getContentPane().add(panel1);

		JPanel panelF = new JPanel();
		lblFiltro = new JLabel("Ordenar tabla por: ");
		lblFiltro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panelF.add(lblFiltro);

		String[] filtros = { "T�tulo A-Z", "T�tulo Z-A", "G�nero A-Z", "A�o" };
		comboFiltros = new JComboBox(filtros);
		comboFiltros.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboFiltros.setMaximumRowCount(4);
		comboFiltros.setSelectedIndex(0);
		comboFiltros.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evento) {
				if (comboFiltros.getSelectedItem().equals("T�tulo A-Z")) {
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
				} else if (comboFiltros.getSelectedItem().equals("T�tulo Z-A")) {
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
				} else if (comboFiltros.getSelectedItem().equals("G�nero A-Z")) {
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
				} else if (comboFiltros.getSelectedItem().equals("A�o")) {
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
		getContentPane().add(panelF);

		JPanel panel2 = new JPanel();
		tabla = new JTable();
		tabla.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tabla.setFillsViewportHeight(true);
		rellenarTabla();
		tabla.setFillsViewportHeight(true);
		panel2.add(new JScrollPane(tabla));
		getContentPane().add(panel2);

		JPanel panel3 = new JPanel();
		detalles = new JButton("Detalles");
		detalles.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		introducir = new JButton("Introducir pel�cula");
		introducir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JPanel panel4 = new JPanel();
		actualizar = new JButton("Actualizar pel�cula");
		actualizar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eliminar = new JButton("Eliminar pel�cula");
		eliminar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel3.add(detalles);
		panel3.add(introducir);
		getContentPane().add(panel3);
		panel4.add(actualizar);
		panel4.add(eliminar);
		getContentPane().add(panel4);
		JPanel panel5 = new JPanel();
		estadistica = new JButton("Estad�sticas");
		estadistica.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel5.add(estadistica);
		getContentPane().add(panel5);

		JPanel panel6 = new JPanel();
		salir = new JButton("Salir");
		salir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel6.add(salir);
		getContentPane().add(panel6);

		tabla.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				JTable table = (JTable) Mouse_evt.getSource();
				Point point = Mouse_evt.getPoint();
				int row = table.rowAtPoint(point);
				try {
					if (Mouse_evt.getClickCount() == 1) {
						int anioSelec = Integer.parseInt((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
						String tituloSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);
						String generoSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 2);
						String usuarioSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 3);
						String rutaSelec = (String) tabla.getValueAt(tabla.getSelectedRow(), 4);
						peliSelec = new Peliculas(anioSelec, tituloSelec, generoSelec, usuarioSelec, rutaSelec);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una pel�cula de la tabla con anterioridad.", "ERROR", JOptionPane.ERROR_MESSAGE);
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

	public void rellenarTabla() throws IOException, ClassNotFoundException {
		dt = new DefaultTableModel();
		String[] columnas = { "A�O", "T�TULO", "G�NERO", "USUARIO", "RUTA IMAGEN" };
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
			try {
				if (selec.equals(detalles)) {
					CRUDDetalles frame = new CRUDDetalles(txtUsuario, arrayPeliculas, peliSelec);
					frame.setLocationRelativeTo(null);
					dispose();
				} else if (selec.equals(introducir)) {
					CRUDIntroduccion frame = new CRUDIntroduccion(txtUsuario, arrayPeliculas, matrizGeneros);
					frame.setLocationRelativeTo(null);
					dispose();
				} else if (selec.equals(actualizar)) {
					CRUDActualizar frame = new CRUDActualizar(txtUsuario, arrayPeliculas, peliSelec, matrizGeneros);
					frame.setLocationRelativeTo(null);
					dispose();
				} else if (selec.equals(eliminar)) {
					CRUDEliminar frame = new CRUDEliminar(txtUsuario, arrayPeliculas, peliSelec);
					frame.setLocationRelativeTo(null);
					dispose();
				} else if (selec.equals(estadistica)) {
					Estadisticas frame = new Estadisticas(txtUsuario, arrayPeliculas, matrizGeneros);
					frame.setLocationRelativeTo(null);
					dispose();
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
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una pel�cula de la tabla con anterioridad.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}

	}

}
