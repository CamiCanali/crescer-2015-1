import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
 */
public class ElfoTest
{
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void elfoVerdeAtiraUmaFlecha(){
        ElfoVerde elfo = new ElfoVerde("Batman", 42);
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        int esperado = 2;
        int obtido = elfo.getExperiencia();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void elfoVerdeAtiraDuasFlechas(){
        ElfoVerde elfo = new ElfoVerde("Batman", 42);
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        int esperado = 4;
        int obtido = elfo.getExperiencia();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void elfoVerdeAtiraTresFlechasEmDoisOrcs(){
        ElfoVerde elfo = new ElfoVerde("Batman", 42);
        Orc orc = new Orc();
        Orc orc2 = new Orc();
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc2);
        int esperado = 6;
        int obtido = elfo.getExperiencia();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void elfoVerdeGanhaUmItem(){
        ElfoVerde elfo = new ElfoVerde("Batman", 42);
        ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario(1, "Espada de Aço Valiriano");

        ArrayList<ItemDoInventario> itensEsperados = new ArrayList<>();
        itensEsperados.add(espadaDeAcoValiriano);

        elfo.adicionarItem(espadaDeAcoValiriano);
        ArrayList<ItemDoInventario> itensObtidos = elfo.getItens();
        
        assertEquals(itensEsperados, itensObtidos);
    }
    
    @Test
    public void elfoVerdeGanhaDoisItens(){
        ElfoVerde elfo = new ElfoVerde("Batman", 42);
        ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario(1, "Espada de Aço Valiriano");
        ItemDoInventario arcoEFlechaDeVidro = new ItemDoInventario(4, "Arco e Flecha de Vidro");
        ArrayList<ItemDoInventario> itensEsperados = new ArrayList<>();
        itensEsperados.add(arcoEFlechaDeVidro);
        itensEsperados.add(espadaDeAcoValiriano);
        elfo.adicionarItem(arcoEFlechaDeVidro);
        elfo.adicionarItem(espadaDeAcoValiriano);
        ArrayList<ItemDoInventario> itensObtidos = elfo.getItens();
        
        assertEquals(itensEsperados, itensObtidos);
    }
    
     @Test
    public void elfoVerdeGanhaTresItens(){
        ElfoVerde elfo = new ElfoVerde("Batman", 42);
        ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario(1, "Espada de Aço Valiriano");
        ItemDoInventario arcoEFlechaDeVidro = new ItemDoInventario(4, "Arco e Flecha de Vidro");
        ItemDoInventario adaga = new ItemDoInventario(5, "Adaga");
        ArrayList<ItemDoInventario> itensEsperados = new ArrayList<>();
        itensEsperados.add(arcoEFlechaDeVidro);
        itensEsperados.add(espadaDeAcoValiriano);
        elfo.adicionarItem(arcoEFlechaDeVidro);
        elfo.adicionarItem(espadaDeAcoValiriano);
        elfo.adicionarItem(adaga);
        ArrayList<ItemDoInventario> itensObtidos = elfo.getItens();
        
        assertEquals(itensEsperados, itensObtidos);
    }
    
}



