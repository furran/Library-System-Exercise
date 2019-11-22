package mata62;

import java.util.ArrayList;
import java.util.HashMap;

public class BancoDeDados {
	private static BancoDeDados instance;
	private HashMap<String,Livro> livros; //mapeia codigo do livro para o livro.
	private HashMap<String,Usuario> usuarios; //mapeia o codigo do usuario para o usuario.
	
	private BancoDeDados() {
		livros = new HashMap<String,Livro>();
		usuarios = new HashMap<String,Usuario>();
	}
	
	public static BancoDeDados getInstance() {
		if(instance == null) {
			instance = new BancoDeDados();
		}
		return instance;
	}

	public void addLivro(Livro livro) {
		livros.put(livro.getCodigo(), livro);
	}
	
	public void addUsuario(Usuario user) {
		usuarios.put(user.getCodigo(), user);
	}
	
	public Livro findLivro(String codigo) {
		return livros.get(codigo);
	}
	
	public Usuario findUsuario(String codigo) {
		return usuarios.get(codigo);
	}

	public void addExemplar(String codigoDoLivro, Exemplar exemplar) {
		livros.get(codigoDoLivro).addExemplar(exemplar);
	}

}
