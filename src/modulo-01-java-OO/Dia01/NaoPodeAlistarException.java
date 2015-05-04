
/**
 * Erro quando o elfo tenta alistar um elfo que não pode ser alistado
 * 
 * @author Camila 
 * @version (a version number or a date)
 */
public class NaoPodeAlistarException extends Exception
{
  
   public NaoPodeAlistarException(){
       super("Erro ao alistar um Elfo. Por favor, tente novamente e se o erro persistir contate o administrador");       
   }

}
