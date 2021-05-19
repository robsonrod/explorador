package br.org.explorador;

public class Planalto {

    private final int largura;
    private final int altura;

    public Planalto(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }
}
