package mestrecuca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceita {
		
	public LivroReceitasJson(String caminho){
		File f = new  File(caminho);
		
		if(f.exists() && !f.isDirectory()) {
			try (BufferedReader br = new BufferedReader(new FileReader(caminho)))
			{
	 
				String sCurrentLine;
	 
				while ((sCurrentLine = br.readLine()) != null) {
			
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}else
			converterObjetoParaJson(caminho);
	}
	
	public void converterObjetoParaJson(String caminho){
		ObjectMapper mapper = new ObjectMapper();
		Livro livro = new Livro();
		try{
			mapper.writeValue(new File(caminho), livro.listaReceitas);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void converterJsonParaObjeto(String caminho){
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Receita> receitas = mapper.readValue(new File(caminho), List.class);
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
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
