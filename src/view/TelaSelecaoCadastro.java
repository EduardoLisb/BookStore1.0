package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecaoCadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecaoCadastro frame = new TelaSelecaoCadastro();
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
	public TelaSelecaoCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAuxiliar = new JButton("Auxiliar");
		btnAuxiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAuxiliar telaCadAux = new TelaCadastroAuxiliar();
				telaCadAux.setResizable(false);
				telaCadAux.setLocationRelativeTo(null);
				telaCadAux.setVisible(true);
				dispose();
			}
		});
		btnAuxiliar.setBounds(172, 33, 89, 23);
		contentPane.add(btnAuxiliar);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setBounds(335, 33, 89, 23);
		contentPane.add(btnCaixa);
		
		JButton btnGerente = new JButton("Gerente");
		btnGerente.setBounds(172, 96, 89, 23);
		contentPane.add(btnGerente);
		
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroVendedor telaCadVen = new TelaCadastroVendedor();
				telaCadVen.setResizable(false);
				telaCadVen.setLocationRelativeTo(null);
				telaCadVen.setVisible(true);
				dispose();
			}
		});
		btnVendedor.setBounds(10, 33, 89, 23);
		contentPane.add(btnVendedor);
	}
}
