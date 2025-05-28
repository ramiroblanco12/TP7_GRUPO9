package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public int obtenerUltimoIdUsuario() {
	    int ultimoId = -1;
	    Connection con = null;

	    try {
	        con = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement st = con.prepareStatement("SELECT MAX(idSeguro) FROM seguros");
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            ultimoId = rs.getInt(1);
	        }

	        con.close();
	    } catch (Exception e) {
	        System.out.println("Error al obtener el último ID: " + e.getMessage());
	    }

	    return ultimoId;
	}
	
	
	public boolean agregarSeguro(Seguro seguro) {
	    Connection con = null;
	    boolean exito = false;
	    
	    try {
	        con = DriverManager.getConnection(host + dbName, user, pass);
	        String sql = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)";
	        
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, seguro.getDescripcion());
	        st.setInt(2, seguro.getIdtipo());
	        st.setFloat(3, seguro.getCostoContracion());
	        st.setFloat(4, seguro.getCostoAsegurado());
	        
	        int filasAfectadas = st.executeUpdate();
	        exito = (filasAfectadas > 0);
	        
	    } catch (Exception e) {
	        System.out.println("Error al agregar seguro: " + e.getMessage());
	    } finally {
	        if (con != null) {
	            try { con.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	    }
	    return exito;
	}
	
}