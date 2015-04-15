import java.util.*;
/**
 * Write a description of class EstrategiaNormal here.
 * 
 * @author Camila
 * @version (a version number or a date)
 */
public class EstrategiaNormal implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        System.out.println("Estrategia normal");
        
        for(Elfo elfo : elfos){
            for(Orc orc : orcs){
                elfo.atirarFlecha(orc);
            }
        }
    }
}
