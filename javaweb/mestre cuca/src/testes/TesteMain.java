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
	/*public void atualizarUmaReceita(){
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
	}*/
	
	@Test
	public void inserirTresReceitasNaListaDeCompras(){
		List<Ingrediente> i = new ArrayList<>();
		List<Ingrediente> i2 = new ArrayList<>();
		List<Ingrediente> i3 = new ArrayList<>();
		List<Instrucao> in = new ArrayList<>();
		Ingrediente arroz = new Ingrediente("Arroz", 3, UnidadeMedida.XICARA);
		Ingrediente arroz2 = new Ingrediente("Arroz", 1, UnidadeMedida.XICARA);
		Ingrediente sal = new Ingrediente("Sal", 1, UnidadeMedida.COLHER_SOPA);
		Ingrediente leiteCondensado = new Ingrediente("Leite Condensado", 1, UnidadeMedida.UNIDADE);
		Ingrediente carne = new Ingrediente("Carne", 3, UnidadeMedida.XICARA);
		Instrucao ins = new Instrucao("Misture tudo");
		i.add(arroz);
		i.add(sal);
		i.add(leiteCondensado);
		i2.add(arroz2);
		i2.add(leiteCondensado);
		i3.add(carne);
		i3.add(sal);
		in.add(ins);
		Receita arrozForno = new Receita ("Arroz de forno", i, in);
		Receita arrozDoce = new Receita ("Arroz doce", i2, in);
		Receita carnePanela = new Receita ("Carne de panela", i3, in);
		Livro l = new Livro();
		l.inserir(arrozForno);
		l.inserir(arrozDoce);
		l.inserir(carnePanela);
		l.listaCompras(l.listaReceitas);
		List<Ingrediente> esperado = ;
		List<Ingrediente> obtido = l.listaCompras(l.listaReceitas);
		assertEquals(esperado, obtido);
	}
}
