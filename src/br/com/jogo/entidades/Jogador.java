package br.com.jogo.entidades;

public class Jogador {
	
	private String nome;
	private int pontuacao;
	private int raking;

	
	public Jogador() {
		this("", 0, 0);
	}
	
	public Jogador(String nome, int pontuacao, int raking) {
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.raking = raking;
	}

	
	public String getNome() {
		return this.nome;
	}


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

	
	public String toString() {
		return "Nome: " + this.nome + "\nPontuação: " + this.pontuacao
				+ "\nRankig: " + this.raking;
	}
}