package mata62;

import java.util.Calendar;

public class Emprestimo {
	private Livro livro;
	private Exemplar exemplar;
	private Usuario user;
	private Calendar dataDoEmprestimo;
	private Calendar dataDaDevolucao;
	private boolean finalizado;
	
	public Emprestimo(Exemplar exemplar, Usuario user, Calendar dataDoEmprestimo, Calendar dataDaDevolucao, boolean status) {
		super();
		this.exemplar = exemplar;
		this.user = user;
		this.dataDoEmprestimo = dataDoEmprestimo;
		this.dataDaDevolucao = dataDaDevolucao;
		this.finalizado = status;
	}


	public Emprestimo(Exemplar exemplar, Usuario user) {
		super();
		this.exemplar = exemplar;
		this.user = user;
		this.dataDoEmprestimo = Calendar.getInstance();
		this.dataDaDevolucao = Calendar.getInstance();
		this.dataDaDevolucao.add(Calendar.DATE, user.getTempoDeEmprestimo());
		
		this.finalizado = false;
	}
	
	public void consulta() {
		
	}

	public Livro getLivro() {
		return livro;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public String getCodigoDoExemplar() {
		return exemplar.getCodigo();
	}
	
	public String getCodigoDoLivro() {
		return livro.getTitulo();
	}


	public Usuario getUser() {
		return user;
	}


	public Calendar getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}


	public Calendar getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean stat) {
		this.finalizado = stat;
	}
	
}
