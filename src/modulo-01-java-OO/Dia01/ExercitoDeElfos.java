import java.util.*;

/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author Camila
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
      
    /**
     * Busca um elfo no meio do exército, a partir do seu nome.
     * 
     * @param nome Nome do elfo para utilizar na busca.
     * @return Elfo Resultado da busca pelo nome. Caso não encontre nada retorna null.
     */
    public Elfo buscar(String nome) {
        return exercito.get(nome);
    }
        
    public HashMap<String, Elfo> getExercito(){
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus(){
        return this.porStatus;
    }
    
    public ArrayList<Elfo> buscar(Status status){
        agruparElfosPorSatus();
        return porStatus.get(status);
    }
    
     /**
      * 
      * se é elfoVerde ou elfoNoturno
      */
    public void alistarElfo(Elfo elfo) throws NaoPodeAlistarException{

        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar){
            exercito.put(elfo.getNome(), elfo);
        }else{
           ErrosDoJogo.naoPodeAlistar();
        }
    }
    
    public void agruparElfosPorSatus(){
        /*for (String key : exercito.keySet()){
            Elfo elfo = new Elfo("nome");
            agrupados.put("nome", elfo);
        }*/
        porStatus.clear();
        for(Map.Entry<String, Elfo> parChaveValor : exercito.entrySet()){
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            if(porStatus.containsKey(status)){
                porStatus.get(status).add(elfo);
            }else{
                porStatus.put(status, new ArrayList<>(Arrays.asList(elfo)));

            }
        }
    }

    public void mudaDeEstrategia(EstrategiaDeAtaque novaEstrategia) {
        estrategia = novaEstrategia;
    }    
    
    public void atacarHorda(ArrayList<Orc> orcs){
        ArrayList <Elfo> elfosQueVaoPraLuta = buscar(Status.VIVO);
        estrategia.atacarOrcs(elfosQueVaoPraLuta, orcs);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }

}   
    