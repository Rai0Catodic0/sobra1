package mc322.lab03;

public class AppRestaUm {
	public static void main(String args[]) {
		Tabuleiro resta1 = new Tabuleiro();
		resta1.Apresentar();
		resta1.Mover(1, 3, 4, 3);
		resta1.Apresentar();
		resta1.Mover(1, 3, 3, 3);
		resta1.Apresentar();
		resta1.Mover(0,3,2,3);
		resta1.Apresentar();
	}
}
