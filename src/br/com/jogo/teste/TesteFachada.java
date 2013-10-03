package br.com.jogo.teste;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.entidades.PosicaoCarta;
import br.com.jogo.excecoes.DesvirarMesmaCartaException;
import br.com.jogo.excecoes.JogadorNaoSelecionadoException;
import br.com.jogo.excecoes.JogoNaoFoiFinalizadoException;
import br.com.jogo.excecoes.JogoNaoIniciadoException;
import br.com.jogo.excecoes.NenhumJogadorNoRankingException;
import br.com.jogo.excecoes.PosicaoDeCartaInvalidaException;
import br.com.jogo.fachada.JogoMemoriaFachada;

public class TesteFachada {
	private JogoMemoriaFachada fachada;
	private Jogador jogador1, jogador2;
	private PosicaoCarta pc1, pc2, pc3, pc4;

	@Before
	public void setUp() throws Exception {
		this.fachada = new JogoMemoriaFachada();

		this.jogador1 = new Jogador("João");
		this.jogador2 = new Jogador("Maria");

		this.pc1 = new PosicaoCarta(0, 0);
		this.pc2 = new PosicaoCarta(0, 1);
		this.pc3 = new PosicaoCarta(1, 1);
		this.pc4 = new PosicaoCarta(4, 0);
	}

	@Test
	public void testSelecionaJogador1() throws JogadorNaoSelecionadoException {
		fachada.setJogador1(jogador1);
		Assert.assertEquals(jogador1, fachada.getJogador1());
	}

	@Test(expected = JogadorNaoSelecionadoException.class)
	public void testJogador1NaoSelecionado()
			throws JogadorNaoSelecionadoException {
		fachada.getJogador1();
	}

	@Test
	public void testSelecionaJogador2() throws JogadorNaoSelecionadoException {
		fachada.setJogador2(jogador2);
		Assert.assertEquals(jogador2, fachada.getJogador2());
	}

	@Test(expected = JogadorNaoSelecionadoException.class)
	public void testJogador2NaoSelecionado()
			throws JogadorNaoSelecionadoException {
		fachada.getJogador2();
	}

	@Test(expected = JogadorNaoSelecionadoException.class)
	public void testIniciarJogoSemJogadores()
			throws JogadorNaoSelecionadoException {
		fachada.iniciarJogo();
	}

	@Test(expected = JogadorNaoSelecionadoException.class)
	public void testIniciarJogoComUmJogador()
			throws JogadorNaoSelecionadoException {
		fachada.setJogador1(jogador1);
		fachada.iniciarJogo();
	}

