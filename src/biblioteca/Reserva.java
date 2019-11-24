package biblioteca;

import java.util.Calendar;

public class Reserva {
	private Livro livro;
	private Usuario usuario;
	private Calendar dataDaSolicitacao;
	
	public Reserva(Livro livro, Usuario user) {
		this.livro = livro;
		this.usuario = user;
		this.dataDaSolicitacao = Calendar.getInstance();
	}
	
	public String getCodigoDoLivro() {
		return livro.getCodigo();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public Calendar getDataDaSolicitacao() {
		return dataDaSolicitacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
