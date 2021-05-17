package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PontoCardealTests {

    @Test
    public void testMovimentosDoPontoInicialNorte() {
        Assertions.assertEquals(PontoCardeal.E, PontoCardeal.N.virarDireita());
        Assertions.assertEquals(PontoCardeal.W, PontoCardeal.N.virarEsquerda());
    }

    @Test
    public void testMovimentosDoPontoInicialSul() {
        Assertions.assertEquals(PontoCardeal.W, PontoCardeal.S.virarDireita());
        Assertions.assertEquals(PontoCardeal.E, PontoCardeal.S.virarEsquerda());
    }

    @Test
    public void testMovimentosDoPontoInicialLeste() {
        Assertions.assertEquals(PontoCardeal.S, PontoCardeal.E.virarDireita());
        Assertions.assertEquals(PontoCardeal.N, PontoCardeal.E.virarEsquerda());
    }

    @Test
    public void testMovimentosDoPontoInicialOeste() {
        Assertions.assertEquals(PontoCardeal.N, PontoCardeal.W.virarDireita());
        Assertions.assertEquals(PontoCardeal.S, PontoCardeal.W.virarEsquerda());
    }

}
