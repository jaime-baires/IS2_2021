package Modelo;

import java.util.TimerTask;

import Controlador.ControladorAlarma;

public class SonandoTask extends TimerTask {

	private ControladorAlarma context;
	private Alarma alarma;
	private Sonando sonando;

	public SonandoTask(ControladorAlarma context, Alarma a, Sonando s) {
		super();
		this.context = context;
		this.alarma = a;
		sonando = s;
	}

	@Override
	public void run() {
		this.sonando.exitAction(context, alarma);

	}

}
