package interfases;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import arreglos.ArregloAlumno;
import clases.Alumno;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

public class _11ReporteAlumnosMatriculaVigente extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JTextArea txtS;
	private JScrollPane scp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_11ReporteAlumnosMatriculaVigente dialog = new _11ReporteAlumnosMatriculaVigente();
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
	public _11ReporteAlumnosMatriculaVigente() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setTitle("Reporte | Matr\u00EDcula Vigente");
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
		Alumno a;
		
		txtS.setText("");
		
		for (int i = 0; i < aa.tama?o(); i++) {
			a = aa.obtener(i);
			
			if (a.getEstado() == 1) {
				a = aa.buscarAlumno(a.getCodAlumno());
				imprimir("C?digo de Alumno		: " + a.getCodAlumno());
				imprimir("Nombre			: " + a.getNombres());
				imprimir("Apellidos		: " + a.getApellidos());
				imprimir("DNI			: " + a.getDNI());
				imprimir("Edad			: " + a.getEdad());
				imprimir("Celular			: " +a.getCelular());
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