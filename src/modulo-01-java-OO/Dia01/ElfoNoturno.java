
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author Camila 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{
    
   public ElfoNoturno(String nome){
      super("");
   }
  
   public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        this.experiencia += 2;
        umOrc.recebeAtaque();
        
        vida -= (vida*5)/100;
        this.status = (int)this.vida ==0 ? Status.MORTO : this.status;
   }
  
   public int calculaFlechas(){
       int contador = 0;
       for (int i = 0; i < getFlechas(); i++){
           contador++;
           vida -= (vida*5)/100;
           if(vida == 0){
               return contador;
            }
       }
       return contador;
    }
}
