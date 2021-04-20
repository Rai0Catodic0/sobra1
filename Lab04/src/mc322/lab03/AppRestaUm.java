package mc322.lab03;

public class AppRestaUm {
	public static void main(String args[]) {
		Tabuleiro resta1 = new Tabuleiro();
		resta1.Apresentar();
		CSVReader csv = new CSVReader();
	    csv.setDataSource("/home/jessica/sobra1/Lab03/src/db");
	    String commands[] = csv.requestCommands();
	    System.out.print(commands[0]);
	}
}
