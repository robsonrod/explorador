package br.org.explorador;

public class Sonda {

    private Posicao posicao;
    private String direcao;
    private final Planalto planalto;

    public Sonda(Posicao posicao, String direcao, Planalto planalto) {
        this.posicao = posicao;
        this.direcao = direcao;
        this.planalto = planalto;
    }

    public String getDirecao() {
        return direcao;
    }

    public void girar(String direcaoDoGiro) {
        boolean direcoesValidas = direcaoDoGiro.equalsIgnoreCase("L") ||
                direcaoDoGiro.equalsIgnoreCase("R");

        if (!direcoesValidas) {
            throw new IllegalArgumentException("Direcao invalida");
        }

        this.direcao = direcaoDoGiro;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void mover() {
        if (this.posicao.getCoordenadaY() >= this.planalto.getAltura()) {
            throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
        }

        this.posicao = new Posicao(this.posicao.getCoordenadaX(), posicao.getCoordenadaY() + 1);
    }
}
