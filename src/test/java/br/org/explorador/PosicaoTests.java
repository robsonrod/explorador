package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosicaoTests {

    @Test
    public void testPosicaoPontoInicialNorteParaDireita() {
        Posicao posicao = new Posicao(0, 0, PontoCardeal.N);
        Assertions.assertEquals(posicao.getDirecao(), PontoCardeal.N);
        posicao.novaDirecao(Direcao.R);
        Assertions.assertEquals(PontoCardeal.E, posicao.getDirecao());
    }
}
