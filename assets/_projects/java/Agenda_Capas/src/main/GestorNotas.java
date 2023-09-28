package main;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import service.AgendasService;

public class GestorNotas {

	/*
	 * OBJETOS i18n
	 */
	static Locale locale = new Locale("");
	static ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
	static MessageFormat message = new MessageFormat("");

	/*
	 * ===== PLANTILLA MENSAJES FORMATEADOS =====

	 System.out.println(bundle.getString("hola"));
	 System.out.println(message.format(bundle.getString("hola"), num));

	 */
	/*
	 * OBJETO Scanner
	 */
	static Scanner sc_menu = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	 

	 /*
	 * OBJETO Service
	 */
	static AgendasService service = new AgendasService();

	public static void main(String[] args) {
		
		
		/*
		 * Menú:
		 * 
		 * 1. Añadir nota
		 * 2. Eliminar nota
		 * 3. Calcular media
		 * 4. Nota más alta
		 * 5. Salir
		 * 
		 */
		
		int opcion = 0;
		double nota = 0;
		ArrayList<Double> notas = new ArrayList<>();
		
		do {
			System.out.println("=================");
			mostrarMenu();
			opcion = sc_menu.nextInt();

			while(opcion<1 || opcion > 5) {

				System.out.println();
				System.out.println(bundle.getString("opcion.excepcion"));
				System.out.println();
				System.out.println("=================");
				mostrarMenu();
				opcion = sc_menu.nextInt();
				
			}

			switch(opcion) {
			// añadir contacto
			case 1:
				System.out.println(bundle.getString("contacto.agregar.email"));
				String email = sc.nextLine();
				
				System.out.println(bundle.getString("contacto.agregar.nombre"));
				String nombre = sc.nextLine();
				
				if(service.agregarContacto(email, nombre)) {
					System.out.println(bundle.getString("contacto.agregado"));
				} else {
					System.out.println(bundle.getString("contacto.ya.existe"));					
				}
				break;
				
			// eliminar nota
			case 2:
				
				System.out.println(bundle.getString("contacto.eliminar.email"));
				email = sc.nextLine();
				
				if(service.eliminarContacto(email)) {
					System.out.println(bundle.getString("contacto.eliminado"));					
				} else {
					System.out.println(bundle.getString("contacto.no.existe"));										
				}

				break;				
				
			// buscar contacto
			case 3:

				System.out.println();
				System.out.println(bundle.getString("contacto.buscar.email"));
				email = sc.nextLine();
				
				if (service.buscarContacto(email)!=null) {
					System.out.println(service.buscarContacto(email) + ": " + email);
				} else {
					System.out.println(bundle.getString("contacto.no.existe"));										
				}

				break;
					
			// mostrar todos los contactos
			case 4:

				System.out.println();
				System.out.println(service.mostrarContactos());

				break;
					
			} // cierre switch
			
		} while (opcion != 5);
		
		System.out.println();
		System.out.println("====================================");
		System.out.println(bundle.getString("salir"));
		System.out.println("====================================");


	} // /////////////////// cierre MAIN
	
	static public void mostrarMenu() {
		System.out.println(bundle.getString("menu"));
	}
	

}