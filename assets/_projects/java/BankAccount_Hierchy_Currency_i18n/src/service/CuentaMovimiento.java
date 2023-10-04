package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import model.Movimiento;
import view.CuentaVista;

public class CuentaMovimiento extends CuentaLimitada {
	
	CuentaVista cuentavista = new CuentaVista();

	/* ===============
	 * OBJETOS i18n
	 =============== */
//	Locale locale = new Locale("en", "us");
	Locale locale = new Locale(cuentavista.localePrincipal().getLanguage(), cuentavista.localePrincipal().getCountry());
	ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);


	List<Movimiento> listaMovimientos = new ArrayList();


	public CuentaMovimiento() {
		// TODO Auto-generated constructor stub
	}
	
	public CuentaMovimiento(double saldo, double limite) {
		super(saldo, limite);
	}

	public CuentaMovimiento(double limite) {
		super(limite);
	}

	@Override
	public void extraer(double cantidad) {
		// TODO Auto-generated method stub
		super.extraer(cantidad);
		listaMovimientos.add(new Movimiento(bundle.getString("tipo.extraccion"), cantidad));
	}

	@Override
	public void ingresar(double cantidad) {
		// TODO Auto-generated method stub
		super.ingresar(cantidad);
		listaMovimientos.add(new Movimiento(bundle.getString("tipo.ingreso"), cantidad));
	}
	
	public List<Movimiento> listaMovimientos(){
		return listaMovimientos;
	}

}