	@Test
	public void testIniciarJogoDoisJogador()
			throws JogadorNaoSelecionadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertTrue(fachada.jogoIniciado());
	}

	@Test(expected = JogoNaoIniciadoException.class)
	public void testConteudoCartaSemIniciarJogo()
			throws JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		String historia = fachada.getConteudoCarta(pc1);
		Assert.assertEquals("Espada", historia);
	}

	@Test(expected = PosicaoDeCartaInvalidaException.class)
	public void testGetConteudoCartaInvalida()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.getConteudoCarta(pc4);
	}

	@Test
	public void testConteudoCarta() throws JogadorNaoSelecionadoException,
			JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		String historia = fachada.getConteudoCarta(pc1);

		Assert.assertEquals("Espada", historia);
	}

	@Test(expected = PosicaoDeCartaInvalidaException.class)
	public void testCartaEstaViradaInvalida()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.cartaEstaVirada(pc4);
	}

	@Test
	public void testCartaEstaVirada() throws JogadorNaoSelecionadoException,
			JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertTrue(fachada.cartaEstaVirada(pc1));
	}

	@Test(expected = JogoNaoIniciadoException.class)
	public void testDesvirarCartasSemIniciarJogo()
			throws JogoNaoIniciadoException, DesvirarMesmaCartaException,
			PosicaoDeCartaInvalidaException, JogoNaoFoiFinalizadoException {
		fachada.desvirarCartas(pc1, pc2);
	}

	@Test(expected = PosicaoDeCartaInvalidaException.class)
	public void testDesvirarCartaInvalida()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc4);
	}

	@Test
	public void testDesvirarCartasDiferentes()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		boolean iguais = fachada.desvirarCartas(pc1, pc2);

		Assert.assertFalse(iguais);
	}

	@Test
	public void testDesvirarCartasIguais()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		boolean iguais = fachada.desvirarCartas(pc1, pc3);

		Assert.assertTrue(iguais);
	}

	@Test
	public void testJogadorAtual() throws JogadorNaoSelecionadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertEquals(jogador1, fachada.getJogadorAtual());
	}

	@Test
	public void testIncrementaPontuacaoJogador()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);

		Assert.assertEquals(10, fachada.getJogador1().getPontuacao());
	}

	@Test
	public void testDecrementaPontuacaoJogador()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc2);

		Assert.assertEquals(-2, fachada.getJogador1().getPontuacao());
	}

	@Test
	public void testMudaJogadorEmCasoDeErro()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertEquals(jogador1, fachada.getJogadorAtual());

		fachada.desvirarCartas(pc1, pc2);

		Assert.assertEquals(jogador2, fachada.getJogadorAtual());
	}

	@Test
	public void testNaoMudaJogadorEmCasoDeAcerto()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertEquals(jogador1, fachada.getJogadorAtual());

		fachada.desvirarCartas(pc1, pc3);

		Assert.assertEquals(jogador1, fachada.getJogadorAtual());
	}

	@Test
	public void testCartaFicaViradaEmCasoDeErro()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertTrue(fachada.cartaEstaVirada(pc1));
		Assert.assertTrue(fachada.cartaEstaVirada(pc2));

		fachada.desvirarCartas(pc1, pc2);

		Assert.assertTrue(fachada.cartaEstaVirada(pc1));
		Assert.assertTrue(fachada.cartaEstaVirada(pc2));
	}

	@Test
	public void testCartaFicaDesviradaEmCasoDeAcerto()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();

		Assert.assertTrue(fachada.cartaEstaVirada(pc1));
		Assert.assertTrue(fachada.cartaEstaVirada(pc3));

		fachada.desvirarCartas(pc1, pc3);

		Assert.assertFalse(fachada.cartaEstaVirada(pc1));
		Assert.assertFalse(fachada.cartaEstaVirada(pc3));
	}

	@Test(expected = JogoNaoIniciadoException.class)
	public void testJogoFoiFinalizadoSemIniciar()
			throws JogoNaoIniciadoException, PosicaoDeCartaInvalidaException {
		fachada.jogoFinalizado();
	}

	@Test
	public void testJogoNaoFoiFinalizado()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));

		Assert.assertFalse(fachada.jogoFinalizado());
	}

	@Test
	public void testJogoFoiFinalizado() throws JogadorNaoSelecionadoException,
			JogoNaoIniciadoException, DesvirarMesmaCartaException,
			PosicaoDeCartaInvalidaException, JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));
		fachada.desvirarCartas(new PosicaoCarta(2, 0), new PosicaoCarta(3, 1));
		fachada.jogoFinalizado();
	}

	@Test
	public void testGetVencedor() throws JogadorNaoSelecionadoException,
			JogoNaoIniciadoException, DesvirarMesmaCartaException,
			PosicaoDeCartaInvalidaException, JogoNaoFoiFinalizadoException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));
		fachada.desvirarCartas(new PosicaoCarta(2, 0), new PosicaoCarta(3, 1));

		Assert.assertEquals(jogador1, fachada.getVencedor());
	}

	@Test
	public void testAdicionaNoRanking() throws JogadorNaoSelecionadoException,
			JogoNaoIniciadoException, DesvirarMesmaCartaException,
			PosicaoDeCartaInvalidaException, JogoNaoFoiFinalizadoException {
		Assert.assertNull(fachada.getRanking()[0]);

		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));
		fachada.desvirarCartas(new PosicaoCarta(2, 0), new PosicaoCarta(3, 1));

		Assert.assertEquals(jogador1, fachada.getRanking()[0]);
		Assert.assertEquals(jogador2, fachada.getRanking()[1]);
	}

	@Test(expected = NenhumJogadorNoRankingException.class)
	public void testNenhumJogadorNoRanking()
			throws NenhumJogadorNoRankingException {
		fachada.getLiderDoRanking();
	}

	@Test
	public void testGetLiderDoRanking() throws JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException, JogadorNaoSelecionadoException,
			NenhumJogadorNoRankingException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));
		fachada.desvirarCartas(new PosicaoCarta(2, 0), new PosicaoCarta(3, 1));

		Assert.assertEquals(jogador1, fachada.getLiderDoRanking());
	}

	@Test
	public void testGetRanking() throws JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException, JogadorNaoSelecionadoException {
		Assert.assertNull(fachada.getRanking()[0]);

		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));
		fachada.desvirarCartas(new PosicaoCarta(2, 0), new PosicaoCarta(3, 1));

		Assert.assertNotNull(fachada.getRanking()[0]);
	}

	@Test
	public void testPontuacaoDoLiderDoRanking()
			throws JogadorNaoSelecionadoException, JogoNaoIniciadoException,
			DesvirarMesmaCartaException, PosicaoDeCartaInvalidaException,
			JogoNaoFoiFinalizadoException, NenhumJogadorNoRankingException {
		fachada.setJogador1(jogador1);
		fachada.setJogador2(jogador2);
		fachada.iniciarJogo();
		fachada.desvirarCartas(pc1, pc3);
		fachada.desvirarCartas(new PosicaoCarta(0, 1), new PosicaoCarta(3, 0));
		fachada.desvirarCartas(new PosicaoCarta(1, 0), new PosicaoCarta(2, 1));
		fachada.desvirarCartas(new PosicaoCarta(2, 0), new PosicaoCarta(3, 1));

		Assert.assertEquals(40, fachada.getLiderDoRanking().getPontuacao());
	}
}