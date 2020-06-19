package controller;

import javax.swing.JOptionPane;

import model.Produto;

public class ListaCompra {
	private Produto inicio;
	private int tamanho;
	
	public ListaCompra() {
		inicio = null;
		tamanho = 0;
	}
	
	public boolean vazia() {
		if(tamanho == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void adicionaInicio() {
		Produto novo = new Produto();
		
		if(vazia()) {
			inicio = novo;
			tamanho++;
		}
		else {
			novo.setProximo(inicio);
			inicio.setAnterior(novo);
			inicio = novo;
			tamanho++;
		}
	}
	
	public void adicionaPosicao(int posicao) {
		Produto novo = new Produto();
		if(vazia() || posicao == 1) {
			adicionaInicio();
		}
		else if(posicao <= 0 || posicao > tamanho) {
			throw new IndexOutOfBoundsException();
		}
		else if(posicao == tamanho) {
			adicionaFinal();
		}
		else {
			Produto aux = inicio;
			int contador = 0;
			while(aux.getProximo() != null && contador < posicao - 1) {
				aux = aux.getProximo();
				contador++;
			}
			novo.setProximo(aux.getProximo());
			aux.setProximo(novo);
			novo.setAnterior(aux);
			tamanho++;
		}
	}
	
	public void adicionaFinal() {
		Produto novo = new Produto();
		
		if(vazia()) {
			adicionaInicio();
		}
		else {
			Produto aux = inicio;
			while(aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
			novo.setAnterior(aux);
			tamanho++;
		}
	}
	
	public void removeInicio() {
		if(vazia()) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		}
		else {
			inicio = inicio.getProximo();
			if(inicio != null) {
				inicio.setAnterior(null);
			}
			tamanho--;
		}
	}
	
	public void removePosicao(int posicao) {
		if(vazia()) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		}
		else if(posicao <= 0 || posicao > tamanho){
			throw new IndexOutOfBoundsException();
		}
		else if(posicao == 1) {
			removeInicio();
		}
		else if(posicao == tamanho) {
			removeFinal();
		}
		else {
			Produto aux = inicio, anterior = inicio;
			while(posicao > 1) {
				anterior = aux;
				aux = aux.getProximo();
				posicao--;
			}
			aux.getProximo().setAnterior(anterior);
			anterior.setProximo(aux.getProximo());
			tamanho--;
		}
	}
	
	public void removeFinal() {
		if(vazia()) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		}
		else {
			Produto aux = inicio, anterior = inicio;
			while(aux.getProximo() != null) {
				anterior = aux;
				aux = aux.getProximo();
			}
			anterior.setProximo(null);
			tamanho--;
		}
	}
	
	public String mostrarLista() {
		String mensagem = "";
		Produto aux = inicio;
		int qtd = 0;
		while(aux != null) {
			qtd++;
			mensagem = mensagem + "\n" + qtd + "- Produto = " + aux.getDescricao() + "  Quantidade estoque = " + aux.getQuantidadeEstoque() + " Valor = " + aux.getValor()
			+ "  Quantidade a ser comprado = " + aux.getQuantidadeCompra();
			aux = aux.getProximo();
		}
		return mensagem;
	}
	
	public static void main(String[] args) {
		ListaCompra compra = new ListaCompra();
		
		compra.adicionaInicio();
		System.out.println(compra.mostrarLista());
	}
}
