package br.com.jogo.entidades;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.jogo.excecoes.NenhumJogadorNoRankingException;

public class Ranking {
	private List<Jogador> ranking;

	public Ranking() {
		this.ranking = new LinkedList<Jogador>();
	}

	public void adicionar(Jogador j) {
		ranking.add(j);
		Collections.sort(ranking);
		if (ranking.size() > 5)
			ranking.remove(5);
	}

	public Jogador[] getRanking() {
		Jogador rk[] = new Jogador[5];

		for (int i = 0; i < 5; i++)
			if (i < ranking.size())
				rk[i] = ranking.get(i);

		return rk;
	}

	public Jogador getLiderDoRanking() throws NenhumJogadorNoRankingException {
		if (ranking.size() > 0)
			return ranking.get(0);
		throw new NenhumJogadorNoRankingException("Nenhum jogador no Ranking!");
	}
}