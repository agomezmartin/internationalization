package service;

public class CuentaBanco {
	
	private double saldo;
	
	/* ===============
	 * 	Constructores
	 =============== */

	public CuentaBanco () {
		
	}
	public CuentaBanco(double saldo) {
		this.saldo = saldo;
	}	

	/* ===============
	 * 	Métodos
	 =============== */

	public double consultarSaldo() {
		return this.saldo;
	}
	public void extraer(double cantidad) {
		this.saldo-=cantidad;
	}
	public void ingresar(double cantidad) {
		this.saldo+=cantidad;
	}

}