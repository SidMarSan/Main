package DbConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TabelaFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbFuncionarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaFuncionarios frame = new TabelaFuncionarios();
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
	public TabelaFuncionarios() {
		setTitle("relatório de Funcionários");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(00, 00, 1520, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Relatório de Funcionários");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(506, 37, 339, 47);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 335, 1275, 403);
		contentPane.add(scrollPane);
		
		tbFuncionarios = new JTable();
		tbFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Matr\u00EDcula", "Nome", "CPF", "Telefone", "E-mail", "Fun\u00E7\u00E3o", "Login", "Senha"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbFuncionarios);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\images2.jpeg"));
		lblNewLabel_1.setBounds(548, 96, 226, 150);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = Conexao.fazer_conexao();
					String sql= " select *from funcionarios_auma";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs =  stmt.executeQuery();
					DefaultTableModel modelo = (DefaultTableModel) tbFuncionarios.getModel();
					
					modelo.setNumRows(0);
					
					while (rs.next()) {
						modelo.addRow(new Object[] {rs.getString("matricula"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"),
								rs.getString("funcao"), rs.getString("login"), rs.getString("senha")});
						
						
					}
					rs.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRelatorio.setBounds(42, 269, 89, 23);
		contentPane.add(btnRelatorio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal exibir = new Principal();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(147, 269, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	Font fonteOriginal = tbFuncionarios.getFont();
		        Font fonteMaior = new Font(fonteOriginal.getFontName(), fonteOriginal.getStyle(), 16); 

		        tbFuncionarios.setFont(fonteMaior);
		        tbFuncionarios.setRowHeight(25); 

		    	
		    	
		        try {
		            boolean complete = tbFuncionarios.print();
		            if (!complete) {
		                System.out.println("Impressão cancelada.");
		            }
		        } catch (Exception pe) {
		            pe.printStackTrace();
		        }
		    }
		});
		btnImprimir.setBounds(252, 269, 100, 23);
		contentPane.add(btnImprimir);
		
		
	}
}
