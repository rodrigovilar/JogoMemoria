package br.com.jogo.excecoes;

public class JogoNaoFoiFinalizadoException extends Exception {
	public JogoNaoFoiFinalizadoException() {
		super("Jogo não foi finalizado!");
	}

	public JogoNaoFoiFinalizadoException(String message) {
		super(message);
	}
}