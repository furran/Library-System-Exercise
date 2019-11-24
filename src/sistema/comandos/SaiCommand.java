package sistema.comandos;

import biblioteca.BancoDeDados;

public class SaiCommand extends Command{

	public SaiCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		System.out.println("Fechando aplicacao...");
		System.exit(0);
	}

}
