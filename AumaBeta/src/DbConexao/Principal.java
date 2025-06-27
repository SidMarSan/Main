package DbConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		setTitle("AUMA Associação dos Amigos da Criança Autista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(00, 00, 1520, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 280, 22);
		contentPane.add(menuBar);
		
		JMenu mnFuncionarios = new JMenu("Funcionários");
		menuBar.add(mnFuncionarios);
		
		JMenuItem mntCadastrar = new JMenuItem("Cadastrar");
		mntCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				CadastroFuncionarios exibir = new CadastroFuncionarios();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		mntCadastrar.setSelected(true);
		mnFuncionarios.add(mntCadastrar);
		
		JMenuItem mntEditar = new JMenuItem("Editar");
		mntEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaFuncionarios exibir = new TelaFuncionarios();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		mnFuncionarios.add(mntEditar);
		
		JMenuItem mntAbrirRel = new JMenuItem("Abrir Relatório");
		mntAbrirRel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				TabelaFuncionarios exibir = new TabelaFuncionarios();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		mnFuncionarios.add(mntAbrirRel);
		
		JMenu mnProfissionais = new JMenu("Profissionais");
		menuBar.add(mnProfissionais);
		
		JMenuItem mntmProfissionais = new JMenuItem("Cadastrar");
		mntmProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroProfissionais exibir = new CadastroProfissionais();
				exibir.setVisible(true);
				setVisible(false);
				
				
			}
		});
		mnProfissionais.add(mntmProfissionais);
		
		JMenuItem mntEditarP = new JMenuItem("Editar");
		mntEditarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaProfissionais exibir = new TelaProfissionais();
				exibir.setVisible(true);
				setVisible(false);
			
			}
			
			
		});
		mnProfissionais.add(mntEditarP);
		
		JMenuItem mntmAbrirRelP = new JMenuItem("Abrir Relatório");
		mntmAbrirRelP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				TabelProfissionais exibir = new TabelProfissionais();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		mnProfissionais.add(mntmAbrirRelP);
		
		JMenu mnAssociado = new JMenu("Associados");
		menuBar.add(mnAssociado);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				CadastroAssociado exibir = new CadastroAssociado();
				exibir.setVisible(true);
				setVisible(false);
			}
		});
		mnAssociado.add(mntmCadastrar);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaAssociado exibir = new TelaAssociado();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		mnAssociado.add(mntmEditar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Abrir Relatório");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TabelaAssociados exibir = new TabelaAssociados();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		mnAssociado.add(mntmNewMenuItem);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\images2.jpeg"));
		lblNewLabel.setBounds(586, 36, 227, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Imagens\\laco.png"));
		lblNewLabel_1.setBounds(529, 206, 369, 278);
		contentPane.add(lblNewLabel_1);
	}
}
