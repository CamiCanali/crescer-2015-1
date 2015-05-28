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
public class UsuarioDao {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void cadastrarUsuario(Usuario usuario){
		jdbcTemplate.update("INSERT INTO Usuario (nome, senha) VALUES (?,?)", usuario.getNome(), 
				usuario.getSenha());
	}
	
	public List<Usuario> login(String nome, int senha){
		return jdbcTemplate.query("SELECT * FROM Usuario where nome like (?) AND senha like (?)", new RowMapper<Usuario>() {
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getInt("senha"));
				return usuario;
			}
		}, nome, senha);
	}
	
}
