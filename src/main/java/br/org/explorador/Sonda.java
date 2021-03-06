package br.org.explorador;

import java.util.ArrayList;
import  java.util.List;

public class Sonda {

    private final Planalto planalto;
    private final Posicao posicaoInicial;
    private Posicao posicaoCorrente;
    private String[] comandos;
    private List<Posicao> posicoesComBandeira;

    public Sonda(Posicao posicao, Planalto planalto) {
        this.posicaoInicial = new Posicao(posicao.getCoordenadaX(), posicao.getCoordenadaY(), posicao.getDirecao());
        this.posicaoCorrente = posicao;
        this.planalto = planalto;
        this.posicoesComBandeira = new ArrayList<>();
    }

    public void girar(String direcao) {
        Direcao direcaoDoGiro = Direcao.converte(direcao);
        this.posicaoCorrente.novaDirecao(direcaoDoGiro);
    }

    public Posicao getPosicao() {
        return posicaoCorrente;
    }

    public void mover() {

        switch (posicaoCorrente.getDirecao()) {
            case N:
                validaSondaChegouLimiteAreaExploracao(this.posicaoCorrente.getCoordenadaY() >= this.planalto.getAltura());
                this.posicaoCorrente.moverDirecaoNorte();
                break;
            case S:
                validaSondaChegouLimiteAreaExploracao(this.posicaoCorrente.getCoordenadaY() <= 0);
                this.posicaoCorrente.moverDirecaoSul();
                break;
            case E:
                validaSondaChegouLimiteAreaExploracao(this.posicaoCorrente.getCoordenadaX() >= this.planalto.getLargura());
                this.posicaoCorrente.moverDirecaoLeste();
                break;
            case W:
                validaSondaChegouLimiteAreaExploracao(this.posicaoCorrente.getCoordenadaX() <= 0);
                this.posicaoCorrente.moverDirecaoOeste();
                break;
        }
    }

    private void validaSondaChegouLimiteAreaExploracao(boolean limiteAtingido) {
        if (limiteAtingido) {
            this.posicaoCorrente = this.posicaoInicial;
            throw new IllegalStateException("Sonda em estado inválido. Tentativa de acessar um local inacessível.");
        }
    }

    public void recebeComandos(String[] comandos) {
        this.comandos = comandos;
    }

    public void executaComandos() {
        for (String comando : this.comandos) {
            if (comando.equalsIgnoreCase("M")) {
                mover();
            } else if (comando.equalsIgnoreCase("F")) {
                fixarBandeira();
            } else {
                girar(comando);

            }
        }
    }

    public void fixarBandeira() {
        this.posicoesComBandeira.add(new Posicao(this.getPosicao().getCoordenadaX(), this.getPosicao().getCoordenadaY(), this.getPosicao().getDirecao()));
    }

    public List<Posicao> getPosicoesComBandeira() {
        return this.posicoesComBandeira;
    }
}
