package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Cliente;
import beans.Endereco;
import beans.Funcionario;
import beans.Sexo;
import dao.ClienteDAO;
import dao.FuncionarioDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> tipoCadastro;
	// coloca o nome doq se trata
	private JTextField txt_nome;
	private JComboBox<String> cb_sexo;
	private JTextField txt_ramal;
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
		//
		btnCadastrar.addActionListener(new ButtonClickListener());
		btnCadastrar.setActionCommand("Cadastrar");
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 47, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(66, 44, 191, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		tipoCadastro = new JComboBox<>();
		tipoCadastro.setModel(new DefaultComboBoxModel<String>(new String[] {"-selecione-", "Cliente", "Funcion\u00E1rio", "Forncedor"}));
		tipoCadastro.setBounds(66, 15, 95, 20);
		contentPane.add(tipoCadastro);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 18, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 76, 46, 14);
		contentPane.add(lblSexo);
		
		cb_sexo = new JComboBox<>();
		cb_sexo.setModel(new DefaultComboBoxModel<String>(new String[] {"-selecione-", "Masculino", "Feminino", "Outros"}));
		cb_sexo.setBounds(66, 75, 77, 20);
		contentPane.add(cb_sexo);
		
		JLabel lblRamal = new JLabel("Ramal");
		lblRamal.setBounds(10, 111, 46, 14);
		contentPane.add(lblRamal);
		
		txt_ramal = new JTextField();
		txt_ramal.setBounds(66, 108, 86, 20);
		contentPane.add(txt_ramal);
		txt_ramal.setColumns(10);
		
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
	private void cadastrar() {
		String tipoCadastro = this.tipoCadastro.getSelectedItem()+"";
		if (tipoCadastro.equals("Cliente")) {
			
		} else if (tipoCadastro.equals("Funcionário")) {
			System.out.println("nome "+this.txt_nome.getText()+" ramal "+txt_ramal.getText());
			Funcionario f = new Funcionario(null, 1000d, 0, Integer.parseInt(txt_ramal.getText()),
					null, null, 0, Sexo.valueOf(cb_sexo.getSelectedItem().toString().toLowerCase()), null, txt_nome.getText(), 0, 0, 0);
			/*
			 * Devia fazer assim pra saber se cadastrou ou não
			 */
			try {
				FuncionarioDAO.create(f, new Endereco(666, "Rua rural", "Eh difisio", "Logaritmo"));
			} catch(Exception e) {
				// TODO Fazer as DAO lançar exception ou retornar boolean
				e.printStackTrace();
			}
		} else if (tipoCadastro.equals("Fornecedor")) {
			
		}
	}
	// Listener da tela
	private class ButtonClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String exec = e.getActionCommand();
			if (exec.equals("Cadastrar")) {
				cadastrar();
			} else if (exec.equals("Voltar")) {
				// Volte
			}
			
		}
		
	}
}
