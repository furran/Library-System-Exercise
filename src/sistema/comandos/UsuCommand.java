package sistema.comandos;

import biblioteca.BancoDeDados;

public class UsuCommand extends Command{

	public UsuCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		String[] args = (String[]) arg;
		getBase().consultarUsuario(args[1]);
	}

}
