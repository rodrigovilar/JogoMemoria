package br.com.jogo.entidades;

public class Jogador {
	// atributos
	private String nome;
	private int pontuacao;
	private int raking;

	// construtor
	public Jogador() {
		this("", 0, 0);
	}

	// construtor
	/**
	 * Construtor da classe jogador que recebe nome e pontuação
	 * 
	 * @param nome
	 *            recebe o nome do jogador
	 * @param pontuacao
	 *            recebe a pontuação do jogador
	 * @param ranking
	 *            recebe o ranking do jogador
	 */
	public Jogador(String nome, int pontuacao, int raking) {
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.raking = raking;
	}

	// get: pegar
	public String getNome() {
		return this.nome;
	}

	// set: modificar
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return this.pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getRaking() {
		return this.raking;
	}

	public void setRaking(int raking) {
		this.raking = raking;
	}

	/**
	 * Serve para retornar informações da classe em forma de String
	 * 
	 * @return retorna uma string contendo as informações da classe
	 */
	public String toString() {
		return "Nome: " + this.nome + "\nPontuação: " + this.pontuacao
				+ "\nRankig: " + this.raking;
	}
}