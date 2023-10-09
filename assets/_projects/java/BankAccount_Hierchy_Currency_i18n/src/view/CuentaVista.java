package view;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import model.Movimiento;
import service.CuentaMovimiento;

public class CuentaVista {

	/* ===============
	 * OBJETOS i18n
	 =============== */
	static Locale locale = new Locale("es", "es");
	static ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
	Currency currentCurrency = Currency.getInstance(locale);
	static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	static MessageFormat message = new MessageFormat("");

	/*
	 * ===== PLANTILLA MENSAJES FORMATEADOS =====

	 System.out.println(bundle.getString("hola"));
	 System.out.println(message.format(bundle.getString("hola"), num));

	 */
	
	/* ===============
	 * OBJETOS estáticos
	 =============== */
	static Scanner sc = new Scanner(System.in);
	static CuentaMovimiento cuenta;

	public static void main(String[] args) {

		/* ===============
		 * 
		 * Se solicita al usuario el SALDO inicial de la cuenta.
		 * 
		 * 1. Ingresar
		 * 2. Extraer
		 * 3. Ver saldo y movimientos
		 * 4. Salir
		 * 
		 =============== */
		
		operarCuenta();

	}
	
	// enviar LOCALE
	static public Locale localePrincipal() {

		return locale;
	}
	
	// operar cuenta
	static public void operarCuenta() {

		
		/* ===============
		 * OBJETO Cuenta Bancaria
		 =============== */
		
		System.out.println(bundle.getString("saldo"));
		double saldo = Double.parseDouble(sc.nextLine());
		double limite = 50;
		
		cuenta = new CuentaMovimiento(saldo, limite);
		
		int opcion = 0;
		
		System.out.println();

		double cantidad = 0;
		
		do {
			
			System.out.println("===============================");
			System.out.println();
			System.out.println(bundle.getString("cuenta.menu"));
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			
			case 1:
				System.out.println(bundle.getString("saldo.ingresar"));
				cantidad = Double.parseDouble(sc.nextLine());
				
				try {
					
					cuenta.ingresar(cantidad);

				} catch(Exception ex) {
				
					ex.printStackTrace();
				
				}
				
				System.out.println("===============================");
				System.out.println(bundle.getString("saldo.ingreso.realizado"));
				
				break;
			
			case 2:
				
				System.out.println(bundle.getString("saldo.extraer"));
				cantidad = Double.parseDouble(sc.nextLine());
								
				try {

					if(cantidad<=limite) {
						
						cuenta.extraer(cantidad);
						System.out.println("===============================");
						System.out.println(bundle.getString("saldo.extraccion.realizada"));
						
					} else {
						
						System.out.println("===============================");
						cuenta.extraer(cantidad);
						System.out.println(message.format(bundle.getString("saldo.extraccion.sobrepasada"), currencyFormatter.format(cantidad), currencyFormatter.format(limite)));
						
					}
	

				} catch(Exception ex) {
				
					ex.printStackTrace();
				
				}
				
				break;
			
			case 3:
				
				
				System.out.println("===============================");
				System.out.println(bundle.getString("lista.movimientos"));
				System.out.println("===============================");
				
				List<Movimiento> lista = cuenta.listaMovimientos();
		 
				lista.stream()
				.forEach(m->System.out.println(m.getTipo() + currencyFormatter.format(m.getCantidad())));
				
				break;
				
			case 4:
				System.out.println();
				System.out.println("===============================");
				System.out.println(message.format(bundle.getString("saldo.actual"), currencyFormatter.format(cuenta.consultarSaldo())));

				break;

			} // cierre SWITCH
			
		}
		while(opcion!=5);
		
		System.out.println();
		System.out.println("===============================");
		System.out.println(bundle.getString("cuenta.salida"));
		System.out.println("===============================");


	}
	
}
