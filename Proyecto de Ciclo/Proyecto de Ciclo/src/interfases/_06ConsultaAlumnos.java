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
import libreria.Libreria;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Font;

public class _06ConsultaAlumnos extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoAlumno;
	private JScrollPane scp;
	private JTextArea txtS;
	private JLabel lblCodigoAlumno;
	private JButton btnConsultar;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_06ConsultaAlumnos dialog = new _06ConsultaAlumnos();
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
	public _06ConsultaAlumnos() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Consulta | Alumnos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigoAlumno.setBounds(129, 9, 125, 20);
		getContentPane().add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		scp = new JScrollPane();
		scp.setBounds(10, 48, 414, 202);
		getContentPane().add(scp);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 10));
		scp.setViewportView(txtS);
		
		lblCodigoAlumno = new JLabel("C\u00F3digo de Alumno");
		lblCodigoAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoAlumno.setBounds(10, 10, 109, 16);
		getContentPane().add(lblCodigoAlumno);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(321, 8, 103, 21);
		getContentPane().add(btnConsultar);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 416, 2);
		getContentPane().add(separator);
		
		soloNumeros(txtCodigoAlumno);
	}
	
	/**
	 * Programaci?n de botones
	 */
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	ArregloMatricula am = new ArregloMatricula();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	// Bot?n consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		try {
			int codigoAlumno = leerCodigoAlumno();
			Alumno a = aa.buscarAlumno(codigoAlumno);
			
			if (a != null) {
				txtS.setText("");
				listar();
			} else {
				mensaje("El c?digo ingresado no existe.");				
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// M?todos sin valor de retorno	
    void listar(){
    	Alumno a = aa.buscarAlumno(leerCodigoAlumno());
	
   		imprimir("Alumno               : " + a.getCodAlumno());
   		imprimir("Nombres              : " + a.getNombres());
   		imprimir("Apellidos            : " + a.getApellidos());
   		imprimir("DNI                  : " + a.getDNI());
   		imprimir("Edad                 : " + a.getEdad());
   		imprimir("Celular              : " + a.getCelular());
   		imprimir("Estado               : " + Libreria.estadoAlumno[a.getEstado()]);
   		
   		Matricula m = am.buscarAlumno(leerCodigoAlumno());
   		Curso c = ac.buscarCurso(m.getCodCurso());
   		
   		imprimir("Asignatura           : " + c.getAsignatura());
   		imprimir("Ciclo                : " + Libreria.ciclocursos[c.getCiclo()]);
   		imprimir("Cantidad de cr?ditos : " + c.getCreditos());
   		imprimir("Cantidad de horas    : " + c.getHoras());
	}
    
    // M?todos con valor de retorno	    
	void imprimir(String s) {
		txtS.append(s + "\n"); 
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Alerta", 1);
	}
	int leerCodigoAlumno(){
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	
	// Validaci?n de caracteres
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