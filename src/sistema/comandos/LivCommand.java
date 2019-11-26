package sistema.comandos;

import biblioteca.Biblioteca;

public class LivCommand extends Command{

	public LivCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().consultarLivro(args[1]);
	}

}
