package listator;

public class Ator {
	private String nome;
	
	public Ator(String nome) {
		this.nome = nome;		
	}
	
	public String getNome(){
		return nome;
	}
	
	@Override
	public String toString() {
		return "Ator: " + nome.toString();
	}
}
