package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import beans.Endereco;
import beans.Funcionario;
import beans.Sexo;
import beans.Vendedor;
import connection.ConnectionFactory;
import dao.FuncionarioDAO;
import dao.VendedorDAO;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastroVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textRamal;
	private JTextField textIdade;
	private JPasswordField passwordField;
	private JTextField textEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVendedor frame = new TelaCadastroVendedor();
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
	public TelaCadastroVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaSelecaoCadastro telSelCad = new TelaSelecaoCadastro();
				telSelCad.setResizable(false);
				telSelCad.setLocationRelativeTo(null);
				telSelCad.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 309, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNome.getText().equals("") || textCPF.getText().equals("") || textRamal.getText().equals("")
						|| textIdade.getText().equals("") || passwordField.getPassword().equals("")
						|| textEndereco.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campops");
				} else {
					try {
						Funcionario f = new Funcionario((long) Integer.parseInt(textCPF.getText()));
						f.setCnpj_filial(ConnectionFactory.getFilial());
						f.setRamal(Integer.parseInt(textRamal.getText()));
						Endereco end = new Endereco(0, "", "", "");
						FuncionarioDAO.create(f, end);
//						VendedorDAO.create(f, end);
						JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso");

						TelaEspacoADM telaADM = new TelaEspacoADM();
						telaADM.setResizable(false);
						telaADM.setLocationRelativeTo(null);
						telaADM.setVisible(true);
						dispose();
					} catch (SQLException sql) {
						
					}
				}
			}
		});
		btnCadastrar.setBounds(335, 309, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 22, 46, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(66, 19, 101, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblRamal = new JLabel("Ramal");
		lblRamal.setBounds(10, 98, 46, 14);
		contentPane.add(lblRamal);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 56, 46, 14);
		contentPane.add(lblCpf);

		textCPF = new JTextField();
		textCPF.setBounds(66, 53, 101, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		textRamal = new JTextField();
		textRamal.setBounds(66, 95, 86, 20);
		contentPane.add(textRamal);
		textRamal.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(271, 19, 94, 20);
		contentPane.add(comboBox);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(231, 22, 46, 14);
		contentPane.add(lblSexo);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 131, 46, 14);
		contentPane.add(lblIdade);

		textIdade = new JTextField();
		textIdade.setBounds(66, 128, 38, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 167, 46, 14);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(66, 167, 65, 17);
		contentPane.add(passwordField);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 218, 46, 14);
		contentPane.add(lblEndereco);

		textEndereco = new JTextField();
		textEndereco.setBounds(78, 215, 321, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
	}
}
