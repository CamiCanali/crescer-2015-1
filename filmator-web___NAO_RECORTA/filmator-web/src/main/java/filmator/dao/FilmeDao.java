package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome) VALUES (?)", filme.getNome());
	}
	
	public List<Filme> buscaTodosFilmesJava8(){
		return jdbcTemplate.query("SELECT nome FROM Filme", (ResultSet rs, int rowNum) -> {	
			Filme filme = new Filme(rs.getString("nome"));
			return filme;
		});	
	}
}
 