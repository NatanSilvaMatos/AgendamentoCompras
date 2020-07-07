package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.Border;
import model.Compra;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JList;

public class TelaPagamento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPagamento frame = new TelaPagamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JTextArea textArea = new JTextArea();
	/**
	 * Create the frame.
	 */
	public TelaPagamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Compras");
		lblNewLabel.setBounds(22, 29, 126, 14);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(21, 71, 348, 188);
		contentPane.add(textArea);
		textArea.setColumns(10);
		textArea.setEditable(false);

		
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		StringBuilder sb = new StringBuilder();
		try {
			fileReader = new FileReader("ListaCompra.txt");
			bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			try {
				while((linha = bufferedReader.readLine()) != null) {
					sb.append(linha + "\n");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		textArea.setText(sb.toString());
		

		DefaultListModel model = new DefaultListModel();
		
		 //javax.swing.border.Border border BorderFactory.createEtchedBorder(1);
	       //list.setBorder(border);
	       //textoPreco.setBorder(border);
	     
		
		JButton btnAgendarCompra = new JButton("Agendar Compra");
		btnAgendarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAgendamento().setVisible(true);
				dispose();
			}
		});
		btnAgendarCompra.setBounds(54, 371, 135, 23);
		contentPane.add(btnAgendarCompra);
		
		JButton btnRetirarNaLoja = new JButton("Retirar na Loja");
		btnRetirarNaLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConfirmacaoPagamento().setVisible(true);
				dispose();
			}
		});
		btnRetirarNaLoja.setBounds(247, 371, 135, 23);
		contentPane.add(btnRetirarNaLoja);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaProduto("natan").setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(432, 371, 135, 23);
		contentPane.add(btnVoltar);
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(22, 54, 268, 228);
		//contentPane.add(scrollPane);
		//scrollPane.setViewportView(textArea);
	}
}
