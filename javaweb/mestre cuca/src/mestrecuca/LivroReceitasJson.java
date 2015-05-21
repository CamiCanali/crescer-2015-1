package mestrecuca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceita {
		
	public LivroReceitasJson(String caminho){
		File f = new  File(caminho);
		if(f.exists() && !f.isDirectory()) {
			try (BufferedReader br = new BufferedReader(new FileReader(caminho)))
			{
	 
				String sCurrentLine;
	 
				while ((sCurrentLine = br.readLine()) != null) {
					Livro
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}else
			ObjectMapper mapper = new ObjectMapper();
			Livro livro = new Livro();
			mapper.writeValue(new File(caminho), livro.listaReceitas);
	}
	@Override
	public void inserir(Receita receita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Receita> getTodasReceitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
