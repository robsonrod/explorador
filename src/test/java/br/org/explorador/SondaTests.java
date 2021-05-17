package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SondaTests {

    @Test
    public void testSondaNoPontoInicialGirarDireita() {
        Sonda sonda = new Sonda(new Posicao(0, 0, "N"), new Planalto(2, 2));
        sonda.girar("R");
        Assertions.assertEquals("R", sonda.getPosicao().getDirecao());
    }

    @Test
    public void testSondaNoPontoInicialGirarEsquerda() {
        Sonda sonda = new Sonda(new Posicao(0, 0, "N"), new Planalto(2, 2));
        sonda.girar("L");
        Assertions.assertEquals("L", sonda.getPosicao().getDirecao());
    }

    @Test
    public void testSondaNoPontoInicialInformandoDirecaoGiroErrada() {
        Sonda sonda = new Sonda(new Posicao(0, 0, "N"), new Planalto(2, 2));
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sonda.girar("D"));
        Assertions.assertEquals("Direcao invalida, somente L e R sao aceitos como direcao.", exception.getMessage());
    }

    @Test
    public void testSondaNoPontoInicialMovendoUmaVezFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(0, 0, "N"), new Planalto(2, 2));
        sonda.mover();
        Assertions.assertEquals("N", sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 0;
        int posicaoEsperadaParaY = 1;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialMovendoDuasVezesFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(0, 0, "N"), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Assertions.assertEquals("N", sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 0;
        int posicaoEsperadaParaY = 2;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialMovendoFrenteSaindoAreaCoberturaERetornandoAoPontoInicial() {
        Sonda sonda = new Sonda(new Posicao(0, 0, "N"), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Exception exception = Assertions.assertThrows(IllegalStateException.class, sonda::mover);
        Assertions.assertEquals("Sonda em estado invalido. Tentativa de acessar um local inacessivel.", exception.getMessage());
        Assertions.assertEquals(0, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(0, sonda.getPosicao().getCoordenadaY());
    }
}
