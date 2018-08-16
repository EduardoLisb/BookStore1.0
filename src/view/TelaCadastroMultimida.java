package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.MultimidiaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastroMultimida extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMultimida frame = new TelaCadastroMultimida();
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
	public TelaCadastroMultimida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Titulo");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(64, 8, 86, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblDuracao = new JLabel("Duracao em min");
		lblDuracao.setBounds(10, 55, 80, 14);
		contentPane.add(lblDuracao);
		
		textField = new JTextField();
		textField.setBounds(100, 52, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxDigital = new JCheckBox("CD");
		chckbxDigital.setBounds(266, 11, 97, 23);
		contentPane.add(chckbxDigital);
		
		JCheckBox chckbxDvd = new JCheckBox("DVD");
		chckbxDvd.setBounds(266, 51, 97, 23);
		contentPane.add(chckbxDvd);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textTitulo.getText().equals("") || textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campops");
				}
				else {
					try {
						MultimidiaDAO multDao = new MultimidiaDAO();
						multDao.create(multDao.toString(textTitulo.getText()));
						
					} catch (SQLException s) {
						
					}
					
				}
			}
		});
		btnCadastrar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(1, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
