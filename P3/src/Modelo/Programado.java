package Modelo;

import java.util.Timer;

import Controlador.ControladorAlarma;
import Controlador.ControladorAlarmaState;

public class Programado extends ControladorAlarmaState {

	protected Timer timer = new Timer();
	protected ProgramadoTask programadoTask;

	public Programado() {
		super();
	}

	@Override
	public void entryAction(ControladorAlarma context, Alarma a) {
		programadoTask = new ProgramadoTask(context, a, this);
		timer.schedule(programadoTask, a.getHora());
	}

	@Override
	public void AlarmaOff(ControladorAlarma context, Alarma a) {
		context.desactivaAlarma(a);
		try {
			programadoTask.cancel();
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
