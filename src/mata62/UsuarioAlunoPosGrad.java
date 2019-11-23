package mata62;

public class UsuarioAlunoPosGrad extends Usuario{
	
	private static int tempoDeEmprestimo = 4;
	private static int limiteDeEmprestimos = 4;
	public UsuarioAlunoPosGrad(String codigo, String nome) {
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


	@Override
	public void consulta() {

	}


}
