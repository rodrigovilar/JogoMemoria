package br.com.jogo.excecoes;

public class DesvirarCartaDuasVezesSeguidasException extends Exception {
	String erro;

	public DesvirarCartaDuasVezesSeguidasException() {
		super();
		erro = "unknown";
	}

	public DesvirarCartaDuasVezesSeguidasException(String err) {
		super(err);
		erro = err;
	}

	public String getError() {
		return erro;
	}
}
