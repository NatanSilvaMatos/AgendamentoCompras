package view;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.MouseEvent;
import com.sun.prism.paint.Color;

import javafx.scene.layout.Border;
import model.Compra;
import model.Produto;
import model.Usuario;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.MutableComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textoQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto frame = new TelaProduto("natan"); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String nome;
	
	//public TelaProduto() {

   // }
	
	/**
	 * Create the frame.
	 */
	public static String variavel = null;
	public TelaProduto(String nomeUsuario) {
		nome = nomeUsuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o item a ser adicionado no carrinho e escolha a quantidade");
		lblNewLabel.setBounds(29, 37, 400, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantidade = new JLabel("Quantidade Dispon\u00EDvel");
		lblQuantidade.setBounds(334, 93, 131, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(556, 93, 69, 14);
		contentPane.add(lblPreco);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(556, 190, -20, 22);
		contentPane.add(textArea);
		
		JTextArea textPreco = new JTextArea();
		textPreco.setBounds(600, 88, 69, 22);
		contentPane.add(textPreco);
		textPreco.setEditable(false);
		
		textoQuantidade = new JTextField();
		textoQuantidade.setBounds(464, 90, 60, 20);
		contentPane.add(textoQuantidade);
		textoQuantidade.setColumns(10);
		textoQuantidade.setEditable(false);
		
		DefaultListModel model = new DefaultListModel();
		JList lista = new JList();
		contentPane.add(lista);
		lista.setModel(model);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setBounds(28, 143, 258, 228);
		lista.setVisible(true);

		lista.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int item = lista.getSelectedIndex();
				if(item < 0) {
				}
				else {
					try {
						FileReader fileReader = new FileReader("Produto.txt");
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						String linha = "";
						int contador = 0;
						ArrayList<String> result = new ArrayList<String>();

						try {
							while((linha = bufferedReader.readLine()) != null) {
								if (linha != null && !linha.isEmpty()) {
									result.add(linha);
								}
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						ArrayList<Produto> produtos = new ArrayList<Produto>();
						String[] vetor = new String[20];

						for(String s: result) {	

							String[] part = s.split(";");

							Produto novo = new Produto();
							novo.setDescricao(part[1]);
							novo.setValor(Double.parseDouble(part[2]));
							novo.setQuantidade(Integer.parseInt(part[3]));

							produtos.add(novo);
						}


						int selecionado = lista.getSelectedIndex();
						textoQuantidade.setText(Integer.toString(produtos.get(selecionado).getQuantidade()));
						textPreco.setText(Double.toString(produtos.get(selecionado).getValor()));


						try {
							fileReader.close();
							bufferedReader.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

				}
				}
				
			}
		);
        
        javax.swing.border.Border border = BorderFactory.createEtchedBorder(1);
        lista.setBorder(border);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try {
					FileReader fileReader = new FileReader("Produto.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String linha = "";
					int contador = 0;
					ArrayList<String> result = new ArrayList<String>();

					try {
						while((linha = bufferedReader.readLine()) != null) {
							if (linha != null && !linha.isEmpty()) {
								result.add(linha);
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					ArrayList<Produto> produtos = new ArrayList<Produto>();
					String[] vetor = new String[20];
					
					for(String s: result) {	
						
						String[] part = s.split(";");
						
						Produto novo = new Produto();
						novo.setDescricao(part[1]);
						novo.setValor(Double.parseDouble(part[2]));
						novo.setQuantidade(Integer.parseInt(part[3]));
						
						produtos.add(novo);
						
					}
					
					
					int selecionado = comboBox.getSelectedIndex();
					textoQuantidade.setText(Integer.toString(produtos.get(selecionado).getQuantidade()));
					textPreco.setText(Double.toString(produtos.get(selecionado).getValor()));
					
					
					try {
						fileReader.close();
						bufferedReader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		comboBox.setBounds(29, 89, 257, 22);
		contentPane.add(comboBox);
		
	
		
		FileReader fileReader;
		try {
			fileReader = new FileReader("Produto.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";

			ArrayList<String> result = new ArrayList<String>();
			
			try {
				while ((linha = bufferedReader.readLine()) != null) {

					if (linha != null && !linha.isEmpty()) {
						result.add(linha);
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			
			for(String s: result) {	
				
				String[] part = s.split(";");
				
				Produto novo = new Produto();
				novo.setDescricao(part[1]);
				novo.setValor(Double.parseDouble(part[2]));
				novo.setQuantidade(Integer.parseInt(part[3]));
				
				produtos.add(novo);
				
			}

			for (int i = 0; i < produtos.size(); i++) {
				comboBox.addItem(produtos.get(i).getDescricao());
			}
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		

	
		
		JButton btnAdicionar = new JButton("Adicionar ");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra c = new Compra();
				c.inserirItens(textoQuantidade, comboBox.getSelectedItem().toString(), model, textPreco, lista);
			}
		});
		btnAdicionar.setBounds(422, 171, 146, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover ");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra c = new Compra();
				c.removerItens(lista, model, textPreco);
			}
		});
		btnRemover.setBounds(417, 232, 161, 23);
		contentPane.add(btnRemover);
		
		JButton btnOrdenarPorQuantidade = new JButton("Ordenar Por Quantidade");
		btnOrdenarPorQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Produto> listaProduto = new ArrayList<Produto>();
				for(int i = 0;i < model.getSize();i++) {
					
					String item = model.getElementAt(i).toString();
					
					String[] parts = item.split("- x");
					String descricaoProduto = parts[0];
					String quantidade = parts[1];
					
					Produto produto = new Produto();
					produto.setDescricao(descricaoProduto);
					produto.setQuantidade(Integer.parseInt(quantidade));
					
					listaProduto.add(produto);
					
				}
				
				ArrayList<Produto> listaOrdenada = new Compra().mergeSort(listaProduto);
				model.clear();
				for (int i = 0; i < listaOrdenada.size(); i++) {
					model.add(i, "\n" + listaOrdenada.get(i).getDescricao() + " - x" + Integer.toString(listaOrdenada.get(i).getQuantidade()));	
				}
				
			}
		});
		btnOrdenarPorQuantidade.setBounds(407, 288, 186, 23);
		contentPane.add(btnOrdenarPorQuantidade);
		
		JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaMenuComprador(nome).setVisible(true);;
            }
        });
        btnVoltar.setBounds(29, 400, 180, 23);
        contentPane.add(btnVoltar);
        
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Compra c = new Compra();
        		c.emitirConfirmacaoPagamento(model);
        	}
        });
        btnConfirmar.setBounds(263, 400, 186, 23);
        contentPane.add(btnConfirmar);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(28, 143, 258, 228);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(lista);
	}
}
