package br.com.jogo.excecoes;

public class JogadorInvalidoException extends Exception {

	String erro;

	public JogadorInvalidoException() {
		super();
		erro = "unknown";
	}

	public JogadorInvalidoException(String err) {
		super(err);
		erro = err;
	}

	public String getError() {
		return erro;
	}
}
