package biblioteca;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TreeMap;

import biblioteca.util.Observer;

public class BancoDeDados {
	private static BancoDeDados instance;
	private TreeMap<String,Livro> livros; //mapeia codigo do livro para o livro.
	private TreeMap<String,Usuario> usuarios; //mapeia o codigo do usuario para o usuario.
	
	private DateFormat dateFormat;
	
	private BancoDeDados() {
		livros = new TreeMap<String,Livro>();
		usuarios = new TreeMap<String,Usuario>();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		preload();
	}
	
	private void preload() {
		//usuarios
		addUsuario(new UsuarioAlunoGrad("123", "Joao da Silva"));
		addUsuario(new UsuarioAlunoPosGrad("456", "Luiz Fernando Rodrigues"));
		addUsuario(new UsuarioAlunoGrad("789", "Pedro Paulo"));
		addUsuario(new UsuarioProfessor("100", "Carlos Lucena"));
		//livros e exemplares
		Livro livro = new Livro("100","Engenharia de Software","Adisson-Wesley","Ian Sommervile","6a",2000);
		livro.addExemplar(new Exemplar("01"));
		livro.addExemplar(new Exemplar("02"));
		addLivro(livro);
		livro = new Livro("101","UML - Guia do Usuario","Campus","Grady Booch, James Rumbaugh, Ivar Jacobson","7a",2000);
		livro.addExemplar(new Exemplar("03"));
		addLivro(livro);
		livro = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnel", "2a", 2014);
		livro.addExemplar(new Exemplar("04"));
		addLivro(livro);
		livro = new Livro("201","Agile Software Development Principles, Patterns and Practices", "Prentice Hall", "Robert Martin", "1a", 2002);
		livro.addExemplar(new Exemplar("05"));
		addLivro(livro);
		livro = new Livro("300","Refaactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1a", 1999);
		livro.addExemplar(new Exemplar("06"));
		livro.addExemplar(new Exemplar("07"));
		addLivro(livro);
		livro = new Livro("301","Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3a", 2014);
		addLivro(livro);
		livro = new Livro("400","Design Paatterns: Elemnts of Reusable Object-Oriented Software","Addison-Wesley Professional","Erich Gamma, Richar Helm, Ralph Johnson, John Vlissides","1a",1994);
		livro.addExemplar(new Exemplar("08"));
		livro.addExemplar(new Exemplar("09"));
		addLivro(livro);
		livro = new Livro("401","UML Distilled: A Brief Guide to the Standard Object Modeling Language","Addison-Wesley Professional","Martin Fowler","3a",2003);
		addLivro(livro);
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
		user.realizarEmprestimo(livro);
	}
	
	public void realizarDevolucao(String codigoDoUsuario, String codigoDoLivro) {
		Livro livro = findLivro(codigoDoLivro);
		Usuario user = findUsuario(codigoDoUsuario);
		if(livro == null) {
			System.out.println("Este livro nao existe.");
			return; 
		}
		if(user == null) {
			System.out.println("Este usuario nao existe.");
			return; 
		}
		user.realizarDevolucao(livro);
	}
	
	public void realizarReserva(String codigoDoUsuario, String codigoDoLivro) {
		Livro livro = findLivro(codigoDoLivro);
		Usuario user = findUsuario(codigoDoUsuario);
		if(livro == null) {
			System.out.println("Este livro nao existe.");
			return; 
		}
		if(user == null) {
			System.out.println("Este usuario nao existe.");
			return; 
		}
		user.realizarReserva(livro);
	}
	
	public void registrarObserver(String codigoDoUsuario, String codigoDoLivro) {
		Livro livro = findLivro(codigoDoLivro);
		Usuario user = findUsuario(codigoDoUsuario);
		Observer obs = (Observer) user;
		if(livro == null) {
			System.out.println("Este livro nao existe.");
			return; 
		}
		if(user == null) {
			System.out.println("Este usuario nao existe.");
			return; 
		}
		
		livro.registerObserver(obs);
		System.out.println("O usuario ["+user.getNome()
				+"] agora esta observando as reservas de ["
				+livro.getTitulo()+"]."
				);
	}
	
