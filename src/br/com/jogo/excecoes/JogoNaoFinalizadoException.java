package br.com.jogo.excecoes;

public class JogoNaoFinalizadoException extends Exception {

	String erro;

	public JogoNaoFinalizadoException() {
		super();
		erro = "unknown";
	}

	public JogoNaoFinalizadoException(String err) {
		super(err);
		erro = err;
	}

	public String getError() {
		return erro;
	}

}
