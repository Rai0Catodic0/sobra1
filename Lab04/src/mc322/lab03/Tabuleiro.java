package mc322.lab03;
import java.lang.Math;

public class Tabuleiro {
	Pino tabuleiro[][] = new Pino[7][7];
	int numeroDePinos = 32;
	Tabuleiro() {
		for(int i=0;i<7;i++) {
			for(int j = 0; j<7; j++) {
				if((i<2 && j>4)||(i<2 && j<2) || (i>4 && j<2) || (i>4 && j>4)) {
					tabuleiro[i][j] = null;
				} else if(i==3 && j==3) {
					tabuleiro[i][j] = null;
				}
				else {
					tabuleiro[i][j] = new Pino(i, j);
				}
			}
		}
		
	}
	
	boolean EstaNoTabuleiro(int i, int j){
		if((j>1 && j<5)||(i>1 && i<5)) {
			return true;
		} else {
			return false;
		}
	}
	
	void Apresentar() {
		for(int i=0;i<7;i++) {
			for(int j = 0; j<7; j++) {
				if(!EstaNoTabuleiro(i,j)) {
					System.out.print(" ");
				} else if(tabuleiro[i][j]==null) {
					System.out.print("-");
				} else {
					System.out.print("P");
				}
			}
			System.out.print("\n");
		}
	}
	
	void Mover(int iOrigem, int jOrigem, int iDestino, int jDestino) {
		//validar movimento
		if(!EstaNoTabuleiro(iDestino,jDestino)||!EstaNoTabuleiro(iDestino, jDestino)) {
			System.out.println("Casas inválidas!");
		} else if(tabuleiro[iDestino][jDestino]!=null) {
			System.out.println("Casa de destino inválida");
		} else if((iOrigem!=iDestino)&& (jDestino!=jOrigem)){
			System.out.println("Movimento na Diagonal Inválido");
		} else if(Math.abs(iOrigem-iDestino)>1 && Math.abs(jOrigem-jDestino)>1){
			System.out.println("Você está pulando muitas casas!");
		} else if(iOrigem == iDestino && tabuleiro[iOrigem][jOrigem+1]== null) {
			System.out.println("Movimento invalido");
		} else if(jOrigem == jDestino && tabuleiro[iOrigem+1][jOrigem]==null) {
			System.out.println("Movimento invalido");
		} else {
			System.out.println("Movimento válido:");
			tabuleiro[iDestino][jDestino] = tabuleiro[iOrigem][jOrigem];
			tabuleiro[iOrigem][jOrigem]= null;
			//movimento com peças na mesma linha
			if(iDestino==iOrigem) {
				int jFora = (jDestino+jOrigem)/2;
				int iFora = iOrigem;
				tabuleiro[iFora][jFora] = null;
			} else { //movimento na mesma coluna
				int iFora = (iDestino+iOrigem)/2;
				int jFora = jOrigem;
				tabuleiro[iFora][jFora] = null;
			}
		}
		
	}
}
