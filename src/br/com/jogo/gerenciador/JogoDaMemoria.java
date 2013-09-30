package br.com.jogo.gerenciador;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.entidades.PosicaoCarta;
import br.com.jogo.entidades.Ranking;
import br.com.jogo.entidades.Tabuleiro;
import br.com.jogo.excecoes.DesvirarMesmaCartaException;
import br.com.jogo.excecoes.JogadorNaoSelecionadoException;
import br.com.jogo.excecoes.JogoNaoFoiFinalizadoException;
import br.com.jogo.excecoes.JogoNaoIniciadoException;
import br.com.jogo.excecoes.NenhumJogadorNoRankingException;
import br.com.jogo.excecoes.PosicaoDeCartaInvalidaException;

public class JogoDaMemoria {
	private Tabuleiro tabuleiro;
	private Ranking ranking;
	private Jogador jogador1, jogador2;
	private int jogadorAtual;
	private boolean jogoAnteriorFinalizado;
	private Jogador vencedor;

	public JogoDaMemoria() {
		tabuleiro = null;
		ranking = new Ranking();
		jogador1 = jogador2 = null;
		jogadorAtual = 1;
		jogoAnteriorFinalizado = false;
		vencedor = null;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador1() throws JogadorNaoSelecionadoException {
		if (jogador1 == null)
			throw new JogadorNaoSelecionadoException(
					"Jogador 1 não foi selecionado!");
		return jogador1;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public Jogador getJogador2() throws JogadorNaoSelecionadoException {
		if (jogador2 == null)
			throw new JogadorNaoSelecionadoException(
					"Jogador 2 não foi selecionado!");
		return jogador2;
	}

	public void iniciarJogo() throws JogadorNaoSelecionadoException {
		if (jogador1 == null || jogador2 == null)
			throw new JogadorNaoSelecionadoException(
					"Algum jogador não foi selecionado!");
		tabuleiro = new Tabuleiro();
	}

	public boolean jogoIniciado() {
		if (tabuleiro != null)
			return true;
		return false;
	}

	public boolean jogoFinalizado() throws JogoNaoIniciadoException,
			PosicaoDeCartaInvalidaException {
		if (jogoAnteriorFinalizado)
			return jogoAnteriorFinalizado;
		if (!jogoIniciado())
			throw new JogoNaoIniciadoException("Jogo não foi iniciado!");
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 2; j++)
				if (tabuleiro.cartaEstaVirada(i, j) == true)
					return false;
		return true;
	}

	public String getConteudoCarta(PosicaoCarta pc)
			throws JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		if (!jogoIniciado())
			throw new JogoNaoIniciadoException("Jogo não foi iniciado!");
		return tabuleiro.getConteudoCarta(pc.getPx(), pc.getPy());
	}

	public boolean cartaEstaVirada(PosicaoCarta pc)
			throws JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		if (!jogoIniciado())
			throw new JogoNaoIniciadoException("Jogo não foi iniciado!");
		return tabuleiro.cartaEstaVirada(pc.getPx(), pc.getPy());
	}

	public boolean desvirarCartas(PosicaoCarta pc1, PosicaoCarta pc2)
			throws JogoNaoIniciadoException, DesvirarMesmaCartaException,
			PosicaoDeCartaInvalidaException, JogoNaoFoiFinalizadoException {
		if (!jogoIniciado())
			throw new JogoNaoIniciadoException("Jogo não foi iniciado!");

		if (pc1.getPx() == pc2.getPx() && pc1.getPy() == pc2.getPy())
			throw new DesvirarMesmaCartaException(
					"Você selecionou a mesma carta duas vezes!");

		String conteudoC1 = tabuleiro
				.getConteudoCarta(pc1.getPx(), pc1.getPy());
		String conteudoC2 = tabuleiro
				.getConteudoCarta(pc2.getPx(), pc2.getPy());

		if (conteudoC1 == conteudoC2) {
			getJogadorAtual().setPontuacao(
					getJogadorAtual().getPontuacao() + 10);
			tabuleiro.desvira(pc1.getPx(), pc1.getPy());
			tabuleiro.desvira(pc2.getPx(), pc2.getPy());

			if (jogoFinalizado())
				encerraPartida();
			return true;
		}

		getJogadorAtual().setPontuacao(getJogadorAtual().getPontuacao() - 2);
		proximoJogador();
		return false;
	}

	private void encerraPartida() throws JogoNaoIniciadoException,
			JogoNaoFoiFinalizadoException {
		ranking.adicionar(jogador1);
		ranking.adicionar(jogador2);

		jogoAnteriorFinalizado = true;
		if(jogador1.getPontuacao() > jogador2.getPontuacao())
			vencedor = jogador1;
		else if (jogador1.getPontuacao() < jogador2.getPontuacao())
			vencedor = jogador2;
		else {
			if(jogador1.getNome().compareTo(jogador2.getNome()) <= 0)
				vencedor = jogador1;
			else
				vencedor = jogador2;
		}
		jogador1 = jogador2 = null;
		jogadorAtual = 1;
		tabuleiro = null;
	}

	public Jogador getJogadorAtual() {
		if (jogadorAtual == 1)
			return jogador1;
		return jogador2;
	}

	private void proximoJogador() {
		if (jogadorAtual == 1)
			jogadorAtual++;
		else
			jogadorAtual--;
	}

	public Jogador getVencedor() throws JogoNaoIniciadoException,
			JogoNaoFoiFinalizadoException {
		if (jogoAnteriorFinalizado)
			return vencedor;

		if (!jogoIniciado())
			throw new JogoNaoIniciadoException("Jogo não foi iniciado!");

		throw new JogoNaoFoiFinalizadoException("Jogo não foi finalizado!");
	}

	public Jogador getLiderDoRanking() throws NenhumJogadorNoRankingException {
		return ranking.getLiderDoRanking();
	}

	public Jogador[] getRanking() {
		return ranking.getRanking();
	}
}