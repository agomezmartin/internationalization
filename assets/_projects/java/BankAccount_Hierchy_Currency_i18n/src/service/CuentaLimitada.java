package service;

public class CuentaLimitada extends CuentaBanco {
	
	private double limite;

	public CuentaLimitada() {
		// TODO Auto-generated constructor stub
	}

	public CuentaLimitada(double limite) {
		super();
		this.limite = limite;
	}

	public CuentaLimitada(double saldo, double limite) {
		super(saldo);
		this.limite = limite;
	}

	@Override
	public void extraer(double cantidad) {
		// TODO Auto-generated method stub

		if(cantidad < limite) {
			super.extraer(cantidad);
		} else {
			super.extraer(limite);			
		}
	}

}
