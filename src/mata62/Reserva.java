package mata62;

import java.util.Calendar;

public class Reserva {
	private Livro livro;
	private Calendar dataDaSolicitacao;
	
	public Reserva(Livro livro) {
		this.livro = livro;
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
}
