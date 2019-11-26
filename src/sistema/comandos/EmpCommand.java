package sistema.comandos;

import biblioteca.Biblioteca;

public class EmpCommand extends Command{
	
	public EmpCommand() {
		super(Biblioteca.getInstance());
	}

	@Override
	public void execute(Object arg) {
		String args[] = (String[]) arg;
		getBase().realizarEmprestimo(args[1], args[2]);;
	}
	
}
