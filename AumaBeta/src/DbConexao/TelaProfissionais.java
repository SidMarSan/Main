package DbConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaProfissionais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfNomeP;
	private JTextField tfEspecialidade;
	private JTextField tfRegistro;
	private JTextField tfTelefoneP;
	private JTextField tfEmailP;
	private JTextField tfConsultarP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfissionais frame = new TelaProfissionais();
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
	public TelaProfissionais() {
		setTitle("Cadastro de  Profissionais");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Profissionais");
		lblNewLabel_1.setBounds(463, 10, 255, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\images2.jpeg"));
		lblNewLabel.setBounds(476, 54, 223, 119);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Id:");
		lblNewLabel_2.setBounds(25, 151, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(122, 145, 125, 20);
		contentPane.add(tfID);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(25, 187, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfNomeP = new JTextField();
		tfNomeP.setColumns(10);
		tfNomeP.setBounds(121, 184, 399, 20);
		contentPane.add(tfNomeP);
		
		JLabel lblNewLabel_4 = new JLabel("Especialidade:");
		lblNewLabel_4.setBounds(25, 218, 102, 14);
		contentPane.add(lblNewLabel_4);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setColumns(10);
		tfEspecialidade.setBounds(122, 215, 125, 20);
		contentPane.add(tfEspecialidade);
		
		JLabel lblNewLabel_5 = new JLabel("Nº Registro");
		lblNewLabel_5.setBounds(25, 243, 102, 14);
		contentPane.add(lblNewLabel_5);
		
		tfRegistro = new JTextField();
		tfRegistro.setColumns(10);
		tfRegistro.setBounds(122, 240, 125, 20);
		contentPane.add(tfRegistro);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(25, 276, 87, 14);
		contentPane.add(lblNewLabel_6);
		
		tfTelefoneP = new JTextField();
		tfTelefoneP.setColumns(10);
		tfTelefoneP.setBounds(122, 273, 125, 20);
		contentPane.add(tfTelefoneP);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(25, 309, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		tfEmailP = new JTextField();
		tfEmailP.setColumns(10);
		tfEmailP.setBounds(122, 306, 125, 20);
		contentPane.add(tfEmailP);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal exibir = new Principal();
				exibir.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnVoltar.setBounds(10, 116, 104, 23);
		contentPane.add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfID.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Informe o numero de Matrícula válido !");
					}
				else {
				try {
					Connection con = Conexao.fazer_conexao();
					String sql = "update profissionais set nome=?, especialidade=?, n_registro=?, email=?, telefone=? where id=?";
					PreparedStatement stmt= con.prepareStatement(sql);
					
					
					stmt.setString(1, tfNomeP.getText());
					stmt.setString(2, tfEspecialidade.getText());
					stmt.setString(3, tfRegistro.getText());
					stmt.setString(4, tfEmailP.getText());
					stmt.setString(5, tfTelefoneP.getText());
					stmt.setString(6, tfID.getText());
					
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
		btnEditar.setBounds(10, 82, 102, 23);
		contentPane.add(btnEditar);
		
		tfConsultarP = new JTextField();
		tfConsultarP.setToolTipText("Digite aqui o ID do Profissional");
		tfConsultarP.setBounds(122, 16, 125, 20);
		contentPane.add(tfConsultarP);
		tfConsultarP.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tfConsultarP.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Informe o numero de Matrícula válido !");
					} else {
					
					try {
						Connection con = Conexao.fazer_conexao();
						String sql = "select *from profissionais where id=?";
						PreparedStatement stmt= con.prepareStatement(sql);
						stmt.setString(1, tfConsultarP.getText());
						ResultSet rs = stmt.executeQuery();
						
						while (rs.next()) {
							tfID.setText(rs.getString("id"));
							tfNomeP.setText(rs.getString("nome"));
							tfEspecialidade.setText(rs.getString("especialidade"));
							tfRegistro.setText(rs.getString("n_registro"));
							tfEmailP.setText(rs.getString("email"));
							tfTelefoneP.setText(rs.getString("telefone"));
							
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
		btnConsultar.setBounds(10, 12, 102, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		lblNewLabel_8.setBounds(413, 184, 286, 284);
		contentPane.add(lblNewLabel_8);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (tfConsultarP.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe a matrícula");
				} else 
				{
					
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql = "delete from profissionais where id = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfID.getText());
					 stmt.execute();
					 
					 stmt.close();
					 con.close();
					 JOptionPane.showMessageDialog(null, "Cadastro Excluido com Sucesso!");
					
					tfID.setText("");
					tfNomeP.setText("");
					tfEspecialidade.setText("");
					tfRegistro.setText("");
					tfEmailP.setText("");
					tfTelefoneP.setText("");
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
				
			}
		});
		btnExcluir.setBounds(10, 48, 102, 23);
		contentPane.add(btnExcluir);
	}
}
