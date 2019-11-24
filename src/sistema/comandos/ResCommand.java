package sistema.comandos;

import biblioteca.BancoDeDados;

public class ResCommand extends Command {


	public ResCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().realizarReserva(args[1], args[2]);
	}

}
