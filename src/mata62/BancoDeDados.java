package mata62;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class BancoDeDados {
	private static BancoDeDados instance;
	private TreeMap<String,Livro> livros; //mapeia codigo do livro para o livro.
	private TreeMap<String,Usuario> usuarios; //mapeia o codigo do usuario para o usuario.
	
	private BancoDeDados() {
		livros = new TreeMap<String,Livro>();
		usuarios = new TreeMap<String,Usuario>();
	}
	
	public static BancoDeDados getInstance() {
		if(instance == null) {
			instance = new BancoDeDados();
		}
		return instance;
	}
	
	public void realizarEmprestimo(String codigoDoUsuario,String codigoDoLivro) {
		Livro livro = findLivro(codigoDoLivro);
		Usuario user = findUsuario(codigoDoUsuario);
		user.registrarEmprestimo(livro);
	}
	
	public void realizarDevolucao() {
		
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
