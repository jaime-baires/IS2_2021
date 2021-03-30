package Controlador;

import java.util.TimerTask;

public class ProgramadoTask extends TimerTask {
	private ControladorAlarma context;
	private Alarma a;
	private Sonando s;
	private Programado p;

	public ProgramadoTask(ControladorAlarma context, Alarma a) {
		super();
		this.context = context;
		this.a = a;
	}

	@Override
	public void run() {

		context.setState(state);
		p.at();
		s.entryAction(context, a);
	}

}
