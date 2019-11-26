package sistema.comandos;

import biblioteca.Biblioteca;

public class DevCommand extends Command {

	public DevCommand() {
		super(Biblioteca.getInstance());
	}
	@Override
	public void execute(Object arg) {
		String args[] = (String[]) arg;
		
		getBase().realizarDevolucao(args[1], args[2]);
	}

}
