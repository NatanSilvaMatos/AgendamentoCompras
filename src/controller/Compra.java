package controller;

import javax.swing.JOptionPane;

import model.Usuario;

public class Compra {
	private Usuario usuario;
	private ListaCompra lista;

	public Compra(Usuario usuario) {
		this.usuario = usuario;
	}

	public void agendarCompra() {

	}

	public void compra() {

	}

	public void cancelarCompra() {

	}

	public void emitirConfirmacaoPagamento() {

	}

	public void inserirItens() {
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha como quer inserir os itens\n \n1 - Adicionar no Inicio \n2 - Adicionar numa determina posicao \n3 - Adicionar"
					+ " no final \n4 - Mostrar lista \n9 - Finalizar compra"));
			switch(opc){
			case 1: lista.adicionaInicio();
				JOptionPane.showMessageDialog(null, "inicio");
			break;
			case 2: JOptionPane.showMessageDialog(null, "posicao");
			break;
			case 3: JOptionPane.showMessageDialog(null, "final");
			break;
			case 4: lista.mostrarLista();
				JOptionPane.showMessageDialog(null, "mostrando a lista");
			break;
			case 9: JOptionPane.showMessageDialog(null, "finalizando");
			break;
			default: JOptionPane.showMessageDialog(null, "inicio");
			break;
			}
		} 
	}

	public void removerItens() {
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha como quer remover os itens\n \n1 - Remover no Inicio \n2 - Remover numa determina posicao \n3 - Remover"
					+ " no final \n9 - Finalizar compra"));
			switch(opc){
			case 1: JOptionPane.showMessageDialog(null, "inicio");
			break;
			case 2: JOptionPane.showMessageDialog(null, "posicao");
			break;
			case 3: JOptionPane.showMessageDialog(null, "final");
			break;
			case 9: JOptionPane.showMessageDialog(null, "finalizando");
			break;
			default: JOptionPane.showMessageDialog(null, "inicio");
			break;
			}
		} 
	}
	
	public static void main(String[] args) {
		Usuario p = new Usuario();
		Compra c = new Compra(p);
		
		
		//c.inserirItens();
		//c.removerItens();
	}

}
