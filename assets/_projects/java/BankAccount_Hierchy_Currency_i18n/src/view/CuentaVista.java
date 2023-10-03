package view;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import model.Movimiento;
import service.CuentaMovimiento;

public class CuentaVista {

	public static void main(String[] args) {
		
		/* ===============
		 * OBJETOS i18n
		 =============== */
		Locale locale = new Locale("es");
		ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
//		Currency currentCurrency = Currency.getInstance(locale);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		
		/* ===============
		 * OBJETO Cuenta Bancaria
		 =============== */
		CuentaMovimiento cuenta = new CuentaMovimiento(50);

		cuenta.ingresar(50);
		
		cuenta.extraer(60);

		cuenta.ingresar(20);

		cuenta.extraer(60);
		
		System.out.println("===============================");
		System.out.println(bundle.getString("lista.movimientos"));
		System.out.println("===============================");
 
		List<Movimiento> lista = cuenta.listaMovimientos();

		lista.stream()
		.forEach(m->System.out.println(m.getTipo() + currencyFormatter.format(m.getCantidad())));
		System.out.println("===============================");

	}

}
