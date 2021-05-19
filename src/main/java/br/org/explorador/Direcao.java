package br.org.explorador;

public enum Direcao {

    R("Direita"),
    L("Esquerda");

    private final String descricao;

    Direcao(String descricao) {
        this.descricao = descricao;
    }

    public static Direcao converte(String direcaoDoGiro) {
        for (Direcao direcao : Direcao.values()) {
            if (direcao.name().equalsIgnoreCase(direcaoDoGiro)) {
                return direcao;
            }
        }
        throw new IllegalArgumentException("Direcao invalida, somente L e R sao aceitos como direcao.");
    }
}
