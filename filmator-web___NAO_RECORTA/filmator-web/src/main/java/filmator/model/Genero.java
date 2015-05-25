package filmator.model;

public enum Genero {
	DRAMA("Drama"),
	TERROR("Terror"),
	ROMANCE("Romance"),
	SUSPENSE("Suspense"),
	MUSICAL("Musical"),
	AVENTURA("Aventura"),
	COMEDIA("Comedia");
	
	private String descricao;

	private Genero(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
