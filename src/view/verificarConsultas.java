package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import controller.Delete;
import controller.HeapSortLetras;
import controller.ListaLigada;
import controller.LogDesempenho;
import controller.MergeSort;
import controller.Read;
import model.verificarTableModel;

public class verificarConsultas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1984205793126500855L;
	public static String path10 = "C:\\Project\\entrada.txt";
	private ListaLigada lista;
	private JPanel contentPane;
	private JTable table;
	private TableModel dataModel;

	public verificarConsultas() {
		LogDesempenho log = new LogDesempenho();
		log.setTempoInicial(System.nanoTime());
		lista = new ListaLigada();
		Read r = new Read();
		try {
			lista = r.readFile(lista);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		log.setTempoFinal(System.nanoTime());
		try {
			log.gerarLog("LEITURA DE ARQUIVO");
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

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

		JLabel txtOrdenar = new JLabel("        Ordenar");
		txtOrdenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.setTempoInicial(System.nanoTime());
				String[] vet = null;
				List<String> itemsSchool = new ArrayList<String>();

				try {
					FileInputStream fstream = new FileInputStream("C:\\Project\\entrada.txt");
					DataInputStream data = new DataInputStream(fstream);
					BufferedReader buffer = new BufferedReader(new InputStreamReader(data));
					String linha;

					while ((linha = buffer.readLine()) != null) {
						linha = linha.trim();
						if ((linha.length() != 0)) {
							itemsSchool.add(linha);
						}
					}

					vet = (String[]) itemsSchool.toArray(new String[itemsSchool.size()]);
					buffer.close();
					data.close();
					fstream.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				log.setTempoFinal(System.nanoTime());
				try {
					log.gerarLog("PREPARAR PARA ORDENAR");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int opc = Integer.parseInt(JOptionPane.showInputDialog("1 - ORDENAR POR NOME\n2 - ORDENAR POR ESPECIALIDADE"));
				switch (opc) {
				case 1:
					log.setTempoInicial(System.nanoTime());
					MergeSort merge = new MergeSort();
					merge.mergeSort(vet, 0, vet.length-1);
					try {
						merge.gravar(vet);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					log.setTempoFinal(System.nanoTime());
					try {
						log.gerarLog("MERGE SORT");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					break;
				case 2:
					log.setTempoInicial(System.nanoTime());
					HeapSortLetras heap = new HeapSortLetras();
					heap.HeapSort(vet);
					try {
						heap.gravar(vet);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					log.setTempoFinal(System.nanoTime());
					try {
						log.gerarLog("HEAP SORT");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				default:
					break;
				}
			}
		});
		txtOrdenar.setForeground(new Color(237, 3, 3));
		txtOrdenar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtOrdenar.setBounds(309, 46, 105, 31);
		contentPane.add(txtOrdenar);

		JLabel txtPesquisar = new JLabel("        Pesquisar");
		txtPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.setTempoInicial(System.nanoTime());
				Read r = new Read();
				String nome = JOptionPane.showInputDialog(null, "DIGITE O NOME PARA PESQUISAR");
				try {
					r.pesquisa(nome);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "NOME NAO ENCONTRADO");
				} finally {
				}
				log.setTempoFinal(System.nanoTime());
				try {
					log.gerarLog("PESQUISAR");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtPesquisar.setForeground(new Color(237, 3, 3));
		txtPesquisar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPesquisar.setBounds(194, 46, 105, 31);
		contentPane.add(txtPesquisar);
		txtInicio.setForeground(color);
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
		txtVerificar.setForeground(vermelho);
		contentPane.add(txtVerificar);

		JLabel txtSair = new JLabel("       Sair");
		txtSair.setBounds(20, 429, 50, 21);
		txtSair.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSair.setForeground(vermelho);
		contentPane.add(txtSair);

		table = new JTable();
		table.setLocation(0, 36);
		// table.setBounds(194, 35, 690, 426);
		dataModel = new verificarTableModel(lista);
		table.setModel(dataModel);
		table.setShowVerticalLines(false);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 33));
		table.setRowHeight(23);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (row % 2 == 0) {
					setBackground(Color.LIGHT_GRAY);
					setForeground(Color.BLACK);
				} else {
					boolean sel = isSelected;
					if (sel == true) {
						setBackground(getBackground());
						setForeground(getForeground());
					} else {
						setBackground(Color.WHITE);
						setForeground(Color.BLACK);
					}
				}
				return this;
			}
		});
		contentPane.add(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(194, 93, 690, 376);
		contentPane.add(scroll);

		JLabel btnRemove = new JLabel("");
		String path3 = new File("").getAbsolutePath();
		btnRemove.setIcon(new ImageIcon(path3 + "\\src\\image\\btn.png"));
		btnRemove.setBounds(743, 46, 131, 36);
		contentPane.add(btnRemove);

		JLabel telaVerificar = new JLabel("");
		String path = new File("").getAbsolutePath();
		telaVerificar.setIcon(new ImageIcon(path + "\\src\\image\\menu2.png"));
		telaVerificar.setBounds(0, 0, 884, 461);
		contentPane.add(telaVerificar);

		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.setTempoInicial(System.nanoTime());
				if (table.isColumnSelected(6)) {
					
					String nome = table.getValueAt(table.getSelectedRow(), 0).toString();

					Delete database = new Delete();
					try {
						database.removePaciente(lista, nome, path10);
						File f = new File(path10);
						if (!f.exists()) {
							verificarConsultas pacientes = new verificarConsultas();
							pacientes.setVisible(true);
							dispose();
						} else {
							((verificarTableModel) dataModel).refresh();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna" + " opções", "Error", 0);
				}
				log.setTempoFinal(System.nanoTime());
				try {
					log.gerarLog("DELETAR REGISTRO");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

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

		txtSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
