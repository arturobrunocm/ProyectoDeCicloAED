package interfases;

import clases.Alumno;
import arreglos.ArregloAlumno;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
 
public class _02MantenimientoAlumno extends JDialog implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JComboBox <String> cboEstado;
	private JLabel lblCodigo;
	private JLabel lblApellidos;
	private JLabel lblNombres;
	private JLabel lblDni;
	private JLabel lblEdad;
	private JScrollPane scrollPane;
	private JTable tblAlumno;
	private DefaultTableModel modelo;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_02MantenimientoAlumno dialog = new _02MantenimientoAlumno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public _02MantenimientoAlumno() {
		setForeground(new Color(0, 0, 0));
		setBackground(Color.WHITE);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Mantenimiento | Alumno");
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(null);
					
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigo.setBounds(10, 10, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigo.setBounds(73, 8, 130, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblNombres.setBounds(10, 34, 66, 14);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtNombres.setBounds(73, 32, 130, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblApellidos.setBounds(10, 58, 65, 14);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtApellidos.setBounds(73, 56, 130, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblDni.setBounds(10, 82, 46, 14);
		getContentPane().add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtDNI.setBounds(73, 80, 130, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblEdad.setBounds(10, 106, 46, 14);
		getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtEdad.setBounds(73, 104, 130, 20);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCelular.setBounds(10, 130, 46, 14);
		getContentPane().add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCelular.setBounds(73, 128, 130, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblEstado.setBounds(10, 154, 46, 14);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Consolas", Font.PLAIN, 10));
		cboEstado.setBounds(73, 152, 130, 20);
		getContentPane().add(cboEstado);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(537, 6, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(537, 30, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(537, 54, 89, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 616, 213);
		getContentPane().add(scrollPane);
		
		tblAlumno = new JTable();
		tblAlumno.addMouseListener(this);
		tblAlumno.getTableHeader().setReorderingAllowed(false);
		tblAlumno.setFillsViewportHeight(true);
		tblAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		scrollPane.setViewportView(tblAlumno);

		modelo = new DefaultTableModel();
		modelo.addColumn("C?digo");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		tblAlumno.setModel(modelo);
		
		separator = new JSeparator();
		separator.setBounds(10, 178, 616, 2);
		getContentPane().add(separator);
		
		ajustarAnchoColumnas();
		listar(0);
		obtenerDatos();
		habilitarEntradas(false);
	}

	/**
	 * Programaci?n de botones
	 */
	ArregloAlumno aa = new ArregloAlumno();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
	}
	
	// Adiciona un nuevo alumno verificando que el c?digo no se repita
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			if (btnAdicionar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLUE);
				btnModificar.setForeground(Color.BLACK);
				btnEliminar.setForeground(Color.BLACK);
				habilitarEntradas(true);
				limpieza();
				txtNombres.requestFocus();
			} else {
				adicionarModificar();
			}			
		} catch (Exception e) {
			mensaje("D?tos no validos.");
			limpieza();
		}
	}
	
	// Busca un c?digo y si existe modifica los datos del Alumno
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (aa.tama?o() > 0) {
			if (btnModificar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLACK);
				btnModificar.setForeground(Color.BLUE);
				btnEliminar.setForeground(Color.BLACK);
				obtenerDatos();
				habilitarEntradas(true);
				txtNombres.requestFocus();
			} else {
				adicionarModificar();
			}			
		} else {
			mensaje("No existen alumnos.");
		}
	}

	// Busca un c?digo y si existe retira el curso del arreglo
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (aa.tama?o() > 0) {
			btnAdicionar.setForeground(Color.BLACK);
			btnModificar.setForeground(Color.BLACK);
			btnEliminar.setForeground(Color.BLUE);
			obtenerDatos();
			habilitarEntradas(false);
			
			int codigo = leerCodigo();
			Alumno a = aa.buscarAlumno(codigo);
			
			if (a.getEstado() == 0) {
				String nombre = leerNombre();
				String apellido = leerApellido();
				int confirmacion = confirmar("?Desea eliminar al alumno " + nombre + " " + apellido + " ?");
				
				if (confirmacion == 0) {
					int posFila = tblAlumno.getSelectedRow();
					
					if (posFila == aa.tama?o() - 1) {
						posFila--;
					}
					aa.eliminar(a);
					listar(posFila);
					obtenerDatos();
				}
			} else {
				mensaje("Solo se puede eliminar alumnos registrados");
			}			
			btnEliminar.setForeground(Color.BLACK);
		} else {
			mensaje("No existen alumnos.");
		}
	}
	
	/**
	 * M?todos adicionales
	 */
	// M?todos sin valor de retorno
	void adicionarModificar() {
		int codigo = aa.numeroCorrelativo();
		String nombre = leerNombre();
		String apellido = leerApellido();
		String dni = leerDNI();
		int edad = leerEdad();
		int celular = leerCelular();
		int estado = leerEstado();
		int posFila = tblAlumno.getSelectedRow();
		
		try {
			if (btnAdicionar.getForeground() == Color.BLUE) {
				if (aa.buscarAlumno(codigo) == null) {
					Alumno a = new Alumno(codigo, nombre, apellido, dni, edad, celular, estado);
					posFila = aa.tama?o();
					aa.adicionar(a);
					limpieza();
					txtCodigo.setText("" + aa.numeroCorrelativo());
					txtNombres.requestFocus();
				} else {
					mensaje("El c?digo ya existe.");
					limpieza();
				}
			}
			if (btnModificar.getForeground() == Color.BLUE) {
				Alumno a = aa.obtener(posFila);
				a.setNombres(nombre);
				a.setApellidos(apellido);
				a.setDNI(dni);
				a.setEdad(edad);
				a.setCelular(celular);
				a.setEstado(estado);
				btnModificar.setForeground(Color.BLACK);
				habilitarEntradas(false);
			}
			listar(posFila);
		} catch (Exception e) {
			mensaje("Datos no validos.");
			limpieza();
		}		
	}
	void habilitarEntradas(boolean trueFalse) {
		txtNombres.setEditable(trueFalse);
		txtApellidos.setEditable(trueFalse);
		
		if (btnModificar.getForeground() == Color.BLUE) {
			txtDNI.setEditable(false);			
		} else {
			txtDNI.setEditable(trueFalse);
		}
		txtEdad.setEditable(trueFalse);
		txtCelular.setEditable(trueFalse);
		
		if (btnAdicionar.getForeground() == Color.BLUE) {
			cboEstado.setEnabled(false);
		} else {
			cboEstado.setEnabled(trueFalse);
		}
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci?n", 1);
	}
	void listar(int posFila) {
		modelo.setRowCount(0);
		for (int i = 0; i < aa.tama?o(); i++) {
			Object[] fila = {
					aa.obtener(i).getCodAlumno(),
					aa.obtener(i).getNombres(),
					aa.obtener(i).getApellidos(),
					aa.obtener(i).getDNI(),
					aa.obtener(i).getEdad(),
					aa.obtener(i).getCelular(),
					leerEstadoString(aa.obtener(i).getEstado())
			};
			modelo.addRow(fila);
		}
		tblAlumno.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void obtenerDatos() {
		if (aa.tama?o() == 0) {
			limpieza();
		} else {
			Alumno a = aa.obtener(tblAlumno.getSelectedRow());
			txtCodigo.setText("" + a.getCodAlumno());
			txtNombres.setText("" + a.getNombres());
			txtApellidos.setText("" + a.getApellidos());
			txtDNI.setText("" + a.getDNI());
			txtEdad.setText("" + a.getEdad());
			txtCelular.setText("" + a.getCelular());
			cboEstado.setSelectedIndex(a.getEstado());
		}
	}
	void limpieza() {
		txtCodigo.setText("" + aa.numeroCorrelativo());
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cboEstado.setSelectedIndex(0);
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblAlumno.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6));	// C?digo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));	// Nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));	// Apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));	// DNI
		tcm.getColumn(4).setPreferredWidth(anchoColumna(4));	// Edad
		tcm.getColumn(5).setPreferredWidth(anchoColumna(5));	// Celular
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10));	// Estado
	}
	
	// M?todos con valor de retorno
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombres.getText().trim();
	}
	String leerApellido() {
		return txtApellidos.getText().trim();
	}
	String leerDNI() {
		return txtDNI.getText().trim();
	}
	int leerEdad() {
		return Integer.parseInt(txtEdad.getText().trim());
	}
	int leerCelular() {
		return Integer.parseInt(txtCelular.getText().trim());
	}
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	String leerEstadoString(int i) {
		return cboEstado.getItemAt(i);
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Confirmaci?n", 0, 1, null);
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	// Acciones del mouse
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblAlumno) {
			btnAdicionar.setForeground(Color.BLACK);
			btnModificar.setForeground(Color.BLACK);
			habilitarEntradas(false);
			obtenerDatos();
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}