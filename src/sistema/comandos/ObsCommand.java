package sistema.comandos;

import biblioteca.Biblioteca;

public class ObsCommand extends Command {
	
	
	public ObsCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().registrarObserver(args[1], args[2]);
	}

}
