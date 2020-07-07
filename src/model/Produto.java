package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Produto {
	private String cnpjVendedor;
	private String descricao;
	private double valor;
	private int quantidade;


	public Produto(){
		//TODO: apagar trecho abaixo se for necessário
		//		e.abasteceEstoque();
		//		proximo = null;
		//		anterior = null;
	}

	public void cadastrarProduto(String cnpjVendedor, String nomeProduto, double valor, int quantidade) {
		Produto novo = new Produto();
		try {
			FileWriter writer = new FileWriter("Produto.txt", true);
			BufferedWriter cadastro = new BufferedWriter(writer);
			CharSequence cadeia =  cnpjVendedor + ";" + nomeProduto + ";" + valor + ";" + quantidade;
			cadastro.append(cadeia);
			cadastro.append("\n");

			cadastro.close();

			JOptionPane.showMessageDialog(null, "Produto cadastrado!", "Cadastro de Produto", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		novo.setDescricao(nomeProduto);
		novo.setValor(valor);
		novo.setQuantidade(quantidade);
	}

	public void listarProduto() {
		System.out.println("Produto = " + getDescricao() + "\nValor = " + getValor());
	}

	public int listarQuantidade() {
		int qtd = this.getQuantidade();
		return qtd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidadeEstoque) {
		this.quantidade = quantidadeEstoque;
	}

}


