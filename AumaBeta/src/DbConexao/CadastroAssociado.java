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
import java.awt.Color;

public class CadastroAssociado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAssociado frame = new CadastroAssociado();
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
	public CadastroAssociado() {
		setTitle("Cadastro de Associados");
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
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Associados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(495, 0, 294, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Matrícula:");
		lblNewLabel_2.setBounds(22, 152, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextField tfMatriculaA = new JTextField();
		tfMatriculaA.setEditable(false);
		tfMatriculaA.setBounds(125, 149, 125, 20);
		contentPane.add(tfMatriculaA);
		tfMatriculaA.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(23, 189, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextField tfNomeA = new JTextField();
		tfNomeA.setBounds(125, 186, 399, 20);
		contentPane.add(tfNomeA);
		tfNomeA.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setBounds(22, 225, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextField tfCPFA = new JTextField();
		tfCPFA.setBounds(125, 222, 125, 20);
		contentPane.add(tfCPFA);
		tfCPFA.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mãe:");
		lblNewLabel_5.setBounds(23, 260, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextField tfMae = new JTextField();
		tfMae.setBounds(125, 257, 399, 20);
		contentPane.add(tfMae);
		tfMae.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Pai:");
		lblNewLabel_6.setBounds(22, 297, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JTextField tfPai = new JTextField();
		tfPai.setBounds(125, 294, 399, 20);
		contentPane.add(tfPai);
		tfPai.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Endereço:");
		lblNewLabel_7.setBounds(23, 336, 77, 14);
		contentPane.add(lblNewLabel_7);
		
		JTextField tfEndereco = new JTextField();
		tfEndereco.setBounds(125, 333, 399, 20);
		contentPane.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Email:");
		lblNewLabel_8.setBounds(22, 374, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JTextField tfEmailA = new JTextField();
		tfEmailA.setBounds(125, 371, 125, 20);
		contentPane.add(tfEmailA);
		tfEmailA.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Telefone:");
		lblNewLabel_9.setBounds(23, 405, 77, 14);
		contentPane.add(lblNewLabel_9);
		
		JTextField tfTelefone = new JTextField();
		tfTelefone.setBounds(125, 402, 125, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Nº SUS:");
		lblNewLabel_9_1.setBounds(22, 447, 77, 14);
		contentPane.add(lblNewLabel_9_1);
		
		JTextField tfSUS = new JTextField();
		tfSUS.setBounds(125, 442, 125, 20);
		contentPane.add(tfSUS);
		tfSUS.setColumns(10);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Cad ùnico:");
		lblNewLabel_9_1_1.setBounds(22, 492, 77, 14);
		contentPane.add(lblNewLabel_9_1_1);
		
		JTextField tfCadUnico = new JTextField();
		tfCadUnico.setBounds(125, 489, 125, 20);
		contentPane.add(tfCadUnico);
		tfCadUnico.setColumns(10);
		
		JButton btnVoltarA = new JButton("Voltar");
		btnVoltarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Principal exibir = new Principal();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltarA.setBounds(10, 118, 101, 23);
		contentPane.add(btnVoltarA);
		
		JButton btnCadastrarA = new JButton("Cadastrar");
		btnCadastrarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNomeA.getText().equals("") || tfCPFA.getText().equals("")||tfMae.getText().equals("")|| tfPai.getText().equals("")|| tfEndereco.getText().equals("")||tfEmailA.getText().equals("")||tfCadUnico.getText().equals("")||tfSUS.getText().equals("")||tfTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos!");  
				}
				else {
					
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql ="insert into autista(nome, cpf, mae, pai, endereco, email, telefone, sus, cad_unico) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfNomeA.getText());
					stmt.setString(2, tfCPFA.getText());
					stmt.setString(3, tfMae.getText());
					stmt.setString(4, tfPai.getText());
					stmt.setString(5, tfEndereco.getText());
					stmt.setString(6, tfEmailA.getText());
					stmt.setString(7, tfCadUnico.getText());
					stmt.setString(8, tfSUS.getText());
					stmt.setString(9, tfTelefone.getText());
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null,"Cadastro realizado com Sucesso!");
					
					tfNomeA.setText("");
					tfCPFA.setText("");
					tfMae.setText("");
					tfPai.setText("");
					tfEndereco.setText("");
					tfEmailA.setText("");
					tfCadUnico.setText("");
					tfSUS.setText("");
					tfTelefone.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			
				
				
				
				
				
			}
		});
		btnCadastrarA.setBounds(10, 47, 101, 23);
		contentPane.add(btnCadastrarA);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		lblNewLabel_10.setBounds(445, 155, 328, 339);
		contentPane.add(lblNewLabel_10);
		
		
		
	}
	

}
