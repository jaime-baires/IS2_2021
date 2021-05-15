package es.unican.is2.practica5refactorizada;

public abstract class Cuenta {

	private String numCuenta;

	public Cuenta(String numCuenta) { // WMC = 1, CCog = 0
		this.numCuenta = numCuenta;
	}

	public String getNumCuenta() { // WMC = 1, CCog = 0
		return numCuenta;
	}
	
	public static double getSaldo(Cuenta c) { // WMC = 2, CCog = 1
		if (c instanceof CuentaAhorro) { // WMC + 1, CCog + 1
			return ((CuentaAhorro) c).getSaldo();
		} 
		return getTotalCuentaValores(c);
	}
	
	private static double getTotalCuentaValores(Cuenta c) { // WMC = 2, CCog = 1
		double total = 0.0;
		for (Valor v : ((CuentaValores) c).getValores()) { // WMC + 1, CCog + 1
			total += v.getCotizacionActual() * v.getNumValores();
		}
		return total;
	}

}
