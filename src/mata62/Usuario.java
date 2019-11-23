package mata62;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

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
	
	
	public abstract void consulta();
	public abstract int getTempoDeEmprestimo();
	public abstract int getQuantidadeMaximaDeEmprestimos();
	
	public void realizarDevolucao(Livro livro) {
		Emprestimo e = findEmprestimoAtivo(livro.getCodigo());
		
		if(e==null) {
			System.out.println("Erro na devolucao do livro ["+livro.getTitulo()+"] para o usuario ["
					+this.getNome()+"]: O usuario nao tem um emprestimo deste livro.");
			
			return;
		}
		
		e.setFinalizado(true);
		this.emprestimosAtivos.remove(e);
		e.getLivro().realizarDevolucao(e);
		System.out.println("Devolucao do livro ["+e.getLivro().getTitulo()+"] para o usuario ["
				+this.getNome()+"] bem sucedida.");
	}
	
	public void registrarEmprestimo(Livro livro) {
		emprestimoBehavior.realizarEmprestimo(livro, this);
	}
	
	public boolean registrarReserva(Livro livro) {
		if(reservas.size()>3) {
			System.out.println(
					"Falha na reserva do livro ["+livro.getTitulo()
				+"]: Limite de reservas excedido pelo usuario ["+this.getNome()+"]."
				);
			return false;
		}
		
		if(livro == null) {
			System.out.println(
					"Falha na reserva do livro pelo usuario ["+this.getNome()+"]: Este livro nao existe."
				);
		}
		
		Reserva r = new Reserva(livro);
		
		addReserva(r);
		livro.registrarReserva(r);
		System.out.println("Reserva do livro [" + livro.getTitulo() + "] pelo usuario [" 
		+ this.getNome() + "] bem sucedida");
		
		return true;
	}
	
	public void listarEmprestimos() {
		System.out.println("Historico de Emprestimos:");
		for(Emprestimo emp : historicoEmprestimos) {
			System.out.println();
		}
	}
	
	public void listarReservas() {
		for(Reserva r : reservas) {
			System.out.println("Titulo: ");
		}
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
	
	protected void addReserva(Reserva r) {
		reservas.add(r);
	}
	
	protected void addEmprestimoAtivo(Emprestimo e) {
		emprestimosAtivos.add(e);
	}
	
	protected void addHistoricoEmprestimo(Emprestimo e) {
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

	public ArrayList<Emprestimo> getEmprestimosAtivos() {
		return emprestimosAtivos;
	}
	
}
