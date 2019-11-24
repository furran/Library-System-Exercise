package sistema.comandos;

import biblioteca.BancoDeDados;

public class ObsCommand extends Command {
	
	
	public ObsCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().registrarObserver(args[1], args[2]);
	}

}
