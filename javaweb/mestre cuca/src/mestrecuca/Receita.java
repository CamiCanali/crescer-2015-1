package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	private String nome;
	private List<Ingrediente> ingredientes= new ArrayList<>();
	private List<Instrucao> instrucoes = new ArrayList<>();
	
	public Receita(String nome){
		this.nome = nome;
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
	
	public void adicionarIngrediente(Ingrediente ingrediente){
		this.ingredientes.add(ingrediente);
	}
	
	public boolean contemUmDosIngredientes(List<String> ingredientesProibidos) {
		for(Ingrediente ingrediente : ingredientes){
			if(ingredientesProibidos.contains(ingrediente.getNome())){
				return true;
			}
		}
		return false;
	}
}
