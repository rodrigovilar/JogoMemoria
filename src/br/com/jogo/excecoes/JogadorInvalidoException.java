package br.com.jogo.excecoes;

public class JogadorInvalidoException extends Exception {

	String erro;

	
	
	public JogadorInvalidoException() {
		super(); // chamar o construtor da superclasse
		erro = "unknown";
	}

	public JogadorInvalidoException(String err) {
		super(err); // chamar o construtor da superclasse
		erro = err; // salva messagem
	}

	public String getError() {
		return erro;
	}
}
