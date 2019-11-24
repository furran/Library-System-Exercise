package biblioteca.util;

import biblioteca.Emprestimo;
import biblioteca.Exemplar;
import biblioteca.Livro;
import biblioteca.Reserva;
import biblioteca.Usuario;

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
		
		Emprestimo e = new Emprestimo(livro,exemplar,user);
		livro.registrarEmprestimo(e);
		user.addEmprestimoAtivo(e);
		user.addHistoricoEmprestimo(e);
		Reserva r = user.findReserva(livro.getCodigo());
		if(r!=null) {
			livro.removeReserva(r); //remove a reserva se houver
			user.removeReserva(r);
		}
		
		System.out.println("Emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
				+user.getNome()+"] bem sucedido.");
	}

}
