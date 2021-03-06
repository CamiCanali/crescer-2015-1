import java.util.*;

/**
 * Pai de todos os Personagem objetos do jogo
 * 
 * @author Camila
 * @version 1
 */
public abstract class Personagem
{
    protected String nome;
    protected int experiencia;
    protected double vida;
    protected Status status = Status.VIVO;
    protected ArrayList<ItemDoInventario> itens = new ArrayList<ItemDoInventario>();
    
    protected Personagem(String nome,int vida){
        this.nome = nome;
        this.vida = vida;
    }
      
    protected Status getStatus() {
        return this.status;
    }    
    
    protected String getNome() {
        return this.nome;
    }
    
    protected int getExperiencia() {
        return this.experiencia;
    }
    
    protected double getVida() {
        return this.vida;
    }


    protected ArrayList<ItemDoInventario> getItens() {
        return this.itens;
    }
    

    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
    }
    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    protected void adicionarItem(ItemDoInventario item) {
        this.itens.add(item);
    }

    /**
     * Remove o item do inventário do orc.
     * 
     * @param item Item a ser perdido do inventário.
     */
    protected void perderItem(ItemDoInventario item) {
        this.itens.remove(item);
    }
    

    protected ItemDoInventario getItemComMaiorQuantidade() {
        ItemDoInventario itemMaiorQuantidade = null;
        
        boolean temItens = !this.itens.isEmpty();       
        if (temItens) {
            itemMaiorQuantidade = this.itens.get(0);
            
            for (int i = 1; i < this.itens.size(); i++) {
                ItemDoInventario itemAtual = this.itens.get(i);
                boolean encontreiAMaiorQuantidade =
                    itemAtual.getQuantidade() > itemMaiorQuantidade.getQuantidade();
                
                if (encontreiAMaiorQuantidade) {
                    // atualizar a minha referência para o maior parcial
                    itemMaiorQuantidade = itemAtual;
                }
            }
        }
        
        return itemMaiorQuantidade;
    }
    
    /**
     * Ordena itens do inventário por quantidade ascendente.
     * 
     * Algoritmo atual: Bubblesort
     */
    protected void ordenarItens(){
        // Versão mais estável do Bubblesort - Melhor caso O(n), Pior caso O(n^2)
       // iniciamos com true para forçar a entrada no laço.. poderia ter sido feito com do-while também
        boolean posicoesSendoTrocadas = true;
         
        while (posicoesSendoTrocadas) {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < this.itens.size() - 1; j++) {
                ItemDoInventario itemAtual = this.itens.get(j);
                ItemDoInventario proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        }
        /**
        boolean haItens = !this.itens.isEmpty();       

        for(int i = 0; i < itens.size() - 1; i++){
            
            if (haItens) {
              ItemDoInventario menor = this.itens.get(i);
              for (int j = i + 1; j < this.itens.size(); j++) {
                ItemDoInventario atual = this.itens.get(j);

                if (atual.getQuantidade() < menor.getQuantidade()) {
                    itens.set(j, menor);
                    itens.set(i, atual);
                    menor = atual;
                }
              }
            }
            
        }**/
    }
    
    

    /**
     * Concatena as descrições dos itens, separados por vírgula.
     * 
     * SEM ESPAÇO ENTRE AS VÍRGULAS E SEM PONTO FINAL
     * 
     * @return Descrições. Ex:
     * 
     * "Adaga,Escudo,Bracelete”
     */
    protected String getDescricoesItens() {
        StringBuilder builder = new StringBuilder();
        
        /*
         * Utilizando for tradicional         
        int numeroDeItens = this.itens.size();


        for (int i = 0; i < numeroDeItens; i++) {
            ItemDoInventario itemAtual = this.itens.get(i);
            
            boolean éÚltimoÍndice = i == numeroDeItens - 1;
                        
            builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
        }
        */

        
        // C#
        //foreach (ItemDoInventario item in this.itens) { }
        
        /*
        * Utilizando FOREACH!!
        for (ItemDoInventario itemAtual : this.itens) {

       
       // C#
       //foreach (ItemDoInventario item in this.itens) { }
       
       /*
        * Utilizando FOREACH!!
       for (ItemDoInventario itemAtual : this.itens) {
           int i = this.itens.indexOf(itemAtual);
           int numeroDeItens = this.itens.size();
           boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
           builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );

        }
        */
        
        /*
        * JavaScript
        for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
        }
        */
        
        /*
        * WHILE (ENQUANTO)
        int i = 0;
        int numeroDeItens = this.itens.size();    
        
        while (i < numeroDeItens) {

       }
       */
      
      /*
       * JavaScript
      for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
      }
      */
      
     /*
      * WHILE (ENQUANTO)
      int i = 0;
      int numeroDeItens = this.itens.size();    

      while (i < numeroDeItens) {

          ItemDoInventario itemAtual = this.itens.get(i);
          boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
          builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
          );
          //
          i++;

        }
        */
     
         int i = 0;
         int numeroDeItens = this.itens.size();
         do {
             if (numeroDeItens > 0) {
                 ItemDoInventario itemAtual = this.itens.get(i);
                  boolean éÚltimoÍndice = i == numeroDeItens - 1;
                   
                  builder.append(
                        éÚltimoÍndice ?
                        itemAtual.getDescricao() :
                        itemAtual.getDescricao() + ","
                  );
             }
             i++;
         } while(i < numeroDeItens);
     
         return builder.toString();
    }
    
    abstract void imprimeNome();

}