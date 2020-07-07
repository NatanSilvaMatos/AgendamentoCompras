package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Usuario {
	private String nome;
	private String CPF;
	private String email;
	private String senha;
	private String tipoUsuario;

	public void cadastrarUsuario(String nome, int cpf, String email, String senha, String tipoUsuario) {
		// TODO: remover trecho abaixo, caso seja necessário
		//setNome(nome);
		//setCPF(cpf);
		//setEmail(email);
		//setSenha(senha);


		try {
			FileWriter writer = new FileWriter("Usuario.txt", true);
			BufferedWriter cadastro = new BufferedWriter(writer);
			CharSequence cadeia =  nome + ";" + Integer.toString(cpf) + ";" + email + ";" + senha + ";" + tipoUsuario;
			cadastro.append(cadeia);
			cadastro.append("\n");

			cadastro.close();

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

	}
	public String verificarUsuario(String email, String senha) {
		try {
			FileReader fileReader = new FileReader("Usuario.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";

			ArrayList<String> result = new ArrayList<String>();

			while ((linha = bufferedReader.readLine()) != null) {
				//System.out.println(linha);

				if (linha != null && !linha.isEmpty()) {
					result.add(linha);
				}
			}
			
			fileReader.close();
			bufferedReader.close();

			for(String s : result) {
				String[] user = s.split(";");

				Usuario u = new Usuario();
				u.setNome(user[0]);
				u.setCPF(user[1]);
				u.setEmail(user[2]);
				u.setSenha(user[3]);
				u.setTipoUsuario(user[4]);

				if(u.email.equals(email) && u.senha.equals(senha)) {
					JOptionPane.showMessageDialog(null, "Logado com sucesso", "Login", JOptionPane.PLAIN_MESSAGE);

					return u.nome + ";" + u.tipoUsuario + ";" + u.CPF;
				}

			}

		}
		catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "E-mail ou senha inválidos", "Login", JOptionPane.WARNING_MESSAGE);
		return "";
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
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
