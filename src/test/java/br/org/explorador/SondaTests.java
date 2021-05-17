package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SondaTests {

	@Test
	public void testSondaNoPontoInicialGirarDireita() {
		Sonda sonda = new Sonda(new Coordenada(0,0), "N");
		sonda.girar("R");
		Assertions.assertEquals("R", sonda.getDirecao());
	}

	@Test
	public void testSondaNoPontoInicialGirarEsquerda() {
		Sonda sonda = new Sonda(new Coordenada(0,0),"N");
		sonda.girar("L");
		Assertions.assertEquals("L", sonda.getDirecao());
	}

	@Test
	public void testSondaNoPontoInicialInformandoDirecaoGiroErrada() {
		Sonda sonda = new Sonda(new Coordenada(0,0),"N");
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sonda.girar("D"));
		Assertions.assertEquals("Direcao invalida", exception.getMessage());
	}

	@Test
	public void testSondaNoPontoInicialMovendoUmaVezFrenteSemAlterarDirecao() {
		Sonda sonda = new Sonda(new Coordenada(0,0),"N");
		sonda.mover();
		Assertions.assertEquals("N", sonda.getDirecao());

		int posicaoEsperadaParaX = 0;
		int posicaoEsperadaParaY = 1;

		Assertions.assertEquals(posicaoEsperadaParaX, sonda.getCoordenada().getX());
		Assertions.assertEquals(posicaoEsperadaParaY, sonda.getCoordenada().getY());
	}

}
