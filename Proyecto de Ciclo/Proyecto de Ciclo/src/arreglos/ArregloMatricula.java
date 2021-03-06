package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Matricula;

public class ArregloMatricula {
	// Atributo privado
	private ArrayList<Matricula> matricula;
	
	// Constructor
	public ArregloMatricula() {
		matricula = new ArrayList<Matricula>();
		cargarMatriculas();
	}
	
	// M?todos p?blicos b?sicos
	public void adicionar(Matricula m) {
		matricula.add(m);
		grabarMatriculas();
	}
	public int tama?o() {
		return matricula.size();
	}	
	public Matricula obtener(int i) {
		return matricula.get(i);
	}
	public void eliminar(Matricula m){
		matricula.remove(m);
		grabarMatriculas();
	}
	public void actualizarArchivo() {
		grabarMatriculas();
	}
	
	// M?todos p?blicos complementarios
	public Matricula buscarMatricula(int numMatricula) {
		for (int i = 0; i < tama?o(); i++)
			if (obtener(i).getNumMatricula() == numMatricula)
				return obtener(i);
		return null;
	}
	public Matricula buscarCurso(int codigoCurso) {
		for(int i = 0; i < tama?o(); i++)
			if (obtener(i).getCodCurso() == codigoCurso)
				return obtener(i);
		return null;
	}
	public Matricula buscarAlumno(int codigoAlumno) {
		for(int i = 0; i < tama?o(); i++)
			if(obtener(i).getCodAlumno() == codigoAlumno)
				return obtener(i);
		return null;
	}
	public int numeroCorrelativo() {
		if (tama?o() == 0) {
			return 100001;
		} else {
			return obtener(tama?o() - 1).getNumMatricula() + 1;
		}
	}
	
	// Manejo de archivos de texto
	private void grabarMatriculas() {
		try {
			PrintWriter pw;
			String linea;
			Matricula m;
			pw = new PrintWriter(new FileWriter("matricula.txt"));
			for (int i = 0; i < tama?o(); i++) {
				m = obtener(i);
				linea = m.getNumMatricula() + ";" + 
						m.getCodAlumno() + ";" +
						m.getCodCurso() + ";" +
						m.getFecha() + ";" +
						m.getHora() + ";" +
						m.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void cargarMatriculas() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int numMatricula, codAlumno, codCurso, estado;
			String fecha, hora;
			br = new BufferedReader(new FileReader("matricula.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();
				estado = Integer.parseInt(s[5].trim());
				adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora, estado));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}