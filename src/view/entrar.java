package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class entrar extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					entrar frame = new entrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JLabel txtEntrar;
	public entrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		@SuppressWarnings("unused")
		Color color = new Color (237,3,3);
		
		txtEntrar = new JLabel("      Entrar");
		txtEntrar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtEntrar.setForeground(Color.WHITE);
		txtEntrar.setBounds(379, 374, 140, 27);
		txtEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                principal principal = new principal();
                principal.setVisible(true);
                dispose();
            }
        });
		contentPane.add(txtEntrar);
		
		JLabel telaEntrar = new JLabel("");
		telaEntrar.setFont(new Font("Arial", Font.PLAIN, 11));
		String path = new File("").getAbsolutePath();
        telaEntrar.setIcon(new ImageIcon(path + "\\src\\image\\gabriel fdp.png"));
		telaEntrar.setBounds(0, 0, 884, 461);
		contentPane.add(telaEntrar);
		
	
		
	
	}
}
