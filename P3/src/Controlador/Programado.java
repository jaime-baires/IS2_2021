package Controlador;

public class Programado extends ControladorAlarmaState {
	public Programado() {
		super();
	}

	@Override
	public void AlarmaOff(ControladorAlarma context, Alarma a) {
		context.desactivaAlarma(a);
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
	}

	@Override
	public void BorraAlarma(ControladorAlarma context, Alarma a) {
		// TODO Auto-generated method stub
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
	}
}
