package br.org.explorador;

public class Sonda {

    private final Planalto planalto;
    private final Posicao posicaoInicial;
    private Posicao posicaoCorrente;

    public Sonda(Posicao posicao, Planalto planalto) {
        this.posicaoInicial = posicao;
        this.posicaoCorrente = posicao;
        this.planalto = planalto;
    }

    public void girar(String direcaoDoGiro) {
        boolean direcoesValidas = direcaoDoGiro.equalsIgnoreCase("L") ||
                direcaoDoGiro.equalsIgnoreCase("R");

        if (!direcoesValidas) {
            throw new IllegalArgumentException("Direcao invalida, somente L e R sao aceitos como direcao.");
        }

        this.posicaoCorrente.novaDirecao(direcaoDoGiro);
    }

    public Posicao getPosicao() {
        return posicaoCorrente;
    }

    public void mover() {

        if (posicaoCorrente.getDirecao() == PontoCardeal.N) {
            if (this.posicaoCorrente.getCoordenadaY() >= this.planalto.getAltura()) {
                this.posicaoCorrente = this.posicaoInicial;
                throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
            }

            this.posicaoCorrente = new Posicao(this.posicaoCorrente.getCoordenadaX(), posicaoCorrente.getCoordenadaY() + 1, this.posicaoCorrente.getDirecao());
        } else if (posicaoCorrente.getDirecao() == PontoCardeal.S) {
            if (this.posicaoCorrente.getCoordenadaY() <= 0) {
                this.posicaoCorrente = this.posicaoInicial;
                throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
            }
            this.posicaoCorrente = new Posicao(this.posicaoCorrente.getCoordenadaX(), posicaoCorrente.getCoordenadaY() - 1, this.posicaoCorrente.getDirecao());
        } else if (posicaoCorrente.getDirecao() == PontoCardeal.E) {
            this.posicaoCorrente = new Posicao(this.posicaoCorrente.getCoordenadaX() + 1, posicaoCorrente.getCoordenadaY(), this.posicaoCorrente.getDirecao());
        } else {
            this.posicaoCorrente = new Posicao(this.posicaoCorrente.getCoordenadaX() - 1, posicaoCorrente.getCoordenadaY(), this.posicaoCorrente.getDirecao());
        }
    }
}
