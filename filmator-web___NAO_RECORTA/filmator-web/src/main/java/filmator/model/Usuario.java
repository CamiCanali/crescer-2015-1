package filmator.model;

public class Usuario {
	private String nome;
	private int senha;
	private boolean administrador;
	
	public Usuario(String nome, int senha, boolean administrador){
		this.nome = nome;
		this.senha = senha;
		this.administrador = administrador;
	}
	
	public Usuario(){}
	
	public int getSenha() {
		return senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public boolean isAdministrador(){
		return administrador;
	}
	public void setAdministrador(){
		this.administrador = true;
	}
}
