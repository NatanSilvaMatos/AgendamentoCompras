package model;

import javax.swing.JOptionPane;

import controller.Estoque;

public class Produto {
	private String descricao;
	private double valor;
	private int quantidadeEstoque;
	private int quantidadeCompra;
	private Produto proximo;
	private Produto anterior;
	Estoque e = new Estoque();
	
	public Produto(){
		e.abasteceEstoque();
		proximo = null;
		anterior = null;
	}
	
	public void cadastrarProduto(String nomeProduto, double valor, int quantidade) {
		this.descricao = nomeProduto;
		this.valor = valor;
		this.quantidadeEstoque = quantidade;
	}
	
	public void listarProduto() {
		System.out.println("Produto = " + getDescricao() + "\nValor = " + getValor());
	}
	
	public int listarQuantidade() {
		int qtd = this.getQuantidadeEstoque();
		return qtd;
	}
	
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
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

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Produto getProximo() {
		return proximo;
	}

	public void setProximo(Produto proximo) {
		this.proximo = proximo;
	}

	public Produto getAnterior() {
		return anterior;
	}

	public void setAnterior(Produto anterior) {
		this.anterior = anterior;
	}
	
	public static void main(String[] args) {
		int opc = 0; 
		while (opc!=9)
	        {
	            opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Cadastrar Produto \n 2 - Comprar \n 9 - Finalizar"));
	            switch (opc)     
	            {
	                case 1: System.out.println("Cadastrar Produto");
	                         break;
	                case 2: System.out.println("opcao 2");;
	                         break;
	                case 3: System.out.println("compra");
	                		break;
	                case 9: JOptionPane.showMessageDialog(null,"FINALIZADO ");
	                         break;
	                default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
	            }  
	        }  
	    } 
	}
	
	
