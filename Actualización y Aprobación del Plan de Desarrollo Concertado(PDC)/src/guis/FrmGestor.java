package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.MySqlGestorDAO;
import objetos.Gestor;

public class FrmGestor extends JFrame {

	MySqlGestorDAO gestor = new MySqlGestorDAO();
	
	private JPanel contentPane;
	private JTable tableGestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGestor frame = new FrmGestor();
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
	public FrmGestor() {
		setTitle("GESTORES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 540, 320);
		contentPane.add(scrollPane);
		
		tableGestor = new JTable();
		tableGestor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO GESTOR", "TIPO DE GESTOR"
			}
		));
		tableGestor.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableGestor);
		listado();
	}
	
	
	void listado() {
		DefaultTableModel model = (DefaultTableModel) tableGestor.getModel();
		
		model.setRowCount(0);
		ArrayList<Gestor> data = gestor.findAll();
		
		for(Gestor ge:data) {
			Object row[]= {
				ge.getCodgestor(), ge.getTipogestor()
			};
			model.addRow(row);
		}
		
	}
	
}
