package mata62;

public class EmprestimoHighPrio implements EmprestimoBehavior {

	@Override
	public void realizarEmprestimo(Livro livro, Usuario user) {
		Exemplar exemplar = livro.getExemplarDisponivel();
		if(exemplar == null) { //i) Sem exemplares disponiveis
			System.out.println("Erro no emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
					+user.getNome()+"]: Nao ha exempares disponiveis.");
			return;
		}
		
		if(user.temEmprestimoAtrasado()) {//ii) Usuario devedor
			System.out.println("Erro no emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
					+user.getNome()+"]: O usuario tem emprestimos atrasados.");
			return;
		}
		
		Emprestimo e = new Emprestimo(exemplar,user);
		livro.registrarEmprestimo(e);
		user.addEmprestimoAtivo(e);
		user.addHistoricoEmprestimo(e);
		
		System.out.println("Emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
				+user.getNome()+"] bem sucedido.");
	}

}
