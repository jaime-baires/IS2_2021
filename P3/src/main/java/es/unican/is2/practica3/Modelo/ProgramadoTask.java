package es.unican.is2.practica3.Modelo;

import java.util.TimerTask;

import es.unican.is2.practica3.Controlador.ControladorAlarma;

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
