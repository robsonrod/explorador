package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SondaTests {

	@Test
	public void testSondaNoPontoInicialVirarDireita() {
		Sonda sonda = new Sonda(0,0,"N");
		sonda.mover("R");
		Assertions.assertEquals("R", sonda.getDirecao());
	}
}
