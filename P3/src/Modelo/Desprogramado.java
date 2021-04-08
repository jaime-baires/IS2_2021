package Modelo;

import Controlador.ControladorAlarma;
import Controlador.ControladorAlarmaState;

public class Desprogramado extends ControladorAlarmaState {

	public Desprogramado() {
		super();
	}

	@Override
	public void AlarmaOn(ControladorAlarma context, Alarma a) {
		context.activarAlarma(a);
		context.desactivaAlarma(a);
		Programado p = new Programado();
		context.setState(p);
		p.entryAction(context, a);
	}

	@Override
	public void BorraAlarma(ControladorAlarma context, Alarma a) {
		context.eliminaAlarma(a);
		context.setState(new Desprogramado());
	}

	@Override
	public void NuevaAlarma(ControladorAlarma context, Alarma a) {
		context.anhadeAlarma(a);
		Programado p = new Programado();
		context.setState(p);
		p.entryAction(context, a);
	}
}
