package es.unican.is2.containers;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ListaOrdenadaTest {

	ListaOrdenada<Integer> sut;

	@Before
	public void setUp() throws Exception {
		sut = new ListaOrdenada<Integer>();
	}

	@Test
	public void GetTest() {
		//indice no valido
		sut.add(1);
		sut.add(2);
		sut.add(3);
		try {
			sut.get(-6);
			fail();
		} catch (Exception e) {

		}
		try {
			sut.get(6);
			fail();
		} catch (Exception e) {

		}
		//indice en lista con elementos
		//indice valido en lista con elementos(remove)
		sut.remove(2);
		assertTrue(sut.size()==2);

		assertTrue(sut.get(1)==2);

		//lista no vacia(clear)
		sut.clear();
		assertTrue(sut.size()==0);
		//lista vacia (clear)
		sut.clear();
		//lista vacia(size)
		assertTrue(sut.size()==0);

		//lista sin elementos
		try {
			sut.get(1);
			fail();
		} catch (Exception e) {
			// TODO: handle exception
		}



	}

	@Test
	public void AddTest() {
		//anhadir en lista vacia
		//lista con un elemento(get)
		sut.add(1);
		assertTrue(sut.get(0)==1);
		assertTrue(sut.size()==1);
		//anhadir en lista con un elemento
		//lista no vacia(size)
		sut.add(2);
		assertTrue(sut.get(1)==2);
		assertTrue(sut.size()==2);
		//anhadir a lista con elementos
		//lista con elementos(get)
		sut.add(3);
		assertTrue(sut.get(2)==3);
		assertTrue(sut.size()==3);
		
		//Anhade elemento en medio de la lista
		sut.clear();
		sut.add(1);
		sut.add(3);
		sut.add(2);
		assertTrue(sut.get(1)==2);
		assertTrue(sut.size()==3);
	}

	@Test
	public void RemoveTest() {
		//indice en lista con un elemento
		sut.add(2);
		sut.remove(0);
		assertTrue(sut.size()==0);
		//indice en lista sin elementos
		try {
			sut.remove(1);
			fail();
		}
		catch(Exception e) {

		}
		//indice no valido
		sut.add(1);
		sut.add(2);
		sut.add(3);
		try {
			sut.remove(-6);
			fail();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			sut.remove(6);
			fail();
		} catch (Exception e) {

		}

	}

	

}
