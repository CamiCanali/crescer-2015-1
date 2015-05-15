package filmator;

import java.util.*;

public class Netflox {
	Map<Genero, Integer> exibicoes = new HashMap<>();
	ArrayList<Filme> acervo = new ArrayList<>();
	private int exibidos = 0;
	
	public void reproduzirFilme(Filme filme){
		if(acervo.contains(filme)){
			exibicoes.put(filme.getGenero(), exibidos++);
		}
	}
	
	public void gerarRelatorio(){
		exibicoes.get(Genero.valueOf(" "));
	}
}
