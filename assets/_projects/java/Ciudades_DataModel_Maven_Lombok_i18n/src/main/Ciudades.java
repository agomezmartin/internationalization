package main;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import service.CiudadesService;

public class Ciudades {

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
	static Scanner sc = new Scanner(System.in);
	static Scanner sc_ = new Scanner(System.in);
	 

	 /*
	 * OBJETO Service
	 */
	static CiudadesService service = new CiudadesService();

	public static void main(String[] args) {

		/*
		 * Menú:
		 * 
		 * 1. Nueva ciudad:			añadir datos de una ciudad
		 * 2. Ciudades por país:	se pide el país y muestra sus ciudades
		 * 3. Ciudad más poblada:	ciudad más poblada
		 * 4. Eliminar ciudad:		pide el nombre de la ciudad y elimina todos sus datos
		 * 5. Salir
		 * 
		 * Cada ciudad se guarda en un ArrayList
		 * 
		 */

		ciudades();
		
	} // cierre MAIN
	
	static public void ciudades() {
		
		int opcion = 0;
		
		do {
			
			try {
				
				System.out.println("=================");
				System.out.println();
				System.out.println(bundle.getString("menu"));
				opcion = sc.nextInt();

				while(opcion<1 || opcion > 5) {

					System.out.println();
					System.out.println(bundle.getString("opcion.excepcion"));
					System.out.println();
					System.out.println("=================");
					System.out.println(bundle.getString("menu"));
					
					opcion = sc.nextInt();				
					
				}

				switch(opcion) {
				
				// añadir ciudad
				case 1:
						System.out.println(bundle.getString("ciudad.agregar"));
						String ciudad = sc_.nextLine();

						System.out.println(bundle.getString("ciudad.agregar.poblacion"));
						int poblacion = Integer.parseInt(sc_.nextLine());
						
						System.out.println(bundle.getString("ciudad.agregar.pais"));
						String pais = sc_.nextLine();

						service.agregarCiudad(ciudad, poblacion, pais);
						System.out.println();
			
					break;
					
				// mostrar ciudades según su país
				case 2:

					System.out.println(bundle.getString("insertar.pais"));
					pais = sc_.nextLine();

					System.out.println("=================");
					service.ciudadPorPais(pais).stream()
					.forEach(c->System.out.println(c.getNombre()));

					break;
						
				// calcular nota media
				case 3:

					System.out.println(bundle.getString("insertar.pais"));
					pais = sc_.nextLine();
					System.out.println("=================");
					System.out.println(bundle.getString("ciudad.mas.poblada") + service.mayorCiudad(pais));

					break;
						
					// eliminar ciudad
					case 4:

						System.out.println();
						System.out.println(bundle.getString("insertar.ciudad"));
						pais = sc_.nextLine();
						if(service.eliminarCiudad(pais)) {
							System.out.println("=================");
							System.out.println(bundle.getString("ciudad.eliminada"));
						}else{
							System.out.println("=================");
							System.out.println(bundle.getString("ciudad.no.existe"));
						};
						System.out.println();

						break;
						
				} // cierre switch
				
				/*
				 * CONTROL DE EXCEPCIONES
				 */
				
			} catch(NumberFormatException ex){
				System.out.println("=================");
				System.out.println(bundle.getString("opcion.error"));

			} catch (InputMismatchException ex) {
				
				System.out.println("=================");
				System.out.println(bundle.getString("opcion.error"));
			
			} catch (Exception ex) {
			
			System.out.println("=================");
			System.out.println(bundle.getString("opcion.error"));
			ex.printStackTrace();
		}

		} while (opcion != 5);
		
		System.out.println();
		System.out.println("====================================");
		System.out.println(bundle.getString("salir"));
		System.out.println("====================================");

	}

}