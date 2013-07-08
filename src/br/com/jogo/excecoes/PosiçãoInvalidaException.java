package br.com.jogo.excecoes;

public class PosiçãoInvalidaException extends Exception {
	String erro;

	public PosiçãoInvalidaException() {
		super(); // chamar o construtor da superclasse
		erro = "unknown";
	}

	
	public PosiçãoInvalidaException(String err) {
		super(err); // chamar o construtor da superclasse
		erro = err; // salva messagem
	}

	public String getError() {
		return erro;
	}
}
