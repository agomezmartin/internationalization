package service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class NotasService {
	/*
	 * OBJETOS i18n
	 */
	static Locale locale = new Locale("");
	static ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
	static MessageFormat message = new MessageFormat("");

	
	/*
	 *					==========
	 * 					 Métodos
	 *					==========
	 */
	
	// mostrar menu
	static public void mostrarMenu() {
		 System.out.println(bundle.getString("menu"));
	}

	// calcular nota media
	static public double calcularMedia(ArrayList<Double> notas) {
		double suma = 0;
		
		for(Double nota:notas) {
			suma+=nota;
		}
		return suma/notas.size();
	}

	// calcular nota más alta
	static public double calcularMasAlta(ArrayList<Double> notas) {
		double masAlta = notas.get(0);
		
		for(Double nota:notas) {
			if(nota>masAlta) {
				masAlta=nota;
			}
		}
		return masAlta;
	}

}