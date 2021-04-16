package es.unican.is2.seguros.model;

import java.time.LocalDate;

public class Seguro {

	private LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	private Cobertura cobertura;
	private Cliente cliente;

	public Seguro(int potenciaCV, Cobertura cobertura, Cliente cliente, LocalDate fecha) throws DatoIncorrectoException {
		if (potenciaCV < 0)
			throw new DatoIncorrectoException();
		if (cobertura == null)
			throw new DatoIncorrectoException();
		if (fecha == null)
			throw new DatoIncorrectoException();
		if(fecha.compareTo(LocalDate.now()) > 0)
			throw new DatoIncorrectoException();
		this.potenciaCV = potenciaCV;
		this.cobertura = cobertura;
		this.cliente = cliente;
		this.fechaUltimoSiniestro = fecha;
	}

	public double precio() throws DatoIncorrectoException {
		
		double precio = 0;
		
		if(this.cobertura == Cobertura.TODORIESGO) {
			precio += 1000;
		} else if(this.cobertura == Cobertura.TERCEROSLUNAS) {
			precio += 600;
		} else {
			precio += 400;
		}
		
		if(this.potenciaCV>=90 && this.potenciaCV<=110) {
			precio *= 1.05;
		} else if(this.potenciaCV>110) {
			precio *= 1.2;
		}
		
		LocalDate fechaActual = LocalDate.now();
		if(fechaActual.minusDays(364).compareTo(this.fechaUltimoSiniestro) <= 0) {
			precio += 200;
		} else if(fechaActual.minusYears(2).minusDays(364).compareTo(this.fechaUltimoSiniestro) <= 0) {
			precio += 50;
		}
		
		if(this.cliente.isMinusvalia()) {
			precio *= 0.75;
		}
		System.out.println(precio);
		return precio;
	}

}
