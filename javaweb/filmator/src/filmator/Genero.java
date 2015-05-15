package filmator;

public enum Genero {
	COMEDIA("Comedia"),
	ACAO("A��o"),
	TERROR("Terror"),
	SUSPENSE("Suspense"),
	ROMANCE("Romance"),
	DRAMA("Drama");
	
	private String genero;
	
	private Genero(String genero){
		this.genero = genero;
	}
	public String getGenero(){
		return genero;
	}	
}
