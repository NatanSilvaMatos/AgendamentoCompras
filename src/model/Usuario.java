package model;

public class Usuario {
	private String nome;
	private int CPF;
	private String email;
	private String senha;
	
	
	public void cadastrarUsuario(String nome, int cpf, String email, String senha) {
		setNome(nome);
		setCPF(cpf);
		setEmail(email);
		setSenha(senha);
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
