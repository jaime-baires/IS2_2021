package es.unican.is2.seguros.model;

import org.junit.Before;
import org.junit.Test;

public class SeguroTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		/*
		 * - Fecha = Actual; Potencia = 0; Cobertura = TERCEROS; Minusvalía = Verdadero
		 * - Fecha = Actual – 3 meses; Potencia = 45; Cobertura=TODORIESGO;
		 * minusvalía=falso - Fecha = Actual – 364 días; Potencia = 89; Cobertura =
		 * TERCEROSLUNA; minusvalía=falso - Fecha = Actual – 1 año; Potencia = 90;
		 * Cobertura = TERCEROS; minusvalía=falso - Fecha = Actual – 2 años; Potencia =
		 * 100; Cobertura = TODORIESGO; minusvalía = verdadero - Fecha = Actual – 2 años
		 * y 364 días; Potencia = 110; Cobertura = TODORIESGO; minusvalía = verdadero -
		 * Fecha = Actual – 3 años; Potencia = 111; Cobertura = TERCEROS; minusvalía =
		 * verdadero - Fecha = Actual – 4 años; Potencia = 200; Cobertura=TERCEROSLUNA;
		 * minusvalía= verdadero
		 */
		Cliente verd = new Cliente(null, null, true);
		Cliente falso = new Cliente(null, null, false);
		Seguro sut1 = new Seguro(0, Cobertura.TERCEROS, verd);
	}

}
