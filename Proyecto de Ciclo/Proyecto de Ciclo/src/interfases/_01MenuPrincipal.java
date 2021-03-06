package interfases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class _01MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmCurso;
	private JMenuItem mntmAlumno;
	private JMenu mnRegistro;
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmAlumnos;
	private JMenuItem mntmCursos;
	private JMenuItem mntmMatriculaPendiente;
	private JMenuItem mntmMatriculaVigente;
	private JMenuItem mntmMatriculadosPorCurso;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmMatriculas;
	private JMenuItem mntmRetiros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_01MenuPrincipal frame = new _01MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public _01MenuPrincipal() {
		setTitle("Registro y Matr\u00EDcula de Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuProyecto = new JMenuBar();
		setJMenuBar(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuProyecto.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuProyecto.add(mnRegistro);
		
		mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmMatricula.addActionListener(this);
		mnRegistro.add(mntmMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmRetiro.addActionListener(this);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuProyecto.add(mnConsulta);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmAlumnos.addActionListener(this);
		mnConsulta.add(mntmAlumnos);
		
		mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmCursos.addActionListener(this);
		mnConsulta.add(mntmCursos);
		
		mntmMatriculas = new JMenuItem("Matriculas");
		mntmMatriculas.addActionListener(this);
		mntmMatriculas.setFont(new Font("Consolas", Font.PLAIN, 12));
		mnConsulta.add(mntmMatriculas);
		
		mntmRetiros = new JMenuItem("Retiros");
		mntmRetiros.addActionListener(this);
		mntmRetiros.setFont(new Font("Consolas", Font.PLAIN, 12));
		mnConsulta.add(mntmRetiros);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Consolas", Font.PLAIN, 12));
		menuProyecto.add(mnReporte);
		
		mntmMatriculaPendiente = new JMenuItem("Matr\u00EDcula pendiente");
		mntmMatriculaPendiente.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmMatriculaPendiente.addActionListener(this);
		mnReporte.add(mntmMatriculaPendiente);
		
		mntmMatriculaVigente = new JMenuItem("Matr\u00EDcula vigente");
		mntmMatriculaVigente.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmMatriculaVigente.addActionListener(this);
		mnReporte.add(mntmMatriculaVigente);
		
		mntmMatriculadosPorCurso = new JMenuItem("Matriculados por curso");
		mntmMatriculadosPorCurso.setFont(new Font("Consolas", Font.PLAIN, 12));
		mntmMatriculadosPorCurso.addActionListener(this);
		mnReporte.add(mntmMatriculadosPorCurso);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmMatriculas) {
			actionPerformedMntmMatriculas(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		if (e.getSource() == mntmCurso) {
			actionPerformedMntmCurso(e);
		}
		if (e.getSource() == mntmMatricula) {
			actionPerformedMntmMatricula(e);
		}
		if (e.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(e);
		}
		if (e.getSource() == mntmAlumnos) {
			actionPerformedMntmAlumnos(e);
		}
		if (e.getSource() == mntmCursos) {
			actionPerformedMntmCursos(e);
		}
		if (e.getSource() == mntmMatriculas) {
			actionPerformedMntmMatriculas(e);
		}
		if (e.getSource() == mntmRetiros) {
			actionPerformedMntmRetiros(e);
		}
		if (e.getSource() == mntmMatriculaPendiente) {
			actionPerformedMntmMatriculaPendiente(e);
		}
		if (e.getSource() == mntmMatriculaVigente) {
			actionPerformedMntmMatriculaVigente(e);
		}
		if (e.getSource() == mntmMatriculadosPorCurso) {
			actionPerformedMntmMatriculadoPorCursos(e);
		}
	}
	
	/**
	 * Enlazando interfaces
	 */
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		_02MantenimientoAlumno ma = new _02MantenimientoAlumno();
		ma.setLocationRelativeTo(this);
		ma.setVisible(true);
	}
	protected void actionPerformedMntmCurso(ActionEvent e) {
		_03MantenimientoCurso mc = new _03MantenimientoCurso();
		mc.setLocationRelativeTo(this);
		mc.setVisible(true);
	}
	protected void actionPerformedMntmMatricula(ActionEvent e) {
		_04RegistroMatricula rm = new _04RegistroMatricula();
		rm.setLocationRelativeTo(this);
		rm.setVisible(true);
	}
	protected void actionPerformedMntmRetiro(ActionEvent e) {
		_05RegistroRetiro rr = new _05RegistroRetiro();
		rr.setLocationRelativeTo(this);
		rr.setVisible(true);
	}
	protected void actionPerformedMntmAlumnos(ActionEvent e) {
		_06ConsultaAlumnos ca = new _06ConsultaAlumnos();
		ca.setLocationRelativeTo(this);
		ca.setVisible(true);
	}
	protected void actionPerformedMntmCursos(ActionEvent e) {
		_07ConsultaCursos ca = new _07ConsultaCursos();
		ca.setLocationRelativeTo(this);
		ca.setVisible(true);
	}
	protected void actionPerformedMntmMatriculas(ActionEvent e) {
		_08ConsultaMatriculas ca = new _08ConsultaMatriculas();
		ca.setLocationRelativeTo(this);
		ca.setVisible(true);
	}
	protected void actionPerformedMntmRetiros(ActionEvent e) {
		_09ConsultaRetiros ca = new _09ConsultaRetiros();
		ca.setLocationRelativeTo(this);
		ca.setVisible(true);
	}
	protected void actionPerformedMntmMatriculaPendiente(ActionEvent e) {
		_10ReporteAlumnosMatriculaPendiente ramp = new _10ReporteAlumnosMatriculaPendiente();
		ramp.setLocationRelativeTo(this);
		ramp.setVisible(true);
	}
	protected void actionPerformedMntmMatriculaVigente(ActionEvent e) {
		_11ReporteAlumnosMatriculaVigente ramv = new _11ReporteAlumnosMatriculaVigente();
		ramv.setLocationRelativeTo(this);
		ramv.setVisible(true);
	}
	protected void actionPerformedMntmMatriculadoPorCursos(ActionEvent e) {		
		_12ReporteAlumnosMatriculadosCurso ramc = new _12ReporteAlumnosMatriculadosCurso();
		ramc.setLocationRelativeTo(this);
		ramc.setVisible(true);
	}
}