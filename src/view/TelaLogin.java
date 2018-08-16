package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;

/* CLICA BOTAO DIREITO EM VIEW, NEW > (ULTIMAOPCAO) OTHER > JFRAME
 * DPS QUE CRIA, CLICA EM CONTENTPANE
 * CLICA EM LAYOUT > ABSOLUT
 * E AI TU PODE ADICIONAR QLQR COISA NA TELA E COLOCAR NO LUGAR QUE TU QUISER
 * PRA BUTAO EU TO USANDO JBUTOM
 * PRA ESPAÇO DE TEXTO TOU USANDO JTEXTFIELD
 * PRA ESPACO DE SENHA TO USANDO PASSWORD FIELD
 * PRA COLOCAR O NOME DO QUE EU TOU REFERENCIANDO TO USANDO JLABEL
 * PRA COLOCAR ATRIBUTOS MULTIVALORADOS, TO USANDO JCOMBOBOX
 * TODOS ESSES "ACESSORIOS" TAO EM COMPONENTS
 * DPS QUE CRIA A TELA, BOTAO, ESPACO DE TEXTO, ETC, TEM QUE IR NOS METODOS E IMPLEMENTAR OQ DEVE SER FEITO
 * EU ACHO QUE TEM Q SE CRIAR A INTERFACE (QUE É UM CONCEITO QUE NUNCA ENTENDI) ENTAO SINTAM-SE A VONTADE
 * 
 */
public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setTitle("BookStore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel botaoLogin = new JLabel("ID");
		botaoLogin.setBackground(Color.GRAY);
		botaoLogin.setBounds(25, 52, 46, 14);
		contentPane.add(botaoLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(25, 95, 46, 14);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(117, 92, 230, 20);
		contentPane.add(passwordField);

		textID = new JTextField();
		textID.setBounds(117, 49, 230, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textID.getText().equals("") && passwordField.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha todos os espacos");
				} else if (textID.getText().equals("bookstore") && passwordField.getText().equals("123")) {
					TelaEspacoADM telaADM = new TelaEspacoADM();
					telaADM.setResizable(false);
					telaADM.setLocationRelativeTo(null);
					telaADM.setVisible(true);
					dispose();
				} /* fazer veriicaçao pra saber se o user existe */
				
				

			}
		});
		btnLogin.setBounds(162, 155, 89, 23);
		contentPane.add(btnLogin);
	}
}
