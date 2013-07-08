package br.com.jogo.entidades;

public class Pontuação {
	public enum Pontuacao {
	    ACERTO(10), ERRO(-2);

	    private int valor;
	    private Pontuacao(int v){
	        this.valor = v;
	    }
	    
	    public int valor(){
	        return this.valor;
	    }
	}
}