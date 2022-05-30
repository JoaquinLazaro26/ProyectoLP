package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySqlConexion;

import interfaces.UsuarioDAO;
import objetos.Usuario;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario validarUsuario(Usuario bean) {
		Usuario usuario = null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select * from Login_Usuarios where usuario = ? and contrasenia = ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getUsuario());
			pstm.setString(2, bean.getContrasenia());
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return usuario;
	}

}
