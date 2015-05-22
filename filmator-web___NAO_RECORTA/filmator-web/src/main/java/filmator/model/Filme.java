package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	private int ano;
	private String imagem;
	
	public Filme(String nome){
		this.nome = nome;
	}
	
	public Filme(){}
	
	public String getNome() {
		return nome;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
