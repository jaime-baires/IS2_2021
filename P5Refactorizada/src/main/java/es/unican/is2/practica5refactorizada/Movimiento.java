package es.unican.is2.practica5refactorizada;

import java.time.LocalDateTime;
import java.util.List;

public class Movimiento {
	private String concepto;
	private LocalDateTime fecha;
	private double importe;

	public double getImporte() { // WMC = 1, CCog = 0
		return importe;
	}

	public String getConcepto() { // WMC = 1, CCog = 0
		return concepto;
	}

	public void setConcepto(String newConcepto) { // WMC = 1, CCog = 0
		concepto = newConcepto;
	}

	public LocalDateTime getFecha() { // WMC = 1, CCog = 0
		return fecha;
	}

	public void setFecha(LocalDateTime newFecha) { // WMC = 1, CCog = 0
		fecha = newFecha;
	}

	public void setImporte(double newImporte) { // WMC = 1, CCog = 0
		importe = newImporte;
	}

	public static double getGastosAcumulados(List<Movimiento> movimientos) { // WMC = 2, CCog = 1
		double r = 0.0;
		for (int i = 0; i < movimientos.size(); i++) { // WMC + 1, CCog + 1
			Movimiento m = (Movimiento) movimientos.get(i);
			r += m.getImporte();
		}
		return r;
	}
}