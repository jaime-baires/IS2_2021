package es.unican.is2.seguros.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class SeguroTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void PrecioTest() {
		Seguro sut;
		Cliente minusvalidoTrue = new Cliente(null, null, true);
		Cliente minusvalidoFalse = new Cliente(null, null, false);
		LocalDate fecha;
		
		/*
		 * CASOS VÁLIDOS
		    -	Fecha = Actual; Potencia = 0; Cobertura = TERCEROS; Minusvalía = Verdadero; Resultado esperado = 450
			-	Fecha = Actual – 3 meses; Potencia = 45; Cobertura=TODORIESGO; Minusvalía=falso; Resultado esperado = 1200
			-	Fecha = Actual – 364 días; Potencia = 89; Cobertura = TERCEROSLUNA; Minusvalía=falso; Resultado esperado = 800
			-	Fecha = Actual – 1 año; Potencia = 90; Cobertura = TERCEROS; Minusvalía=falso; Resultado esperado = 470
			-	Fecha = Actual – 2 años; Potencia = 100; Cobertura = TODORIESGO; Minusvalía = verdadero; Resultado esperado = 825
			-	Fecha = Actual – 2 años y 364 días; Potencia = 110; Cobertura = TODORIESGO; Minusvalía = verdadero; Resultado esperado = 825
			-	Fecha = Actual – 3 años; Potencia = 111; Cobertura = TERCEROS; Minusvalía = verdadero; Resultado esperado = 360
			-	Fecha = Actual – 4 años; Potencia = 200; Cobertura=TERCEROSLUNA; Minusvalía= verdadero; Resultado esperado = 540
		 * */

		try {
			fecha = LocalDate.now();
			sut = new Seguro(0, Cobertura.TERCEROS, minusvalidoTrue, fecha);
			assertTrue(sut.precio()==450);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusMonths(3);
			sut = new Seguro(45, Cobertura.TODORIESGO, minusvalidoFalse, fecha);
			assertTrue(sut.precio()==1200);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusDays(364);
			sut = new Seguro(89, Cobertura.TERCEROSLUNAS, minusvalidoFalse, fecha);
			assertTrue(sut.precio()==800);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusYears(1);
			sut = new Seguro(90, Cobertura.TERCEROS, minusvalidoFalse, fecha);
			assertTrue(sut.precio()==470);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusYears(2);
			sut = new Seguro(100, Cobertura.TODORIESGO, minusvalidoTrue, fecha);
			assertTrue(sut.precio()==825);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusYears(2).minusDays(364);
			sut = new Seguro(110, Cobertura.TODORIESGO, minusvalidoTrue, fecha);
			assertTrue(sut.precio()==825);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusYears(3);
			sut = new Seguro(111, Cobertura.TERCEROS, minusvalidoTrue, fecha);
			assertTrue(sut.precio()==360);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		try {
			fecha = LocalDate.now().minusYears(4);
			sut = new Seguro(200, Cobertura.TERCEROSLUNAS, minusvalidoTrue, fecha);
			assertTrue(sut.precio()==540);
		} catch (DatoIncorrectoException e) {
			fail();
		}
		
		
		/*
		 * CASOS NO VÁLIDOS
		    -	Fecha= Actual +1 día; Potencia=0; Cobertura=TODORIESGO; Minusvalía=falso; Resultado esperado = DatoIncorrectoException
			-	Fecha = Actual +1 año; Potencia = 45; Cobertura= TERCEROS; Minusvalía=verdadero; Resultado esperado = DatoIncorrectoException
			-	Fecha = Null; Potencia = 45; Cobertura= TODORIESGO; Minusvalía = verdadero; Resultado esperado = DatoIncorrectoException
			-	Fecha = Actual; Potencia = -1; Cobertura = TERCEROS; Minusvalía = falso; Resultado esperado = DatoIncorrectoException
			-	Fecha = Actual; Potencia = -30; Cobertura = TERCEROS; Minusvalía = falso; Resultado esperado = DatoIncorrectoException
			-	Fecha = Actual; Potencia = 45; Cobertura = Null; Minusvalía = falso; Resultado esperado = DatoIncorrectoException
		 * */
		
		try {
			fecha = LocalDate.now().plusDays(1);
			sut = new Seguro(0, Cobertura.TODORIESGO, minusvalidoFalse, fecha);
			sut.precio();
			fail();
		} catch (DatoIncorrectoException e) {}
		
		try {
			fecha = LocalDate.now().plusYears(1);
			sut = new Seguro(45, Cobertura.TERCEROS, minusvalidoTrue, fecha);
			sut.precio();
			fail();
		} catch (DatoIncorrectoException e) {}
		
		try {
			fecha = null;
			sut = new Seguro(45, Cobertura.TODORIESGO, minusvalidoTrue, fecha);
			sut.precio();
			fail();
		} catch (DatoIncorrectoException e) {}
		
		try {
			fecha = LocalDate.now();
			sut = new Seguro(-1, Cobertura.TERCEROS, minusvalidoFalse, fecha);
			sut.precio();
			fail();
		} catch (DatoIncorrectoException e) {}
		
		try {
			fecha = LocalDate.now();
			sut = new Seguro(-30, Cobertura.TERCEROS, minusvalidoFalse, fecha);
			sut.precio();
			fail();
		} catch (DatoIncorrectoException e) {}
		
		try {
			fecha = LocalDate.now();
			sut = new Seguro(45, null, minusvalidoFalse, fecha);
			sut.precio();
			fail();
		} catch (DatoIncorrectoException e) {}
		
	}

}
