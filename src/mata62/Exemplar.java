package mata62;

public class Exemplar {
	private Livro livro;
	private String codigo;
	private boolean disponivel;
	
	public Exemplar(Livro livro,String codigo, boolean status) {
		this.livro = livro;
		this.codigo = codigo;
		this.disponivel = status;
	}
	
	public Exemplar(Livro livro,String codigo) {
		this.livro = livro;
		this.codigo = codigo;
		this.disponivel = true;
	}
	
	public String getTitulo() {
		return livro.getTitulo();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean status) {
		this.disponivel = status;
	}
	
}
