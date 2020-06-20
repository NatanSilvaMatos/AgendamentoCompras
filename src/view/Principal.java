package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textoEmail;
	private JTextField textoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		textoEmail = new JTextField();
		textoEmail.setBounds(196, 132, 162, 20);
		contentPane.add(textoEmail);
		textoEmail.setColumns(10);
		
		textoSenha = new JTextField();
		textoSenha.setBounds(196, 205, 162, 20);
		contentPane.add(textoSenha);
		textoSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(255, 106, 31, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(255, 180, 41, 14);
		contentPane.add(lblSenha);
		

		JButton logarBotao = new JButton("Logar");
		logarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCompra().setVisible(true);
				dispose();
			}
		});
		logarBotao.setBounds(233, 273, 89, 23);
		contentPane.add(logarBotao);
	}
}
