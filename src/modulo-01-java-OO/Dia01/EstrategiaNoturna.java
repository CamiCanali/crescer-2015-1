import java.util.*;
/**
 * elfos noturnos podem fazer 30% do ataque
 * 
 * @author Camila
 * @version 15/04/2015
 */
public class EstrategiaNoturna implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        System.out.println ("Estratégia Noturna!");
        int qtdAtaques = elfos.size() * orcs.size();
        int limiteElfosNoturnos = (int)(qtdAtaques * 0.3);
        int qtdElfosNoturnosQueJáAtacaram = 0;
        for(Elfo elfoQueVaiAtacar : elfos ){
            boolean éElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;
            if(éElfoNoturno){
                if(qtdElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos)
                    continue;
                qtdElfosNoturnosQueJáAtacaram++;
            
            }
            for(Orc orc : orcs){
                elfoQueVaiAtacar.atirarFlecha(orc);
            }
        }
    }
}
