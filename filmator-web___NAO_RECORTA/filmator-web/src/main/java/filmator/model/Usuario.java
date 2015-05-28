package filmator.model;

public class Usuario {
	private String nome;
	private int senha;
	//private boolean adiministrador;
	
	public Usuario(String nome, int senha){
		this.nome = nome;
		this.senha = senha;
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
}
