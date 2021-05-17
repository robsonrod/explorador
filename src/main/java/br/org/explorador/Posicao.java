package br.org.explorador;

public class Posicao {

    private final int coordenadaX;
    private final int coordenadaY;
    private String direcao;

    public Posicao(int coordenadaX, int coordenadaY, String direcao) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.direcao = direcao;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public String getDirecao() {
        return direcao;
    }

    public void novaDirecao(String direcaoDoGiro) {
        this.direcao = direcaoDoGiro;
    }
}
