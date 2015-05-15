package listator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Listator {
	File file = new File("Lembretes.txt");
	boolean fileExists = file.exists();
	
	public void lerArquivo(String message){
		try {
			 	 
			File[] arquivos = file.listFiles();
		 
			FileReader fr = new FileReader(file);
		 
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String linha = br.readLine();
				System.out.println(linha);
			}
		 
			br.close();
			fr.close();
		 
		} catch (IOException ex) {
		ex.printStackTrace();
		}
	}
		public static void main(String[] args) {
			 
			File arquivo = new File("/home/hallan/nome_do_arquivo.txt");
			 
			File aquivoLido = new File("");
			// arquivoLido = lerArquivo(file);
			}
}

