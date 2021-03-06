package interfases;

import java.awt.EventQueue;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import clases.Curso;
import clases.Matricula;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JSeparator;

public class _03MantenimientoCurso extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtCodigo;
	private JComboBox <String> cboCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JTextField txtAsignatura;
	private JLabel lblCodigo;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JLabel lblAsignatura;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTable tblCurso;
	private JSeparator separator;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_03MantenimientoCurso dialog = new _03MantenimientoCurso();
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
	public _03MantenimientoCurso() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setAutoRequestFocus(false);
		setTitle("Mantenimiento | Curso");
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(530, 8, 96, 21);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(530, 32, 96, 21);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(530, 55, 96, 21);
		getContentPane().add(btnEliminar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigo.setBounds(73, 9, 130, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cboCiclo = new JComboBox<String>();
		cboCiclo.setModel(new DefaultComboBoxModel<String>(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		cboCiclo.setEnabled(false);
		cboCiclo.setFont(new Font("Consolas", Font.PLAIN, 10));
		cboCiclo.setBounds(73, 56, 130, 20);
		getContentPane().add(cboCiclo);
		
		txtCreditos = new JTextField();
		txtCreditos.setEditable(false);
		txtCreditos.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCreditos.setBounds(73, 80, 130, 20);
		getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.setEditable(false);
		txtHoras.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtHoras.setBounds(73, 104, 130, 19);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setEditable(false);
		txtAsignatura.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtAsignatura.setBounds(73, 33, 130, 20);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigo.setBounds(10, 10, 96, 16);
		getContentPane().add(lblCodigo);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCiclo.setBounds(10, 57, 96, 16);
		getContentPane().add(lblCiclo);
		
		lblCreditos = new JLabel("Cr\u00E9ditos");
		lblCreditos.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCreditos.setBounds(10, 81, 85, 16);
		getContentPane().add(lblCreditos);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblHoras.setBounds(10, 105, 96, 16);
		getContentPane().add(lblHoras);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblAsignatura.setBounds(10, 34, 96, 16);
		getContentPane().add(lblAsignatura);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 616, 258);
		getContentPane().add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.addMouseListener(this);
		tblCurso.getTableHeader().setReorderingAllowed(false);
		tblCurso.setFillsViewportHeight(true);
		tblCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		scrollPane.setViewportView(tblCurso);
		
		separator = new JSeparator();
		separator.setBounds(10, 133, 616, 2);
		getContentPane().add(separator);

		modelo = new DefaultTableModel();
		modelo.addColumn("C?digo");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Cr?ditos");
		modelo.addColumn("Horas");
		tblCurso.setModel(modelo);
		
		ajustarAnchoColumnas();
		listar(0);
		obtenerDatos();
		habilitarEntradas(false);
	}
	
	/**
	 * Programaci?n de botones
	 */
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	
	
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
	
	// Adiciona un nuevo curso verificando que el c?digo no se repita
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			if (btnAdicionar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLUE);
				btnModificar.setForeground(Color.BLACK);
				btnEliminar.setForeground(Color.BLACK);
				habilitarEntradas(true);
				limpieza();
				txtCodigo.requestFocus();
			} else {
				adicionarModificar();
			}
		} catch (Exception e) {
			mensaje("Datos no v?lidos.");
			limpieza();
		}
	}

	// Busca un c?digo y si existe modifica los datos del curso
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (ac.tama?o() > 0) {
			if (btnModificar.getForeground() == Color.BLACK) {
				btnAdicionar.setForeground(Color.BLACK);
				btnModificar.setForeground(Color.BLUE);
				btnEliminar.setForeground(Color.BLACK);
				obtenerDatos();
				habilitarEntradas(true);
				txtAsignatura.requestFocus();
			} else {
				adicionarModificar();
			}
		} else {
			mensaje("No existen cursos.");
		}
	}

	// Busca un c?digo y si existe retira el curso del arreglo
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (ac.tama?o() > 0) {
			btnAdicionar.setForeground(Color.BLACK);
			btnModificar.setForeground(Color.BLACK);
			btnEliminar.setForeground(Color.BLUE);
			obtenerDatos();
			habilitarEntradas(false);
			
			int codigo = leerCodigo();
			Curso c = ac.buscarCurso(codigo);
			Matricula m = am.buscarCurso(codigo);

			if (m == null) {
				String asignatura = leerAsignatura();
				int confirmacion = confirmar("Desea eliminar la asignatura " + asignatura + " ?");
				
				if (confirmacion == 0) {
					int posFila = tblCurso.getSelectedRow();
					
					if (posFila == ac.tama?o() - 1) {
						posFila--;
					}
					ac.eliminar(c);
					listar(posFila);
					obtenerDatos();
				}			
			} else {
				mensaje("Hay alumnos matriculados en este curso.");
			}
			btnEliminar.setForeground(Color.BLACK);
		} else {
			mensaje("No existen asignaturas.");
		}
	}
	
	/**
	 * M?todos adicionales
	 */
	// M?todos sin valor de retorno
	void adicionarModificar() {
		int codigo = leerCodigo();
		String asignatura = leerAsignatura();
		int ciclo = leerCiclo();
		int creditos = leerCreditos();
		int horas = leerHoras();
		int posFila = tblCurso.getSelectedRow();
		
		try {
			if (btnAdicionar.getForeground() == Color.BLUE) {
				if (ac.buscarCurso(codigo) == null) {
					Curso c = new Curso(codigo, asignatura, ciclo, creditos, horas);
					posFila = ac.tama?o();
					ac.adicionar(c);
					limpieza();
					txtCodigo.requestFocus();
				} else {
					mensaje("El c?digo ya existe.");
					limpieza();
				}
			}
			if (btnModificar.getForeground() == Color.BLUE) {
				Curso c = ac.obtener(posFila);
				c.setCodCurso(codigo);
				c.setAsignatura(asignatura);
				c.setCiclo(ciclo);
				c.setCreditos(creditos);
				c.setHoras(horas);
				btnModificar.setForeground(Color.BLACK);
				habilitarEntradas(false);
			}
			listar(posFila);
		} catch (Exception e) {
			mensaje("Datos no v?lidos.");
			limpieza();
		}
	}
	void habilitarEntradas(boolean trueFalse) {
		if (btnModificar.getForeground() == Color.BLUE) {
			txtCodigo.setEditable(false);			
		} else {
			txtCodigo.setEditable(trueFalse);
		}
		txtAsignatura.setEditable(trueFalse);
		cboCiclo.setEnabled(trueFalse);
		txtCreditos.setEditable(trueFalse);
		txtHoras.setEditable(trueFalse);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void listar(int posFila) {
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tama?o(); i++) {
			Object[] fila = {
					ac.obtener(i).getCodCurso(),
					ac.obtener(i).getAsignatura(),
					leerCicloString(ac.obtener(i).getCiclo()),
					ac.obtener(i).getCreditos(),
					ac.obtener(i).getHoras()
			};
			modelo.addRow(fila);
		}
		tblCurso.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void obtenerDatos() {
		if (ac.tama?o() == 0) {
			limpieza();
		} else {
			Curso c = ac.obtener(tblCurso.getSelectedRow());
			txtCodigo.setText("" + c.getCodCurso());
			txtAsignatura.setText("" + c.getAsignatura());
			cboCiclo.setSelectedIndex(c.getCiclo());
			txtCreditos.setText("" + c.getCreditos());
			txtHoras.setText("" + c.getHoras());
		}
	}
	void limpieza() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCurso.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));	// C?digo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));	// Asignatura
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));	// Ciclo
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));	// Cr?ditos
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));	// Horas
	}
	
	// M?todos con valor de retorno
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerAsignatura() {
		return txtAsignatura.getText().trim();
	}
	int leerCiclo() {
		return cboCiclo.getSelectedIndex();
	}
	String leerCicloString(int i) {
		return cboCiclo.getItemAt(i);
	}
	int leerCreditos() {
		return Integer.parseInt(txtCreditos.getText().trim());
	}
	int leerHoras() {
		return Integer.parseInt(txtHoras.getText().trim());
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Confirmaci?n", 0, 1, null);
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	// Acciones del mouse
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCurso) {
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