import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaIntercaladaTest
{
    @Test
    public void exercitoIntercaladoComeçandoComElfoVerde() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
       Elfo green1 = new ElfoVerde("Green 1");
        Elfo night3 = new ElfoNoturno("Night 3");
       Elfo green2 = new ElfoVerde("Green 2");
        Elfo green3 = new ElfoVerde("Green 3");
        exercito.alistarElfo(green1);
        exercito.alistarElfo(night1);
        exercito.alistarElfo(green2);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(green3);
        exercito.alistarElfo(night3);
    
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(green2, night3, green3, night2, green1, night1)
       );

        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void exercitoIntercaladoComeçandoComElfoNoturno() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfoVerde("Elfo Verde 1");
        Elfo green2 = new ElfoVerde("Green 2");

        exercito.alistarElfo(green1);
        exercito.alistarElfo(green2);
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(night1, green2, night2, green1)

        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void exercitoDesproporcionalNãoAtaca() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfoVerde("Elfo Verde 1");

        exercito.alistarElfo(green1);
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);

        ArrayList<Elfo> esperado = new ArrayList<>();
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }

}

