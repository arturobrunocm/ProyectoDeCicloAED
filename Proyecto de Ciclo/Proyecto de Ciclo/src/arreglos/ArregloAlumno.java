package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Alumno;

public class ArregloAlumno {
	// Atributo privado
	private ArrayList<Alumno> alumno;
	
	// Constructor
	public ArregloAlumno() {
		alumno = new ArrayList<Alumno>();
		cargarAlumnos();
	}
	
	// M?todos p?blicos b?sicos
	public void adicionar(Alumno a) {
		alumno.add(a);
		grabarAlumnos();
	}
	public int tama?o() {
		return alumno.size();
	}	
	public Alumno obtener(int i) {
		return alumno.get(i);
	}
	public void eliminar(Alumno a){
		alumno.remove(a);
		grabarAlumnos();
	}
	public void actualizarArchivo() {
		grabarAlumnos();
	}
	
	// M?todos p?blicos complementarios
	public Alumno buscarAlumno(int codigo) {
		for (int i = 0; i < tama?o(); i++)
			if (obtener(i).getCodAlumno() == codigo)
				return obtener(i);
		return null;
	}
	public Alumno buscarDNI(String DNI) {
		for (int i = 0; i < tama?o(); i++) {
			if (obtener(i).getDNI() == DNI)
				return obtener(i);
		}
		return null;
	}
	public int numeroCorrelativo() {
		if (tama?o() == 0) {
			return 202010001;
		} else {
			return obtener(tama?o() - 1).getCodAlumno() + 1;
		}
	}
	
	// Manejo de archivos de texto
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno a;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i = 0; i < tama?o(); i++) {
				a = obtener(i);
				linea = a.getCodAlumno() + ";" +
						a.getNombres() + ";" +
						a.getApellidos() + ";" +
						a.getDNI() + ";" +
						a.getEdad() + ";" +
						a.getCelular() + ";" +
						a.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codAlumno, edad, celular, estado;
			String nombres, apellidos, dni;
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				edad = Integer.parseInt(s[4].trim());
				celular = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
			}
			br.close();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}