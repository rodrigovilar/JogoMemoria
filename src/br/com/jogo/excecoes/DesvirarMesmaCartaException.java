package br.com.jogo.excecoes;

public class DesvirarMesmaCartaException extends Exception {
	public DesvirarMesmaCartaException() {
		super("Você selecionou a mesma carta duas vezes!");
	}

	public DesvirarMesmaCartaException(String message) {
		super(message);
	}
}