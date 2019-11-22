package mata62;

public class UsuarioAlunoGrad extends Usuario{

	private static int tempoDeEmprestimo = 3;
	public UsuarioAlunoGrad(String codigo, String nome) {
		super(codigo, nome);
	}
	
	@Override
	public void consulta() {
		System.out.println("Codigo do usuario: "+ this.getCodigo()+ "\n"
				+ "Nome: "+this.getNome()+"\n"
				);
	}

	@Override
	public void realizarEmprestimo(Livro livro) {
		this.
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
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}

}
