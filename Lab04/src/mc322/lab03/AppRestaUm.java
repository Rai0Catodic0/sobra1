package mc322.lab03;

public class AppRestaUm {
	public static void main(String args[]) {
		Tabuleiro resta1 = new Tabuleiro();
		String str = resta1.Apresentar();
		System.out.println(str);
		//CSVReader csv = new CSVReader();
	    //csv.setDataSource("/Lab04/src/mc322/lab03/jogadas.csv");
	    //String commands[] = csv.requestCommands();
		String commands[] = {"d2:d4","d5:d3","f4:d4","c4:e4"};
		resta1.executaJogo(commands);

	}
}
