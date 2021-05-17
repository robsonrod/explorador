package br.org.explorador;

public class Sonda {

    private Posicao posicao;
    private final Planalto planalto;

    public Sonda(Posicao posicao, Planalto planalto) {
        this.posicao = posicao;
        this.planalto = planalto;
    }

    public void girar(String direcaoDoGiro) {
        boolean direcoesValidas = direcaoDoGiro.equalsIgnoreCase("L") ||
                direcaoDoGiro.equalsIgnoreCase("R");

        if (!direcoesValidas) {
            throw new IllegalArgumentException("Direcao invalida");
        }

        this.posicao.novaDirecao(direcaoDoGiro);
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void mover() {
        if (this.posicao.getCoordenadaY() >= this.planalto.getAltura()) {
            throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
        }

        this.posicao = new Posicao(this.posicao.getCoordenadaX(), posicao.getCoordenadaY() + 1, this.posicao.getDirecao());
    }
}
