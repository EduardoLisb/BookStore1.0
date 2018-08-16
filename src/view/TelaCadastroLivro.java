package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LivroDAO;
import dao.VendedorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class TelaCadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textTitulo;
	private JTextField textNumEdicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLivro frame = new TelaCadastroLivro();
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
	public TelaCadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(10, 11, 46, 14);
		contentPane.add(lblIsbn);

		textISBN = new JTextField();
		textISBN.setBounds(66, 8, 95, 20);
		contentPane.add(textISBN);
		textISBN.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 55, 46, 14);
		contentPane.add(lblTitulo);

		textTitulo = new JTextField();
		textTitulo.setBounds(66, 52, 95, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);

		JCheckBox digital = new JCheckBox("Digital");
		digital.setBounds(222, 25, 97, 23);
		contentPane.add(digital);

		JCheckBox fisico = new JCheckBox("Fisico");
		fisico.setBounds(222, 55, 97, 23);
		contentPane.add(fisico);

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setBounds(10, 314, 89, 23);
		contentPane.add(btnVolta);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textISBN.getText().equals("") || textTitulo.getText().equals("")
						|| textNumEdicao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campops");
				} else {
					try {
						LivroDAO livroDao = new LivroDAO();
						if (livroDao instanceof LivroDAO) {
							
							livroDao.create(livroDao);
							JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso");

							TelaEspacoADM telaADM = new TelaEspacoADM();
							telaADM.setResizable(false);
							telaADM.setLocationRelativeTo(null);
							telaADM.setVisible(true);
							dispose();
						}
					} catch (SQLException sql) {

					}
				}
			}
		});
		btnCadastrar.setBounds(335, 314, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblEdicao = new JLabel("Edicao");
		lblEdicao.setBounds(10, 103, 46, 14);
		contentPane.add(lblEdicao);

		textNumEdicao = new JTextField();
		textNumEdicao.setBounds(66, 100, 95, 20);
		contentPane.add(textNumEdicao);
		textNumEdicao.setColumns(10);
	}
}
