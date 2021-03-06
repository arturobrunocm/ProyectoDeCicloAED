package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Retiro;

public class ArregloRetiro {
	// Atributo privado
	private ArrayList<Retiro> retiro;
	
	// Constructor
	public ArregloRetiro() {
		retiro = new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	// M?todos p?blicos b?sicos
	public void adicionar(Retiro r) {
		retiro.add(r);
		grabarRetiros();
	}
	public int tama?o() {
		return retiro.size();
	}	
	public Retiro obtener(int i) {
		return retiro.get(i);
	}
	public void eliminar(Retiro r){
		retiro.remove(r);
		grabarRetiros();
	}
	public void actualizarArchivo() {
		grabarRetiros();
	}
		
	// M?todos p?blicos complementarios
	public Retiro buscarRetiro(int numRetiro) {
		for (int i = 0; i < tama?o(); i++)
			if (obtener(i).getNumRetiro() == numRetiro)
				return obtener(i);
		return null;
	}
	public Retiro buscarMatricula(int numMatricula) {
		for (int i = 0; i < tama?o(); i++)
			if (obtener(i).getNumMatricula() == numMatricula)
				return obtener(i);
		return null;
	}
	public int numeroCorrelativo() {
		if (tama?o() == 0) {
			return 200001;
		} else {
			return obtener(tama?o() - 1).getNumRetiro() + 1;			
		}
	}
	
	// Manejo de archivos de texto
	private void grabarRetiros() {
		try {
			PrintWriter pw;
			String linea;
			Retiro r;
			pw = new PrintWriter(new FileWriter("retiros.txt"));
			for (int i = 0; i < tama?o(); i++) {
				r = obtener(i);
				linea =	r.getNumRetiro() + ";" +
						r.getNumMatricula() + ";" +
						r.getFecha() + ";" +
						r.getHora();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void cargarRetiros() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			String[] s;
			int numeroRetiro, numeroMatricula;
			br = new BufferedReader(new FileReader("retiros.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				numeroRetiro = Integer.parseInt(s[0].trim());
				numeroMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				adicionar(new Retiro(numeroRetiro, numeroMatricula, fecha, hora));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}