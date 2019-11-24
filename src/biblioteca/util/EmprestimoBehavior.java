package biblioteca.util;

import biblioteca.Livro;
import biblioteca.Usuario;

public interface EmprestimoBehavior {
	public void realizarEmprestimo(Livro livro, Usuario user);
}
