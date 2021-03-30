package Controlador;

import java.util.Timer;

public class Programado extends ControladorAlarmaState {

	protected Timer timer = new Timer();
	protected ProgramadoTask programadoTask;

	public Programado() {
		super();
	}

	@Override
	public void AlarmaOff(ControladorAlarma context, Alarma a) {
		context.desactivaAlarma(a);
		programadoTask.cancel();
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
		programadoTask = new ProgramadoTask(context, a);
		timer.schedule(programadoTask, a.getHora());
	}

	@Override
	public void BorraAlarma(ControladorAlarma context, Alarma a) {
		// TODO Auto-generated method stub
		context.eliminaAlarma(a);
		programa
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
	}

	public void at() {

	}
}
