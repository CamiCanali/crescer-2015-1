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
		List<Ingrediente> i2 = new ArrayList<>();
		List<Instrucao> in = new ArrayList<>();
		Livro livro = new Livro();
		Ingrediente ovo = new Ingrediente("Ovo", 2, UnidadeMedida.UNIDADE);
		Ingrediente coco = new Ingrediente("Côco", 3, UnidadeMedida.XICARA);
		Ingrediente leite = new Ingrediente("Leite", 2, UnidadeMedida.XICARA);
		Instrucao ins = new Instrucao("Misture tudo");
		i.add(ovo);
		i2.add(ovo);
		i.add(coco);
		i2.add(coco);
		i2.add(leite);
		in.add(ins);
		Receita receita = new Receita ("Quindim", i, in);
		Receita receitaAtualizada = new Receita ("Quindim novo", i2, in);	
		livro.inserir(receita);
		livro.atualizar("Quindim", receitaAtualizada);
		Receita obtida = livro.buscaReceitaPeloNome("Quindim");
		Receita esperada = receitaAtualizada;
		assertEquals(esperada, obtida);
	}
}
