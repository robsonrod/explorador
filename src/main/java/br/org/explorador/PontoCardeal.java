package br.org.explorador;

public enum PontoCardeal {

    N("Norte") {
        PontoCardeal virarDireita() {
            return E;
        }

        PontoCardeal virarEsquerda() {
            return W;
        }
    },
    S("Sul") {
        @Override
        PontoCardeal virarDireita() {
            return W;
        }

        @Override
        PontoCardeal virarEsquerda() {
            return E;
        }
    },
    E("Leste") {
        @Override
        PontoCardeal virarDireita() {
            return S;
        }

        @Override
        PontoCardeal virarEsquerda() {
            return N;
        }
    },
    W("Oeste") {
        @Override
        PontoCardeal virarDireita() {
            return N;
        }

        @Override
        PontoCardeal virarEsquerda() {
            return S;
        }
    };

    private final String nome;

    PontoCardeal(String nome) {
        this.nome = nome;
    }

    abstract PontoCardeal virarDireita();

    abstract PontoCardeal virarEsquerda();
}
