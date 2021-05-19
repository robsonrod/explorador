package br.org.explorador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilArquivo {

    private final List<String> linhasArquivo;

    public UtilArquivo(String nomeArquivoEntrada) {
        linhasArquivo = leLinhasArquivo(nomeArquivoEntrada);
    }

    private List<String> leLinhasArquivo(String nomeArquivoEntrada) {
        try (Stream<String> stream = Files.lines(Paths.get(nomeArquivoEntrada))) {
            return stream.map(String::toUpperCase).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void lePosicaoSonda() {
        Iterator<String> iterator = linhasArquivo.iterator();
        Integer[] dimensaoPlanalto = Arrays.stream(iterator.next().split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(dimensaoPlanalto[0]);
        System.out.println(dimensaoPlanalto[1]);
        while (iterator.hasNext()) {
            String posicaoSonda[] = iterator.next().split("\\s");
            String comandos[] = iterator.next().split("{1}");
        }
    }
}
