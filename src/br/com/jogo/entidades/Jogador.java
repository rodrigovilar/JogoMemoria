package br.com.jogo.entidades;

public class Jogador implements Comparable<Jogador> {
	private String nome;
	private int pontuacao;

	public Jogador() {
		this("Desconhecido");
	}

	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public int compareTo(Jogador o) {
		if (o.getPontuacao() > pontuacao)
			return 1;
		else if (o.getPontuacao() < pontuacao)
			return -1;
		return -o.getNome().compareTo(nome);
	}
}