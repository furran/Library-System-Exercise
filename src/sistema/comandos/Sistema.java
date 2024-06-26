package sistema.comandos;

import java.util.HashMap;
import java.util.Locale;

public class Sistema {
	private HashMap<String,Command> cmds;
	
	public Sistema() {
		cmds = new HashMap<String,Command>();
		initCMDS();
	}
	
	private void initCMDS() {
		cmds.put("res", new ResCommand());
		cmds.put("emp", new EmpCommand());
		cmds.put("liv", new LivCommand());
		cmds.put("dev", new DevCommand());
		cmds.put("usu", new UsuCommand());
		cmds.put("ntf", new NtfCommand());
		cmds.put("obs", new ObsCommand());
		cmds.put("sai", new SaiCommand());
	}

	public void doCommand(String cmd, Object args) {
		cmd.toLowerCase(Locale.ROOT);
		Command com = cmds.get(cmd);
		if(com == null) {
			System.out.println("Comando ["+cmd+"] invalido.");
			return;
		}
		com.execute(args);
	}
}
