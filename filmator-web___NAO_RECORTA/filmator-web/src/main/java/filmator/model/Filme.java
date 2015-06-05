package filmator.model;

public class Filme {
	private int idFilme;
	private String nome;
	private Genero genero;
	private int ano;
	private String imagem;
	private String sinopse;
	private int avaliacao;
	
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

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int id) {
		this.idFilme = id;
	}
}
