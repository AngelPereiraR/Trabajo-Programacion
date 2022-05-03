package examples;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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
	private JLabel usuario;
	private JTextField txtUsuario;
	private JButton detalles, introducir, actualizar, eliminar, estadistica;
	private JTable tabla;
	private DefaultTableModel dt;
	private File fb;
	private ObjectOutputStream os = null;
	private ObjectInputStream is = null;
	//private (Creación del ArrayList)
	
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Inicio(JTextField txtUsuario, JTextField txtContrasena, JTextField txtTelefono) throws ClassNotFoundException, IOException {
		super("Películas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		fb = new File("TrabajoProgramacion/peliculas");
		if(fb.exists()) {
			is = new ObjectInputStream(new FileInputStream(fb));
			try {
				Peliculas p = (Peliculas) is.readObject();
				while (p != null) {
					//Cuando esté el CRUD terminado, ArrayList se convertirá en el arrayList creado por el CRUD
					//ArrayList.add(p);
					p = (Peliculas) is.readObject();
				}
			} catch (Exception ex) {}
			is.close();
		}
		
		JPanel panel1 = new JPanel();
		usuario = new JLabel("Usuario:");
		this.txtUsuario = new JTextField(20);
		this.txtUsuario.setEditable(false);
		this.txtUsuario.setText(txtUsuario.getText());
		panel1.add(usuario);
		panel1.add(this.txtUsuario);
		add(panel1);
		
		JPanel panel2=new JPanel();
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
		
		try {
			if (fb.exists()) {
				os = new AppendableObjectOutputStream(new FileOutputStream(fb, true));
			} else {
				os = new ObjectOutputStream(new FileOutputStream(fb));
			}
		} catch (Exception ex) {}
		
		//Cuando esté el CRUD terminado, ArrayList se convertirá en el arrayList creado por el CRUD
		//os.writeObject(ArrayList);
		os.close();
	}
	//Metodo rellenar tabla 
		public void rellenarTabla() throws IOException, ClassNotFoundException {
			//Crear un objeto del modelo generico de tabla
			dt=new DefaultTableModel();
			//Definir un array de columnas (Tantas como se necesiten)
			String[] columnas= {"CÓDIGO","TÍTULO","GÉNERO","USUARIO"};
			//Define los nombres de las columnas
			dt.setColumnIdentifiers(columnas);
			//Comprobamos si existe el fichero 
			if (fb.exists()) {
				//Abrimos flujo de lectura
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fb));
				//Crea un array de Objetos peliculas
				List<Peliculas> peliculas = new ArrayList<>();
				peliculas = (ArrayList<Peliculas>) ois.readObject();
				//Bucle que lee todos los objetos del fichero binario
				for (Peliculas p : peliculas) {
					//Separa la informacion de cada la linea del fichero por ;
					//o por cualquier caracter que se especifique
					//Array de datos separados por ;
					String codigo = String.valueOf(p.getCodigo());
					String titulo = p.getTitulo();
					String genero = p.getGenero();
					String usuario = p.getUsuario().getUsuario();
					
					//Creamos un array de object fila que sea tan largo como columnas haya
					Object[] fila=new Object[4];
					//Asignamos la info a cada espacio de la tabla
					fila[0]= codigo;
					fila[1]= titulo;
					fila[2]= genero;
					fila[3]= usuario;
					//Añadimos la fila a la tabla
					dt.addRow(fila);
				}
				//Establecemos el modelo establecido a la tabla
				tabla.setModel(dt);
			}
		}
}
