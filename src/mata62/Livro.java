package mata62;

import java.util.ArrayList;
import java.util.HashMap;

public class Livro {
	private String codigo;
	private String titulo;
	private String editora;
	private String autores;
	private String edicao;
	private String ano;
	
	private ArrayList<Exemplar> exemplares;
	private HashMap<String,Emprestimo> emprestimos;
	private ArrayList<Usuario> reservas; //usuarios com reservas desse livro
	
	public Livro(String codigo, String titulo, String editora, String autores, String edicao, String ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.ano = ano;
		
		exemplares = new ArrayList<Exemplar>();
		emprestimos = new HashMap<String,Emprestimo>();
		reservas = new ArrayList<Usuario>();
	}
	
	public void addExemplar(Exemplar e) {
		exemplares.add(e);
	}
	
	public void removeExemplar(Exemplar e) {
		exemplares.remove(e);
	}
	
	public void addReserva(Usuario user) {
		reservas.add(user);
	}
	
	public Exemplar findExemplar(String codigo) {
		Exemplar e;
		for(int i=0;i<exemplares.size();i++) {
			e = (Exemplar)exemplares.get(i);
			if(e.getCodigo().equals(codigo)) {
				return e;
			}
		}
		return null;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public String getAutores() {
		return autores;
	}

	public String getEdicao() {
		return edicao;
	}

	public String getAno() {
		return ano;
	}

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public ArrayList<Usuario> getReservas() {
		return reservas;
	}

	
}
