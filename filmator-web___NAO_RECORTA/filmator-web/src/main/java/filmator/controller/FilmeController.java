package filmator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {
	
	@Inject 
	private FilmeDao filmeDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//model.addAttribute("listaGeneros", Genero.values()); 
		return "telaInicial";
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consulta(Model model) {		
		return "telaConsulta";
	}
		
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme) {
		filmeDao.inserir(filme);
		return "telaCadastro";
	}	
	
	@ResponseBody //@ResponseBody faz transformar o retorno para JSON!
	@RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	public List<Filme> buscarTodos(Model model) {
		return filmeDao.buscaTodosFilmesJava8();
	}
	
	@RequestMapping(value = "/buscarUm", method = RequestMethod.GET)
	public String buscarUm(String nome, Model model) {
		model.addAttribute("filme", filmeDao.buscaFilmePeloNome(nome));	
		return "telaConsulta";
	}	
}
