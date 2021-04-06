package Modelo;

import java.util.TimerTask;

import Controlador.ControladorAlarma;

public class ProgramadoTask extends TimerTask {
	private ControladorAlarma context;
	private Alarma a;
	private Programado p;

	public ProgramadoTask(ControladorAlarma context, Alarma a, Programado p) {
		super();
		this.context = context;
		this.a = a;
		this.p = p;
	}

	@Override
	public void run() {
		this.p.at(context, a);
	}

}
