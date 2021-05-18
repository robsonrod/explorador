package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SondaTests {

    @Test
    public void testSondaNoPontoInicialGirarDireita() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.N), new Planalto(2, 2));
        sonda.girar("R");
        Assertions.assertEquals(PontoCardeal.E, sonda.getPosicao().getDirecao());
    }

    @Test
    public void testSondaNoPontoInicialGirarEsquerda() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.N), new Planalto(2, 2));
        sonda.girar("L");
        Assertions.assertEquals(PontoCardeal.W, sonda.getPosicao().getDirecao());
    }

    @Test
    public void testSondaNoPontoInicialInformandoDirecaoGiroErrada() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.N), new Planalto(2, 2));
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sonda.girar("D"));
        Assertions.assertEquals("Direcao invalida, somente L e R sao aceitos como direcao.", exception.getMessage());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoNorteMovendoUmaVezFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.N), new Planalto(2, 2));
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.N, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 0;
        int posicaoEsperadaParaY = 1;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoNorteMovendoDuasVezesFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.N), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.N, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 0;
        int posicaoEsperadaParaY = 2;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoNorteMovendoFrenteSaindoAreaCoberturaERetornandoAoPontoInicial() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.N), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Exception exception = Assertions.assertThrows(IllegalStateException.class, sonda::mover);
        Assertions.assertEquals("Sonda em estado invalido. Tentativa de acessar um local inacessivel.", exception.getMessage());
        Assertions.assertEquals(0, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(0, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoSulMovendoUmaVezFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(2, 2, PontoCardeal.S), new Planalto(2, 2));
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.S, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 2;
        int posicaoEsperadaParaY = 1;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoSulMovendoDuasVezesFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(2, 2, PontoCardeal.S), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.S, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 2;
        int posicaoEsperadaParaY = 0;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoSulMovendoFrenteComAreaCoberturaNegativa() {
        Sonda sonda = new Sonda(new Posicao(2, 2, PontoCardeal.S), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Exception exception = Assertions.assertThrows(IllegalStateException.class, sonda::mover);
        Assertions.assertEquals("Sonda em estado invalido. Tentativa de acessar um local inacessivel.", exception.getMessage());
        Assertions.assertEquals(2, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(2, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoLesteMovendoUmaVezFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.E), new Planalto(2, 2));
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.E, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 1;
        int posicaoEsperadaParaY = 0;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoLesteMovendoDuasVezesFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.E), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.E, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 2;
        int posicaoEsperadaParaY = 0;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoLesteMovendoFrenteSaindoAreaCoberturaERetornandoAoPontoInicial() {
        Sonda sonda = new Sonda(new Posicao(0, 0, PontoCardeal.E), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Exception exception = Assertions.assertThrows(IllegalStateException.class, sonda::mover);
        Assertions.assertEquals("Sonda em estado invalido. Tentativa de acessar um local inacessivel.", exception.getMessage());

        int posicaoEsperadaParaX = 0;
        int posicaoEsperadaParaY = 0;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());

    }

    @Test
    public void testSondaNoPontoInicialDirecaoOesteMovendoUmaVezFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(2, 2, PontoCardeal.W), new Planalto(2, 2));
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.W, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 1;
        int posicaoEsperadaParaY = 2;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoOesteMovendoDuasVezesFrenteSemAlterarDirecao() {
        Sonda sonda = new Sonda(new Posicao(2, 2, PontoCardeal.W), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Assertions.assertEquals(PontoCardeal.W, sonda.getPosicao().getDirecao());

        int posicaoEsperadaParaX = 0;
        int posicaoEsperadaParaY = 2;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaNoPontoInicialDirecaoOesteMovendoFrenteSaindoAreaCoberturaERetornandoAoPontoInicial() {
        Sonda sonda = new Sonda(new Posicao(2, 2, PontoCardeal.W), new Planalto(2, 2));
        sonda.mover();
        sonda.mover();
        Exception exception = Assertions.assertThrows(IllegalStateException.class, sonda::mover);
        Assertions.assertEquals("Sonda em estado invalido. Tentativa de acessar um local inacessivel.", exception.getMessage());

        int posicaoEsperadaParaX = 2;
        int posicaoEsperadaParaY = 2;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testSondaExecutandoUmConjuntoDeComandos() {
        Sonda sonda = new Sonda(new Posicao(1, 2, PontoCardeal.N), new Planalto(3, 3));
        sonda.recebeComandos(new String[] {"L", "M", "L", "M", "L", "M", "L", "M", "M"});
        sonda.executarComandos();

        int posicaoEsperadaParaX = 1;
        int posicaoEsperadaParaY = 3;

        Assertions.assertEquals(posicaoEsperadaParaX, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(posicaoEsperadaParaY, sonda.getPosicao().getCoordenadaY());
        Assertions.assertEquals(PontoCardeal.N, sonda.getPosicao().getDirecao());
    }
}
