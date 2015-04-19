import java.util.*;
/**
 * Write a description of interface EstrategiaDeAtaque here.
 * 
 * @author Camila
 * @version 15/04/2015
 * NÃO PODE INSTANCIAR INTERFACE!!
 */
public interface EstrategiaDeAtaque
{
    void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs);
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
}
