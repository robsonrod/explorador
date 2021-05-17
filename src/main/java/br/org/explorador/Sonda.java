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

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void girar(String direcaoDoGiro) {
		boolean direcoesValidas = direcaoDoGiro.equalsIgnoreCase("L") ||
				direcaoDoGiro.equalsIgnoreCase("R");

		if (!direcoesValidas) {
			throw new IllegalArgumentException("Direcao invalida");
		}

		this.direcao = direcaoDoGiro;
	}

	public void mover() {
		this.coordenada = new Coordenada(this.coordenada.getX(), coordenada.getY() + 1);
	}
}
