package sistema.comandos;

import biblioteca.BancoDeDados;

public class LivCommand extends Command{

	public LivCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().consultarLivro(args[1]);
	}

}
