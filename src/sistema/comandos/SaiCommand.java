package sistema.comandos;

import biblioteca.Biblioteca;

public class SaiCommand extends Command{

	public SaiCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		System.out.println("Fechando aplicacao...");
		System.exit(0);
	}

}
