package sistema.comandos;

import biblioteca.BancoDeDados;

public abstract class Command {
	
	private BancoDeDados base;
	
	public Command(BancoDeDados b) {
		this.base = b;
	}
	
	public abstract void execute(Object arg);

	public BancoDeDados getBase() {
		return base;
	}

	public void setBase(BancoDeDados base) {
		this.base = base;
	}
	
	
}
