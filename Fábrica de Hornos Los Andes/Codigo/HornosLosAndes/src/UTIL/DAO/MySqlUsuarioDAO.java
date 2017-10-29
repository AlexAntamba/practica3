package UTIL.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UTIL.Beans.UsuarioBean;
import UTIL.Interfaces.UsuarioDAO;


public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public UsuarioBean validarUsuario(String login, String password) {
		
		UsuarioBean ub = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM Usuarios WHERE login=? AND password=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se llena el bean con los datos
			if (rs.next()){
				ub = new UsuarioBean();
				ub.setLogin(login);
				ub.setPassword(password);
				ub.setNombre(rs.getString("NOMBRE"));
				ub.setTipoUsuario(rs.getString("TIPOUSUARIO"));
			}			
		} 
		
		catch(Exception e){
			e.printStackTrace();
		} 
		
		finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		
		return ub;	
	}
}
