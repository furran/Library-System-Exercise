package mata62;

public class DevCommand implements Command {
	private BancoDeDados base;
	
	public DevCommand(BancoDeDados b) {
		this.base = b;
	}
	@Override
	public void execute(Object arg) {
		
	}

}
