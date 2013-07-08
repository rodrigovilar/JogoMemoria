package br.com.jogo.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.entidades.Pontuacao;
import br.com.jogo.entidades.PosicaoCarta;
import br.com.jogo.entidades.Tabuleiro;
import br.com.jogo.excecoes.DesvirarCartaDuasVezesSeguidasException;
import br.com.jogo.excecoes.JogadorInvalidoException;
import br.com.jogo.excecoes.JogadorNaoSelecionadoException;
import br.com.jogo.excecoes.JogoNaoFinalizadoException;
import br.com.jogo.excecoes.PosicaoInvalidaException;

public class GerenciadorDeJogador {

	private List<Jogador> jogadores;
	private Jogador jogador1 = null;
	private Jogador jogador2 = null;
	private Tabuleiro tab = null;

	public Jogador getJogador1() {
		return this.jogador1;
	}

	public Jogador getJogadorVencedor() throws JogoNaoFinalizadoException {
		if (!this.tab.jogoEstaFinalizado()) {
			throw new JogoNaoFinalizadoException("Jogo não acabaou");
		}
		if (this.jogador1.getPontuacao() > this.jogador2.getPontuacao()) {
			return this.jogador1;
		} else {
			return this.jogador2;
		}
	}

	public GerenciadorDeJogador() {
		this.jogadores = new ArrayList<Jogador>();
	}

	public void iniciarPartida() throws JogadorNaoSelecionadoException {
		if ((this.jogador1 == null) || (this.jogador2 == null)) {
			throw new JogadorNaoSelecionadoException();
		}
		this.tab = new Tabuleiro();
		this.tab.init();
	}

	public void adicionarJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}

	public void removerJogador(Jogador jogador) {
		this.jogadores.remove(jogador);
	}

	public Jogador liderDoRankig() {
		Jogador aux = null;

		for (Jogador j : jogadores) {
			if (aux == null) {
				aux = j;
			}

			if (j.getPontuacao() >= aux.getPontuacao()) {
				aux = j;
			}
		}

		return aux;
	}

	public void criarJogador1(String nome) {
		this.jogador1 = new Jogador();
		this.jogador1.setNome(nome);
		jogadores.add(jogador1);
	}

	public void criarJogador2(String nome) {
		this.jogador2 = new Jogador();
		this.jogador2.setNome(nome);
		jogadores.add(jogador2);
	}

	public Jogador pesquisarJogadorNome(String nome)
			throws JogadorInvalidoException {

		for (Jogador jogador : jogadores) {
			if (jogador.getNome().equals(nome)) {
				return jogador;
			}
		}
		throw new JogadorInvalidoException("Jogador " + nome + " invalido!");
	}

	public String desvirarCarta(PosicaoCarta pos)
			throws DesvirarCartaDuasVezesSeguidasException,
			PosicaoInvalidaException {
		int controle = 0;
		int jogadorAtual = 1;
		String carta = null;

		if (controle == 0) {
			carta = this.tab.desvirarCarta(pos);
			++controle;
		} else {
			carta = this.tab.desvirarCarta(pos);
			if (this.tab.asCartasDesviradasSaoIguais()) {

				if (jogadorAtual == 1) {
					this.jogador1.setPontuacao(this.jogador1.getPontuacao()
							+ Pontuacao.ACERTO.valor());
					jogadorAtual = 1;
				} else {
					jogador2.setPontuacao(this.jogador2.getPontuacao()
							+ Pontuacao.ACERTO.valor());
					jogadorAtual = 2;
				}
			} else {
				if (jogadorAtual == 1) {
					this.jogador1.setPontuacao(this.jogador1.getPontuacao()
							+ Pontuacao.ERRO.valor());
					jogadorAtual = 2;
				} else {
					this.jogador2.setPontuacao(this.jogador2.getPontuacao()
							+ Pontuacao.ERRO.valor());
					jogadorAtual = 1;
				}
			}
			this.tab.virarCartas();
			controle = 0;
		}

		return carta;

	}

}