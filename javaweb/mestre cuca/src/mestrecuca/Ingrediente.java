package mestrecuca;

public class Ingrediente {
	private String nome;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	
	public Ingrediente(String nome, double quantidade, UnidadeMedida unidade){
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidade;
	}
	
}
