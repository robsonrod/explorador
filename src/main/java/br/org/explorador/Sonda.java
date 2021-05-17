package br.org.explorador;

public class Sonda {

    private Posicao posicaoInicial;
    private Posicao posicaoCorrente;
    private final Planalto planalto;

    public Sonda(Posicao posicao, Planalto planalto) {
        this.posicaoInicial = posicao;
        this.posicaoCorrente = posicao;
        this.planalto = planalto;
    }

    public void girar(String direcaoDoGiro) {
        boolean direcoesValidas = direcaoDoGiro.equalsIgnoreCase("L") ||
                direcaoDoGiro.equalsIgnoreCase("R");

        if (!direcoesValidas) {
            throw new IllegalArgumentException("Direcao invalida");
        }

        this.posicaoCorrente.novaDirecao(direcaoDoGiro);
    }

    public Posicao getPosicao() {
        return posicaoCorrente;
    }

    public void mover() {
        if (this.posicaoCorrente.getCoordenadaY() >= this.planalto.getAltura()) {
            this.posicaoCorrente = this.posicaoInicial;

            throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
        }

        this.posicaoCorrente = new Posicao(this.posicaoCorrente.getCoordenadaX(), posicaoCorrente.getCoordenadaY() + 1, this.posicaoCorrente.getDirecao());
    }
}
