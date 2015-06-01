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
		return "telaLogin";
	}

	@RequestMapping(value = "/consultaFilme", method = RequestMethod.GET)
	public String consulta(Model model) {		
		return "consultaFilme";
	}
	
	@RequestMapping(value = "/usuarioCadastro", method = RequestMethod.GET)
	public String abrirTelaUsuario(Model model){
		return "usuarioCadastro";
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme, HttpSession session) {
		filmeDao.inserir(filme);
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		Usuario usuarioAdministrador = (Usuario) session.getAttribute("usuarioAdministrador");
		if(usuarioAdministrador != null && usuarioAdministrador.isAdministrador() == true){
			model.addAttribute("admin", usuarioAdministrador.isAdministrador());
			return "cadastroFilme";
		}else
			return "telaLogin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Usuario usuario, Model model, HttpSession session){
		Usuario u = usuarioDao.login(usuario.getNome(), usuario.getSenha());
		if(u != null){
			session.setAttribute("usuarioLogado", u);
			return  "redirect:/consultaFilme";
		}
		
		return "telaLogin";
	}
	
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	 public String avaliarFilme(int idFilme, int avaliacao){
		filmeDao.avaliarFilme(idFilme, avaliacao);
		return "telaConsulta";
	}
	
	@ResponseBody //@ResponseBody faz transformar o retorno para JSON!
	@RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	public List<Filme> buscarTodos(Model model) {
		model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
		return filmeDao.buscaTodosFilmesJava8();
	}
	
	@RequestMapping(value = "/buscarUm", method = RequestMethod.GET)
	public String buscarUm(String nome, Model model) {
		model.addAttribute("filme", filmeDao.buscaFilmePeloNome(nome));	
		return "consultaFilme";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String cadastrarUsuario(Model model, Usuario usuario){
		usuarioDao.cadastrarUsuario(usuario);
		return "telaLogin";
	}
}
