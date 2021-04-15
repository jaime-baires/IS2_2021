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
		 * - Fecha = Actual; Potencia = 0; Cobertura = TERCEROS; Minusval�a = Verdadero
		 * - Fecha = Actual � 3 meses; Potencia = 45; Cobertura=TODORIESGO;
		 * minusval�a=falso - Fecha = Actual � 364 d�as; Potencia = 89; Cobertura =
		 * TERCEROSLUNA; minusval�a=falso - Fecha = Actual � 1 a�o; Potencia = 90;
		 * Cobertura = TERCEROS; minusval�a=falso - Fecha = Actual � 2 a�os; Potencia =
		 * 100; Cobertura = TODORIESGO; minusval�a = verdadero - Fecha = Actual � 2 a�os
		 * y 364 d�as; Potencia = 110; Cobertura = TODORIESGO; minusval�a = verdadero -
		 * Fecha = Actual � 3 a�os; Potencia = 111; Cobertura = TERCEROS; minusval�a =
		 * verdadero - Fecha = Actual � 4 a�os; Potencia = 200; Cobertura=TERCEROSLUNA;
		 * minusval�a= verdadero
		 */
		Cliente verd = new Cliente(null, null, true);
		Cliente falso = new Cliente(null, null, false);
		Seguro sut1 = new Seguro(0, Cobertura.TERCEROS, verd);
	}

}
