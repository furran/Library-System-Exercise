package sistema.comandos;

import java.util.HashMap;
import java.util.Locale;

import biblioteca.BancoDeDados;

public class Sistema {
	private static Sistema sys;
	private HashMap<String,Command> cmds;
	private BancoDeDados base;
	
	private Sistema() {
		cmds = new HashMap<String,Command>();
		base = BancoDeDados.getInstance();
		initCMDS();
	}
	
	private void initCMDS() {
		cmds.put("res", new ResCommand(base));
		cmds.put("emp", new EmpCommand(base));
		cmds.put("liv", new LivCommand(base));
		cmds.put("dev", new DevCommand(base));
		cmds.put("usu", new UsuCommand(base));
		cmds.put("ntf", new NtfCommand(base));
		cmds.put("obs", new ObsCommand(base));
		cmds.put("sai", new SaiCommand(base));
	}
	
	public static Sistema getInstance() {
		if(sys==null) {
			sys = new Sistema();
		}
		return sys;
	}
	
	public void doCommand(String cmd, Object args) {
		cmd.toLowerCase(Locale.ROOT);
		Command com = cmds.get(cmd);
		if(com == null) {
			System.out.println("Comando ["+cmd+"] invalido.");
			return;
		}
		cmds.get(cmd).execute(args);
	}
}
