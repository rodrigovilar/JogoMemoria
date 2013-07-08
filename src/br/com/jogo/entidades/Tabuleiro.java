package br.com.jogo.entidades;

import java.util.ArrayList;
import java.util.List;

import br.com.jogo.entidades.Carta;
import br.com.jogo.excecoes.DesvirarCartaDuasVezesSeguidasException;
import br.com.jogo.entidades.PosicaoCarta;

public class Tabuleiro {

	
	private Carta[][] tabuleiro; 
	
        private PosicaoCarta pc1 = null;
        private PosicaoCarta pc2 = null;
        public int linhas;
        public int colunas;
        
        public void init(){
          
            this.tabuleiro = new Carta[2][4];
            this.linhas = 2;
            this.colunas = 4;
            
            
            this.tabuleiro[0][0] = new Carta(0, "copas", "./img/copas.jpg");
            this.tabuleiro[0][1] = new Carta(1, "espada", "./img/espada.jpg");
            this.tabuleiro[0][2] = new Carta(2, "ouro", "./img/ouro.jpg");
            this.tabuleiro[0][3] = new Carta(3, "paus", "./img/paus.jpg");
            
            this.tabuleiro[1][0] = new Carta(2, "ouro", "./img/ouro.jpg");
            this.tabuleiro[1][1] = new Carta(3, "paus", "./img/paus.jpg");
            this.tabuleiro[1][2] = new Carta(1, "espada", "./img/espada.jpg");
            this.tabuleiro[1][3] = new Carta(0, "copas", "./img/copas.jpg");
        }
        
        public boolean jogoEstaFinalizado(){
            boolean finalizado = true;
            for(int i=0; i < this.linhas; ++i){
                for(int j=0; j < this.colunas; ++j){
                    if(this.tabuleiro[i][j].estaVirada()){
                        System.out.println("X: " + i + " Y: " + j);
                        finalizado = false;
                        break;
                    }
                }
            }
            return finalizado;
        }
        
        public String desvirarCarta(PosicaoCarta pc) throws DesvirarCartaDuasVezesSeguidasException{
            if(this.pc2 != null)
                return null;
                
            Carta c = this.tabuleiro[pc.getX()][pc.getY()];
            if(!c.estaVirada()){
                throw new DesvirarCartaDuasVezesSeguidasException("Carta já virada.");
            }
            c.desvira();
            
            if(this.pc1 == null){
                this.pc1 = pc;
            }else{
                this.pc2 = pc;
            }
            
            return c.getHistoria();
        }
        
        public boolean asCartasDesviradasSaoIguais(){
            Carta c1 = this.tabuleiro[this.pc1.getX()][this.pc1.getY()];
            Carta c2 = this.tabuleiro[this.pc2.getX()][this.pc2.getY()];
            
            if(c1.equals(c2)){
                return true;
            }else{
                return false;
            }
        }
        
        public void virarCartas(){
            if(!this.asCartasDesviradasSaoIguais()){
                this.tabuleiro[this.pc1.getX()][this.pc1.getY()].vira();
                this.tabuleiro[this.pc2.getX()][this.pc2.getY()].vira();
            }
            this.pc1 = null;
            this.pc2 = null;
        }

    String getCartaIconPath(PosicaoCarta pc) {
        return this.tabuleiro[pc.getX()][pc.getY()].getIconPath();
    }

    List<PosicaoCarta> getCartas() {
            List<PosicaoCarta> cartas = new ArrayList<PosicaoCarta>();
            for(int i=0; i < this.linhas; ++i){
                for(int j=0; j < this.colunas; ++j){
                    cartas.add(new PosicaoCarta(i, j));
                }
            }
            return cartas;
    }
}
