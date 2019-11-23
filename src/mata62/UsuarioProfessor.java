package mata62;

public class UsuarioProfessor extends Usuario{
	
	private static int tempoDeEmprestimo = 7;
	private static int limiteDeEmprestimos = Integer.MAX_VALUE;
	public UsuarioProfessor(String codigo, String nome) {
		super(codigo, nome, new EmprestimoHighPrio());
	}


	@Override
	public void consulta() {
		// TODO Auto-generated method stub
		
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
