package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

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
	
	public void Validar() {
		if(txtSenha.getText().isEmpty() || txtEmail.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Preencha o e-mail e a senha para efetuar login", "Cadastro", JOptionPane.WARNING_MESSAGE);

		String usuario = new Usuario().verificarUsuario(txtEmail.getText(), txtSenha.getText());
		String[] parts = usuario.split(";");
		String nome = parts[0];
		String tipoUsuario = parts[1];
		String cpfCnpj = parts[2];
		
		if(tipoUsuario.equals("Vendedor")){
			
			setVisible(false);
			TelaMenuVendedor menuVendedor = new TelaMenuVendedor(cpfCnpj, nome);
			menuVendedor.setVisible(true);
		}
		if(tipoUsuario.equals("Comprador")) {
			setVisible(false);
			TelaMenuComprador menuComprador = new TelaMenuComprador(nome);
			menuComprador.setVisible(true);
		}
			
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
		
		txtEmail = new JTextField();
		txtEmail.setBounds(196, 132, 162, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(196, 205, 162, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setBounds(196, 106, 120, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(196, 180, 100, 14);
		contentPane.add(lblSenha);
		

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validar();
			}
		});
		btnLogar.setBounds(197, 271, 89, 23);
		contentPane.add(btnLogar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setVisible(true);
			}
		});
		btnCadastrar.setBounds(295, 271, 97, 23);
		contentPane.add(btnCadastrar);
	}
}
