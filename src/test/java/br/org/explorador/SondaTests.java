package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SondaTests {

	@Test
	public void testSondaNoPontoInicialVirarDireita() {
		Sonda sonda = new Sonda(new Coordenada(0,0), "N");
		sonda.mover("R");
		Assertions.assertEquals("R", sonda.getDirecao());
	}

	@Test
	public void testSondaNoPontoInicialVirarEsquerda() {
		Sonda sonda = new Sonda(new Coordenada(0,0),"N");
		sonda.mover("L");
		Assertions.assertEquals("L", sonda.getDirecao());
	}

	@Test
	public void testSondaNoPontoInicialInformandoPosicaoErrada() {
		Sonda sonda = new Sonda(new Coordenada(0,0),"N");
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sonda.mover("D"));
		Assertions.assertEquals("Direcao invalida", exception.getMessage());
	}
}
