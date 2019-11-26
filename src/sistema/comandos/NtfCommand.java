package sistema.comandos;

import biblioteca.Biblioteca;

public class NtfCommand extends Command{
	
	public NtfCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().consultarNotificacoes(args[1]);
	}
	
}
