package listator;

import java.util.ArrayList;

public class Filme {
	private String nomeFilme;
	private ArrayList<Ator> elenco = new ArrayList<>();
	
	public Filme(String nome) {
		this.nomeFilme = nome;
	}
	
	public void insereAtor(Ator ator){
		elenco.add(ator);		
	}
	
	 public int qtdAtores(){
		 return elenco.size();
	 }
	 
	public ArrayList<Ator> retornaAtores(String s){
		ArrayList <Ator> lista = new ArrayList<>();
		for(int i=0; i<elenco.size(); i++){
			if(elenco.get(i).getNome().equals(s))
				lista.add(elenco.get(i));
		}	
		return lista;
	}
	
	@Override
	public String toString() {
		return "Nome do filme: " + nomeFilme.toString();
	}
}
