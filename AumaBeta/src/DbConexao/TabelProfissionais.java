package DbConexao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TabelProfissionais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbProfissionais;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelProfissionais frame = new TabelProfissionais();
					frame.setVisible(true);
				 }catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TabelProfissionais() {
		setTitle("Relatório de Profissionais");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(00, 00, 1520, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Relatório de Profissionais");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(506, 37, 339, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\images2.jpeg"));
		lblNewLabel_1.setBounds(548, 96, 226, 150);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 335, 1275, 403);
		contentPane.add(scrollPane);
		
		tbProfissionais = new JTable();
		tbProfissionais.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Especialidade", "N\u00BA Registro", "E-mail", "Telefone"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8381519961795889682L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbProfissionais);
		
		JButton btnRelatorioP = new JButton("Relatório");
		btnRelatorioP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					Connection con = Conexao.fazer_conexao();
					String sql= " select *from profissionais";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs =  stmt.executeQuery();
					DefaultTableModel modelo = (DefaultTableModel) tbProfissionais.getModel();
					
					modelo.setNumRows(0);
					
					while (rs.next()) {
						modelo.addRow(new Object[] {rs.getString("id"), rs.getString("nome"), rs.getString("especialidade"), rs.getString("n_registro"), rs.getString("email"),
								rs.getString("telefone")});
						
						
					}
					rs.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnRelatorioP.setBounds(42, 269, 89, 23);
		contentPane.add(btnRelatorioP);
		
		JButton btnVoltarP = new JButton("Voltar");
		btnVoltarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Principal exibir = new Principal();
				exibir.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltarP.setBounds(147, 269, 89, 23);
		contentPane.add(btnVoltarP);
		
				
				
				JButton btnImprimir = new JButton("Imprimir");
				btnImprimir.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	
				    	
				    	Font fonteOriginal = tbProfissionais.getFont();
				        Font fonteMaior = new Font(fonteOriginal.getFontName(), fonteOriginal.getStyle(), 16); 

				        tbProfissionais.setFont(fonteMaior);
				        tbProfissionais.setRowHeight(25); 

				    	
				    	
				        try {
				            boolean complete = tbProfissionais.print();
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