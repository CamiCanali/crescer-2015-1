package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Livro implements LivroReceita{
	public List<Receita> listaReceitas = new ArrayList<>();

	public void inserir(Receita receita){
		if(receita != null){
			listaReceitas.add(receita);
		}else{
			throw new IllegalArgumentException("Não é possível inserir essa receita!");
		}
	}

	public void atualizar(String nome, Receita receitaAtualizada){
		Receita encontrada = new Receita();
		int indice = 0;
		if(receitaAtualizada != null){
			encontrada = buscaReceitaPeloNome(nome);
			indice = listaReceitas.indexOf(encontrada);
			listaReceitas.set(indice, receitaAtualizada);
		}
		else{
			throw new IllegalArgumentException("Não é possível atualizar essa receita!");
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
		for(int i = 0; i < listaReceitas.size(); i++){
			if(listaReceitas.contains(nome)){
				return listaReceitas.get(i);
			}
			else{
				throw new IllegalArgumentException("Não existe essa receita!");
			}
		}
		return null; 
	}
}

