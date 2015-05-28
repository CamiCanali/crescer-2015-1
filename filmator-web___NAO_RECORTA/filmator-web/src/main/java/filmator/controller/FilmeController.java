package filmator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class FilmeController {
	
	@Inject 
	private FilmeDao filmeDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//model.addAttribute("listaGeneros", Genero.values()); 
		return "telaInicial";
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consulta(Model model) {		
		return "telaConsulta";
	}
	
	@RequestMapping(value = "/telaUsuario", method = RequestMethod.GET)
	public String abrirTelaUsuario(Model model){
		return "telaUsuario";
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme) {
		filmeDao.inserir(filme);
		return "telaCadastro";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Usuario usuario, Model model, HttpSession session){
		Usuario usuarioLogado = usuario;
		if(usuarioLogado == null){
			return "login";
		}
		session.setAttribute("usuarioLogado", usuario);
		return  "telaConsulta";
	}
	
	/*@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	 public String avaliarFilme(int idFilme, int nota){
		FilmeDao.avaliarFilme();
		return "telaConsulta";
	}*/
	
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
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String cadastrarUsuario(Model model, Usuario usuario){
		usuarioDao.cadastrarUsuario(usuario);
		return "telaInicial";
	}
}
