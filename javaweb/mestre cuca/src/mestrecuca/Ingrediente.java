package mestrecuca;

public class Ingrediente {
	private String nome;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	private double preco;
	
	public Ingrediente(String nome, double preco, double quantidade, UnidadeMedida unidade){
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.unidadeMedida = unidade;
	}
	
	public Ingrediente(String nome, double quantidade, UnidadeMedida unidade){
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidade;
	}
	
	public Ingrediente(){}
	public double getPreco(){
		return preco;
	}
	
	public double getQuantidade(){
		return quantidade;
	}
	
	public void setQuantidade(double novaQuantidade){
		this.quantidade = novaQuantidade;
	}
}
