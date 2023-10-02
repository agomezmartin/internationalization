package main;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import service.NotasService;

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
	static Scanner sc = new Scanner(System.in);
	 

	 /*
	 * OBJETO Service
	 */
	static NotasService service = new NotasService();

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

			try {
				
				System.out.println("=====================================");
				System.out.println();
				
				service.mostrarMenu();
				
				System.out.println();
					
				opcion = sc.nextInt();

			} catch(InputMismatchException ex) {
				
				System.out.println("=====================================");
				System.out.println(bundle.getString("opcion.excepcion"));
				
				service.mostrarMenu();
				
				System.out.println();
			}

			while(opcion < 1 || opcion > 5) {
				
				sc.nextLine(); // limpia el buffer
				
				System.out.println();
				System.out.println("=====================================");
				System.out.println(bundle.getString("opcion.excepcion"));
				System.out.println("=====================================");
				System.out.println();
				
				service.mostrarMenu();
				
				System.out.println();
				
				try {
					
					opcion = sc.nextInt();				

				} catch(InputMismatchException ex) {
					
					System.out.println("=====================================");
					System.out.println(bundle.getString("opcion.excepcion"));
				}
			
			} // cierre while

			switch(opcion) {
			
			// añadir nota
			case 1:
				
				// control de tipo de dato introducido por usuario
				try {
				
					System.out.println();
					System.out.println(bundle.getString("nota.agregar"));

					nota = sc.nextDouble();

				} catch(InputMismatchException ex) {

					System.out.println("=====================================");
					System.out.println(bundle.getString("nota.agregar.excepcion"));
					
					sc.nextLine();
					
					System.out.println();
					System.out.println(bundle.getString("nota.agregar"));

					nota = sc.nextDouble();
					
				} // cierre catch
				
					while(nota < 0 || nota > 10) {
					
					
						System.out.println();
						System.out.println(bundle.getString("nota.agregar.excepcion"));
						System.out.println();
						System.out.println(bundle.getString("nota.agregar"));
						
						try {
							
							nota = sc.nextDouble();

						} catch(InputMismatchException ex) {
							
							System.out.println();
							System.out.println(bundle.getString("nota.agregar.excepcion"));
							System.out.println();
							System.out.println(bundle.getString("nota.agregar"));
							
							sc.nextLine();

							nota = sc.nextDouble();
							
						} // cierre catch

				} // cierre while
				
				notas.add(nota);
				System.out.println("=====================================");
				System.out.println(bundle.getString("nota.agregada"));
				break;
				
			// eliminar nota
			case 2:
				System.out.println(bundle.getString("nota.eliminar"));
				int pos = sc.nextInt();
				
				try {					
					notas.remove(pos);
					System.out.println();
					System.out.println(bundle.getString("nota.eliminada"));
				
				} catch(InputMismatchException ex) {
				
					System.out.println();
					System.out.println(message.format(bundle.getString("nota.eliminar.excepcion"), (notas.size()-(notas.size())), notas.size()-1));
				
				} catch(Exception e) {
					
					System.out.println();
					System.out.println(message.format(bundle.getString("nota.eliminar.excepcion"), (notas.size()-(notas.size())), notas.size()-1));

				}

				System.out.println();

				
				break;
					
			// calcular nota media
			case 3:

				System.out.println();
				System.out.println(message.format(bundle.getString("nota.media"), service.calcularMedia(notas)));
				System.out.println();

				break;
					
			// calcular nota más alta
			case 4:

				System.out.println();
				System.out.println(message.format(bundle.getString("nota.mas.alta"), service.calcularMasAlta(notas)));
				System.out.println();

				break;
					
			} // cierre switch
			
		} while (opcion != 5);
		
		System.out.println();
		System.out.println("====================================");
		System.out.println(bundle.getString("salir"));
		System.out.println("====================================");


	} // /////////////////// cierre MAIN
	

}