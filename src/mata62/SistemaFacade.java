package mata62;

import java.util.HashMap;

public class SistemaFacade {
	private static SistemaFacade sys;
	private HashMap<String,Command> cmds;
	private BancoDeDados base;
	
	private SistemaFacade() {
		cmds = new HashMap<String,Command>();
		base = BancoDeDados.getInstance();
		initCMDS();
	}
	
	private void initCMDS() {
		cmds.put("dev", new DevCommand(base));
	}
	
	public static SistemaFacade getInstance() {
		if(sys==null) {
			sys = new SistemaFacade();
		}
		return sys;
	}
	
	public void doCommand(String cmd, Object args) {
		cmds.get(cmd).execute(args);
	}
}
