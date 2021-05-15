package es.unican.is2.practica5refactorizada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> movimientos;
	private LocalDate fechaDeCaducidadTarjetaDebito;
	private LocalDate fechaDeCaducidadTarjetaCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) { // WMC = 1, CCog = 0
		super(numCuenta);
		this.fechaDeCaducidadTarjetaDebito = date;
		this.fechaDeCaducidadTarjetaCredito = date2;
		movimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double cantidad) throws datoErroneoException { // WMC = 1, CCog = 0
		this.movimientos.add(crearMovimientoIngreso(cantidad, "Ingreso en efectivo"));
	}

	private Movimiento crearMovimientoIngreso(double cantidad, String concepto) { //WMC=2, CCog=1
		if (cantidad <= 0) // WMC + 1, CCog + 1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto(concepto);
		m.setImporte(cantidad);
		return m;
	}

	public void retirar(double cantidad) throws saldoInsuficienteException, datoErroneoException { // WMC = 1, CCog = 0
		Movimiento m = creaRetiro(cantidad,"Retirada de efectivo");
		this.movimientos.add(m);
	}

	private Movimiento creaRetiro(double cantidad,String concepto) { //WMC=3, CCog=2
		if (cantidad <= 0) // WMC + 1, CCog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		if (getSaldo() < cantidad) // WMC + 1, CCog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto(concepto);
		m.setImporte(-cantidad);
		return m;
	}

	public void ingresar(String concepto, double cantidad) throws datoErroneoException { // WMC = 1, CCog = 0
	
		this.movimientos.add(crearMovimientoIngreso(cantidad, concepto));
	}

	public void retirar(String concepto, double cantidad) throws saldoInsuficienteException, datoErroneoException { // WMC = 1, CCog = 0
		Movimiento m = creaRetiro(cantidad,concepto);
		this.movimientos.add(m);
	}

	public double getSaldo() { // WMC = 1, CCog = 0
	
		return Movimiento.getGastosAcumulados(movimientos);
	}

	public void addMovimiento(Movimiento m) { // WMC = 1, CCog = 0
		movimientos.add(m);
	}

	public List<Movimiento> getMovimientos() { // WMC = 1, CCog = 0
		return movimientos;
	}

	public LocalDate getCaducidadDebito() { // WMC = 1, CCog = 0
		return this.fechaDeCaducidadTarjetaDebito;
	}

	public LocalDate getCaducidadCredito() { // WMC = 1, CCog = 0
		return this.fechaDeCaducidadTarjetaCredito;
	}

	public double getLimiteDebito() { // WMC = 1, CCog = 0
		return limiteDebito;
	}

}