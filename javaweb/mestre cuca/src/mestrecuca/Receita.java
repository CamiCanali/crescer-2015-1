package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	private String nome;
	private List<Ingrediente> ingredientes= new ArrayList<>();
	private List<Instrucao> instrucoes = new ArrayList<>();
	
	public Receita(String nome, List<Ingrediente> ingredientes, List<Instrucao> instrucoes){
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.instrucoes = instrucoes;
	}
	
	public Receita(){
		
	}
	
	public String getNome(){
		return nome;
	}
	
	public double calculaPreco(){
		double total = 0.0;
		for(int i = 0; i < ingredientes.size(); i++){
			total += ingredientes.get(i).getPreco();
		}
		return total;
	}
	
	public List<Ingrediente> getIngredientes(){
		return ingredientes;
	}
	
	public Ingrediente getUmIngrediente(int posicao){
		return ingredientes.get(posicao);
	}
}
