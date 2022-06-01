package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class libreria {
	
	public static int findByNombre(String nombreabuscar, String nombretabla, String nombrecolumna) {
		int codigo=-1;
		/*cuando trabajamos con select usamos conecction*/
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		try {
			cn=MySqlConexion.getConexion();
			String sql = "select * from " + nombretabla+ " where "  + nombrecolumna + " = '" +nombreabuscar + "' " ; 
			pstm=cn.prepareStatement(sql);
	
			
			rs=pstm.executeQuery();
			
			if(rs.next()) {
				codigo=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			System.out.println("falloas");
		}
		
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null)cn.close();
				
			} catch (SQLException e2) {
				System.out.println("fallo2");
			}
		}
		
		
		
		return codigo;
	}

}
