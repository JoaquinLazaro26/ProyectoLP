package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.MySqlUsuarioDAO;
import objetos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmLogin extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField psfContraseña;
	private JButton btnIngresar;
	private JLabel lblError;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmLogin dialog = new FrmLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmLogin() {
		setTitle("Login");
		setBounds(100, 100, 720, 477);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(409, 103, 83, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(409, 177, 83, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(479, 134, 129, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		psfContraseña = new JPasswordField();
		psfContraseña.setBounds(479, 210, 129, 20);
		contentPanel.add(psfContraseña);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(479, 280, 89, 23);
		contentPanel.add(btnIngresar);
		
		lblError = new JLabel("Usuario o contrase\u00F1a incorrectos");
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		lblError.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblError.setBounds(423, 244, 200, 14);
		contentPanel.add(lblError);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 51, 332, 332);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(409, 137, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(409, 213, 46, 14);
		contentPanel.add(lblNewLabel_4);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		
		String usuario = txtUsuario.getText();
		String contrasenia = String.valueOf(psfContraseña.getPassword());
		
		MySqlUsuarioDAO usuarioDAO = new MySqlUsuarioDAO();
		
		if(usuario.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "El campo usuario es obligatorio");
		}
		else if(contrasenia.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "El campo contraseña es obligatorio");
		}
		else {
			Usuario oUsuario = new Usuario();
			oUsuario.setUsuario(usuario);
			oUsuario.setContrasenia(contrasenia);
			
			Usuario usuarioValidar = usuarioDAO.validarUsuario(oUsuario);
			
			if(usuarioValidar!= null) {
				JOptionPane.showMessageDialog(this, "Bienvenido " + oUsuario.getUsuario());
				FrmPrincipal x = new FrmPrincipal();
				x.setVisible(true);
				this.dispose();
			}
			else {
				lblError.setVisible(true);
				psfContraseña.setText("");
				txtUsuario.requestFocus();
				txtUsuario.selectAll();
			}
		}	
	}
}
