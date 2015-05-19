package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Livro implements LivroReceita{
	public List<Receita> listaReceitas = new ArrayList<>();

	public void inserir(Receita receita){
		if(receita != null){
			listaReceitas.add(receita);
		}else{
			throw new IllegalArgumentException("N�o � poss�vel inserir essa receita!");
		}
	}

	public void atualizar(String nome, Receita receitaAtualizada){
		Receita encontrada;
		int indice = 0;
		if(receitaAtualizada != null){
			encontrada = buscaReceitaPeloNome(nome);
			indice = listaReceitas.indexOf(encontrada);
			listaReceitas.set(indice, receitaAtualizada);
		}
		else{
			throw new IllegalArgumentException("N�o � poss�vel atualizar essa receita!");
		}
			
	}

	public void excluir(String nome) {
		for(int i = 0; i < listaReceitas.size(); i++){
			if(listaReceitas.contains(nome)){
				listaReceitas.remove(i);
			}
		}
	}

	public List<Receita> getTodasReceitas() {
			return listaReceitas;
	}

	public Receita buscaReceitaPeloNome(String nome){
		if(listaReceitas.contains(nome)){
				return listaReceitas.get(listaReceitas.indexOf(nome));
		}
		else{
			throw new IllegalArgumentException("N�o existe essa receita!");
		}
	}
	
	public double calculaValorTotalTodasReceitas(){
		double total = 0;
		for(int i = 0; i < listaReceitas.size(); i++){
			total += listaReceitas.get(i).calculaPreco();
		}
		return total;
	}
	
	public List<Receita> ingredientesAlergicos(List<Ingrediente> ingredientesProibidos){
		List<Receita> receitasNaoAlergicas = new ArrayList<Receita>();
		for(int i = 0; i < listaReceitas.size(); i++){
			if(!ingredientesProibidos.contains(listaReceitas.get(i).getIngredientes())){
				receitasNaoAlergicas.add(listaReceitas.get(i));
			}
		}
		return receitasNaoAlergicas;
	} 
	
	public List<Ingrediente> listaCompras(List<Receita> receitas){
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		Ingrediente atualizado;
		double novaQuantidade = 0;
		for(int i = 0; i < receitas.size(); i++){				
			for(int j = 0; j < receitas.get(i).getIngredientes().size(); j++ ){
				Ingrediente parte = receitas.get(i).getUmIngrediente(j);
				if(ingredientes.isEmpty() || !ingredientes.contains(parte)){
					ingredientes.add(parte);
				}else if(ingredientes.contains(parte)){
					int indice = ingredientes.indexOf(parte);
					atualizado = parte;
					novaQuantidade = atualizado.getQuantidade();
					novaQuantidade += parte.getQuantidade();
					atualizado.setQuantidade(novaQuantidade);
					ingredientes.set(indice, atualizado);
					
					// n
					//ingre.set(indice, <ing atualizado>)
					
				}	
			}
		}
		return ingredientes;
	}
}

