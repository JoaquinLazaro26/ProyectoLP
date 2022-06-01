package componentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import utils.MySqlConexion;



public class JComboBoxBD extends JComboBox{
	/*al llamar al constructor tu vas a enviar un parámetro tipo cadena*/ 
	/*cualquier sentencia que tu escribas lo va a recibir el parámetro sql*/
	
	public JComboBoxBD(String sql) {
		/*de esta manera igual se agregan*/
		Connection cn = null;
		
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try {
			/*conecion*/
			cn = MySqlConexion.getConexion();
			/*paso 2 que es guardar la sentencia no lo hago porque en el parametro ya le estoy dando la sentencia
			 * o sea select * from*/
			
			/*paso3*/
			pstm=cn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {		
				/*tomará segunda columna porque quiero trabajar con eso
				 * y eso saldra en el combo*/
				addItem(rs.getString(2));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)pstm.close();
 			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	


}
