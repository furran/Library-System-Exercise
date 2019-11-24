package biblioteca.util;

import biblioteca.Emprestimo;
import biblioteca.Exemplar;
import biblioteca.Livro;
import biblioteca.Reserva;
import biblioteca.Usuario;

public class EmprestimoLowPrio implements EmprestimoBehavior {

	@Override
	public void realizarEmprestimo(Livro livro, Usuario user) {
		String codigoDoLivro = livro.getCodigo();
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
		
		if(user.getQuantidadeMaximaDeEmprestimos()<=user.getQuantidadeDeEmprestimosAtivos()) {//iii) qtd maxima de emprestimos violada
			System.out.println("Erro no emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
					+user.getNome()+"]: O usuario tem quantidade maxima de emprestimos ativos.");
			return;
		}
		
		Reserva r = user.findReserva(codigoDoLivro);
		
		if(livro.getReservas().size() >= livro.getExemplares().size() && r==null) {//iv e v) Reserva maior/igual ao o numero de exemplares e usuario sem reserva
			System.out.println("Erro no emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
					+user.getNome()+"]: O numero de reservas excede o de exemplares.");
			return;
		}
		
		if(user.findEmprestimoAtivo(codigoDoLivro)!=null) {// vi) O usuario ja tem este livro emprestado
			System.out.println("Erro no emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
					+user.getNome()+"]: O usuario ja tem este livro emprestado.");
			return;
		}
		
		Emprestimo e = new Emprestimo(livro,exemplar,user);
		livro.registrarEmprestimo(e);
		if(r!=null) {
			livro.removeReserva(r); //remove a reserva se houver
			user.removeReserva(r);
		}
		user.addEmprestimoAtivo(e);
		user.addHistoricoEmprestimo(e);
		
		System.out.println("Emprestimo do livro ["+livro.getTitulo()+"] para o usuario ["
				+user.getNome()+"] bem sucedido.");
	}

}
