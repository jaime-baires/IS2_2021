package es.unican.is2.practica3.Controlador;

import es.unican.is2.practica3.Modelo.Alarma;
import es.unican.is2.practica3.Modelo.Desprogramado;
import es.unican.is2.practica3.Modelo.Programado;
import es.unican.is2.practica3.Modelo.Sonando;

public abstract class ControladorAlarmaState {

	private static Desprogramado estadoDesprogramado = new Desprogramado();
	private static Programado estadoProgramado = new Programado();
	private static Sonando estadoSonando = new Sonando();

	// devuelve estado inicial
	public static ControladorAlarmaState init(ControladorAlarma context) {
		return estadoDesprogramado;
	}

	public void NuevaAlarma(ControladorAlarma context, Alarma a) {
	}

	public void BorraAlarma(ControladorAlarma context, Alarma a) {
	}

	public void Apagar(ControladorAlarma context, Alarma a) {
	}

	public void AlarmaOff(ControladorAlarma context, Alarma a) {
	}

	public void AlarmaOn(ControladorAlarma context, Alarma a) {
	}

	public void entryAction(ControladorAlarma context, Alarma a) {
	}

	public void exitAction(ControladorAlarma context, Alarma a) {
	}

	public void doAction(ControladorAlarma context, Alarma a) {
	}

	public static Desprogramado getEstadoDesprogramado() {
		return estadoDesprogramado;
	}

	public static Programado getEstadoProgramado() {
		return estadoProgramado;
	}

	public static Sonando getEstadoSonando() {
		return estadoSonando;
	}

}
