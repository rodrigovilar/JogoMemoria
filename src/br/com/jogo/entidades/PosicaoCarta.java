package br.com.jogo.entidades;

public class PosicaoCarta {
	private int px;
	private int py;

	public PosicaoCarta(int px, int py) {
		this.px = px;
		this.py = py;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}
}