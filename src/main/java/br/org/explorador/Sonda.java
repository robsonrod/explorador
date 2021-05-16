package br.org.explorador;

public class Sonda {

	private int posicaoX;
	private int posicaoY;
	private String direcao;

	public Sonda(int posicaoX, int posicaoY, String direcao) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.direcao = direcao;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
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
