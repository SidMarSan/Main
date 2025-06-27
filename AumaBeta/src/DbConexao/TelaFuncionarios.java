package DbConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfFuncao;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private JTextField tfConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	public TelaFuncionarios() {
		setTitle("Cadastro de Funcionários");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
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
		
		tfMatricula = new JTextField();
		tfMatricula.setEditable(false);
		tfMatricula.setBounds(125, 149, 125, 20);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(23, 189, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfNome = new JTextField();
		tfNome.setBounds(125, 186, 399, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setBounds(22, 225, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(125, 222, 125, 20);
		contentPane.add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone:");
		lblNewLabel_5.setBounds(23, 260, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(125, 257, 125, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		lblNewLabel_6.setBounds(22, 297, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(125, 294, 125, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Função:");
		lblNewLabel_7.setBounds(23, 336, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		tfFuncao = new JTextField();
		tfFuncao.setBounds(125, 333, 125, 20);
		contentPane.add(tfFuncao);
		tfFuncao.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Login:");
		lblNewLabel_8.setBounds(22, 374, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(125, 371, 125, 20);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Senha:");
		lblNewLabel_9.setBounds(23, 405, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(125, 402, 125, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		tfConsultar = new JTextField();
		tfConsultar.setToolTipText("Didite aqui a matrícula para consultar funcionarios");
		tfConsultar.setBounds(125, 20, 125, 20);
		contentPane.add(tfConsultar);
		tfConsultar.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfConsultar.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Informe o numero de Matrícula válido !");
				} else {
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql = "select *from funcionarios_auma where matricula=?";
					PreparedStatement stmt= con.prepareStatement(sql);
					stmt.setString(1, tfConsultar.getText());
					ResultSet rs = stmt.executeQuery();
					
					while (rs.next()) {
						tfMatricula.setText(rs.getString("matricula"));
						tfNome.setText(rs.getString("nome"));
						tfCPF.setText(rs.getString("cpf"));
						tfTelefone.setText(rs.getString("telefone"));
						tfEmail.setText(rs.getString("email"));
						tfFuncao.setText(rs.getString("funcao"));
						tfLogin.setText(rs.getString("login"));
						tfSenha.setText(rs.getString("senha"));
					}
					rs.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				
				
			}
			
			
		});
		btnConsultar.setBounds(10, 19, 101, 23);
		contentPane.add(btnConsultar);
		
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfMatricula.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Informe o numero de Matrícula válido !");
					}
				else {
				try {
					Connection con = Conexao.fazer_conexao();
					String sql = "update funcionarios_auma set nome=?, cpf=?, telefone=?, email=?, funcao=?, login=?, senha=? where matricula=?";
					PreparedStatement stmt= con.prepareStatement(sql);
					
					
					stmt.setString(1, tfNome.getText());
					stmt.setString(2, tfCPF.getText());
					stmt.setString(3, tfTelefone.getText());
					stmt.setString(4, tfEmail.getText());
					stmt.setString(5, tfFuncao.getText());
					stmt.setString(6, tfLogin.getText());
					stmt.setString(7, tfSenha.getText());
					stmt.setString(8, tfMatricula.getText());
					
					stmt.execute();
					stmt.close();
					con.close();	
					JOptionPane.showMessageDialog(null,"Dados atualizados com Sucesso !");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				
			}
		});
		btnEditar.setBounds(10, 80, 101, 23);
		contentPane.add(btnEditar);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		lblNewLabel_10.setBounds(445, 155, 328, 339);
		contentPane.add(lblNewLabel_10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (tfConsultar.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe a matrícula!");
				} else 
				{
					
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql = "delete from funcionarios_auma where matricula = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfMatricula.getText());
					 stmt.execute();
					 
					 stmt.close();
					 con.close();
					 JOptionPane.showMessageDialog(null, "Cadastro Excluido com Sucesso!");
					
					tfMatricula.setText("");
					tfNome.setText("");
					tfCPF.setText("");
					tfTelefone.setText("");
					tfEmail.setText("");
					tfFuncao.setText("");
					tfLogin.setText("");
					tfSenha.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			}
		});
		btnExcluir.setBounds(10, 46, 101, 23);
		contentPane.add(btnExcluir);
	}
}
