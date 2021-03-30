package Controlador;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class ControladorAlarma {

	private int INTERVALO_SONAR;
	private PriorityQueue<Alarma> alarmasActivas = new PriorityQueue<Alarma>();
	private LinkedList<Alarma> alarmasDesactivadas = new LinkedList<Alarma>();
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

	/**
	 * Cuando se elimina por completo la alarma
	 */
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

	/**
	 * Cuando el usuario desactiva manualmente una alarma sin que esté sonando
	 */
	public void desactivaAlarma(Alarma a) {
		alarmasActivas.remove(a);
		alarmasDesactivadas.add(a);

	}

	public PriorityQueue<Alarma> alarmasActivas() {
		return this.alarmasActivas;
	}

	public LinkedList<Alarma> alarmasDesactivadas() {
		return this.alarmasDesactivadas;
	}

	public void activarMelodia() {
		System.out.println("SONANDO");
	}

	public void desactivarMelodia() {
		System.out.println("YA NO ESTÁ SONANDO");
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

	public int getINTERVALO_SONAR() {
		return INTERVALO_SONAR;
	}

	public void setINTERVALO_SONAR(int iNTERVALO_SONAR) {
		INTERVALO_SONAR = iNTERVALO_SONAR;
	}

}
