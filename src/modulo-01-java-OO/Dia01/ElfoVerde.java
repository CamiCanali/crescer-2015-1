
/**
 * Write a description of class ElfosVerdes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{   
    private ItemDoInventario espadaDeAcoValiriano, arcoEFlechaDeVidro;
    
    public ElfoVerde(String nome, int flechas){
        super("");
    }
    
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia += 2;
        umOrc.recebeAtaque();
    }
    
    public void adicionarItem(ItemDoInventario item) {
        if(item.getDescricao().equals("Espada de Aço Valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro")){
            itens.add(item);
        }
    }
}