package Controlador;

import java.util.LinkedList;

public class ControladorAlarma {

	private int INTERVALO_SONAR;
	private LinkedList<Alarma> alarmasActivas;
	private LinkedList<Alarma> alarmasDesactivadas;
	private ControladorAlarmaState state;

	public ControladorAlarma() {
		state = ControladorAlarmaState.init(this);
	}

	public Alarma alarma(String id) {
		return null;
	}

	public boolean anhadeAlarma(Alarma a) {
		alarmasActivas.add(a);
		return true;
	}

	public boolean eliminaAlarma(Alarma a) {
		if (alarmasActivas.contains(a)) {
			alarmasActivas.remove(a);
			return true;
		}
		if (alarmasDesactivadas.contains(a)) {
			alarmasDesactivadas.remove(a);
			return true;
		}
		return false;
	}

	public Alarma alarmaMasProxima() {
		return null;
	}

	public void desactivaAlarma(Alarma a) {
		alarmasActivas.remove(a);
		alarmasDesactivadas.add(a);

	}

	public LinkedList<Alarma> alarmasActivas() {
		return this.alarmasActivas;
	}

	public LinkedList<Alarma> alarmasDesactivadas() {
		return this.alarmasDesactivadas;
	}

	public void activarMelodia() {

	}

	public void desactivarMelodia() {

	}

	public void NuevaAlarma(Alarma a) {
		state.NuevaAlarma(this, a);
	}

	public void BorraAlarma(Alarma a) {
		state.BorraAlarma(this, a);
	}

	public void Apagar(Alarma a) {
		state.Apagar(this, a);
	}

	public void AlarmaOff(Alarma a) {
		state.AlarmaOff(this, a);
	}

	public void AlarmaOn(Alarma a) {
		state.AlarmaOn(this, a);
	}

	public void setState(ControladorAlarmaState state) {
		this.state = state;
	}

	public void activarAlarma(Alarma a) {
		alarmasDesactivadas.remove(a);
		alarmasActivas.add(a);

	}

}
