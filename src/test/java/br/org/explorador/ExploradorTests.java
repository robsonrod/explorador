package br.org.explorador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExploradorTests {

    @Test
    public void testExploradorComUmaSondaPontoCardealErrado() {
        Explorador explorador = new Explorador("src/test/resources/entrada_sonda_invalida.txt");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, explorador::exploraPlanaltoMarciano);
        Assertions.assertEquals("Ponto cardeal invalido, somente pontos cardeais em ingles sao aceitos.", exception.getMessage());
    }

    @Test
    public void testExploradorComUmaSonda() {
        Explorador explorador = new Explorador("src/test/resources/entrada_uma_sonda.txt");
        explorador.exploraPlanaltoMarciano();
        Assertions.assertEquals(1, explorador.getSondas().size());

        Sonda sonda = explorador.getSondas().get(0);
        Assertions.assertEquals(PontoCardeal.N, sonda.getPosicao().getDirecao());
        Assertions.assertEquals(1, sonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(3, sonda.getPosicao().getCoordenadaY());
    }

    @Test
    public void testExploradorComDuasSondas() {
        Explorador explorador = new Explorador("src/test/resources/entrada_duas_sondas.txt");
        explorador.exploraPlanaltoMarciano();
        Assertions.assertEquals(2, explorador.getSondas().size());

        Sonda primeiraSonda = explorador.getSondas().get(0);
        Assertions.assertEquals(PontoCardeal.N, primeiraSonda.getPosicao().getDirecao());
        Assertions.assertEquals(1, primeiraSonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(3, primeiraSonda.getPosicao().getCoordenadaY());

        Sonda segundaSonda = explorador.getSondas().get(1);
        Assertions.assertEquals(PontoCardeal.E, segundaSonda.getPosicao().getDirecao());
        Assertions.assertEquals(5, segundaSonda.getPosicao().getCoordenadaX());
        Assertions.assertEquals(1, segundaSonda.getPosicao().getCoordenadaY());
    }
}
