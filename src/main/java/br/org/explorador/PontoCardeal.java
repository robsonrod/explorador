package br.org.explorador;

public enum PontoCardeal {
    N {
        PontoCardeal virarDireita() {
            return E;
        }

        PontoCardeal virarEsquerda() {
            return W;
        }
    },
    S {
        @Override
        PontoCardeal virarDireita() {
            return W;
        }

        @Override
        PontoCardeal virarEsquerda() {
            return E;
        }
    },
    E {
        @Override
        PontoCardeal virarDireita() {
            return S;
        }

        @Override
        PontoCardeal virarEsquerda() {
            return N;
        }
    },
    W {
        @Override
        PontoCardeal virarDireita() {
            return N;
        }

        @Override
        PontoCardeal virarEsquerda() {
            return S;
        }
    };

    abstract PontoCardeal virarDireita();

    abstract PontoCardeal virarEsquerda();
}
