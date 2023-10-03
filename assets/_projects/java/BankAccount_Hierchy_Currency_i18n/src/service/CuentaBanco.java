package service;

public class CuentaBanco {
	
	private double saldo;

	public CuentaBanco () {
		
	}
	public CuentaBanco(double saldo) {
		this.saldo = saldo;
	}	
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