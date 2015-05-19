package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	private String nome;
	private List<Ingrediente> ingredientes= new ArrayList<>();
	private List<Instrucao> intrucoes = new ArrayList<>();
	
	public Receita(String nome, List<Ingrediente> ingredientes, List<Instrucao> instrucoes){
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.intrucoes = instrucoes;
	}
	
	public Receita(){
		
	}
	
	public String getNome(){
		return nome;
	}
}
