package br.com.jogo.excecoes;

public class JogadorNaoSelecionadoException extends Exception {
	private String erro;

	public JogadorNaoSelecionadoException() {
		super();
		erro = "unknown";
	}

	public JogadorNaoSelecionadoException(String err) {
		super(err);
		erro = err;
	}

	public String getError() {
		return erro;
	}
}