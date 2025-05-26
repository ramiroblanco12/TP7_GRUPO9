package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class TipoSegurosDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	//cambiar a tu contraseña de bd
	private String pass = "password";
	private String dbName = "SegurosGroup";
	
	
	public ArrayList<TipoSeguros>  obtenerTipoSeguros(){
		
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<TipoSeguros> listaTipoSeguros = new ArrayList<TipoSeguros>();
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host + dbName + "?useSSL=false", user, pass);
			String sql = "SELECT * FROM tipoSeguros";
			java.sql.Statement statement = conexion.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				TipoSeguros tipoSeguros = new TipoSeguros();
				tipoSeguros.setIdTipo(resultSet.getInt("idTipo"));
				tipoSeguros.setDescripcion(resultSet.getString("descripcion"));
				listaTipoSeguros.add(tipoSeguros);
			}
			conexion.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return listaTipoSeguros;
		
		
	}

}
