package br.org.explorador;

public class Sonda {

    private final Planalto planalto;
    private final Posicao posicaoInicial;
    private Posicao posicaoCorrente;
    private String[] comandos;

    public Sonda(Posicao posicao, Planalto planalto) {
        this.posicaoInicial = new Posicao(posicao.getCoordenadaX(), posicao.getCoordenadaY(), posicao.getDirecao());
        this.posicaoCorrente = posicao;
        this.planalto = planalto;
    }

    public void girar(String direcao) {
        Direcao direcaoDoGiro = Direcao.converte(direcao);
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
            this.posicaoCorrente.moverDirecaoNorte();

        } else if (posicaoCorrente.getDirecao() == PontoCardeal.S) {
            if (this.posicaoCorrente.getCoordenadaY() <= 0) {
                this.posicaoCorrente = this.posicaoInicial;
                throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
            }

            this.posicaoCorrente.moverDirecaoSul();

        } else if (posicaoCorrente.getDirecao() == PontoCardeal.E) {

            if (this.posicaoCorrente.getCoordenadaX() >= this.planalto.getLargura()) {
                this.posicaoCorrente = this.posicaoInicial;
                throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
            }
            this.posicaoCorrente.moverDirecaoLeste();
        } else {
            if (this.posicaoCorrente.getCoordenadaX() <= 0) {
                this.posicaoCorrente = this.posicaoInicial;
                throw new IllegalStateException("Sonda em estado invalido. Tentativa de acessar um local inacessivel.");
            }
            this.posicaoCorrente.moverDirecaoOeste();
        }
    }

    public void recebeComandos(String[] comandos) {
        this.comandos = comandos;
    }

    public void executaComandos() {
        for (String comando : this.comandos) {
            if (comando.equalsIgnoreCase("M")) {
                mover();
            } else {
                girar(comando);
            }
        }
    }
}
