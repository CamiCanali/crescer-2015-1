import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
   
    @Test
    public void elfoVerdeAtiraUmaFlecha(){
        ElfoVerde elfo = new ElfoVerde("Batman");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        int esperado = 2;
        int obtido = elfo.getExperiencia();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void elfoVerdeAtiraDuasFlechas(){
        ElfoVerde elfo = new ElfoVerde("Batman");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        int esperado = 4;
        int obtido = elfo.getExperiencia();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void elfoVerdeAtiraTresFlechasEmDoisOrcs(){
        ElfoVerde elfo = new ElfoVerde("Batman");
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
        ElfoVerde elfo = new ElfoVerde("Batman");
        ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario(1, "Espada de Aço Valiriano");

        ArrayList<ItemDoInventario> itensEsperados = new ArrayList<>();
        itensEsperados.add(espadaDeAcoValiriano);

        elfo.adicionarItem(espadaDeAcoValiriano);
        ArrayList<ItemDoInventario> itensObtidos = elfo.getItens();
        
        assertEquals(itensEsperados, itensObtidos);
    }
    
    @Test
    public void elfoVerdeGanhaDoisItens(){
        ElfoVerde elfo = new ElfoVerde("Batman");
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
        ElfoVerde elfo = new ElfoVerde("Batman");
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

