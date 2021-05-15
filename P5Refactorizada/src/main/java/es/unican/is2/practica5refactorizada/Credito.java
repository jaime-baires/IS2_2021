package es.unican.is2.practica5refactorizada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Credito extends Tarjeta {

	private double credito;
	private List<Movimiento> movimientosMensuales;
	private List<Movimiento> historicoMovimientos;

	public Credito(String numero, String titular, CuentaAhorro c, double credito) { // WMC = 1, CCog = 0
		super(numero, titular, c);
		this.credito = credito;
		movimientosMensuales = new LinkedList<Movimiento>();
		historicoMovimientos = new LinkedList<Movimiento>();
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * 
	 * @param cantidad Cantidad a retirar. Se aplica una comisión del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double cantidad) throws saldoInsuficienteException, datoErroneoException { // WMC = 3, CCog = 2
		if (cantidad < 0) // WMC + 1, CCog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Retirada en cajero automático");
		cantidad += cantidad * 0.05; // Añadimos una comisión de un 5%
		m.setImporte(-cantidad);

		if (Movimiento.getGastosAcumulados(this.movimientosMensuales) + cantidad > credito) // WMC + 1, CCog + 1
			throw new saldoInsuficienteException("Crédito insuficiente");
		else { // WMC + 1, CCog + 1
			movimientosMensuales.add(m);
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double cantidad) throws saldoInsuficienteException, datoErroneoException { // WMC = 3, CCog = 2
		if (cantidad < 0) // WMC + 1, CCog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		if (Movimiento.getGastosAcumulados(this.movimientosMensuales) + cantidad > credito) // WMC + 1, CCog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");

		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Compra a crédito en: " + datos);
		m.setImporte(-cantidad);
		movimientosMensuales.add(m);
	}

	public LocalDate getCaducidadCredito() { // WMC = 1, CCog = 0
		return this.cuentaAsociada.getCaducidadCredito();
	}

	/**
	 * Método que se invoca automáticamente el día 1 de cada mes
	 */
	public void liquidar() { // WMC = 2, CCog = 1
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		liq.setFecha(now);
		liq.setConcepto("Liquidación de operaciones tarjeta crédito");
		double r = Movimiento.getGastosAcumulados(this.movimientosMensuales);
	
		liq.setImporte(r);

		if (r != 0) // WMC + 1, CCog + 1
			cuentaAsociada.addMovimiento(liq);

		historicoMovimientos.addAll(movimientosMensuales);
		movimientosMensuales.clear();
	}

	public List<Movimiento> getMovimientosUltimoMes() { // WMC = 1, CCog = 0
		return movimientosMensuales;
	}

	public Cuenta getCuentaAsociada() { // WMC = 1, CCog = 0
		return cuentaAsociada;
	}

	public List<Movimiento> getMovimientos() { // WMC = 1, CCog = 0
		return historicoMovimientos;
	}

}