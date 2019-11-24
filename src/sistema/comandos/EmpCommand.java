package sistema.comandos;

import biblioteca.BancoDeDados;

public class EmpCommand extends Command{
	
	public EmpCommand(BancoDeDados b) {
		super(b);
	}

	@Override
	public void execute(Object arg) {
		String args[] = (String[]) arg;
		getBase().realizarEmprestimo(args[1], args[2]);;
	}
	
}
