package br.com.jogo.excecoes;

public class JogadorNaoSelecionadoException extends Exception {
	public JogadorNaoSelecionadoException() {
		super("Jogador não selecionado!");
	}

	public JogadorNaoSelecionadoException(String message) {
		super(message);
	}
}