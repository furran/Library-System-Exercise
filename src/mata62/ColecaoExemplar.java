package mata62;

import java.util.ArrayList;

public class ColecaoExemplar {
	private ArrayList<Exemplar> listaDeExemplares;
	
	public ColecaoExemplar() {
		listaDeExemplares = new ArrayList<Exemplar>();
	}
	
	public void addExemplar(Exemplar e) {
		listaDeExemplares.add(e);
	}
	
	public void removeExemplar(Exemplar e) {
		listaDeExemplares.remove(e);
	}
	
	public Exemplar getExemplar(String codigo) {
		Exemplar e;
		for(int i=0;i<listaDeExemplares.size();i++) {
			e = (Exemplar)listaDeExemplares.get(i);
			if(e.getCodigo().equals(codigo)) {
				return e;
			}
		}
		return null;
	}
}
