package biblioteca;

import biblioteca.util.EmprestimoHighPrio;
import biblioteca.util.Observer;

public class UsuarioProfessor extends Usuario implements Observer{
	private static int tempoDeEmprestimo = 7;
	private static int limiteDeEmprestimos = Integer.MAX_VALUE;
	private int notificacoes;
	public UsuarioProfessor(String codigo, String nome) {
		super(codigo, nome, new EmprestimoHighPrio());
		notificacoes = 0;
	}

	@Override
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}

	@Override
	public int getQuantidadeMaximaDeEmprestimos() {
		return limiteDeEmprestimos;
	}


	@Override
	public void update() {
		notificacoes++;
	}


	public int getNotificacoes() {
		return notificacoes;
	}	

}
