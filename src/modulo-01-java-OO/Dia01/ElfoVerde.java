
/**
 * Write a description of class ElfosVerdes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{   
    private ItemDoInventario espadaDeAcoValiriano, arcoEFlechaDeVidro;
    
    public ElfoVerde(String nome){
        super(nome, 0);
    }
    
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia += 2;
        umOrc.recebeAtaque();
    }
    
    protected void adicionarItem(ItemDoInventario item) {
        if(item == espadaDeAcoValiriano || item == arcoEFlechaDeVidro){
            adicionarItem(item);
        }
    }
}