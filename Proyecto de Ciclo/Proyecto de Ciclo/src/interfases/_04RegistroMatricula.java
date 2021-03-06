package interfases;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import libreria.Fecha;
import libreria.Libreria;
import javax.swing.JSeparator;

public class _04RegistroMatricula extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scp;
	private JLabel lblNumeroMatricula;
	private JLabel lblCodigoAlumno;
	private JLabel lblCodigoCurso;
	private JTextField txtNumeroMatricula;
	private JTextField txtCodigoAlumno;
	private JTextField txtCodigoCurso;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblMatricula;
	private DefaultTableModel modelo;
	private JLabel lblAlumno;
	private JLabel lblCurso;
	private JTextField txtAlumno;
	private JTextField txtCurso;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			_04RegistroMatricula dialog = new _04RegistroMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public _04RegistroMatricula() {
		setTitle("Registro | Matricula");
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scp = new JScrollPane();
		scp.setBounds(10, 143, 616, 260);
		contentPanel.add(scp);
		
		lblNumeroMatricula = new JLabel("N\u00FAmero de Matr\u00EDcula");
		lblNumeroMatricula.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblNumeroMatricula.setBounds(10, 10, 127, 16);
		contentPanel.add(lblNumeroMatricula);
		
		lblCodigoAlumno = new JLabel("C\u00F3digo Alumno");
		lblCodigoAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoAlumno.setBounds(10, 34, 127, 16);
		contentPanel.add(lblCodigoAlumno);
		
		lblCodigoCurso = new JLabel("C\u00F3digo Curso");
		lblCodigoCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoCurso.setBounds(10, 57, 127, 16);
		contentPanel.add(lblCodigoCurso);
		
		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtNumeroMatricula.setEditable(false);
		txtNumeroMatricula.setColumns(10);
		txtNumeroMatricula.setBounds(147, 9, 130, 20);
		contentPanel.add(txtNumeroMatricula);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setColumns(10);
		txtCodigoAlumno.setBounds(147, 33, 130, 20);
		contentPanel.add(txtCodigoAlumno);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBounds(147, 56, 130, 20);
		contentPanel.add(txtCodigoCurso);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnAdicionar.setBounds(530, 8, 96, 21);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnModificar.setBounds(530, 32, 96, 21);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnEliminar.setBounds(530, 55, 96, 21);
		contentPanel.add(btnEliminar);
		
		lblAlumno = new JLabel("Alumno");
		lblAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblAlumno.setBounds(10, 81, 127, 16);
		contentPanel.add(lblAlumno);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCurso.setBounds(10, 105, 127, 16);
		contentPanel.add(lblCurso);
		
		txtAlumno = new JTextField();
		txtAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(147, 80, 235, 20);
		contentPanel.add(txtAlumno);
		
		txtCurso = new JTextField();
		txtCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(147, 104, 235, 20);
		contentPanel.add(txtCurso);

		tblMatricula = new JTable();
		tblMatricula.addMouseListener(this);
		tblMatricula.getTableHeader().setReorderingAllowed(false);
		tblMatricula.setFillsViewportHeight(true);
		tblMatricula.setFont(new Font("Consolas", Font.PLAIN, 10));
		scp.setViewportView(tblMatricula);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("N?mero");
		modelo.addColumn("Cod. Alumno");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Estado");
		tblMatricula.setModel(modelo);
		
		separator = new JSeparator();
		separator.setBounds(10, 131, 616, 2);
		contentPanel.add(separator);
		
		listar(0);
		obtenerDatos();
		habilitarEntradas(false);
	}
	
	/**
	 * Programaci?n de botones
	 */
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	
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
	
	// Adiciona una nueva matr?cula
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			if (btnAdicionar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLUE);
				btnModificar.setForeground(Color.BLACK);
				btnEliminar.setForeground(Color.BLACK);
				habilitarEntradas(true);
				limpieza();
				txtCodigoAlumno.requestFocus();
			} else {
				adicionarModificar();
			}
		} catch (Exception e) {
			mensaje("Datos no v?lidos.");
			limpieza();
		}
	}
	
	// Busca un c?digo y si existe modifica los datos de la matr?cula
	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (am.tama?o() > 0) {
			if (btnModificar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLACK);
				btnModificar.setForeground(Color.BLUE);
				btnEliminar.setForeground(Color.BLACK);
				obtenerDatos();
				habilitarEntradas(true);
				txtCodigoCurso.requestFocus();
			} else {
				adicionarModificar();
			}			
		} else {
			mensaje("No existen matr?culas.");
		}
	}
	
	// Busca un c?digo y si existe retira la matr?cula del arreglo
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if (am.tama?o() > 0) {
			btnAdicionar.setForeground(Color.BLACK);
			btnModificar.setForeground(Color.BLACK);
			btnEliminar.setForeground(Color.BLUE);			
			obtenerDatos();
			habilitarEntradas(false);
			
			int numeroMatricula = leerNumeroMatricula();
			Matricula m = am.buscarMatricula(numeroMatricula);
			Alumno a = aa.buscarAlumno(m.getCodAlumno());
			
			if (a.getEstado() == 2) {
				mensaje("El alumno se encuentra retirado.");
			} else {
				int confirmacion = confirmar("?Desea eliminar el registro?");

				if (confirmacion == 0) {
					int posFila = tblMatricula.getSelectedRow();
					
					if (posFila == am.tama?o() - 1) {
						posFila--;
					}
					a.setEstado(0);
					aa.actualizarArchivo();
					am.eliminar(m);
					listar(posFila);
					obtenerDatos();
				}
			}
			btnEliminar.setForeground(Color.BLACK);			
		} else {
			mensaje("No existen matr?culas.");
		}
	}

	/**
	 * M?todos adicionales
	 */
	// M?todos sin valor de retorno
	void adicionarModificar() {
		int numMatricula = leerNumeroMatricula();
		int codAlumno = leerCodigoAlumno();
		int codCurso = leerCodigoCurso();
		int posFila = tblMatricula.getSelectedRow();
		
		Alumno a = aa.buscarAlumno(codAlumno);
		Curso c = ac.buscarCurso(codCurso);
		Matricula m = am.buscarAlumno(codAlumno);
		
		try {
			if (btnAdicionar.getForeground() == Color.BLUE) {				
				if (a != null && c != null) {
					if (m == null) {
						Matricula nuevaMatricula = new Matricula(numMatricula, codAlumno, codCurso, Fecha.fechaActual(), Fecha.horaActual(), 1);
						posFila = am.tama?o();
						am.adicionar(nuevaMatricula);
						a.setEstado(1);
						aa.actualizarArchivo();
						limpieza();
						txtCodigoAlumno.requestFocus();
					} else {
						mensaje("El alumno ya ha sido matriculado.");
						limpieza();
					}
				} else {
					mensaje("El alumno o el curso no se encuentran registrados.");
					limpieza();
				}
			}
			if (btnModificar.getForeground() == Color.BLUE) {				
				if (c != null) {
					m.setNumMatricula(numMatricula);
					m.setCodAlumno(codAlumno);
					m.setCodCurso(codCurso);
					btnModificar.setForeground(Color.BLACK);
					habilitarEntradas(false);
				} else {
					mensaje("El c?digo de curso ingresado no existe.");
				}
			}
			listar(posFila);
		} catch (Exception e) {
			mensaje("Datos no validos.");
			limpieza();
		}
	}
	void habilitarEntradas(boolean trueFalse) {
		if (btnModificar.getForeground() == Color.BLUE) {
			txtCodigoAlumno.setEditable(false);			
		} else {
			txtCodigoAlumno.setEditable(trueFalse);
		}
		txtCodigoCurso.setEditable(trueFalse);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci?n", 1);
	}
	void listar(int posFila) {
		modelo.setRowCount(0);
		for (int i = 0; i < am.tama?o(); i++) {
			Object[] fila = {
					am.obtener(i).getNumMatricula(),
					am.obtener(i).getCodAlumno(),
					am.obtener(i).getCodCurso(),
					am.obtener(i).getFecha(),
					am.obtener(i).getHora(),
					Libreria.estadoAlumno[am.obtener(i).getEstado()]
			};
			modelo.addRow(fila);
		}
		tblMatricula.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void obtenerDatos() {
		if (am.tama?o() == 0) {
			limpieza();
		} else {
			Matricula m = am.obtener(tblMatricula.getSelectedRow());
			txtNumeroMatricula.setText("" + m.getNumMatricula());
			txtCodigoAlumno.setText("" + m.getCodAlumno());
			txtCodigoCurso.setText("" + m.getCodCurso());
			txtAlumno.setText(nombreAlumno());
			txtCurso.setText(nombreCurso());
		}
	}
	void limpieza() {
		txtNumeroMatricula.setText("" + am.numeroCorrelativo());
		txtCodigoAlumno.setText("");
		txtCodigoCurso.setText("");
		txtAlumno.setText("");
		txtCurso.setText("");
	}
	
	// M?todos con valor de retorno
	int leerNumeroMatricula() {
		return Integer.parseInt(txtNumeroMatricula.getText().trim());
	}
	int leerCodigoAlumno() {
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	int leerCodigoCurso() {
		return Integer.parseInt(txtCodigoCurso.getText().trim());
	}
	String nombreAlumno() {
		Alumno a = aa.buscarAlumno(leerCodigoAlumno());
		return a.getNombres() + " " + a.getApellidos();
	}
	String nombreCurso() {
		Curso c = ac.buscarCurso(leerCodigoCurso());
		return c.getAsignatura();
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	// Acciones del mouse
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblMatricula) {
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