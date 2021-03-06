
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author Camila 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{

    public ElfoNoturno(String nome){
      super(nome);
    }
  
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        this.experiencia += 2;
        double qtdVidaAPerder = this.vida*0.05;
        this.vida -= qtdVidaAPerder;
        this.status = (int)this.vida ==0 ? Status.MORTO : this.status;
    }
    
    public String toString(){
        return "Elfo Noturno" + super.toString();
    }
}
