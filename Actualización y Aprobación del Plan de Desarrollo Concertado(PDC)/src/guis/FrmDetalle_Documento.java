package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Text;

import componentes.JComboBoxBD;
import controladores.MySqlGestorDAO;
import objetos.Gestor;
import utils.libreria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class FrmDetalle_Documento extends JFrame implements ActionListener {

	MySqlGestorDAO gedao = new MySqlGestorDAO();
	

	ResourceBundle ab = ResourceBundle.getBundle("SENTENCIAS_SQL");
	
	private JPanel contentPane;
	private JTextField txtCodDocumento;
	private JTextField txtDescripcion;
	private JTextField txtTiempo;
	private JTable table;
	private JButton btnGuardar;
	private JComboBoxBD cboGestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDetalle_Documento frame = new FrmDetalle_Documento();
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
	public FrmDetalle_Documento() {
		setTitle("DETALLE DOCUMENTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00D3DIGO DOCUMENTO");
		lblNewLabel.setBounds(33, 31, 136, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcinDocumento = new JLabel("DESCRIPCI\u00D3N DOCUMENTO");
		lblDescripcinDocumento.setBounds(33, 73, 149, 20);
		contentPane.add(lblDescripcinDocumento);
		
		JLabel lblTiempoEstimado = new JLabel("TIEMPO ESTIMADO");
		lblTiempoEstimado.setBounds(33, 116, 136, 20);
		contentPane.add(lblTiempoEstimado);
		
		JLabel lblGestor = new JLabel("GESTOR");
		lblGestor.setBounds(33, 162, 92, 20);
		contentPane.add(lblGestor);
		
		txtCodDocumento = new JTextField();
		txtCodDocumento.setBounds(246, 31, 120, 20);
		contentPane.add(txtCodDocumento);
		txtCodDocumento.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(246, 73, 312, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtTiempo = new JTextField();
		txtTiempo.setBounds(246, 116, 312, 20);
		contentPane.add(txtTiempo);
		txtTiempo.setColumns(10);
		
		cboGestor = new JComboBoxBD("select * from gestores");
		cboGestor.setBounds(162, 161, 149, 22);
		contentPane.add(cboGestor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 548, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "DESCRIPCI\u00D3N", "TIEMPO", "GESTOR"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(457, 30, 101, 23);
		contentPane.add(btnGuardar);

		listado();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		String  cod, tiempo, descripcion;
		
		
		int codgestor;
		/*nombre. tabla . columna*/
		
		/*numero del codigo*/
		codgestor=libreria.findByNombre(cboGestor.getSelectedItem().toString(), 
				ab.getString("TABLA_GESTORES"),ab.getString("COLUMNA_TIPO"));

	
		cod=txtCodDocumento.getText();
		tiempo=txtTiempo.getText();
		descripcion=txtDescripcion.getText();
		
		
		
			/*crear objeto de la base libro*/
		Gestor bean = new Gestor();
		
		/*asignar valor a los atributos del objeto bean usando las variables*/
		
		bean.setCoddocu(cod);
		bean.setDesdocu(descripcion);
		bean.setTiempo(tiempo);
		bean.setCodgestor(codgestor);
	
		/*invocar al método save y enviar como parámetro el objeto bean*/
		int resultado;
		resultado=gedao.save(bean);
		
		/*validar variable*/
		if(resultado==1) { 
			JOptionPane.showMessageDialog(null,"Documento registrado");
			listado();
		}
		
		else
			JOptionPane.showMessageDialog(null,"Error en el registro");
	
		}
	
	void listado() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		ArrayList<Gestor> data = gedao.findAll2();
		
		for(Gestor ge:data) {
			Object row[]= {
				ge.getCoddocu(), ge.getDesdocu(),ge.getTiempo(), ge.getTipogestor()
			};
			model.addRow(row);
		}
		
	}
	
}
