package es.unican.is2.practica3.Modelo;

import java.util.Timer;

import es.unican.is2.practica3.Controlador.ControladorAlarma;
import es.unican.is2.practica3.Controlador.ControladorAlarmaState;

public class Sonando extends ControladorAlarmaState {

	protected Timer timer = new Timer();
	protected SonandoTask sonandoTask;

	public Sonando() {
		super();

	}

	@Override
	public void Apagar(ControladorAlarma context, Alarma a) {
		this.exitAction(context, a);
	}

	@Override
	public void entryAction(ControladorAlarma context, Alarma a) {
		if (context.alarmasActivas().contains(a)) {
			context.activarMelodia();
			sonandoTask = new SonandoTask(context, a, this);
			timer.schedule(sonandoTask, context.getINTERVALO_SONAR());
		}
	}

	@Override
	public void exitAction(ControladorAlarma context, Alarma a) {
		context.desactivarMelodia();
		context.eliminaAlarma(a);
		sonandoTask.cancel();
		if (context.alarmasActivas().size() == 0) {
			context.setState(new Desprogramado());
		} else {
			context.setState(new Programado());
		}
	}
}
