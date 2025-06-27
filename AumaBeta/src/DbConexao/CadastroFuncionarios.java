package DbConexao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula1;
	private JTextField tfNome1;
	private JTextField tfCPF1;
	private JTextField tfTelefone1;
	private JTextField tfEmail1;
	private JTextField tfFuncao1;
	private JTextField tfLogin1;
	private JTextField tfSenha1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarios frame = new CadastroFuncionarios();
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
	public CadastroFuncionarios() {
		setTitle("Cadastro de Funcionários");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\images2.jpeg"));
		lblNewLabel.setBounds(513, 47, 223, 119);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Funcionários");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(495, 0, 294, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Matrícula:");
		lblNewLabel_2.setBounds(22, 152, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		tfMatricula1 = new JTextField();
		tfMatricula1.setEditable(false);
		tfMatricula1.setBounds(125, 149, 125, 20);
		contentPane.add(tfMatricula1);
		tfMatricula1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(23, 189, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfNome1 = new JTextField();
		tfNome1.setBounds(125, 186, 399, 20);
		contentPane.add(tfNome1);
		tfNome1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setBounds(22, 225, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tfCPF1 = new JTextField();
		tfCPF1.setBounds(125, 222, 125, 20);
		contentPane.add(tfCPF1);
		tfCPF1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone:");
		lblNewLabel_5.setBounds(23, 260, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		tfTelefone1 = new JTextField();
		tfTelefone1.setBounds(125, 257, 125, 20);
		contentPane.add(tfTelefone1);
		tfTelefone1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		lblNewLabel_6.setBounds(22, 297, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		tfEmail1 = new JTextField();
		tfEmail1.setBounds(125, 294, 125, 20);
		contentPane.add(tfEmail1);
		tfEmail1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Função:");
		lblNewLabel_7.setBounds(23, 336, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		tfFuncao1 = new JTextField();
		tfFuncao1.setBounds(125, 333, 125, 20);
		contentPane.add(tfFuncao1);
		tfFuncao1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Login:");
		lblNewLabel_8.setBounds(22, 374, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		tfLogin1 = new JTextField();
		tfLogin1.setBounds(125, 371, 125, 20);
		contentPane.add(tfLogin1);
		tfLogin1.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Senha:");
		lblNewLabel_9.setBounds(23, 405, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		tfSenha1 = new JTextField();
		tfSenha1.setBounds(125, 402, 125, 20);
		contentPane.add(tfSenha1);
		tfSenha1.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Principal exibir = new Principal();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(10, 118, 101, 23);
		contentPane.add(btnVoltar);
		
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNome1.getText().equals("") || tfCPF1.getText().equals("")||tfTelefone1.getText().equals("")|| tfEmail1.getText().equals("")|| tfFuncao1.getText().equals("")||tfLogin1.getText().equals("")||tfSenha1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos!");  
				}
				else {
					
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql ="insert into funcionarios_auma(nome, cpf, telefone, email, funcao, login, senha) value (?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfNome1.getText());
					stmt.setString(2, tfCPF1.getText());
					stmt.setString(3, tfTelefone1.getText());
					stmt.setString(4, tfEmail1.getText());
					stmt.setString(5, tfFuncao1.getText());
					stmt.setString(6, tfLogin1.getText());
					stmt.setString(7, tfSenha1.getText());
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null,"Cadastro realizado com Sucesso!");
					
					tfNome1.setText("");
					tfCPF1.setText("");
					tfTelefone1.setText("");
					tfEmail1.setText("");
					tfFuncao1.setText("");
					tfLogin1.setText("");
					tfSenha1.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(10, 47, 101, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		lblNewLabel_10.setBounds(445, 155, 328, 339);
		contentPane.add(lblNewLabel_10);
		
		
	}

}
