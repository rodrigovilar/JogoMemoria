package br.com.jogo.fachada;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.entidades.PosicaoCarta;
import br.com.jogo.excecoes.DesvirarCartaDuasVezesSeguidasException;
import br.com.jogo.excecoes.JogadorInvalidoException;
import br.com.jogo.excecoes.JogadorNaoSelecionadoException;
import br.com.jogo.excecoes.JogoNaoFinalizadoException;
import br.com.jogo.excecoes.PosicaoInvalidaException;
import br.com.jogo.gerenciador.GerenciadorDeJogador;

public class JogoMemoriaFachada {

	private GerenciadorDeJogador gerente = new GerenciadorDeJogador();

	public Jogador getJogador1() {
		return gerente.getJogador1();
	}

	public void adicionarJogador(Jogador jogador) {
		this.gerente.adicionarJogador(jogador);
	}

	public void removerJogador(Jogador jogador) {
		this.gerente.removerJogador(jogador);
	}

	public Jogador pesquisarJogadorNome(String nome)
			throws JogadorInvalidoException {
		return this.gerente.pesquisarJogadorNome(nome);
	}

	public String desvirarCarta(PosicaoCarta pos)
			throws DesvirarCartaDuasVezesSeguidasException,
			PosicaoInvalidaException {

		return gerente.desvirarCarta(pos);

	}

	public void criarJogador1(String nome) {
		gerente.criarJogador1(nome);
	}

	public void criarJogador2(String nome) {
		gerente.criarJogador2(nome);
	}

	public void iniciarPartida() throws JogadorNaoSelecionadoException {
		gerente.iniciarPartida();
	}

	public void selecionarJogador1(String nome) throws JogadorInvalidoException {
		gerente.pesquisarJogadorNome(nome);
	}

	public void selecionarJogador2(String nome) throws JogadorInvalidoException {
		this.gerente.pesquisarJogadorNome(nome);
	}

	public Jogador getJogadorVencedor() throws JogoNaoFinalizadoException {
		return this.gerente.getJogadorVencedor();
	}
}