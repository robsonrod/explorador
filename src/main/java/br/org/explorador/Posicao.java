package br.org.explorador;

public class Posicao {

    private final int coordenadaX;
    private final int coordenadaY;
    private PontoCardeal pontoCardeal;

    public Posicao(int coordenadaX, int coordenadaY, PontoCardeal pontoCardeal) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.pontoCardeal = pontoCardeal;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public PontoCardeal getDirecao() {
        return pontoCardeal;
    }

    public void novaDirecao(Direcao direcaoDoGiro) {
        if (direcaoDoGiro == Direcao.R) {
            this.pontoCardeal = this.pontoCardeal.virarDireita();
            return;
        }
        this.pontoCardeal = this.pontoCardeal.virarEsquerda();
    }
}
