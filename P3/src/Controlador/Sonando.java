package Controlador;

public class Sonando extends ControladorAlarmaState {

	public Sonando() {
		super();

	}

	@Override
	public void Apagar(ControladorAlarma context, Alarma a) {
		// TODO Auto-generated method stub
		context.eliminaAlarma(a);
		context.setState(new Desprogramado());
	}

	@Override
	public void entryAction(ControladorAlarma context, Alarma a) {
		// TODO Auto-generated method stub
		context.activarMelodia();
	}

	@Override
	public void exitAction(ControladorAlarma context, Alarma a) {
		// TODO Auto-generated method stub
		context.desactivarMelodia();
	}
}
