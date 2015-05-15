package filmator;

import java.util.ArrayList;
import java.util.List;

public class Filme {
	private String nomeFilme;
	private List<Ator> elenco = new ArrayList<>();
	private Genero genero;
	
	public Filme(String nome, Genero genero) {
		this.nomeFilme = nome;
		this.genero = genero;
	}
	
	public void insereAtor(Ator ator){
		elenco.add(ator);		
	}
	
	 public int qtdAtores(){
		 return elenco.size();
	 }
	 
	public List<Ator> retornaAtores(String s){
		List <Ator> lista = new ArrayList<>();
		for(int i=0; i<elenco.size(); i++){
			if(elenco.get(i).getNome().equals(s))
				lista.add(elenco.get(i));
		}	
		return lista;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	@Override
	public String toString() {
		return "Nome do filme: " + nomeFilme.toString();
	}
}
