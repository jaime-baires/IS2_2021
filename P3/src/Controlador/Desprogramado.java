package Controlador;

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
		// TODO Auto-generated method stub
		context.anhadeAlarma(a);
		context.setState(new Programado());
	}
}
