package br.org.explorador;

public class Sonda {

    private Coordenada posicao;
    private String direcao;
    private final Planalto planalto;

    public Sonda(Coordenada posicao, String direcao, Planalto planalto) {
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

    public Coordenada getPosicao() {
        return posicao;
    }

    public void mover() {
        if (this.posicao.getY() >= this.planalto.getAltura()) {
            throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
        }

        this.posicao = new Coordenada(this.posicao.getX(), posicao.getY() + 1);
    }
}
