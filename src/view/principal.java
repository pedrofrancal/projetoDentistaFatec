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
import javax.swing.border.EmptyBorder;

import controller.ListaLigada;
import controller.LogDesempenho;
import controller.Read;
import controller.tabelaHash;

public class principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6777557041595972355L;
	private JPanel contentPane;

	public principal() {
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

		JLabel txtHeap = new JLabel("        HASH");
		txtHeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogDesempenho log = new LogDesempenho();
				log.setTempoInicial(System.nanoTime());
				ListaLigada lista = new ListaLigada();
				Read r = new Read();
				try {
					lista = r.readFile(lista);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
				tabelaHash tab = new tabelaHash(40);
				for(int i = 0; i<40; i++) {
					tab.inserir(lista.get(i).getNomecompleto());
					System.out.println(lista.get(i).getNomecompleto()+"nome");
				}
				tab.mostrarTabela();
				log.setTempoInicial(System.nanoTime());
				try {
					log.gerarLog("TESTE DE HASH");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtHeap.setForeground(new Color(145, 150, 153));
		txtHeap.setFont(new Font("Arial", Font.PLAIN, 12));
		txtHeap.setBounds(20, 212, 80, 31);
		contentPane.add(txtHeap);
		txtInicio.setForeground(vermelho);
		txtInicio.setFont(new Font("Arial", Font.PLAIN, 12));

		contentPane.add(txtInicio);

		JLabel txtAgendar = new JLabel("        Agendar");
		txtAgendar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAgendar.setBounds(20, 136, 80, 23);
		txtAgendar.setForeground(color);
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

		JLabel txtBemvindo = new JLabel("");
		String path2 = new File("").getAbsolutePath();
		txtBemvindo.setIcon(new ImageIcon(path2 + "\\src\\image\\TEXTO TRAB.png"));
		txtBemvindo.setBounds(249, 64, 591, 344);
		contentPane.add(txtBemvindo);

		JLabel telaMenu = new JLabel("");
		String path = new File("").getAbsolutePath();
		telaMenu.setIcon(new ImageIcon(path + "\\src\\image\\menu2.png"));
		telaMenu.setBounds(0, 0, 884, 461);
		contentPane.add(telaMenu);

		txtAgendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				agendarConsultas agendar = new agendarConsultas();
				agendar.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				txtAgendar.setForeground(vermelho);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtAgendar.setForeground(color);
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
