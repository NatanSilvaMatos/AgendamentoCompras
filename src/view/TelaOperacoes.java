package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOperacoes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOperacoes frame = new TelaOperacoes();
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
	public TelaOperacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Escolha a op\u00E7\u00E3o para adicionar ou remover itens do Carrinho");
		lblNewLabel.setBounds(146, 54, 366, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnAdicionarInicio = new JButton("Adicionar no Inicio");
		btnAdicionarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaProduto().setVisible(true);
				dispose();
			}
		});
		btnAdicionarInicio.setBounds(112, 118, 153, 23);
		contentPane.add(btnAdicionarInicio);
		
		JButton btnAdicionarPosicao = new JButton("Adicionar na Posicao");
		btnAdicionarPosicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaProduto().setVisible(true);
				dispose();
			}
		});
		btnAdicionarPosicao.setBounds(104, 184, 161, 23);
		contentPane.add(btnAdicionarPosicao);
		
		JButton btnAdicionarFinal = new JButton("Adicionar no Final");
		btnAdicionarFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaProduto().setVisible(true);
				dispose();
			}
		});
		btnAdicionarFinal.setBounds(112, 256, 153, 23);
		contentPane.add(btnAdicionarFinal);
		
		JButton btnRemoverInicio = new JButton("Remover no Inicio");
		btnRemoverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoverInicio.setBounds(372, 118, 153, 23);
		contentPane.add(btnRemoverInicio);
		
		JButton btnRemoverNaPosicao = new JButton("Remover na Posicao");
		btnRemoverNaPosicao.setBounds(372, 184, 153, 23);
		contentPane.add(btnRemoverNaPosicao);
		
		JButton btnRemoverNoFinal = new JButton("Remover no Final");
		btnRemoverNoFinal.setBounds(372, 256, 153, 23);
		contentPane.add(btnRemoverNoFinal);
		
		JButton btnMostrarLista = new JButton("Mostrar Lista");
		btnMostrarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMostrarLista.setBounds(112, 320, 153, 23);
		contentPane.add(btnMostrarLista);
		
		JButton btnOrdenarLista = new JButton("Ordenar Lista");
		btnOrdenarLista.setBounds(372, 320, 153, 23);
		contentPane.add(btnOrdenarLista);
		
		JButton btnSeguirParaPagamento = new JButton("Seguir para Pagamento");
		btnSeguirParaPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPagamento().setVisible(true);
				dispose();
			}
		});
		btnSeguirParaPagamento.setBounds(226, 385, 168, 23);
		contentPane.add(btnSeguirParaPagamento);
	}

}
