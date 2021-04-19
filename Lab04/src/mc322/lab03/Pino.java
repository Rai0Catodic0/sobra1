package mc322.lab03;

public class Pino {
	int linha, coluna;
	boolean emJogo;
	
	Pino (int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
		emJogo = true;
	}
	
	void Mover(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	void Sair() {
		emJogo = false;
	}
	
	
}
