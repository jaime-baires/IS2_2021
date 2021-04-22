package es.unican.is2.seguros.view;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SegurosFESTTest {

	private FrameFixture demo;
	
	@Before
	public void setUp() {
		SegurosGUI gui = new SegurosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void GUITest() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnCalcular").requireText("CALCULAR");
		
		/*
		 •	Fecha = 20/01/2000; Potencia = 60; Cobertura = TERCEROS; Minusvalía = Falso; Resultado esperado = 400
		 * */
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("20-02-2000");
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("60");
		demo.comboBox("comboCobertura").selectItem("TERCEROS");
		demo.radioButton("btnMinusvalia").uncheck();
		demo.button("btnCalcular").click();
		demo.textBox("txtPrecio").requireText("400.0");
		
	
		/*
		•	Fecha = 02/mm/2000; Potencia = 60; Cobertura = TERCEROS; Minusvalía = Falso; Resultado esperado = La fecha no se pudo parsear
		 * */
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("02-mm-2000");
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("60");
		demo.comboBox("comboCobertura").selectItem("TERCEROS");
		demo.radioButton("btnMinusvalia").uncheck();
		demo.button("btnCalcular").click();
		demo.textBox("txtPrecio").requireText("La fecha no se pudo parsear");
		
		/*
		•	Fecha = 20/02/2000; Potencia = 60a; Cobertura = TERCEROS; Minusvalía = Falso; Resultado esperado = Error, datos incorrectos
		 * */
		
		demo.textBox("txtFechaUltimoSiniestro").deleteText();
		demo.textBox("txtFechaUltimoSiniestro").enterText("20-02-2000");
		demo.textBox("txtPotencia").deleteText();
		demo.textBox("txtPotencia").enterText("60a");
		demo.comboBox("comboCobertura").selectItem("TERCEROS");
		demo.radioButton("btnMinusvalia").uncheck();
		demo.button("btnCalcular").click();
		demo.textBox("txtPrecio").requireText("¡Dato de entrada erróneo!");

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
