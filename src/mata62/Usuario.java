package mata62;

public abstract class Usuario {
	private String codigo;
	private String nome;
	private int tempoDeEmprestimo;
	public Usuario(String codigo, String nome, int tempo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tempoDeEmprestimo = tempo;
	}
	
	public abstract void realizarEmprestimo();
	public abstract void realizarReserva();
	public abstract void realizarDevolucao();
	
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
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}
	public void setTempoDeEmprestimo(int tempoDeEmprestimo) {
		this.tempoDeEmprestimo = tempoDeEmprestimo;
	}
	
}
