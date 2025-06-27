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

public class CadastroProfissionais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfID2;
	private JTextField tfNomeP2;
	private JTextField tfEspecialidade2;
	private JTextField tfRegistro2;
	private JTextField tfTelefoneP2;
	private JTextField tfEmailP2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProfissionais frame = new CadastroProfissionais();
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
	public CadastroProfissionais() {
		setTitle("Cadastro de Profissionais");
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
		
		tfID2 = new JTextField();
		tfID2.setEditable(false);
		tfID2.setColumns(10);
		tfID2.setBounds(122, 145, 125, 20);
		contentPane.add(tfID2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(25, 187, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfNomeP2 = new JTextField();
		tfNomeP2.setColumns(10);
		tfNomeP2.setBounds(121, 184, 399, 20);
		contentPane.add(tfNomeP2);
		
		JLabel lblNewLabel_4 = new JLabel("Especialidade:");
		lblNewLabel_4.setBounds(25, 218, 102, 14);
		contentPane.add(lblNewLabel_4);
		
		tfEspecialidade2 = new JTextField();
		tfEspecialidade2.setColumns(10);
		tfEspecialidade2.setBounds(122, 215, 125, 20);
		contentPane.add(tfEspecialidade2);
		
		JLabel lblNewLabel_5 = new JLabel("Nº Registro");
		lblNewLabel_5.setBounds(25, 243, 102, 14);
		contentPane.add(lblNewLabel_5);
		
		tfRegistro2 = new JTextField();
		tfRegistro2.setColumns(10);
		tfRegistro2.setBounds(122, 240, 125, 20);
		contentPane.add(tfRegistro2);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(25, 276, 87, 14);
		contentPane.add(lblNewLabel_6);
		
		tfTelefoneP2 = new JTextField();
		tfTelefoneP2.setColumns(10);
		tfTelefoneP2.setBounds(122, 273, 125, 20);
		contentPane.add(tfTelefoneP2);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(25, 309, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		tfEmailP2 = new JTextField();
		tfEmailP2.setColumns(10);
		tfEmailP2.setBounds(122, 306, 125, 20);
		contentPane.add(tfEmailP2);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNomeP2.getText().equals("") || tfEspecialidade2.getText().equals("")||tfRegistro2.getText().equals("")|| tfTelefoneP2.getText().equals("")|| tfEmailP2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos!");  
				}
				else {
					
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql ="insert into profissionais(nome, especialidade, n_registro, email, telefone) value (?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfNomeP2.getText());
					stmt.setString(2, tfEspecialidade2.getText());
					stmt.setString(3, tfRegistro2.getText());
					stmt.setString(4, tfEmailP2.getText());
					stmt.setString(5, tfTelefoneP2.getText());
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null,"Cadastro realizado com Sucesso!");
					
					tfNomeP2.setText("");
					tfEspecialidade2.setText("");
					tfRegistro2.setText("");
					tfEmailP2.setText("");
					tfTelefoneP2.setText("");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			}
		});
		btnSalvar.setBounds(10, 46, 102, 23);
		contentPane.add(btnSalvar);
		
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
		

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		lblNewLabel_8.setBounds(413, 184, 286, 284);
		contentPane.add(lblNewLabel_8);
		
		
	}

}
