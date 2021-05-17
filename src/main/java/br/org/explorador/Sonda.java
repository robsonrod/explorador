package br.org.explorador;

public class Sonda {

	private Coordenada coordenada;
	private String direcao;

	public Sonda(Coordenada coordenada, String direcao) {
		this.coordenada = coordenada;
		this.direcao = direcao;
	}

	public String getDirecao() {
		return direcao;
	}

	public void mover(String novaDirecao) {
		boolean direcoesValidas = novaDirecao.equalsIgnoreCase("L") || novaDirecao.equalsIgnoreCase("R");
		if (!direcoesValidas) {
			throw new IllegalArgumentException("Direcao invalida");
		}
		this.direcao = novaDirecao;
	}
}
