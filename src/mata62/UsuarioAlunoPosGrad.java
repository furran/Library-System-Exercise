package mata62;

public class UsuarioAlunoPosGrad extends Usuario{
	
	private static int tempoDeEmprestimo = 4;
	
	public UsuarioAlunoPosGrad(String codigo, String nome) {
		super(codigo, nome);
	}

	@Override
	public void realizarEmprestimo(Exemplar exemplar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarReserva(Livro livro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarDevolucao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTempoDeEmprestimo() {
		// TODO Auto-generated method stub
		return tempoDeEmprestimo;
	}


}
