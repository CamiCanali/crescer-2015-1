package teste;
import static org.junit.Assert.*;

import org.junit.Test;

import filmator.*;

public class TestFilme {
	
	@Test
	public void insereNenhumAtorNoElenco(){
		Filme f = new Filme("Maleficent", Genero.DRAMA);
		int contadorEsperado = 0;
		int contadorObtido = f.qtdAtores();
		assertEquals(contadorEsperado, contadorObtido);
	}
	@Test
	public void insereUmAtorNoElenco(){
		Ator a = new Ator("Angelina Jolie");
		Filme f = new Filme("Maleficent", Genero.DRAMA);
		f.insereAtor(a);
		int contadorEsperado = 1;
		int contadorObtido = f.qtdAtores();
		assertEquals(contadorEsperado, contadorObtido);
	}
	
	@Test
	public void insereDoisAtoresNoElenco(){
		Ator a = new Ator("Angelina Jolie");
		Ator b = new Ator("Ellie Fanning");
		Filme f = new Filme("Maleficent", Genero.DRAMA);
		f.insereAtor(a);
		f.insereAtor(b);
		int contadorEsperado = 2;
		int contadorObtido = f.qtdAtores();
		assertEquals(contadorEsperado, contadorObtido);
	}
	
	@Test
	public void reproduzUmFilme(){
		Filme f = new Filme("Kill Bill", Genero.ACAO);
		Netflox n = new Netflox();
		n.reproduzirFilme(f);
		int esperado = 1;
		//int obtido = n.gerarRelatorio();
		//assertEquals(esperado, obtido);
	}
}
