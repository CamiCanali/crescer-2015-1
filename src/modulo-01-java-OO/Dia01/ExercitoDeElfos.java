import java.util.HashMap;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author Camil
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito(){
        return this.exercito;
    }
    
     /**
      * 
      * se é elfoVerde ou elfoNoturno
      */
    public void alistarElfo(Elfo elfo){
       
       
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar){
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public Elfo buscar(String nome){
        return exercito.get(nome);
    }
}
