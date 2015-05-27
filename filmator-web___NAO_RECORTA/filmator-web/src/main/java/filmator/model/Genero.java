package filmator.model;

public enum Genero {
	DRAMA("Drama"),
	TERROR("Terror"),
	ROMANCE("Romance"),
	SUSPENSE("Suspense"),
	MUSICAL("Musical"),
	AVENTURA("Aventura"),
	COMEDIA("Comédia"),
	ACAO("Ação");
	
	private String descricao;

	private Genero(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
