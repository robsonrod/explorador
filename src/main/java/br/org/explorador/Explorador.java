package br.org.explorador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Explorador {

    private final List<String> linhasArquivo;
    private List<Sonda> sondas;

    public Explorador(String nomeArquivoEntrada) {
        linhasArquivo = leLinhasArquivo(nomeArquivoEntrada);
        sondas = new ArrayList<>();
    }

    private List<String> leLinhasArquivo(String nomeArquivoEntrada) {
        try (Stream<String> stream = Files.lines(Paths.get(nomeArquivoEntrada))) {
            return stream.map(String::toUpperCase).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sonda> getSondas() {
        return sondas;
    }

    public void exploraPlanaltoMarciano() {
        Iterator<String> iteradorDeLinhas = linhasArquivo.iterator();

        String[] dimensaoPlanalto = iteradorDeLinhas.next().split("\\s");
        int larguraPlanalto = Integer.parseInt(dimensaoPlanalto[0]);
        int alturaPlanalto = Integer.parseInt(dimensaoPlanalto[1]);
        Planalto planalto = new Planalto(alturaPlanalto, larguraPlanalto);

        while (iteradorDeLinhas.hasNext()) {
            String posicaoSonda[] = iteradorDeLinhas.next().split("\\s");
            int coordenadaInicialX = Integer.parseInt(posicaoSonda[0]);
            int coordenadaInicialY = Integer.parseInt(posicaoSonda[1]);

            Posicao posicao = new Posicao(coordenadaInicialX, coordenadaInicialY, PontoCardeal.converte(posicaoSonda[2]));
            String comandos[] = iteradorDeLinhas.next().split("{1}");

            Sonda sonda = new Sonda(posicao, planalto);
            sonda.recebeComandos(comandos);
            sonda.executaComandos();

            sondas.add(sonda);
        }
    }
}
