package service;

import java.util.ArrayList;

import model.Ciudad;

public class CiudadesService {
	/*
	 *					==========
	 * 					 Objetos
	 *					==========
	 */
	ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

	/*
	 *					==========
	 * 					 Métodos
	 *					==========
	 */
	
	// 1. añadir ciudad
	public ArrayList<Ciudad> agregarCiudad(String nombre, int poblacion, String pais) {

		Ciudad ciudad = new Ciudad(nombre, poblacion, pais);
		ciudades.add(ciudad);
		
		return ciudades;
	}

	// 2. mostrar ciudades según su país ////////////////////////////////////
	public ArrayList<Ciudad> ciudadPorPais(String pais) {
		ArrayList<Ciudad> aux = new ArrayList<Ciudad>();
		for(Ciudad c:ciudades) {
			if(pais.equals(c.getPais())) {
				aux.add(c);
			}
		}
		return aux;
	}

	// 3. ciudad más poblada
	public String mayorCiudad(String pais) {
		
		String ciudadMasPoblada = "";

		for(Ciudad c:ciudades) {
		
			int aux = 0;
			if(c.getPoblacion() > aux) {
				
				ciudadMasPoblada = c.getNombre();
			
			}
		
		}

		return ciudadMasPoblada;
	}

	// 4. eliminar ciudad
	public boolean eliminarCiudad(String ciudad) {
		
		for(int i= 0; i<ciudades.size();i++) {
			if(ciudad.equals(ciudades.get(i).getNombre())) {
				ciudades.remove(i);
				return true;
			}
		}
		return false;
	}

}