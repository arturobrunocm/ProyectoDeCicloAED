package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Curso;

public class ArregloCurso {	
	// Atributo privado
	private ArrayList<Curso> curso;
	
	// Constructor
	public ArregloCurso() {
		curso = new ArrayList<Curso>();
		cargarCursos();
	}
	
	// M?todos p?blicos
	public void adicionar(Curso c) {
		curso.add(c);
		grabarCursos();
	}
	public int tama?o() {
		return curso.size();
	}	
	public Curso obtener(int i) {
		return curso.get(i);
	}
	public void eliminar(Curso c) {
		curso.remove(c);
		grabarCursos();
	}
	public void actualizarArchivo() {
		grabarCursos();
	}
	
	// M?todos p?blicos complementarios
	public Curso buscarCurso(int codigo) {
		for (int i = 0; i < tama?o(); i++)
			if (obtener(i).getCodCurso() == codigo)
				return obtener(i);
		return null;
	}
	
	// Manejo de archivos de texto
	private void grabarCursos() {
		try {
			PrintWriter pw;
			String linea;
			Curso c;
			pw = new PrintWriter(new FileWriter("cursos.txt"));
			for (int i = 0; i < tama?o(); i++) {
				c = obtener(i);
				linea = c.getCodCurso() + ";" +
						c.getAsignatura() + ";" +
						c.getCiclo() + ";" +
						c.getCreditos() + ";" +
						c.getHoras();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void cargarCursos() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codCurso, ciclo, creditos, horas;
			String asignatura;
			br = new BufferedReader(new FileReader("cursos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				adicionar(new Curso(codCurso, asignatura, ciclo, creditos, horas));
			}
			br.close();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}