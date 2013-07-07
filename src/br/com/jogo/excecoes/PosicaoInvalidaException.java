package br.com.jogo.excecoes;

public class PosicaoInvalidaException extends Exception {
	String erro;

	public PosicaoInvalidaException() {
		super();
		erro = "unknown";
	}

	public PosicaoInvalidaException(String err) {
		super(err);
		erro = err;
	}

	public String getError() {
		return erro;
	}

}
