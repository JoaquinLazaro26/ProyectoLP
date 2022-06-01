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

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
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
		setTitle("Actualizaci\u00F3n y aprobaci\u00F3n de plan de desarrollo concertado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 515);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Cambiar de usuario");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Rosita");
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("Jesus");
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_3 = new JMenu("Rodrigo");
		menuBar.add(mnNewMenu_3);
		
		mnNewMenu_4 = new JMenu("Victoria");
		menuBar.add(mnNewMenu_4);
		
		mnNewMenu_5 = new JMenu("Matenimiento documentos");
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
