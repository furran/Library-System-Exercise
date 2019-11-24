package biblioteca;

import biblioteca.util.EmprestimoLowPrio;

public class UsuarioAlunoGrad extends Usuario{

	private static int tempoDeEmprestimo = 3;
	private static int limiteDeEmprestimos = 3;
	public UsuarioAlunoGrad(String codigo, String nome) {
		super(codigo, nome, new EmprestimoLowPrio());
	}

	@Override
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}

	@Override
	public int getQuantidadeMaximaDeEmprestimos() {
		return limiteDeEmprestimos;
	}

}
