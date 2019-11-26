package biblioteca;

import java.util.Calendar;

public class Emprestimo {
	private Livro livro;
	private Exemplar exemplar;
	private Usuario usuario;
	private Calendar dataDoEmprestimo;
	private Calendar dataDaDevolucao;
	private boolean finalizado;
	
	public Emprestimo(Livro livro, Exemplar exemplar, Usuario user, Calendar dataDoEmprestimo, Calendar dataDaDevolucao, boolean status) {
		super();
		this.livro = livro;
		this.exemplar = exemplar;
		this.usuario = user;
		this.dataDoEmprestimo = dataDoEmprestimo;
		this.dataDaDevolucao = dataDaDevolucao;
		this.finalizado = status;
	}


	public Emprestimo(Livro livro,Exemplar exemplar, Usuario user) {
		super();
		this.livro = livro;
		this.exemplar = exemplar;
		this.usuario = user;
		this.dataDoEmprestimo = Calendar.getInstance();
		this.dataDaDevolucao = Calendar.getInstance();
		this.dataDaDevolucao.add(Calendar.DATE, user.getTempoDeEmprestimo());
		
		this.finalizado = false;
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
		return livro.getCodigo();
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public Calendar getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}

	public Calendar getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public void setDataDaDevolucao(Calendar dataDaDevolucao) {
		this.dataDaDevolucao = dataDaDevolucao;
	}


	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean stat) {
		this.finalizado = stat;
	}
	
}
