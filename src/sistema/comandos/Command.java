package sistema.comandos;

import biblioteca.Biblioteca;

public abstract class Command {
	
	private Biblioteca base;
	
	public Command(Biblioteca b) {
		this.base = b;
	}
	
	public abstract void execute(Object arg);

	public Biblioteca getBase() {
		return base;
	}

	public void setBase(Biblioteca base) {
		this.base = base;
	}
	
	
}
