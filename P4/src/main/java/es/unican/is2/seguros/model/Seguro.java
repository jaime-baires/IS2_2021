package es.unican.is2.seguros.model;

import java.time.LocalDate;

public class Seguro {

	private LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	private Cobertura cobertura;
	private Cliente cliente;

	public Seguro(int potenciaCV, Cobertura cobertura, Cliente cliente) {
		this.potenciaCV = potenciaCV;
		this.cobertura = cobertura;
		this.cliente = cliente;
	}

	public double precio() throws DatoIncorrectoException {
		return 2;
	}

	public LocalDate getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}

	public void setFechaUltimoSiniestro(LocalDate fechaUltimoSiniestro) {
		this.fechaUltimoSiniestro = fechaUltimoSiniestro;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
