package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.GestorDAO;
import objetos.Gestor;
import utils.MySqlConexion;

public class MySqlGestorDAO implements GestorDAO{
	public ArrayList<Gestor> findAll() {
		/*para almacena el contenido de una tabla, es con una clase
		 * que se llama resulset*/
		ArrayList<Gestor> lista = new ArrayList<Gestor>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		
		
		try {
			/*por la conexion*/
			cn=MySqlConexion.getConexion();
			String sql= "select * from gestores";
			/*tiene la sentencia*/
			pstm=cn.prepareStatement(sql);
			
			/*no uso los parámetros poruqe no tiene ningún ??*/
			/*esto te devuele una tabla y todo se guarda en rs*/
			rs=pstm.executeQuery();
			
			/*paso6*/
			/*llegara un momento en el q rs me devuelva falso*/
			/*no es necesario colocar true*/
			 while (rs.next()==true) {
					/*paso 7*/
				 /*crear el objeto de la clase libro*/
				 Gestor ge = new Gestor();
				 
				 /*paso 8*/
				 /*asignar valor a los atributos del objeto lib segun fila actual*/
				  /*tambien lo puedes hacer asi lib.setCodigo(rs.getInt("cod_libro")*/
				 ge.setCodgestor(rs.getInt(1));
				 ge.setTipogestor(rs.getString(2));
				 
				 
				 /*paso9*/
				 /*adicionar al arreglo libro*/
				 lista.add(ge);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error en prepared");
				e2.printStackTrace();
			}
		}
		
		return lista;
		

	}

	@Override
	public int save(Gestor bean) {
		int salida =-1;
		Connection cn =null;
		/*clase que trabaje con sentencias*/
		/*maneja el insert into*/
		PreparedStatement pstm = null;
		
		try {
			/*obtener la conexión con la bd y guardar en el objeto cn*/
			cn=MySqlConexion.getConexion();
			
			/*variable de tipo string que almacene sentencia sql*/
			String sql="insert into detalle_documento values(?,?,?,?)";
			
			/*crear objeto pstm y enviar la variable sql*/
			pstm=cn.prepareStatement(sql);
			
			/*parámetros en la sentencia*/
			/*tenemos que poner las que tienen interrogante ya que el resto
			 * o sea null es algo predeterminado*/
			/*hemos agregado el codigodeedicion, eso se verá en la tabla*/
			pstm.setString(1, bean.getCoddocu());
			pstm.setString(2, bean.getDesdocu());
			pstm.setInt(3, bean.getCodgestor());
			pstm.setString(4, bean.getTiempo());
			
			
			/*si todo sale bien me va a retornar 1 y la ejecucion o sea aceptará los parámertos:
			 * codigo, tituto, eso */
			/*si todo es correcto salida será igual a 1*/
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				/*si pasa eso es porque fue creado y en su interior
				 * tiene en insert*/
				if(pstm!=null)	pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		/*va a retornar 1*/
		return salida;
		
	}

	@Override
	public ArrayList<Gestor> findAll2() {
		/*para almacena el contenido de una tabla, es con una clase
		 * que se llama resulset*/
		ArrayList<Gestor> lista = new ArrayList<Gestor>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		
		
		try {
			/*por la conexion*/
			cn=MySqlConexion.getConexion();
			String sql= "select d.cod_docu, des_docu, tiempo, tipo_gestor "
					+ "from `detalle_documento` as d join `gestores` as g "
					+ "on d.cod_gestor=g.cod_gestor";
			
			
			/*tiene la sentencia*/
			pstm=cn.prepareStatement(sql);
			
			/*no uso los parámetros poruqe no tiene ningún ??*/
			/*esto te devuele una tabla y todo se guarda en rs*/
			rs=pstm.executeQuery();
			
			/*paso6*/
			/*llegara un momento en el q rs me devuelva falso*/
			/*no es necesario colocar true*/
			 while (rs.next()==true) {
					/*paso 7*/
				 /*crear el objeto de la clase libro*/
				 Gestor ge = new Gestor();
				 
				 /*paso 8*/
				 /*asignar valor a los atributos del objeto lib segun fila actual*/
				  /*tambien lo puedes hacer asi lib.setCodigo(rs.getInt("cod_libro")*/
				 
				 
				 ge.setCoddocu(rs.getString(1));
				 ge.setDesdocu(rs.getString(2));
				 ge.setTiempo(rs.getString(3));
				 ge.setTipogestor(rs.getString(4));
				 
				 
				 /*paso9*/
				 /*adicionar al arreglo libro*/
				 lista.add(ge);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error en prepared");
				e2.printStackTrace();
			}
		}
		
		return lista;
		


	}

}
