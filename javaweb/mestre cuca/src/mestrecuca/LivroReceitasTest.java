package mestrecuca;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import mestrecuca.Ingrediente;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestrecuca.*;

import org.junit.Before;
import org.junit.Test;

public class LivroReceitasTest {
		private Livro livro;
		
		@Before
		public void setUp(){
			livro = new Livro();
		}
		
		@Test
		public void inserirNenhumaReceita(){
			int esperado = 0;
			int obtido = livro.listaReceitas.size();
			assertEquals(esperado, obtido);
		}
		
		/*@Test
		public void inserirUmaReceita(){
		
		}
		
		@Test
		public void inserirDuasReceitas(){
		
		}*/
		
		@Test
		public void atualizaReceita() throws Exception {
			livro.inserir(new Receita("Feijoada"));
			livro.atualizar("Feijoada", new Receita("Feijoada da Vovó"));
			
			assertEquals(1, livro.getTodasReceitas().size());
			assertTrue(livro.buscaReceitaPeloNome("Feijoada da Vovó") != null);
		}
		
		/*@Test
		public void inserirTresReceitasNaListaDeCompras(){
		
		}*/
	
}
