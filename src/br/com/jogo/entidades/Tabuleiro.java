package br.com.jogo.entidades;

import br.com.jogo.excecoes.PosicaoDeCartaInvalidaException;

public class Tabuleiro {
	private Carta[][] tabuleiro;

	public Tabuleiro() {
		tabuleiro = new Carta[4][2];

		initTabuleiro();
	}

	private void initTabuleiro() {
		this.tabuleiro[0][0] = new Carta("Espada");
		this.tabuleiro[0][1] = new Carta("Copas");
		this.tabuleiro[1][0] = new Carta("Ouro");
		this.tabuleiro[1][1] = new Carta("Espada");
		this.tabuleiro[2][0] = new Carta("Paus");
		this.tabuleiro[2][1] = new Carta("Ouro");
		this.tabuleiro[3][0] = new Carta("Copas");
		this.tabuleiro[3][1] = new Carta("Paus");
	}

	public String getConteudoCarta(int i, int j)
			throws PosicaoDeCartaInvalidaException {
		if (i > 3 || i < 0 || j > 3 || j < 0)
			throw new PosicaoDeCartaInvalidaException(
					"Posição de carta fora dos limites do tabuleiro!");
		return tabuleiro[i][j].getHistoria();
	}

	public boolean cartaEstaVirada(int i, int j)
			throws PosicaoDeCartaInvalidaException {
		if (i > 3 || i < 0 || j > 3 || j < 0)
			throw new PosicaoDeCartaInvalidaException(
					"Posição de carta fora dos limites do tabuleiro!");
		return tabuleiro[i][j].isVirada();
	}

	public void desvira(int px, int py) {
		tabuleiro[px][py].setVirada(false);
	}
}