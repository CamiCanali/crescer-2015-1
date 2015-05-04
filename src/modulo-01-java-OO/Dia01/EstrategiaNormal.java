import java.util.*;
/**
 * Write a description of class EstrategiaNormal here.
 * 
 * @author Camila
 * @version (a version number or a date)
 */
public class EstrategiaNormal implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        System.out.println("Estrategia normal");
        for(Elfo elfo : elfos){
            ordemAtaque.add(elfo);
            for(Orc orc : orcs){
                elfo.atirarFlecha(orc);
            }
        }

    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
}
