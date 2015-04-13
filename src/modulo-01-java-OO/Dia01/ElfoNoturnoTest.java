

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  Camila
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoAtiraUmaFlecha(){
        ElfoNoturno elfo = new ElfoNoturno("Batman");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        int experienciaEsperada = 3;
        int experienciaObtida = elfo.getExperiencia();
        int vidaEsperada = 95;
        int vidaObtida = elfo.getVida();
        assertEquals(experienciaEsperada, experienciaObtida);
        assertEquals(vidaEsperada, vidaObtida);
    }
    
    @Test
    public void elfoNoturnoAtiraDuasFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("Batman");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        int experienciaEsperada = 6;
        int experienciaObtida = elfo.getExperiencia();
        int vidaEsperada = 91;
        int vidaObtida = elfo.getVida();
        assertEquals(experienciaEsperada, experienciaObtida);
        assertEquals(vidaEsperada, vidaObtida);
    }
    
    @Test
    public void elfoNoturnoAtiraTresFlechasEmDoisOrcs(){
        ElfoNoturno elfo = new ElfoNoturno("Batman");
        Orc orc = new Orc();
        Orc orc2 = new Orc();
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc2);
        int experienciaEsperada = 9;
        int experienciaObtida = elfo.getExperiencia();
        int vidaEsperada = 87;
        int vidaObtida = elfo.getVida();
        assertEquals(experienciaEsperada, experienciaObtida);
        assertEquals(vidaEsperada, vidaObtida);
    }
  
}
