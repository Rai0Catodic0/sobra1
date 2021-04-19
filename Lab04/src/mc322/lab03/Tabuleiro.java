package mc322.lab03;

public class Tabuleiro {
	Pino tabuleiro[][] = new Pino[7][7];
	
	Tabuleiro() {
		for(int i=0;i<7;i++) {
			for(int j = 0; j<7; j++) {
				if((i<2 && j>4)||(i<2 && j<2) || (i>4 && j<2) || (i>4 && j>4)) {
					tabuleiro[i][j] = null;
				} else if(i==3 && j==3) {
					tabuleiro[i][j] = new Pino(i,j);
					tabuleiro[i][j].emJogo = false;
				}
				else {
					tabuleiro[i][j] = new Pino(i, j);
				}
			}
		}
	}
	
	void Apresentar() {
		for(int i=0;i<7;i++) {
			for(int j = 0; j<7; j++) {
				if(tabuleiro[i][j]==null) {
					System.out.print(" ");
				} else if(tabuleiro[i][j].emJogo) {
					System.out.print("P");
				} else {
					System.out.print("-");
				}
			}
			System.out.print("\n");
		}
	}
}
