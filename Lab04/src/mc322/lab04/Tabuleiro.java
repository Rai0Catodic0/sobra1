package mc322.lab04;
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
					tabuleiro[i][j] = new Pino();
				}
			}
		}

	}

	boolean EstaNoTabuleiro(int i, int j){
		if((i>1&&i<5&&j>-1&&j<7)||(j>1&&j<5&&i>-1&&i<7)) {
			return true;
		} else {
			return false;
		}
	}

	String Apresentar() {
		int indice = 0;
		char[] representacao = new char[56];
		char[] numeros = {'7','6','5','4','3','2','1'};
		char[] letras = {'a','b','c','d','e','f','g'};
		for(int i=0;i<7;i++) {
			System.out.print(numeros[i]);
			for(int j = 0; j<7; j++) {
				if(!EstaNoTabuleiro(i,j)) {
					System.out.print(" ");
					representacao[indice] = ' ';
					indice++;
				} else if(tabuleiro[i][j]==null) {
					System.out.print("-");
					representacao[indice] = '-';
					indice++;
				} else {
					System.out.print("P");
					representacao[indice] = 'P';
					indice++;
				}
			}
			System.out.print("\n");
			representacao[indice] = '\n';
			indice++;
		}
		System.out.print(' ');
		System.out.println(letras);
		return new String(representacao);
	}

	void Mover(String comando) {
		//transformar coordenadas
		int jOrigem = comando.charAt(0)-97;
		int iOrigem = 55-comando.charAt(1);
		int jDestino = comando.charAt(3)-97;
		int iDestino = 55-comando.charAt(4);
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
			//movimento válido
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
