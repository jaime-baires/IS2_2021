package Controlador;

import java.util.LinkedList;
import java.util.PriorityQueue;

import Modelo.Alarma;

public class ControladorAlarma {

	private int INTERVALO_SONAR;
	private PriorityQueue<Alarma> alarmasActivas = new PriorityQueue<Alarma>();
	private LinkedList<Alarma> alarmasDesactivadas = new LinkedList<Alarma>();
	private ControladorAlarmaState state;

	// Constructor
	public ControladorAlarma() {
		state = ControladorAlarmaState.init(this);
	}

	// SetState
	public void setState(ControladorAlarmaState state) {
		this.state = state;
	}

	// Se�al
	public void NuevaAlarma(Alarma a) {
		state.NuevaAlarma(this, a);
	}

	// Se�al
	public void BorraAlarma(Alarma a) {
		state.BorraAlarma(this, a);
	}

	// Se�al
	public void Apagar(Alarma a) {
		state.Apagar(this, a);
	}

	// Se�al
	public void AlarmaOff(Alarma a) {
		state.AlarmaOff(this, a);
	}

	// Se�al
	public void AlarmaOn(Alarma a) {
		state.AlarmaOn(this, a);
	}

	// M�todos de negocio

	public Alarma alarma(String id) {
		for (Alarma a : alarmasActivas) {
			if (a.getId().equals(id))
				return a;
		}
		for (Alarma a : alarmasDesactivadas) {
			if (a.getId().equals(id))
				return a;
		}
		return null;
	}

	/**
	 * A�ade desde cero una alarma nueva
	 */
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

	/**
	 * Retorna null si est� vac�a la lista ordenada
	 */
	public Alarma alarmaMasProxima() {
		return alarmasActivas.peek();
	}

	/**
	 * Cuando el usuario desactiva manualmente una alarma sin que est� sonando
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
		System.out.println("YA NO EST� SONANDO");
	}

	/**
	 * Activar una alarma que estaba deshabilitada
	 */
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
