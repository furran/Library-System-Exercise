package mata62;

import java.util.HashMap;

public abstract class Usuario {
	private String codigo;
	private String nome;
	private HashMap<String,Emprestimo> emprestimos;
	private HashMap<String,Reserva> reservas;
	
	public Usuario(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;

		this.emprestimos = new HashMap<String, Emprestimo>();
		this.reservas = new HashMap<String,Reserva>();
		
	}
	
	public abstract void realizarEmprestimo(Livro livro);
	public abstract void consulta();
	public abstract int getTempoDeEmprestimo();
	
	public void realizarDevolucao(Emprestimo emprestimo) {
		
	}
	
	public void registrarReserva(Livro livro) {
		if(reservas.size()>3) {
			System.out.println("Falha na reserva do livro ["+livro.getTitulo()
				+"]: Limite de reservas excedido pelo usuario ["+this.getNome()+"].");
			return;
		}
		
		reservas.put(livro.getCodigo(), new Reserva(livro));
		
		System.out.println("Reserva do livro [" + livro.getTitulo() + "] pelo usuario [" 
		+ this.getNome() + "] bem sucedida");
	}
	
	public void listarEmprestimos() {
		System.out.println("Historico de Emprestimos:");
		for(Emprestimo emp : emprestimos.values()) {
			System.out.println();
		}
	}
	
	public void listarReservas() {
		for(Reserva r : reservas.values()) {
			System.out.println("Titulo: ");
		}
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
	
	public HashMap<String, Reserva> getReservas() {
		return reservas;
	}

	public HashMap<String, Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	
	
}
