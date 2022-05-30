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
		setBounds(100, 100, 358, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 51, 83, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(53, 125, 83, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(123, 82, 129, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		psfContraseña = new JPasswordField();
		psfContraseña.setBounds(123, 158, 129, 20);
		contentPanel.add(psfContraseña);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(123, 228, 89, 23);
		contentPanel.add(btnIngresar);
		
		lblError = new JLabel("Usuario o contrase\u00F1a incorrectos");
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		lblError.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblError.setBounds(67, 192, 200, 14);
		contentPanel.add(lblError);
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
