package br.com.jogo.excecoes;

public class PosicaoDeCartaInvalidaException extends Exception {
	public PosicaoDeCartaInvalidaException() {
		super("Posição de carta inválida!");
	}

	public PosicaoDeCartaInvalidaException(String message) {
		super(message);
	}
}