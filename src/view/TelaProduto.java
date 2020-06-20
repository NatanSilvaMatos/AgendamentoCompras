package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto frame = new TelaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o item a ser adicionado no carrinho e escolha a quantidade");
		lblNewLabel.setBounds(29, 37, 400, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(108, 335, 60, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(29, 338, 69, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(508, 338, 69, 14);
		contentPane.add(lblPreo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(556, 190, -20, 22);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(556, 333, 49, 22);
		contentPane.add(textArea_1);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaOperacoes().setVisible(true);
			}
		});
		btnAdicionarProduto.setBounds(267, 400, 141, 23);
		contentPane.add(btnAdicionarProduto);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Banana");
		rdbtnNewRadioButton.setBounds(171, 97, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLeite = new JRadioButton("Leite");
		rdbtnLeite.setBounds(171, 143, 109, 23);
		contentPane.add(rdbtnLeite);
		
		JRadioButton rdbtnDesodorante = new JRadioButton("Desodorante");
		rdbtnDesodorante.setBounds(171, 189, 109, 23);
		contentPane.add(rdbtnDesodorante);
		
		JRadioButton rdbtnRefrigerante = new JRadioButton("Refrigerante");
		rdbtnRefrigerante.setBounds(171, 237, 109, 23);
		contentPane.add(rdbtnRefrigerante);
		
		JRadioButton rdbtnMargarina = new JRadioButton("Margarina");
		rdbtnMargarina.setBounds(171, 281, 109, 23);
		contentPane.add(rdbtnMargarina);
		
		JRadioButton rdbtnAmaciante = new JRadioButton("Amaciante");
		rdbtnAmaciante.setBounds(412, 97, 109, 23);
		contentPane.add(rdbtnAmaciante);
		
		JRadioButton rdbtnMelancia = new JRadioButton("Melancia");
		rdbtnMelancia.setBounds(412, 143, 109, 23);
		contentPane.add(rdbtnMelancia);
		
		JRadioButton rdbtnBolo = new JRadioButton("Bolo");
		rdbtnBolo.setBounds(412, 191, 109, 23);
		contentPane.add(rdbtnBolo);
		
		JRadioButton rdbtnCarne = new JRadioButton("Carne");
		rdbtnCarne.setBounds(412, 237, 109, 23);
		contentPane.add(rdbtnCarne);
		
		JRadioButton rdbtnSuco = new JRadioButton("Suco");
		rdbtnSuco.setBounds(412, 281, 109, 23);
		contentPane.add(rdbtnSuco);
		this.setLocationRelativeTo(null);
	}
}
