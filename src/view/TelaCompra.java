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

public class TelaCompra extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompra frame = new TelaCompra();
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
	public TelaCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Escolha a op\u00E7\u00E3o desejada");
		lblNewLabel.setBounds(228, 95, 156, 14);
		contentPane.add(lblNewLabel);
		
		JButton botaoCompra = new JButton("Comprar");
		botaoCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaOperacoes().setVisible(true);
				dispose();
			}
		});
		botaoCompra.setBounds(253, 161, 89, 23);
		contentPane.add(botaoCompra);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoSair.setBounds(253, 231, 89, 23);
		contentPane.add(botaoSair);
	}
}
