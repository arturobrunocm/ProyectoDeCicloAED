package interfases;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import arreglos.ArregloCurso;
import clases.Curso;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class _07ConsultaCursos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoCurso;
	private JScrollPane scp;
	private JTextArea txtS;
	private JButton btnConsultar;
	private JLabel lblCodigoCurso;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_07ConsultaCursos dialog = new _07ConsultaCursos();
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
	public _07ConsultaCursos() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setForeground(SystemColor.inactiveCaption);
		setTitle("Consulta | Cursos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		txtCodigoCurso.setBounds(129, 9, 125, 20);
		getContentPane().add(txtCodigoCurso);
		txtCodigoCurso.setColumns(10);
		
		scp = new JScrollPane();
		scp.setBounds(10, 48, 414, 205);
		getContentPane().add(scp);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.PLAIN, 10));
		scp.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Consolas", Font.PLAIN, 10));
		btnConsultar.setBackground(UIManager.getColor("Button.background"));
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(SystemColor.desktop);
		btnConsultar.setBounds(321, 8, 103, 21);
		getContentPane().add(btnConsultar);
		
		lblCodigoCurso = new JLabel("C\u00F3digo de Curso");
		lblCodigoCurso.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblCodigoCurso.setBounds(10, 10, 109, 16);
		getContentPane().add(lblCodigoCurso);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		getContentPane().add(separator);
		
		soloNumeros(txtCodigoCurso);
	}
	
	/**
	 * Programaci?n de botones
	 */
	ArregloCurso ac = new ArregloCurso();
		
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	// Bot?n consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {		
		try {
			int codigoCurso = leerCodigoCurso();
			Curso c = ac.buscarCurso(codigoCurso);
			
			if (c != null) {
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
		Curso c = ac.buscarCurso(leerCodigoCurso());
		imprimir("Curso                : " + c.getCodCurso());
		imprimir("Asignatura           : " + c.getAsignatura());
		imprimir("Ciclo                : " + c.getCiclo());
		imprimir("Cantidad de cr?ditos : " + c.getCreditos());
		imprimir("Cantidad de horas    : " + c.getHoras());
	}	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Alerta", 1);
	}

	// M?todos con valor de retorno
	int leerCodigoCurso() {
		return Integer.parseInt(txtCodigoCurso.getText().trim());
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
