package sistema.comandos;

import biblioteca.Biblioteca;

public class ResCommand extends Command {


	public ResCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().realizarReserva(args[1], args[2]);
	}

}
