// Consulta Retiros
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
import arreglos.ArregloRetiro;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;
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

public class _09ConsultaRetiros extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtRetiro;
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
					_09ConsultaRetiros dialog = new _09ConsultaRetiros();
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
	public _09ConsultaRetiros() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Consulta | Retiros");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtRetiro = new JTextField();
		txtRetiro.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtRetiro.setBounds(129, 9, 125, 20);
		getContentPane().add(txtRetiro);
		txtRetiro.setColumns(10);
		
		scp = new JScrollPane();
		scp.setBounds(10, 51, 414, 199);
		getContentPane().add(scp);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 10));
		scp.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setBounds(321, 8, 103, 21);
		getContentPane().add(btnConsultar);
		
		lblCodigoDeAlumno = new JLabel("Numero de Retiro");
		lblCodigoDeAlumno.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoDeAlumno.setBounds(10, 10, 109, 16);
		getContentPane().add(lblCodigoDeAlumno);
		
		soloNumeros(txtRetiro);
		
		separator = new JSeparator();
		separator.setBounds(10, 39, 414, 2);
		getContentPane().add(separator);
	}
	
	/**
	 * Programaci?n de botones
	 */
	ArregloRetiro ar = new ArregloRetiro();
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	private JSeparator separator;
		
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	// Bot?n consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		try {
			int numeroRetiro = leerNumeroRetiro();
			Retiro r = ar.buscarRetiro(numeroRetiro);
			
			if(r != null) {
				txtS.setText("");
				listar();
			} else {				
				mensaje("El c?digo ingresado no existe.");
			}	
		} catch (Exception e){
			// TODO: handle exception
		}	
	}
	
	// M?todos sin valor de retorno
	void listar() {
		Retiro r = ar.buscarRetiro(leerNumeroRetiro());
		Matricula m = am.buscarMatricula(r.getNumMatricula());
		Alumno a = aa.buscarAlumno(m.getCodAlumno());
		Curso c = ac.buscarCurso(m.getCodCurso());

		imprimir("N?mero de retiro     : " + r.getNumRetiro());
		imprimir("N?mero de matr?cula  : " + r.getNumMatricula());
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
		imprimir("Cantidad de cr?ditos : " + c.getCreditos());
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
		
	// M?todos con valor de retorno	
	int leerNumeroRetiro() {
		return Integer.parseInt(txtRetiro.getText().trim());
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