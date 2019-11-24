package biblioteca;

public class Exemplar {
	private String codigo;
	private boolean disponivel;
	
	public Exemplar(String codigo, boolean status) {
		this.codigo = codigo;
		this.disponivel = status;
	}
	
	public Exemplar(String codigo) {
		this.codigo = codigo;
		this.disponivel = true;
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
	
	public String consulta() {
		return "Codigo: ["+codigo+"] "+((isDisponivel())?"Disponivel":"Emprestado");
	}
	
}
