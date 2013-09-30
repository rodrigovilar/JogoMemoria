package br.com.jogo.entidades;

public class Carta {
	private boolean virada;
	private String historia;

	public Carta(String historia) {
		this.historia = historia;
		this.virada = true;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public boolean isVirada() {
		return virada;
	}

	public void setVirada(boolean virada) {
		this.virada = virada;
	}
}