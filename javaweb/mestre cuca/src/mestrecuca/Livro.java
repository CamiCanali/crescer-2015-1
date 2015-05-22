package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Livro implements LivroReceita{
	public List<Receita> listaReceitas = new ArrayList<>();

	public void inserir(Receita receita){
		validaReceita(receita);
		listaReceitas.add(receita);
	}

	public void atualizar(String nome, Receita receitaAtualizada){
		validaReceita(receitaAtualizada);
		Receita encontrada = buscaReceitaPeloNome(nome);
		int indice = listaReceitas.indexOf(encontrada);
		listaReceitas.set(indice, receitaAtualizada);			
	}
	
	private void validaReceita(Receita receita){
		String nome = receita.getNome();
		if(nome == null ||nome.trim().equals("")){
			throw new IllegalArgumentException("Nome de receita nulo ou inválido");
		}
	}

	public void excluir(String nome) {
		Receita receita = buscaReceitaPeloNome(nome);
		int indice = listaReceitas.indexOf(receita);
		listaReceitas.remove(indice);
	}

	public List<Receita> getTodasReceitas() {
			return listaReceitas;
	}

	public Receita buscaReceitaPeloNome(String nome){
		/*for(Receita receita: listaReceitas){
		 * if(receita.getNome().equals(nome)
		 * return receita;
		}*/
		for (int i = 0; i < listaReceitas.size(); i++){
			if(listaReceitas.get(i).getNome().equals(nome)){
				return listaReceitas.get(i);
			}
		}
		throw new IllegalArgumentException("Não existe essa receita!");
	
	}

	public double calculaValorTotalTodasReceitas(){
		double total = 0;
		for(int i = 0; i < listaReceitas.size(); i++){
			total += listaReceitas.get(i).calculaPreco();
		}
		return total;
	}
	
	public List<Receita> buscaReceitasSemIngredientes(List<String> ingredientesProibidos){
		List<Receita> receitasNaoAlergicas = new ArrayList<Receita>();
		for(Receita receita : listaReceitas){
			if(!receita.contemUmDosIngredientes(ingredientesProibidos)){
				receitasNaoAlergicas.add(receita);
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

