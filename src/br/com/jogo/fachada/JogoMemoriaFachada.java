package br.com.jogo.fachada;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.entidades.PosicaoCarta;
import br.com.jogo.excecoes.DesvirarMesmaCartaException;
import br.com.jogo.excecoes.JogadorNaoSelecionadoException;
import br.com.jogo.excecoes.JogoNaoFoiFinalizadoException;
import br.com.jogo.excecoes.JogoNaoIniciadoException;
import br.com.jogo.excecoes.NenhumJogadorNoRankingException;
import br.com.jogo.excecoes.PosicaoDeCartaInvalidaException;
import br.com.jogo.gerenciador.JogoDaMemoria;

public class JogoMemoriaFachada {
	private JogoDaMemoria jogo;

	public JogoMemoriaFachada() {
		this.jogo = new JogoDaMemoria();
	}

	public void setJogador1(Jogador jogador1) {
		jogo.setJogador1(jogador1);
	}

	public Jogador getJogador1() throws JogadorNaoSelecionadoException {
		return jogo.getJogador1();
	}

	public void setJogador2(Jogador jogador2) {
		jogo.setJogador2(jogador2);
	}

	public Jogador getJogador2() throws JogadorNaoSelecionadoException {
		return jogo.getJogador2();
	}

	public void iniciarJogo() throws JogadorNaoSelecionadoException {
		jogo.iniciarJogo();
	}

	public boolean jogoIniciado() {
		return jogo.jogoIniciado();
	}

	public String getConteudoCarta(PosicaoCarta pc)
			throws JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		return jogo.getConteudoCarta(pc);
	}

	public boolean cartaEstaVirada(PosicaoCarta pc)
			throws JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		return jogo.cartaEstaVirada(pc);
	}

	public boolean desvirarCartas(PosicaoCarta pc1, PosicaoCarta pc2)
			throws JogoNaoIniciadoException, DesvirarMesmaCartaException,
			PosicaoDeCartaInvalidaException, JogoNaoFoiFinalizadoException {
		return jogo.desvirarCartas(pc1, pc2);
	}

	public Jogador getJogadorAtual() {
		return jogo.getJogadorAtual();
	}

	public boolean jogoFinalizado() throws JogoNaoIniciadoException,
			PosicaoDeCartaInvalidaException {
		return jogo.jogoFinalizado();
	}

	public Jogador getVencedor() throws JogoNaoIniciadoException,
			JogoNaoFoiFinalizadoException {
		return jogo.getVencedor();
	}

	public Jogador getLiderDoRanking() throws NenhumJogadorNoRankingException {
		return jogo.getLiderDoRanking();
	}

	public Jogador[] getRanking() {
		return jogo.getRanking();
	}
}