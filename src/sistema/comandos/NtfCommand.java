package sistema.comandos;

import biblioteca.BancoDeDados;

public class NtfCommand extends Command{
	
	

	public NtfCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().consultarNotificacoes(args[1]);
	}
	
}
