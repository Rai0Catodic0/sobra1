package mc322.lab04;

public class AppRestaUm {
	public static void main(String args[]) {
		//CSVReader csv = new CSVReader();
	    //csv.setDataSource("/Lab04/src/mc322/lab03/jogadas.csv");
	    //String commands[] = csv.requestCommands();
		String commands[] = {"d2:d4","d5:d3","f4:d4","c4:e4"};
		executaJogo(commands);
	}
	
	public static void executaJogo (String comandos[]) {
		Tabuleiro resta1 = new Tabuleiro();
		int n = comandos.length;
		String[] estados = new String[n];
		System.out.printf("Tabuleiro Inicial\n");
		resta1.Apresentar();
		for(int i = 0; i<n; i++) {
			resta1.Mover(comandos[i]);
			System.out.println();
			System.out.print("Source: "+comandos[i].charAt(0)+comandos[i].charAt(1)+"\n");
			System.out.print("Target: "+comandos[i].charAt(3)+comandos[i].charAt(4)+"\n");
			estados[i] = resta1.Apresentar();
		}
	}
}
