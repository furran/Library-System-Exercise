package mata62;

import java.util.ArrayList;
import java.util.TreeMap;

public class Livro {
	private String codigo;
	private String titulo;
	private String editora;
	private String autores;
	private String edicao;
	private String ano;

	private ArrayList<Exemplar> exemplares;
	private ArrayList<Emprestimo> emprestimos; // mapeia codigo do exemplar para emprestimo ativo desse livro
	private ArrayList<Reserva> reservas; //lista de reserva desse livro
	
	public Livro(String codigo, String titulo, String editora, String autores, String edicao, String ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.ano = ano;
		
		exemplares = new ArrayList<Exemplar>();
		emprestimos = new ArrayList<Emprestimo>();
		reservas = new ArrayList<Reserva>();
	}
	
	public void addExemplar(Exemplar e) {
		exemplares.add(e);
	}
	
	public void removeExemplar(Exemplar e) {
		exemplares.remove(e);
	}
	
	public void registrarReserva(Reserva r) {
		reservas.add(r);
	}
	
	private void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
	}
	
	private void removeEmprestimo(Emprestimo e) {
		emprestimos.remove(e);
	}
	
	public void registrarEmprestimo(Emprestimo e) {
		e.getExemplar().setDisponivel(false);
		addEmprestimo(e);
	}
	
	public void realizarDevolucao(Emprestimo e) {
		e.getExemplar().setDisponivel(true);
		removeEmprestimo(e);
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
	
	public Exemplar getExemplarDisponivel() {
		for(Exemplar e : exemplares) {
			if(e.isDisponivel()) return e;
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

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	
}
