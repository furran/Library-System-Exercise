package mata62;

public class Exemplar {
	private String codigo;
	private boolean disponivel;
	
	public Exemplar(Livro livro,String codigo, boolean status) {
		this.codigo = codigo;
		this.disponivel = status;
	}
	
	public Exemplar(Livro livro,String codigo) {
		this.codigo = codigo;
		this.disponivel = true;
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
