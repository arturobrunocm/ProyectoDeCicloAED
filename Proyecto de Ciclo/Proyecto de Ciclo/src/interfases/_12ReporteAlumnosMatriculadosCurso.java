// Reporte de Alumnos Matriculados por Curso
package interfases;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import java.awt.SystemColor;
import java.awt.Font;

public class _12ReporteAlumnosMatriculadosCurso extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scp;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_12ReporteAlumnosMatriculadosCurso dialog = new _12ReporteAlumnosMatriculadosCurso();
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
	public _12ReporteAlumnosMatriculadosCurso() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Reporte | Matriculados por Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		scp = new JScrollPane();
		scp.setBounds(10, 11, 414, 239);
		getContentPane().add(scp);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtS.setEditable(false);
		scp.setViewportView(txtS);
		listar();
	}
	
	// M?todos sin valor de retorno
	void listar() {
		ArregloAlumno aa = new ArregloAlumno();
		ArregloCurso ac = new ArregloCurso();
		ArregloMatricula am = new ArregloMatricula();
		
		Alumno a;
		Curso c;
		Matricula m;		
		txtS.setText("");
		
		for (int i = 0; i < am.tama?o(); i++) {
			m = am.obtener(i);
			
			if (m.getEstado() == 1) {
				c = ac.buscarCurso(m.getCodCurso());
				a = aa.buscarAlumno(m.getCodAlumno());
				imprimir("Asignatura	: " + c.getAsignatura());		
				imprimir("Nombre		: " + a.getNombres());
				imprimir("Apellidos	: " + a.getApellidos());
				imprimir();
			}
		}
	}
	void imprimir() {
		imprimir("");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}