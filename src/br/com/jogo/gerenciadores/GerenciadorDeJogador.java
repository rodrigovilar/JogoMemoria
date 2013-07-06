package br.com.jogo.gerenciadores;

import java.util.ArrayList;
import java.util.List;

import br.com.jogo.entidades.Jogador;
import br.com.jogo.excecoes.JogadorInvalidoException;

public class GerenciadorDeJogador {

	
	private List<Jogador> jogadores;

	/**
	 * Construtor do Gerenciador de Jogadores, inicializando a lista de
	 * Jogadores.
	 */
	public GerenciadorDeJogador() {
		this.jogadores = new ArrayList<Jogador>();
	}

	/**
	 * Adiciona um jogador passado por parâmetro na lista de jogadores.
	 * 
	 * @param jogador
	 *            Jogador a ser adicionado
	 */
	public void adicionarJogador(Jogador jogador) { 
		this.jogadores.add(jogador);
	}

	/**
	 * Remove um determinado jogador passado por parâmetro da lista de
	 * jogadores.
	 * 
	 * @param jogador
	 *            Jogador a ser removido
	 */
	public void removerJogador(Jogador jogador) { 
		this.jogadores.remove(jogador);
	}

	
	/**
	 * Método que percorre a lista de jogadores para encontrar o jogador com
	 * maior pontuação.
	 * 
	 * @return O jogador com maior pontuação.
	 */
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

	/**
	 * Método para pesquisar um jogador que recebe o nome do jogador a ser
	 * pesquisado por parâmetro.
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

		for (Jogador jogador : jogadores) { //
			if (jogador.getNome().equals(nome)) {
				return jogador;
			}
		}
		
		throw new JogadorInvalidoException("Jogador " + nome + " invalido!");
	}
}