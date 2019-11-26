package sistema.comandos;

import biblioteca.Biblioteca;

public class UsuCommand extends Command{

	public UsuCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().consultarUsuario(args[1]);
	}

}
