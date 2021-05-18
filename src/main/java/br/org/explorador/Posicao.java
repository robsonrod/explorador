package br.org.explorador;

public class Posicao {

    private static final int VALOR_DO_DESLOCAMENTO = 1;

    private int coordenadaX;
    private int coordenadaY;
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

    public void moverDirecaoNorte() {
        this.coordenadaY += VALOR_DO_DESLOCAMENTO;
    }

    public void moverDirecaoSul() {
        this.coordenadaY -= VALOR_DO_DESLOCAMENTO;
    }

    public void moverDirecaoLeste() {
        this.coordenadaX += VALOR_DO_DESLOCAMENTO;
    }

    public void moverDirecaoOeste() {
        this.coordenadaX -= VALOR_DO_DESLOCAMENTO;
    }
}
