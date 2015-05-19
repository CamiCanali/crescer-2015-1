package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestrecuca.*;

import org.junit.Test;

public class TesteMain {
	@Test
	public void inserirNenhumaReceita(){
		Livro l = new Livro();
		int esperado = 0;
		int obtido = l.listaReceitas.size();
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void inserirUmaReceita(){
		List<Ingrediente> i = new ArrayList<>();
		List<Instrucao> in = new ArrayList<>();
		Ingrediente ovo = new Ingrediente("Ovo", 2, UnidadeMedida.UNIDADE);
		Ingrediente coco = new Ingrediente("Côco", 3, UnidadeMedida.XICARA);
		Instrucao ins = new Instrucao("Misture tudo");
		i.add(ovo);
		i.add(coco);
		in.add(ins);
		Receita r = new Receita ("Quindim", i, in);
		Livro l = new Livro();
		l.inserir(r);	
		int esperado = 1;
		int obtido = l.listaReceitas.size();
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void inserirDuasReceitas(){
		List<Ingrediente> i = new ArrayList<>();
		List<Instrucao> in = new ArrayList<>();
		Ingrediente ovo = new Ingrediente("Ovo", 2, UnidadeMedida.UNIDADE);
		Ingrediente coco = new Ingrediente("Côco", 3, UnidadeMedida.XICARA);
		Instrucao ins = new Instrucao("Misture tudo");
		i.add(ovo);
		i.add(coco);
		in.add(ins);
		Receita r = new Receita ("Quindim", i, in);
		Receita r2 = new Receita ("Quindim", i, in);
		Livro l = new Livro();
		l.inserir(r);
		l.inserir(r2);
		int esperado = 2;
		int obtido = l.listaReceitas.size();
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void atualizarUmaReceita(){
		List<Ingrediente> i = new ArrayList<>();
		List<Instrucao> in = new ArrayList<>();
		List<Receita> livro = new ArrayList<>();
		Livro l = new Livro();
		Ingrediente ovo = new Ingrediente("Ovo", 2, UnidadeMedida.UNIDADE);
		Ingrediente coco = new Ingrediente("Côco", 3, UnidadeMedida.XICARA);
		Instrucao ins = new Instrucao("Misture tudo");
		i.add(ovo);
		i.add(coco);
		in.add(ins);
		Receita r = new Receita ("Quindim", i, in);
		Receita r2 = new Receita ("Quindim", i, in);
		l.inserir(r);
		int esperado = 2;
		int obtido = livro.size();
		assertEquals(esperado, obtido);
	}
}
