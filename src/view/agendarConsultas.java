package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Create;
import controller.LogDesempenho;
import controller.Pacientes;

public class agendarConsultas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2068625204135927805L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTable table;
	private JTextField txtNome;
	private JTextField txtRG;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTextField txtData;
	private JTextField txtTipo;
	private JLabel btnAdd;
	private JLabel txtAtualizar;

	public agendarConsultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel txtInicio = new JLabel("         In\u00EDcio");
		txtInicio.setBounds(20, 96, 62, 21);
		Color vermelho = new Color(237, 3, 3);
		Color color = new Color(145, 150, 153);

		txtAtualizar = new JLabel("       Atualizar");
		txtAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogDesempenho log = new LogDesempenho();
				log.setTempoInicial(System.nanoTime());
				Create c = new Create();
				Pacientes data = new Pacientes();
				data.setNomecompleto(txtNome.getText());
				data.setRg(txtRG.getText());
				data.setEmail(txtEmail.getText());
				data.setTelefone(txtTel.getText());
				data.setDataAgenda(txtData.getText());
				data.setTipoDeAgendamento(txtData.getText());
				
				try {
					c.atualizarLinha(data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				log.setTempoFinal(System.nanoTime());
				try {
					log.gerarLog("ATUALIZAR TABELA");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtAtualizar.setForeground(Color.RED);
		txtAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAtualizar.setBounds(470, 390, 80, 31);
		contentPane.add(txtAtualizar);
		txtInicio.setForeground(color);
		txtInicio.setFont(new Font("Arial", Font.PLAIN, 12));

		contentPane.add(txtInicio);

		JLabel txtAgendar = new JLabel("        Agendar");
		txtAgendar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAgendar.setBounds(20, 136, 80, 23);
		txtAgendar.setForeground(vermelho);
		contentPane.add(txtAgendar);

		JLabel txtVerificar = new JLabel("        Verificar");
		txtVerificar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtVerificar.setBounds(20, 170, 80, 31);
		txtVerificar.setForeground(color);
		contentPane.add(txtVerificar);

		JLabel txtSair = new JLabel("       Sair");
		txtSair.setBounds(20, 429, 50, 21);
		txtSair.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSair.setForeground(vermelho);
		contentPane.add(txtSair);

		JLabel TelaAdd = new JLabel("");
		String path = new File("").getAbsolutePath();
		TelaAdd.setIcon(new ImageIcon(path + "\\src\\image\\texto add2.png"));
		TelaAdd.setBounds(218, 51, 642, 388);
		contentPane.add(TelaAdd);

		txtNome = new JTextField();
		txtNome.setBounds(218, 77, 429, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(218, 138, 246, 31);
		contentPane.add(txtRG);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(218, 201, 484, 31);
		contentPane.add(txtEmail);

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(218, 265, 246, 31);
		contentPane.add(txtTel);

		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(218, 324, 246, 31);
		contentPane.add(txtData);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(218, 390, 246, 31);
		contentPane.add(txtTipo);

		JLabel telaMenu = new JLabel("");
		String path2 = new File("").getAbsolutePath();
		telaMenu.setIcon(new ImageIcon(path2 + "\\src\\image\\menu2.png"));
		telaMenu.setBounds(0, 0, 884, 461);
		contentPane.add(telaMenu);

		btnAdd = new JLabel("");
		btnAdd.setBounds(693, 400, 124, 37);
		contentPane.add(btnAdd);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogDesempenho log = new LogDesempenho();
				log.setTempoInicial(System.nanoTime());
				Pacientes data = new Pacientes();
				data.setNomecompleto(txtNome.getText());
				data.setRg(txtRG.getText());
				data.setEmail(txtEmail.getText());
				data.setTelefone(txtTel.getText());
				data.setDataAgenda(txtData.getText());
				data.setTipoDeAgendamento(txtData.getText());

				Create gravar = new Create();
				try {
					gravar.gravar(data);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				log.setTempoFinal(System.nanoTime());
				try {
					log.gerarLog("GRAVAR PACIENTE");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		txtInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				principal inicio = new principal();
				inicio.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				txtInicio.setForeground(vermelho);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtInicio.setForeground(color);
			}
		});

		txtVerificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				verificarConsultas verificar = new verificarConsultas();
				verificar.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				txtVerificar.setForeground(vermelho);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtVerificar.setForeground(color);
			}
		});

		txtSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