	public void consultarLivro(String codigoDoLivro) {
		Livro livro = findLivro(codigoDoLivro);
		
		if(livro == null) {
			System.out.println("Este livro nao existe.");
			return;
		}
		
		System.out.println("Titulo: "+livro.getTitulo());
		int resSize = livro.getReservas().size();
		
		System.out.println("Usuarios com Reservas: "+resSize);
		for(int i=0;i<resSize;i++) {
			System.out.println("   + "+livro.getReservas().get(i).getUsuario().getNome());
		}
		
		int exemplaresSize = livro.getExemplares().size();
		System.out.println("Exemplares: "+exemplaresSize);
		Exemplar exemplar;
		Emprestimo empr;
		for(int i=0;i<exemplaresSize;i++) {
			exemplar = livro.getExemplares().get(i);
			System.out.println("   + "+exemplar.consulta());
			if(exemplar.isDisponivel()==false) {
				empr = livro.findEmprestimo(exemplar.getCodigo());
				System.out.println("     - "+empr.getUsuario().getNome()
						+"| Data do Emprestimo: "+dateFormat.format(empr.getDataDoEmprestimo().getTime())
						+"| Data de Devolucao: "+dateFormat.format(empr.getDataDaDevolucao().getTime()));
			}
		}
	}
	
	public void consultarUsuario(String codigoDoUsuario) {
		Usuario user = findUsuario(codigoDoUsuario);
		
		if(user == null) {
			System.out.println("Este usuario nao existe.");
			return;
		}
		
		System.out.println("Emprestimos Ativos: ");
		int size =user.getEmprestimosAtivos().size();
		Emprestimo emp;
		
		
		
		for(int i=0;i<size;i++) {
			
			
			
			
			emp = user.getEmprestimosAtivos().get(i);
			System.out.println("   + Titulo: "+emp.getLivro().getTitulo()
					+"| Data do Emprestimo: "+dateFormat.format(emp.getDataDoEmprestimo().getTime())
					+"| Data de Devolucao: "+dateFormat.format(emp.getDataDaDevolucao().getTime())
					+"| Status: "+(emp.isFinalizado()?"Finalizado":"Em aberto"));
		}
		System.out.println("Historico de Emprestimos: ");
		size = user.getHistoricoEmprestimos().size();
		for(int i=0;i<size;i++) {
			emp = user.getHistoricoEmprestimos().get(i);
			System.out.println("   + Titulo: "+emp.getLivro().getTitulo()
					+"| Data do Emprestimo: "+dateFormat.format(emp.getDataDoEmprestimo().getTime())
					+"| Data de Devolucao: "+dateFormat.format(emp.getDataDaDevolucao().getTime())
					+"| Status: "+(emp.isFinalizado()?"Finalizado":"Em aberto"));
		}
		
		System.out.println("Reservas: ");
		size = user.getReservas().size();
		Reserva reserva;
		for(int i =0;i<size;i++) {
			reserva = user.getReservas().get(i);
			System.out.println("   + Titulo: "+reserva.getLivro().getTitulo()
					+"| Data da reserva: "+dateFormat.format(reserva.getDataDaSolicitacao().getTime()));
		}
	}
	
	public void consultarNotificacoes(String codigoDoUsuario) {
		UsuarioProfessor user = (UsuarioProfessor) findUsuario(codigoDoUsuario);
		if(user == null) {
			System.out.println("Este usuario nao existe.");
			return;
		}
		System.out.println("O usuario ["+user.getNome()+"] foi notificado "+user.getNotificacoes()+" vezes.");
	}

	private void addLivro(Livro livro) {
		livros.put(livro.getCodigo(), livro);
	}
	
	private void addUsuario(Usuario user) {
		usuarios.put(user.getCodigo(), user);
	}
	
	private Livro findLivro(String codigo) {
		return livros.get(codigo);
	}
	
	private Usuario findUsuario(String codigo) {
		return usuarios.get(codigo);
	}

}
