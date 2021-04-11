package es.unican.is2.practica3.Modelo;

import java.util.Timer;

import es.unican.is2.practica3.Controlador.ControladorAlarma;
import es.unican.is2.practica3.Controlador.ControladorAlarmaState;

public class Programado extends ControladorAlarmaState {

	protected Timer timer = new Timer();
	protected ProgramadoTask programadoTask;

	public Programado() {
		super();
	}

	@Override
	public void entryAction(ControladorAlarma context, Alarma a) {
		if (context.alarmasActivas().contains(a)) {
			programadoTask = new ProgramadoTask(context, a, this);
			timer.schedule(programadoTask, a.getHora());
		}
	}

	@Override
	public void AlarmaOff(ControladorAlarma context, Alarma a) {
		context.desactivaAlarma(a);
		try {
			programadoTask.cancel();
			timer.cancel();
		} catch (Exception e) {

		}

		if (context.alarmasActivas().size() == 0) {
			context.setState(new Desprogramado());
		} else {
			context.setState(new Programado());
		}
	}

	@Override
	public void AlarmaOn(ControladorAlarma context, Alarma a) {
		context.activarAlarma(a);
		context.setState(new Programado());
		this.entryAction(context, a);
	}

	@Override
	public void BorraAlarma(ControladorAlarma context, Alarma a) {
		context.eliminaAlarma(a);
		if (context.alarmasActivas().size() == 0) {
			context.setState(new Desprogramado());
		} else {
			context.setState(new Programado());
		}
	}

	@Override
	public void NuevaAlarma(ControladorAlarma context, Alarma a) {
		context.anhadeAlarma(a);
		context.setState(new Programado());
		this.entryAction(context, a);
	}

	public void at(ControladorAlarma context, Alarma a) {
		Sonando s = new Sonando();
		context.setState(s);
		s.entryAction(context, a);

	}
}
