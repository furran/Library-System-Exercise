package biblioteca;

import java.util.ArrayList;
import biblioteca.util.DataFormato;
import biblioteca.util.Observer;
import biblioteca.util.Subject;

public class Livro implements Subject{
	
	private ArrayList<Observer> observers; //observadores
	
	private String codigo;
	private String titulo;
	private String editora;
	private String autores;
	private String edicao;
	private int ano;

	private ArrayList<Exemplar> exemplares;
	private ArrayList<Emprestimo> emprestimos;
	private ArrayList<Reserva> reservas;

	public Livro(String codigo, String titulo, String editora, String autores, String edicao, int ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.ano = ano;
		
		observers = new ArrayList<Observer>();
		
		exemplares = new ArrayList<Exemplar>();
		emprestimos = new ArrayList<Emprestimo>();
		reservas = new ArrayList<Reserva>();
	}
	
	//emprestimo,devolucao,reserva
	
	public void registrarReserva(Reserva r) {
		addReserva(r);
		if(reservas.size()>=2)notifyObservers();
	}
	
	public void registrarEmprestimo(Emprestimo e) {
		e.getExemplar().setDisponivel(false);
		addEmprestimo(e);
	}
	
	public void realizarDevolucao(Emprestimo e) {
		e.getExemplar().setDisponivel(true);
		removeEmprestimo(e);
	}
	
	public void consulta(){
		System.out.println("Titulo: "+this.getTitulo());
		int resSize = this.getReservas().size();
		
		System.out.println("Usuarios com Reservas: "+resSize);
		for(int i=0;i<resSize;i++) {
			System.out.println("   + "+this.getReservas().get(i).getUsuario().getNome());
		}
		
		int exemplaresSize = this.getExemplares().size();
		System.out.println("Exemplares: "+exemplaresSize);
		Exemplar exemplar;
		Emprestimo empr;
		for(int i=0;i<exemplaresSize;i++) {
			exemplar = this.getExemplares().get(i);
			System.out.println("   + "+exemplar.consulta());
			if(exemplar.isDisponivel()==false) {
				empr = this.findEmprestimo(exemplar.getCodigo());
				System.out.println("     - Usuario: "+empr.getUsuario().getNome()
						+" | Data do Emprestimo: "+DataFormato.formatar(empr.getDataDoEmprestimo().getTime())
						+" | Data de Devolucao: "+DataFormato.formatar(empr.getDataDaDevolucao().getTime()));
			}
		}
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
	
	public Emprestimo findEmprestimo(String codigo) {
		Emprestimo e;
		for(int i=0;i<emprestimos.size();i++) {
			e = (Emprestimo) emprestimos.get(i);
			if(e.getCodigoDoExemplar() == codigo) {
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
	
	//funcoes do subject

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}


	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}


	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update();
		}
	}

	//add/removes
	
	public void addExemplar(Exemplar e) {
		exemplares.add(e);
	}
	
	public void removeExemplar(Exemplar e) {
		exemplares.remove(e);
	}
	
	public void addReserva(Reserva r) {
		reservas.add(r);
	}
	
	public void removeReserva(Reserva r) {
		reservas.remove(r);
	}
	
	private void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
	}
	
	private void removeEmprestimo(Emprestimo e) {
		emprestimos.remove(e);
	}
	
	//gets/sets etc
	
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

	public int getAno() {
		return ano;
	}
	
	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}
	
	public ArrayList<Emprestimo> getEmprestimos(){
		return emprestimos;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

}
