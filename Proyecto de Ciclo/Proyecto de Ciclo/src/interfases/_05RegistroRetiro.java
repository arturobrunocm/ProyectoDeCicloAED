package interfases;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;
import libreria.Fecha;

public class _05RegistroRetiro extends JDialog implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scp;
	private JLabel lblNumeroRetiro;
	private JLabel lblNumeroMatricula;
	private JLabel lblAlumno;
	private JTextField txtNumeroRetiro;
	private JTextField txtNumeroMatricula;
	private JTextField txtAlumno;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JSeparator separator;
	private JTable tblRetiro;
	private DefaultTableModel modelo;
	private JLabel lblCurso;
	private JTextField txtCurso;
	private JLabel lblCodigoCurso;
	private JTextField txtCodigoCurso;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_05RegistroRetiro dialog = new _05RegistroRetiro();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public _05RegistroRetiro() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Registro | Retiro");
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(null);
		
		scp = new JScrollPane();
		scp.setBounds(10, 143, 616, 260);
		getContentPane().add(scp);
		
		lblNumeroRetiro = new JLabel("N\u00FAmero de Retiro");
		lblNumeroRetiro.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblNumeroRetiro.setBounds(10, 10, 127, 16);
		getContentPane().add(lblNumeroRetiro);
		
		lblNumeroMatricula = new JLabel("N\u00FAmero de Matr\u00EDcula");
		lblNumeroMatricula.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblNumeroMatricula.setBounds(10, 34, 127, 16);
		getContentPane().add(lblNumeroMatricula);
		
		lblAlumno = new JLabel("Alumno");
		lblAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblAlumno.setBounds(10, 81, 127, 16);
		getContentPane().add(lblAlumno);
		
		txtNumeroRetiro = new JTextField();
		txtNumeroRetiro.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtNumeroRetiro.setEditable(false);
		txtNumeroRetiro.setColumns(10);
		txtNumeroRetiro.setBounds(147, 7, 130, 20);
		getContentPane().add(txtNumeroRetiro);
		
		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtNumeroMatricula.setEditable(false);
		txtNumeroMatricula.setColumns(10);
		txtNumeroMatricula.setBounds(147, 31, 130, 20);
		getContentPane().add(txtNumeroMatricula);
		
		txtAlumno = new JTextField();
		txtAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(147, 80, 235, 20);
		getContentPane().add(txtAlumno);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnAdicionar.setBounds(530, 6, 96, 21);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnModificar.setBounds(530, 30, 96, 21);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnEliminar.setBounds(530, 55, 96, 21);
		getContentPane().add(btnEliminar);
		
		separator = new JSeparator();
		separator.setBounds(10, 131, 616, 2);
		getContentPane().add(separator);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCurso.setBounds(10, 105, 127, 16);
		getContentPane().add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(147, 104, 235, 20);
		getContentPane().add(txtCurso);
		
		lblCodigoCurso = new JLabel("C\u00F3digo Curso");
		lblCodigoCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoCurso.setBounds(10, 57, 127, 16);
		getContentPane().add(lblCodigoCurso);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBounds(147, 56, 130, 20);
		getContentPane().add(txtCodigoCurso);
		
		tblRetiro = new JTable();
		tblRetiro.addMouseListener(this);
		tblRetiro.getTableHeader().setReorderingAllowed(false);
		tblRetiro.setFillsViewportHeight(true);
		tblRetiro.setFont(new Font("Consolas", Font.PLAIN, 10));
		scp.setViewportView(tblRetiro);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("N?m. Retiro");
		modelo.addColumn("N?m. Matr?cula");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		tblRetiro.setModel(modelo);
		
		listar(0);
		obtenerDatos();
		habilitarEntradas(false);
	}
	
	/**
	 * Programaci?n de botones
	 */
	ArregloRetiro ar = new ArregloRetiro(); 
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
	
	// Adiciona un nuevo retiro
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			if (btnAdicionar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLUE);
				btnModificar.setForeground(Color.BLACK);
				btnEliminar.setForeground(Color.BLACK);
				habilitarEntradas(true);
				limpieza();
				txtNumeroMatricula.requestFocus();
			} else {
				adicionarModificar();
			}

		} catch (Exception e) {
			mensaje("Datos no validos.");
			limpieza();
			
		}
	}
	
	// Modifica un retiro existente
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (ar.tama?o() > 0) {
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
			mensaje("No existen registros.");
		}
	}
	
	// Elimina un registro de retiro
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (ar.tama?o() > 0) {
			btnAdicionar.setForeground(Color.BLACK);
			btnModificar.setForeground(Color.BLACK);
			btnEliminar.setForeground(Color.BLUE);
			obtenerDatos();
			habilitarEntradas(false);
			
			int numeroRetiro = leerNumeroRetiro();
			Retiro r = ar.buscarRetiro(numeroRetiro);
			Matricula m = am.buscarMatricula(r.getNumMatricula());
			Alumno a = aa.buscarAlumno(m.getCodAlumno());
			
			if (a.getEstado() == 2) {
				int confirmacion = confirmar("?Desea eliminar el registro?");
				
				if (confirmacion == 0) {
					int posFila = tblRetiro.getSelectedRow();
					
					if (posFila == ar.tama?o() - 1) {
						posFila--;
					}
					ar.eliminar(r);
					listar(posFila);
					obtenerDatos();
				}
			} else {
				mensaje("El alumno no est? retirado.");
			}
		} else {
			mensaje("No existen retiros.");
		}
	}
	
	/**
	 * M?todos adicionales
	 */
	// M?todos sin valor de retorno
	void adicionarModificar() {
		int numRetiro = leerNumeroRetiro();
		int numMatricula = leerNumeroMatricula();
		int posFila = tblRetiro.getSelectedRow();
		
		Matricula m = am.buscarMatricula(numMatricula);
		
		try {
			if (btnAdicionar.getForeground() == Color.BLUE) {
				if (m != null) {
					Curso c = ac.buscarCurso(m.getCodCurso());
					int confirmacion = confirmar("?Deseas retirar al alumno " + nombreAlumno() + " del curso " + c.getAsignatura() + "?");
					
					if (confirmacion == 0) {
						Retiro nuevoRetiro = new Retiro(numRetiro, numMatricula, Fecha.fechaActual(), Fecha.horaActual());
						posFila = ar.tama?o();						
						ar.adicionar(nuevoRetiro);
						Alumno a = aa.buscarAlumno(m.getCodAlumno());

						a.setEstado(2);
						aa.actualizarArchivo();
						m.setEstado(2);
						am.actualizarArchivo();
						
						limpieza();
						txtNumeroMatricula.requestFocus();
					}
				} else {
					mensaje("El c?digo de matr?cula no existe.");
					limpieza();
					txtNumeroMatricula.requestFocus();
				}
			}
			if (btnModificar.getForeground() == Color.BLUE) {				
				int codCurso = leerCodigoCurso();
				Curso c = ac.buscarCurso(codCurso);
				
				if (c != null) {
					Retiro r = ar.buscarMatricula(numMatricula);
					r.setNumRetiro(numRetiro);
					r.setNumMatricula(numMatricula);
					btnModificar.setForeground(Color.BLACK);
					habilitarEntradas(false);
				} else {
					mensaje("El c?digo de curso ingresado no existe.");
				}
			}
			listar(posFila);
		} catch (Exception e) {
			mensaje("dfdgh");
			limpieza();
		}
	}
	void habilitarEntradas(boolean trueFalse) {
		if (btnModificar.getForeground() == Color.BLUE) {
			txtNumeroMatricula.setEditable(false);
			txtCodigoCurso.setEditable(true);
		} else {
			txtNumeroMatricula.setEditable(trueFalse);
			txtCodigoCurso.setEditable(false);
		}
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void listar(int posFila) {
		modelo.setRowCount(0);
		for (int i = 0; i < ar.tama?o(); i++) {
			Object[] fila = {
					ar.obtener(i).getNumRetiro(),
					ar.obtener(i).getNumMatricula(),
					ar.obtener(i).getFecha(),
					ar.obtener(i).getHora()
			};
			modelo.addRow(fila);
		}
		tblRetiro.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void obtenerDatos() {
		if (ar.tama?o() == 0) {
			limpieza();
		} else {
			Retiro r = ar.obtener(tblRetiro.getSelectedRow());
			Matricula m = am.buscarMatricula(r.getNumMatricula());
			Curso c = ac.buscarCurso(m.getCodCurso());
			Alumno a = aa.buscarAlumno(m.getCodAlumno());
			
			txtNumeroRetiro.setText("" + r.getNumRetiro());
			txtNumeroMatricula.setText("" + r.getNumMatricula());
			txtCodigoCurso.setText("" + m.getCodCurso());
			txtAlumno.setText(a.getNombres() + " " + a.getApellidos());
			txtCurso.setText(c.getAsignatura());
		}
	}
	void limpieza() {
		txtNumeroRetiro.setText("" + ar.numeroCorrelativo());
		txtNumeroMatricula.setText("");
		txtCodigoCurso.setText("");
		txtAlumno.setText("");
		txtCurso.setText("");
	}
	
	// M?todos con valor de retorno
	int leerNumeroRetiro() {
		return Integer.parseInt(txtNumeroRetiro.getText().trim());
	}
	int leerNumeroMatricula() {
		return Integer.parseInt(txtNumeroMatricula.getText().trim());
	}
	int leerCodigoCurso(){
		return Integer.parseInt(txtCodigoCurso.getText().trim());
	}
	String nombreAlumno() {
		Matricula m = am.buscarMatricula(leerNumeroMatricula());
		Alumno a = aa.buscarAlumno(m.getCodAlumno());
		return "" + a.getNombres() + " " + a.getApellidos();
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	// Acciones del mouse
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblRetiro) {
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