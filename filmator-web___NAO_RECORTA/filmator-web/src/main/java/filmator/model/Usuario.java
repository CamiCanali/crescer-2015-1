package filmator.model;

public class Usuario {
	private String nome;
	private String senha;
	private String administrador;
	
	public Usuario(){}
	
	public String getSenha() {
		return senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getAdministrador(){
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	
}
