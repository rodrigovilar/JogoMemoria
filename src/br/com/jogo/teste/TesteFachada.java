package br.com.jogo.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.entidades.PosicaoCarta;
import br.com.jogo.excecoes.DesvirarCartaDuasVezesSeguidasException;
import br.com.jogo.excecoes.JogadorInvalidoException;
import br.com.jogo.excecoes.JogadorNaoSelecionadoException;
import br.com.jogo.excecoes.JogoNaoFinalizadoException;
import br.com.jogo.excecoes.PosicaoInvalidaException;
import br.com.jogo.fachada.JogoMemoriaFachada;
import br.com.jogo.gerenciador.GerenciadorDeJogador;

public class TesteFachada {

	private JogoMemoriaFachada fachada = null;

	public void init() {
		if (fachada != null)
			return;
		fachada = new JogoMemoriaFachada();

		Jogador jogador = new Jogador("Jose", 0, 0);
		fachada.adicionarJogador(jogador);
		jogador = new Jogador("Lilian", 0, 0);
		fachada.adicionarJogador(jogador);
		jogador = new Jogador("Roger", 0, 0);
		fachada.adicionarJogador(jogador);
	}

	@Test
	public void testeIniciarPartidaSemJogadores() {
		init();

		try {
			fachada.iniciarPartida();
			Assert.fail("Partida iniciada sem jogadores");
		} catch (JogadorNaoSelecionadoException ex) {
		}
	}

	@Test
	public void testeIniciarPartidaComUmJogador() {
		init();

		try {

			fachada.selecionarJogador1("Lilian");
		} catch (JogadorInvalidoException ex) {
		}
		try {
			fachada.iniciarPartida();
			Assert.fail("Partida iniciada sem jogadores");
		} catch (JogadorNaoSelecionadoException ex) {
		}
	}

	public void iniciarPartida() {

		fachada.criarJogador1("Lilian");
		fachada.criarJogador2("Jose");

		try {
			fachada.iniciarPartida();
		} catch (JogadorNaoSelecionadoException ex) {
			Assert.fail("Exceção lancada errada.");
		}
	}

	@Test
	public void testeConteudoCartaExibidoParaTodos() {
		init();
		iniciarPartida();
		try {

			PosicaoCarta pc = new PosicaoCarta(0, 1);
			String cartaValor = fachada.desvirarCarta(pc);
			Assert.assertEquals("Estrela", cartaValor);

		} catch (PosicaoInvalidaException jie) {
			Assert.fail("A posição da carta fornecida é inválida");
		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
			Assert.fail("A posição da carta fornecida é inválida");
		}
	}

	// Testa acertar Par de cartas ganha 10 pontos e tem nova chance
	@Test
	public void testeAcertarParDeCartaDesviraNovamente() {
		init();
		iniciarPartida();
		try {

			PosicaoCarta pc = new PosicaoCarta(0, 0);
			String cartaValor = fachada.desvirarCarta(pc);
			PosicaoCarta pc2 = new PosicaoCarta(1, 1);
			String cartaValor2 = fachada.desvirarCarta(pc);
			Jogador j1 = fachada.getJogador1();

			Assert.assertEquals(10, j1.getPontuacao());

		} catch (PosicaoInvalidaException jie) {
		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
		}
	}

	// Perde 2 pontos

	public void testeErrarParDeCartaPerdePontos() {
		init();
		iniciarPartida();
		try {

			PosicaoCarta cp = new PosicaoCarta(0, 0);
			String cartaValor = fachada.desvirarCarta(cp);
			PosicaoCarta cp2 = new PosicaoCarta(1, 0);
			String cartaValor2 = fachada.desvirarCarta(cp2);
			Jogador j1 = fachada.getJogador1();

			Assert.assertEquals(-2, j1.getPontuacao());

		} catch (PosicaoInvalidaException jie) {
		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
		}
	}

	@Test
	public void testeCartaNaoDeveSerDesviradaDuasVezesSeguidas() {
		init();
		iniciarPartida();

		try {

			PosicaoCarta pcd = new PosicaoCarta(0, 0);
			String cartaValor = fachada.desvirarCarta(pcd);
			PosicaoCarta pcd2 = new PosicaoCarta(0, 0);
			String cartaValor2 = fachada.desvirarCarta(pcd2);

			Assert.fail("A posição da carta fornecida é inválida");

		} catch (PosicaoInvalidaException jie) {
		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
			// Assert.fail("A posicao da Carta fornecida nao pode ser desvirada duas vezes seguidas");
		}
	}

	@Test
	public void testeQuemFoiVencedor() {
		init();
		iniciarPartida();

		try {

			PosicaoCarta posc = new PosicaoCarta(0, 0);
			String cartaValor = fachada.desvirarCarta(posc);
			PosicaoCarta posc2 = new PosicaoCarta(0, 0);
			String cartaValor2 = fachada.desvirarCarta(posc2);
			Jogador vencedor = fachada.getJogadorVencedor();

			Assert.fail("Exception não foi lançada - A partida não tem vencedor");

		} catch (PosicaoInvalidaException jie) {
			Assert.fail("Exception não deveria ser lancada");

		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
			// Assert.fail("A posição da carta fornecida não pode ser desvirada duas vezes seguidas");

		} catch (JogoNaoFinalizadoException jnf) {
		}
	}

	public void testeVenceQuemTiverMaisPontosPartidaAtual() {
		init();
		iniciarPartida();

		try {

			PosicaoCarta cartp = new PosicaoCarta(0, 0);
			String cartaValor = fachada.desvirarCarta(cartp);
			PosicaoCarta cartp2 = new PosicaoCarta(1, 1);
			String cartaValor2 = fachada.desvirarCarta(cartp2);
			PosicaoCarta cartp3 = new PosicaoCarta(0, 1);
			String cartaValor3 = fachada.desvirarCarta(cartp3);
			PosicaoCarta cartp4 = new PosicaoCarta(1, 0);
			String cartaValor4 = fachada.desvirarCarta(cartp4);
			Jogador jogador1 = fachada.getJogador1();

			Assert.assertEquals(jogador1, fachada.getJogadorVencedor());

		} catch (PosicaoInvalidaException jie) {
			Assert.fail("Exception não deveria ser lançada");

		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
			Assert.fail("A posicão da Carta fornecida não pode ser desvirada duas vezes seguidas");

		} catch (JogoNaoFinalizadoException jnf) {
			Assert.fail("O jogo não foi finalizado");
		}
	}

	public void testePontuacaoJogadorAcrescentadaNaPontuacaoRaking() {
		init();
		iniciarPartida();

		try {

			PosicaoCarta pc = new PosicaoCarta(0, 0);
			String cartaValor = fachada.desvirarCarta(pc);
			PosicaoCarta pc2 = new PosicaoCarta(1, 1);
			String cartaValor2 = fachada.desvirarCarta(pc);
			Jogador j1 = fachada.getJogador1();

			Assert.assertEquals(10, j1.getRaking());

		} catch (PosicaoInvalidaException jie) {
			Assert.fail("Exception não deveria ser lancada");

		} catch (DesvirarCartaDuasVezesSeguidasException jie) {
			Assert.fail("A posição da carta fornecida não pode ser desvirada duas vezes seguidas");
		}
	}
}
