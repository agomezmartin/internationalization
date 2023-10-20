package main;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import model.Pedido;
import service.PedidosService;

public class PedidoView {

	/*
	 * OBJETOS i18n
	 */
	static Locale locale = new Locale("es", "es");
	static ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
	static MessageFormat message = new MessageFormat("");
	static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	static Currency currency = Currency.getInstance(locale);

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
	static PedidosService service = new PedidosService();

	public static void main(String[] args) {

		/*
		 * 
		 * Un pedido se caracteriza por: producto,fechaPedido,precio
		 * 
		 * 1.- Alta pedido
		 * 2.- Pedido más reciente
		 * 3.- Pedidos por precio inferior:		Solicita un precio y muestra todos los productos inferiores
		 * 4.- Pedidos previos a una fecha:	El usuario inserta el número de meses previos		
		 * 5.- Salir
		 * 
		 * Cada ciudad se guarda en un ArrayList<Pedido>
		 * 
		 */

		pedidos();
		
	} // cierre MAIN
	
	static public void pedidos() {
		
		int opcion = 0;
		
		do {
			try {
				
				System.out.println("===============================");
				System.out.println();
				System.out.println(bundle.getString("menu"));
				opcion = sc.nextInt();

				while(opcion<1 || opcion > 5) {

					System.out.println();
					System.out.println(bundle.getString("opcion.excepcion"));
					System.out.println();
					System.out.println("===============================");
					System.out.println(bundle.getString("menu"));
					opcion = sc.nextInt();					
				}
				
				sc.nextLine();

				switch(opcion) {
				
				// 1. añadir producto
				case 1:
					System.out.println(bundle.getString("insertar.producto"));
					String producto = sc.nextLine();

					System.out.println(bundle.getString("insertar.fecha"));
					String fechaPedido = sc.nextLine();

					System.out.println(bundle.getString("insertar.precio"));
					double precio = Double.parseDouble(sc.nextLine());

					if(service.agregarPedido(producto, fechaPedido, precio)) {
						System.out.println("===============================");
						System.out.println(bundle.getString("pedido.agregado"));
					} else {
						System.out.println("===============================");
						System.out.println(bundle.getString("pedido.no.agregado"));						
					}
						
					break;
					
				// 2. mostrar el producto más reciente
				case 2:

					System.out.println(bundle.getString("pedido.mas.reciente"));
					System.out.println(bundle.getString("pedido") + service.pedidoReciente().getProducto());
					System.out.println(bundle.getString("precio") + currencyFormatter.format(service.pedidoReciente().getPrecio()));
					System.out.println(bundle.getString("fecha") + service.pedidoReciente().getFechapedido());
					break;
						
					// 3. Mostrar los pedidos inferiores al precio recibido por pantalla
					case 3:
						
						System.out.println(bundle.getString("insertar.precio"));
						precio = Double.parseDouble(sc.nextLine());

						List<Pedido> resultado = service.mostrarPedidosInferiores(precio);
						
						resultado.stream()
						.forEach(p ->System.out.println(
						"-----------------------------" + "\n" +
						bundle.getString("pedido") + p.getProducto() + "\n" +
						bundle.getString("precio")	+ currencyFormatter.format(p.getPrecio()) + "\n" +
						bundle.getString("fecha") + p.getFechapedido()));
						
						break;

					// 3. Mostrar los pedidos anteriores al número de meses que haya dicho el usuario
					case 4:
						
						System.out.println(bundle.getString("insertar.numero.meses"));
						int meses = Integer.parseInt(sc.nextLine());

						resultado = service.mostrarPedidosAnteriores(meses);
						
						resultado.stream()
						.forEach(p ->System.out.println(
						"-----------------------------" + "\n" +
						bundle.getString("pedido") + p.getProducto() + "\n" +
						bundle.getString("precio")	+ currencyFormatter.format(p.getPrecio()) + "\n" +
						bundle.getString("fecha") + p.getFechapedido()));
						
						break;

				} // cierre switch

			} catch(InputMismatchException ex) {
				
				System.out.println("===============================");
				System.out.println(bundle.getString("excepcion.input"));

			} catch(NumberFormatException ex) {
				
				System.out.println("===============================");
				System.out.println(bundle.getString("excepcion.input"));
				ex.printStackTrace();
			}

		} while (opcion != 5);
		
		System.out.println("====================================");
		System.out.println(bundle.getString("salir"));
		System.out.println("====================================");

	}

}