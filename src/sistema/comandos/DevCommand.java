package sistema.comandos;

import biblioteca.BancoDeDados;

public class DevCommand extends Command {

	public DevCommand(BancoDeDados b) {
		super(b);
	}
	@Override
	public void execute(Object arg) {
		String args[] = (String[]) arg;
		
		getBase().realizarDevolucao(args[1], args[2]);
	}

}
