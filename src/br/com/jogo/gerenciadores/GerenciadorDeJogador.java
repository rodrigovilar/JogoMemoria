package br.com.jogo.gerenciadores;

import java.util.ArrayList;
import java.util.List;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.excecoes.JogadorInvalidoException;

public class GerenciadorDeJogador {

	// Lista de jogadores
	private List<Jogador> jogadores;

	// construtor inicializando a lista de jogadores
	/**
	 * Construtor do Gerenciador de Jogadores, inicializando a lista de
	 * Jogadores
	 */
	public GerenciadorDeJogador() {
		this.jogadores = new ArrayList<Jogador>();
	}

	/**
	 * Adiciona um jogador passado por parâmetro na lista de jogadores
	 * 
	 * @param jogador
	 *            Jogador a ser adicionado
	 */
	public void adicionarJogador(Jogador jogador) { // assinatura do metodo
		this.jogadores.add(jogador);
	}

	/**
	 * Remove um determinado jogador passado por parâmetro da lista de jogadores
	 * 
	 * @param jogador
	 *            Jogador a ser removido
	 */
	public void removerJogador(Jogador jogador) { // assinatura do metodo
		this.jogadores.remove(jogador);
	}

	// metodo retorna o lider do metodo
	/**
	 * Método que percorre a lista de jogadores para encontrar o jogador com
	 * maior pontuação
	 * 
	 * @return O jogador com maior pontuação
	 */
	public Jogador liderDoRankig() { // for de todos os jogadores
		Jogador aux = null;

		for (Jogador j : jogadores) {
			if (aux == null) {
				aux = j;
			}

			// comparando que tem a pontuacao maior
			if (j.getPontuacao() >= aux.getPontuacao()) {
				aux = j;
			}
		}

		return aux;
	}

	/**
	 * Método para pesquisar um jogador que recebe o nome do jogador a ser
	 * pesquisado por parâmetro
	 * 
	 * @param nome
	 *            Nome do jogador a ser pesquisado
	 * @return O jogador encontrado
	 * @throws JogadorInvalidoException
	 *             exceção lançada caso não exista nenhum jogador na lista com o
	 *             nome pesquisado
	 */
	public Jogador pesquisarJogadorNome(String nome)
			throws JogadorInvalidoException {

		// varrendo a lista e ver qual o jogador que tem o mesmo nome que o nome
		// passado por parametro
		for (Jogador j : jogadores) { //
			if (j.getNome().equals(nome)) {
				return j;
			}
		}
		// quando nao achar o jogador lanca a excecao
		throw new JogadorInvalidoException("Jogador " + nome + " invalido!");
	}
}