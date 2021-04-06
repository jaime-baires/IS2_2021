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
		context.setState(new Programado());

	}

	@Override
	public void BorraAlarma(ControladorAlarma context, Alarma a) {
		context.eliminaAlarma(a);
		context.setState(new Desprogramado());
	}

	@Override
	public void NuevaAlarma(ControladorAlarma context, Alarma a) {
		context.anhadeAlarma(a);
		context.setState(new Programado());
	}
}
