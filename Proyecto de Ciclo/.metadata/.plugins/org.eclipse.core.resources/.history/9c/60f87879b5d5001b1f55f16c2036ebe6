package interfases;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class _08ConsultaMatriculas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMatricula;
	private JScrollPane scp;
	private JTextArea txtS;
	private JButton btnConsultar;
	private JLabel lblCodigoDeAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_08ConsultaMatriculas dialog = new _08ConsultaMatriculas();
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
	public _08ConsultaMatriculas() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Consultar | Matriculas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtMatricula.setBounds(129, 9, 125, 20);
		getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		scp = new JScrollPane();
		scp.setBounds(10, 51, 414, 199);
		getContentPane().add(scp);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 10));
		scp.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnConsultar.setBackground(UIManager.getColor("Button.background"));
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setBounds(321, 8, 103, 21);
		getContentPane().add(btnConsultar);
		
		lblCodigoDeAlumno = new JLabel("N\u00FAmero de Matr\u00EDcula");
		lblCodigoDeAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoDeAlumno.setBounds(10, 10, 109, 16);
		getContentPane().add(lblCodigoDeAlumno);
		
		soloNumeros(txtMatricula);
		
		separator = new JSeparator();
		separator.setBounds(10, 39, 414, 2);
		getContentPane().add(separator);
	}
	
	/**
	 * Programación de botones
	 */
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();	
	private JSeparator separator;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	// Botón consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		try {
			int numeroMatricula = leerNumeroMatricula();
			Matricula m = am.buscarMatricula(numeroMatricula);
			
			if (m != null) {
				txtS.setText("");
				listar();
			} else {
				mensaje("El código ingresado no existe.");					
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	// Métodos sin valor de retorno
	void listar(){
		Matricula m = am.buscarMatricula(leerNumeroMatricula());
		Alumno a = aa.buscarAlumno(m.getCodAlumno());
		Curso c = ac.buscarCurso(m.getCodCurso());
		
		imprimir("Matrícula            : " + m.getNumMatricula());
		imprimir("Estado de matrícula  : " + m.getEstado());
		imprimir();
		imprimir("Alumno               : " + a.getCodAlumno());
		imprimir("Nombres              : " + a.getNombres());
		imprimir("Apellidos            : " + a.getApellidos());
		imprimir("DNI                  : " + a.getDNI());
		imprimir("Edad                 : " + a.getEdad());
		imprimir("Celular              : " + a.getCelular());
		imprimir();
		imprimir("Curso                : " + c.getCodCurso());
		imprimir("Asignatura           : " + c.getAsignatura());
		imprimir("Ciclo                : " + c.getCiclo());
		imprimir("Cantidad de créditos : " + c.getCreditos());
		imprimir("Cantidad de horas    : " + c.getHoras());
	}
	void imprimir(){
		imprimir("");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Alerta", 1);
	}
		
	// Métodos con valor de retorno		
	int leerNumeroMatricula() {
		return Integer.parseInt(txtMatricula.getText().trim());
	}
	
	// Validación de caracteres
	public void soloNumeros(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}
}
