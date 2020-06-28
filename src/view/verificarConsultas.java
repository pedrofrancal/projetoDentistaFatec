package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import model.verificarTableModel;

public class verificarConsultas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public verificarConsultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtInicio = new JLabel("         In\u00EDcio");
		txtInicio.setBounds(20, 96, 62, 21);
		Color vermelho = new Color(237,3,3);
		Color color = new Color(145,150,153);
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
		//table.setBounds(194, 35, 690, 426);
		verificarTableModel model = new verificarTableModel();
		table.setModel(model);
		table.setShowVerticalLines(false);
		JTableHeader th = table.getTableHeader(); 
        th.setPreferredSize(new Dimension(100, 33));
		table.setRowHeight(23);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row%2==0) {
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
		 scroll.setBounds(194, 134, 690, 327);
        contentPane.add(scroll);
        
        JComboBox comboBox = new JComboBox();
		comboBox.setBounds(204, 43, 101, 21);
		contentPane.add(comboBox);
		comboBox.addItem("todos");
		
		JLabel telaMenu = new JLabel("");
		telaMenu.setIcon(new ImageIcon("C:\\Users\\gabri\\OneDrive\\\u00C1rea de Trabalho\\proejct\\menu2.png"));
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
