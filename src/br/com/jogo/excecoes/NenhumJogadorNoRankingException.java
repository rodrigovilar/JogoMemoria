package br.com.jogo.excecoes;

public class NenhumJogadorNoRankingException extends Exception {
	public NenhumJogadorNoRankingException() {
		super("Nenhum jogador no ranking!");
	}

	public NenhumJogadorNoRankingException(String message) {
		super(message);
	}
}