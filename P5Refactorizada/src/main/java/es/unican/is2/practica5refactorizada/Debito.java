package es.unican.is2.practica5refactorizada;

import java.time.LocalDate;

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public Debito(String numero, String titular, CuentaAhorro c) { // WMC = 1, CCog = 0
		super(numero, titular, c);
	}
	
	
	@Override
	public void retirar(double cantidad) throws saldoInsuficienteException, datoErroneoException { // WMC = 2, CCog = 1
		if (saldoDiarioDisponible<cantidad) { // WMC + 1, CCog = 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.cuentaAsociada.retirar("Retirada en cajero autom�tico", cantidad);
		saldoDiarioDisponible-=cantidad;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double cantidad) throws saldoInsuficienteException, datoErroneoException { // WMC = 2, CCog = 1
		if (saldoDiarioDisponible<cantidad) { // WMC + 1, CCog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.cuentaAsociada.retirar("Compra en : " + datos, cantidad);
		saldoDiarioDisponible-=cantidad;
	}
	
	public LocalDate getCaducidadDebito() { // WMC = 1, CCog = 0
		return this.cuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * M�todo invocado autom�ticamente a las 00:00 de cada d�a
	 */
	public void restableceSaldo() { // WMC = 1, CCog = 0
		saldoDiarioDisponible = cuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() { // WMC = 1, CCog = 0
		return cuentaAsociada;
	}

}