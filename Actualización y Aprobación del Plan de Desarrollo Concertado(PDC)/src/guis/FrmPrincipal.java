package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/iconos/im3.jpeg")));
		setTitle("Actualizaci\u00F3n y Aprobaci\u00F3n de Plan de Desarrollo Concertado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 399);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/folder.jpeg")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Cambiar de usuario");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_5 = new JMenu("Matenimiento documentos");
		mnNewMenu_5.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/applications.jpeg")));
		menuBar.add(mnNewMenu_5);
		
		mntmNewMenuItem_2 = new JMenuItem("Listar gestores");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_5.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Documentos gestores");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_5.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Buscar nombre");
		mnNewMenu_5.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/im2.jpeg")));
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 688, 301);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		FrmGestor x = new FrmGestor();
		x.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		FrmDetalle_Documento x = new FrmDetalle_Documento();
		x.setVisible(true);
	}
}
