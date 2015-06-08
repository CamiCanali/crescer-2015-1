package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome, genero, ano, imagem, sinopse) VALUES (?,?,?,?,?)", filme.getNome(), 
				filme.getGenero().name(),filme.getAno(), filme.getImagem(), filme.getSinopse());
	}

	public List<Filme> buscaTodosFilmesJava8(){
		return jdbcTemplate.query("SELECT nome, genero, ano, imagem, sinopse FROM Filme", new RowMapper<Filme>(){	
			//Filme filme = new Filme(rs.getString("nome"));
			//return filme;
			
				@Override
				public Filme mapRow(ResultSet rs, int arg) throws SQLException {
					Genero genero = Genero.valueOf(rs.getString("genero"));
					Filme filme = new Filme();
					filme.setNome(rs.getString("nome"));
					filme.setGenero(genero);
					filme.setAno(rs.getInt("ano"));
					filme.setImagem(rs.getString("imagem"));
					filme.setSinopse(rs.getString("sinopse"));
					//filme.setAvaliacao(rs.getInt("avaliacao"));			
					return filme;
				}			
		});	
	}

	public List<Filme> buscaFilmePeloNome(String nome) {
		return jdbcTemplate.query("SELECT * FROM Filme where nome like (?)", new RowMapper<Filme>() {
			public Filme mapRow(ResultSet rs, int rowNum) throws SQLException{
				Filme filme = new Filme();
				filme.setNome(rs.getString("nome"));
				filme.setGenero(Genero.valueOf(rs.getString("genero")));
				filme.setAno(rs.getInt("ano"));
				filme.setImagem(rs.getString("imagem"));
				filme.setSinopse(rs.getString("sinopse"));
				//filme.setAvaliacao(rs.getInt("avaliacao"));	
				return filme;
			}
		}, nome);
	}

	public void avaliarFilme(int idDoFilme, double nota) {
		jdbcTemplate.update("INSERT Into Avaliacao SET nota = (?) where idDoFilme = (?)", nota, idDoFilme);	
	}
}
 