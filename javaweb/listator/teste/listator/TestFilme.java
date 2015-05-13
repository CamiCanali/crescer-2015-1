package listator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFilme {
	@Test
	public void insereNenhumAtorNoElenco(){
		Filme f = new Filme("Maleficent");
		int contadorEsperado = 0;
		int contadorObtido = f.qtdAtores();
		assertEquals(contadorEsperado, contadorObtido);
	}
	@Test
	public void insereUmAtorNoElenco(){
		Ator a = new Ator("Angelina Jolie");
		Filme f = new Filme("Maleficent");
		f.insereAtor(a);
		int contadorEsperado = 1;
		int contadorObtido = f.qtdAtores();
		assertEquals(contadorEsperado, contadorObtido);
	}
	
	@Test
	public void insereDoisAtoresNoElenco(){
		Ator a = new Ator("Angelina Jolie");
		Ator b = new Ator("Ellie Fanning");
		Filme f = new Filme("Maleficent");
		f.insereAtor(a);
		f.insereAtor(b);
		int contadorEsperado = 2;
		int contadorObtido = f.qtdAtores();
		assertEquals(contadorEsperado, contadorObtido);
	}
}
