package mata62;

public class SistemaFacade {
	private static SistemaFacade sys;
	private SistemaFacade() {
	}
	
	public static SistemaFacade getInstance() {
		if(sys==null) {
			sys = new SistemaFacade();
		}
		return sys;
	}
}
