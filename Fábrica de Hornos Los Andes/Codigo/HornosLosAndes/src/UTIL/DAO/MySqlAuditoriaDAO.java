package UTIL.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import UTIL.Beans.AuditoriaBean;

public class MySqlAuditoriaDAO {

	public int ingresarAuditoria(AuditoriaBean Auditoria) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "comoubinario");			
			//Paso 3: Se prepara la sentencia
			String sql = "INSERT INTO auditoria VALUES(?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, Auditoria.getCodigo());
			pstmt.setString(2, Auditoria.getUsuario());
			pstmt.setString(3, Auditoria.getAccion());
			pstmt.setString(4, Auditoria.getDetalle());
			
			//Paso 4: Se ejecuta la sentencia
			retorno = pstmt.executeUpdate();
			
			//Paso 5: Se evalúa el resultado
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}		
		return retorno;
	}

	public ArrayList<AuditoriaBean> obtenerCodigo() {
		// TODO Auto-generated method stub
		ArrayList<AuditoriaBean> lista= new ArrayList<AuditoriaBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM auditoria";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				AuditoriaBean e = new AuditoriaBean();
				e.setCodigo(rs.getInt("codigo"));				
				lista.add(e);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}		
		return lista;
	}
	
}
