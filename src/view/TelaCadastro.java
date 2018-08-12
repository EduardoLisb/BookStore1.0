package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 47, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(66, 44, 191, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-selecione-", "Cliente", "Funcion\u00E1rio", "Forncedor"}));
		comboBox.setBounds(66, 15, 95, 20);
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 18, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 76, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-selecione-", "Masculino", "Feminino", "Outros"}));
		comboBox_1.setBounds(66, 75, 77, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblRamal = new JLabel("Ramal");
		lblRamal.setBounds(10, 111, 46, 14);
		contentPane.add(lblRamal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 108, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 147, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 144, 100, 20);
		contentPane.add(passwordField);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}
