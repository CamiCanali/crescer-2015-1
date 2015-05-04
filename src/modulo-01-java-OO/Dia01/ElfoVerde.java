import java.util.*;
/**
 * Write a description of class ElfosVerdes here.
 * 
 * @author Camila
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{   
    private final ArrayList<String> ITENS_PERMITIDOS = new ArrayList<>();
    {
        ITENS_PERMITIDOS.add("Espada de aço Valiriano"); 
        ITENS_PERMITIDOS.add("Arco e flecha de vidro");
    }
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        this.experiencia++;
    }
   
    public void adicionarItem(ItemDoInventario item) {
        if(item.getDescricao().equalsIgnoreCase("Espada de Aço Valiriano") || 
        item.getDescricao().equalsIgnoreCase("Arco e Flecha de Vidro")){
            super.adicionarItem(item);
        }
    }
    
    public String toString(){
        return "Elfo Verde" + super.toString();
    }
}
