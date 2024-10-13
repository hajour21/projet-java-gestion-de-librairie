package bdConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnexion {
	  public final static String url = "jdbc:mysql://localhost:3306/bibliotheque";
	    public final static String username = "root";
	    public final static String password = "123456789++";

	    
	    public static  Connection getConnection() throws SQLException {
	        try{
	        Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        System.err.println(e.getMessage());    
	        }
	        Connection connexion = DriverManager.getConnection(url, username, password);
	        return connexion;
	    }

	    public static String getUrl() {
	        return url;
	    }

	    public static String getUsername() {
	        return username;
	    }

	    public static String getPassword() {
	        return password;
	    }

		public static void printSQLException(SQLException ex) {
			// TODO Auto-generated method stub
			
			// TODO Auto-generated method stub
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}

	    
	}


