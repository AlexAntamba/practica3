package Empleado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Empleado.Beans.EmpleadoBean;
import Empleado.Interfaces.EmpleadoDAO;

public class MySqlEmpleadoDAO implements EmpleadoDAO {
	@Override
	public EmpleadoBean consultarPorCodigo(int codigo) {
		EmpleadoBean e = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM empleados WHERE codigo=? and estado=1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			if (rs.next()){
				e = new EmpleadoBean();
				e.setCodigo(rs.getInt("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setDireccion(rs.getString("direccion"));
				e.setEmail(rs.getString("email"));
				e.setTelefono(rs.getString("telefono"));
			}			
		} 
		
		catch(Exception m){
			m.printStackTrace();
			
		} 
		finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception m){m.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception m){m.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception m){m.printStackTrace();}
		}
		return e;
	}

	@Override
	public ArrayList<EmpleadoBean> consultarTodos() {
		ArrayList<EmpleadoBean> lista= new ArrayList<EmpleadoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM empleados WHERE estado=1";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				EmpleadoBean e = new EmpleadoBean();
				e.setCodigo(rs.getInt("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setDireccion(rs.getString("direccion"));
				e.setEmail(rs.getString("email"));
				e.setTelefono(rs.getString("telefono"));
				
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

	@Override
	public int eliminarEmpleado(int codigo) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE empleados SET estado=0 WHERE codigo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
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

	@Override
	public int ingresarEmpleado(EmpleadoBean Empleado) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "INSERT INTO empleados VALUES(?,?,?,?,?,?,1)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Empleado.getCodigo());
			pstmt.setString(2, Empleado.getNombre());
			pstmt.setString(3, Empleado.getApellido());
			pstmt.setString(4, Empleado.getDireccion());
			pstmt.setString(5, Empleado.getEmail());
			pstmt.setString(6, Empleado.getTelefono());	
			
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

	@Override
	public int modificarEmpleado(EmpleadoBean Empleado) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE empleados SET nombre=?," +
								"apellido=?, direccion=?, email=?," + 
								"telefono=? WHERE " +
								"codigo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Empleado.getNombre());
			pstmt.setString(2, Empleado.getApellido());
			pstmt.setString(3, Empleado.getDireccion());
			pstmt.setString(4, Empleado.getEmail());
			pstmt.setString(5, Empleado.getTelefono());
			pstmt.setInt(6, Empleado.getCodigo());
			
			//Paso 4: Se ejecuta la sentencia
			retorno = pstmt.executeUpdate();
		} 
		
		catch(Exception e){
			e.printStackTrace();
		} 
		
		finally {
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return retorno;
	}

	@Override
	public ArrayList<EmpleadoBean> buscarEmpleados(String nombre, String apellido) {
		ArrayList<EmpleadoBean> lista= new ArrayList<EmpleadoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM empleados WHERE nombre like ? and apellido like ? and estado=1";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+nombre+"%");
			pstmt.setString(2, "%"+apellido+"%");
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				EmpleadoBean e = new EmpleadoBean();
				e.setCodigo(rs.getInt("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setDireccion(rs.getString("direccion"));
				e.setEmail(rs.getString("email"));
				e.setTelefono(rs.getString("telefono"));
				
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

	@Override
	public ArrayList<EmpleadoBean> consultarCodigos() {
		// TODO Auto-generated method stub
		ArrayList<EmpleadoBean> lista= new ArrayList<EmpleadoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM empleados";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				EmpleadoBean e = new EmpleadoBean();
				e.setCodigo(rs.getInt("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setDireccion(rs.getString("direccion"));
				e.setEmail(rs.getString("email"));
				e.setTelefono(rs.getString("telefono"));
				
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
