package biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

import biblioteca.util.EmprestimoBehavior;

public abstract class Usuario {
	private String codigo;
	private String nome;
	private EmprestimoBehavior emprestimoBehavior;
	private ArrayList<Emprestimo> emprestimosAtivos;
	private ArrayList<Emprestimo> historicoEmprestimos;
	private ArrayList<Reserva> reservas;
	
	public Usuario(String codigo, String nome, EmprestimoBehavior emp) {
		this.codigo = codigo;
		this.nome = nome;
		this.emprestimoBehavior = emp;
		this.emprestimosAtivos = new ArrayList<Emprestimo>();
		this.historicoEmprestimos = new ArrayList<Emprestimo>();
		this.reservas = new ArrayList<Reserva>();
		
	}
	
	public abstract int getTempoDeEmprestimo();
	public abstract int getQuantidadeMaximaDeEmprestimos();
	
	
	public void realizarEmprestimo(Livro livro) {
		emprestimoBehavior.realizarEmprestimo(livro, this);
	}
	
	
	public void realizarDevolucao(Livro livro) {
		Emprestimo e = findEmprestimoAtivo(livro.getCodigo());
		
		if(e==null) {
			System.out.println("Erro na devolucao do livro ["+livro.getTitulo()+"] para o usuario ["
					+this.getNome()+"]: O usuario nao tem um emprestimo deste livro.");
			
			return;
		}
		
		e.setFinalizado(true);
		this.emprestimosAtivos.remove(e);
		livro.realizarDevolucao(e);
		System.out.println("Devolucao do livro ["+e.getLivro().getTitulo()+"] para o usuario ["
				+this.getNome()+"] bem sucedida.");
	}

	public void realizarReserva(Livro livro) {
		
		if(livro == null) {
			System.out.println(
					"Falha na reserva do livro pelo usuario ["+this.getNome()+"]: Este livro nao existe."
				);
			return;
		}
		
		
		if(reservas.size()>=3) {
			System.out.println(
					"Falha na reserva do livro ["+livro.getTitulo()
				+"]: Limite de reservas excedido pelo usuario ["+this.getNome()+"]."
				);
			return;
		}
		Reserva r = findReserva(livro.getCodigo());
		
		if(r!=null) {
			System.out.println(
					"Falha na reserva do livro ["+livro.getTitulo()
				+"]: O usuario ["+this.getNome()+"] ja reservou esse livro."
				);
			return;
		}
		
		Emprestimo e = findEmprestimoAtivo(livro.getCodigo());
		
		if(e!=null) {
			System.out.println(
					"Falha na reserva do livro ["+livro.getTitulo()
				+"]: O usuario ["+this.getNome()+"] ja tem um emprestimo desse livro."
				);
			return;
		}
		
		 r = new Reserva(livro, this);
			System.out.println("REserva: "+r.getCodigoDoLivro());
		addReserva(r);
		livro.registrarReserva(r);
		System.out.println("Reserva do livro [" + livro.getTitulo() + "] pelo usuario [" 
		+ this.getNome() + "] bem sucedida");
	}
	
	public boolean temEmprestimoAtrasado() {
		Calendar cal = Calendar.getInstance();
		for(Emprestimo e : emprestimosAtivos) {
			if(e.getDataDaDevolucao().compareTo(cal)<0) {
				return true;
			}
		}
		return false;
	}
	
	
	public Reserva findReserva(String codigoDoLivro) {
		for(Reserva r : reservas) {
			if(r.getCodigoDoLivro().equals(codigoDoLivro)) {
				return r; 
			}
		}
		return null;
	}
	
	public Emprestimo findEmprestimoAtivo(String codigoDoLivro) {
		for(Emprestimo e : emprestimosAtivos) {
			if(e.getCodigoDoLivro().equals(codigoDoLivro)) {
				return e; 
			}
		}
		return null;
	}

	
	public void addReserva(Reserva r) {
		reservas.add(r);
	}
	
	public void removeReserva(Reserva r) {
		reservas.remove(r);
	}
	
	public void addEmprestimoAtivo(Emprestimo e) {
		emprestimosAtivos.add(e);
	}
	
	public void addHistoricoEmprestimo(Emprestimo e) {
		historicoEmprestimos.add(e);
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidadeDeEmprestimosAtivos() {
		return emprestimosAtivos.size();
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<Emprestimo> getHistoricoEmprestimos() {
		return historicoEmprestimos;
	}

	public ArrayList<Emprestimo> getEmprestimosAtivos() {
		return emprestimosAtivos;
	}
	
}
