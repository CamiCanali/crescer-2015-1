
/**
 * Write a description of class EstrategiaIntercalada here.
 * 
 * @author Camila
 * @version 18/04/2015
 */
public class EstrategiaIntercalada implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        System.out.println("Estratégia Intercalada!");
        for(Elfo elfoAtacando : elfos ){
            boolean éElfoVerde = elfoAtacando instanceof ElfoVerde;
            if(éElfoVerde){
                
            }
            for(Orc orc : orcs){}
        }
    }
}
