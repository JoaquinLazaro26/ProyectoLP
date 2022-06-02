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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class FrmLogin extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField psfContraseña;
	private JButton btnIngresar;
	private JLabel lblError;
	private JLabel lblNewLabel_5;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/iconos/im3.jpeg")));
		setTitle("Login");
		setBounds(100, 100, 441, 678);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(88, 374, 113, 29);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(49, 449, 143, 27);
		contentPanel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(202, 376, 151, 32);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		psfContraseña = new JPasswordField();
		psfContraseña.setBounds(202, 450, 151, 32);
		contentPanel.add(psfContraseña);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnIngresar.setBackground(new Color(102, 204, 255));
		btnIngresar.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/search.jpeg")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(32, 545, 357, 53);
		contentPanel.add(btnIngresar);
		
		lblError = new JLabel("Usuario o contrase\u00F1a incorrectos");
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		lblError.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblError.setBounds(113, 510, 200, 14);
		contentPanel.add(lblError);
		
		lblNewLabel_5 = new JLabel("MUNICIPALIDAD DE MIRAFLORES");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(51, 204, 255));
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_5.setBounds(32, 16, 357, 59);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/im1.jpeg")));
		lblNewLabel_2.setBounds(32, 73, 357, 279);
		contentPanel.add(lblNewLabel_2);
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
