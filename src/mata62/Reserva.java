package mata62;

import java.util.Calendar;

public class Reserva {
	private Livro livro;
	private Calendar dataDaSolicitacao;
	
	public Reserva(Livro livro) {
		this.livro = livro;
		this.dataDaSolicitacao = Calendar.getInstance();
	}
}
