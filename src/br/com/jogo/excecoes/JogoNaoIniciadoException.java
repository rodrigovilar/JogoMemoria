package br.com.jogo.excecoes;

public class JogoNaoIniciadoException extends Exception {
	public JogoNaoIniciadoException() {
		super("Jogo não iniciado!");
	}

	public JogoNaoIniciadoException(String message) {
		super(message);
	}
}