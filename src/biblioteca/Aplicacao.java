package biblioteca;

import java.util.Scanner;

import sistema.comandos.Sistema;

public class Aplicacao {
	public static void main(String args[]) {
		System.out.println("Inicializando...");
		Sistema sys = Sistema.getInstance();
		Scanner sc = new Scanner(System.in);
		String line;
		String cmd[];
		
		System.out.println("Pronto");
		while(true) {
			line = sc.nextLine();
			cmd = line.split(" ");
			sys.doCommand(cmd[0], cmd);
		}
	}
}
