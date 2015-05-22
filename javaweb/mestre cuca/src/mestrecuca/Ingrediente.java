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
	
	public String getNome() {
		return nome;
	}
	
	public void setQuantidade(double novaQuantidade){
		this.quantidade = novaQuantidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidadeMedida != other.unidadeMedida)
			return false;
		return true;
	}

}
