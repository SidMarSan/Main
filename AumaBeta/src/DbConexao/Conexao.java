package DbConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection fazer_conexao() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/aumapf","root","Benjamin6346%");
			
			
		} catch (ClassNotFoundException  e) {
			throw new SQLException(e.getException());
		
		}
	}
	
	}

