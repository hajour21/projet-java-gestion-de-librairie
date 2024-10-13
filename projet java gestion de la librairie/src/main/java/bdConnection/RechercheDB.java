package bdConnection;
import addition.Book;
import addition.User; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class RechercheDB {

	
	    public User getUser(String login, String password) throws SQLException{
	        Connection connexion = bdConnection.BdConnexion.getConnection();
	        Statement stmt = connexion.createStatement(); 
	        ResultSet resultat = stmt.executeQuery("SELECT * FROM bibliotheque.t_users WHERE password = "+ password + "login = "+ login);
	        
	        String fname = resultat.getString("first_name");
	        String lname = resultat.getString("family_lname");
	        String gendre = resultat.getString("gendre");
	        String grade = resultat.getString("grade");
	        String address = resultat.getString("address");
	        String email = resultat.getString("email");
	        int telephone = resultat.getInt("telephone");
	        
	        
	        if (email != null) {
	            User user = new User(login,password,fname,lname,gendre ,grade ,address,email, telephone );
	            return user;
	            }
	        else {
	            return null;}
	    }
	    private static final String INSERT_BOOKS_SQL = "INSERT INTO t_books"
				+ "  (title,isbn,authors,lang,year,abstract) VALUES " + " (?,?,?,?,?,?);";

		private static final String SELECT_BOOK_BY_ISBN = "select title,isbn,authors,lang,year,abstract from bibliotheque.t_books where isbn =?";
		private static final String SELECT_ALL_BOOKS = "select * from bibliotheque.t_books";
		private static final String DELETE_BOOK_BY_ISBN = "delete from bibliotheque.t_books where isbn=?;";
		private static final String UPDATE_BOOK = "update bibliotheque.t_books set title = ?, authors =?, lang =?, year = ?, abstract = ? where isbn = ?;";
		public void BookControl(BdConnexion BdConnexion) {

			
		}

		public void insertbook(Book book) throws SQLException {
			System.out.println(INSERT_BOOKS_SQL);

			// try-with-resource statement will auto close the connection.
			try (Connection connection = bdConnection.BdConnexion.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
				preparedStatement.setString(1, book.getTitle());
				preparedStatement.setString(2, book.getISBN());
				preparedStatement.setString(3, book.getAuthor());
				preparedStatement.setString(4, book.getLanguage());
				preparedStatement.setInt(5, book.getYear());
				preparedStatement.setString(6, book.getAbstract());
				System.out.println(preparedStatement);
			    preparedStatement.executeUpdate();
				connection.commit();
				
			} catch (SQLException exception) {
				bdConnection.BdConnexion.printSQLException(exception);

			}
		}

		public Book selectbook (String isbn2) {
			Book book = null;
			// Step 1: Establishing a Connection
			try (Connection connection = bdConnection.BdConnexion.getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ISBN);) {
				preparedStatement.setString(1, isbn2);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();
				connection.commit();


				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String Title = rs.getString("title");
	                String ISBN = rs.getString("isbn");
	                String Author = rs.getString("authors");
	                String Language = rs.getString("lang");
	                int Year = rs.getInt("year");
	                String Abstract = rs.getString("abstract");
	                book = new Book(Title,ISBN,Author,Language,Year,Abstract);
	    			System.out.println(book);

				}
			} catch (SQLException exception) {
				bdConnection.BdConnexion.printSQLException(exception);
			}
			
			return book;
		}
		

		public Vector<Book> selectAllbook() {

			// using try-with-resources to avoid closing resources (boiler plate code)
            Vector<Book> books = new Vector<Book>();

			// Step 1: Establishing a Connection
			try (Connection connection = bdConnection.BdConnexion.getConnection();

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String Title = rs.getString("title");
	                String ISBN = rs.getString("isbn");
	                String Author = rs.getString("authors");
	                String Language = rs.getString("lang");
	                int Year = rs.getInt("year");
	                String Abstract = rs.getString("abstract");
	                books.add(new Book( Title,ISBN , Author, Language,   Year, Abstract));
	    			connection.commit();

				}
			} catch (SQLException exception) {
				bdConnection.BdConnexion.printSQLException(exception);
			}
			return books;
		}

		public boolean deletebook(String isbn) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = bdConnection.BdConnexion.getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_BY_ISBN);) {
				statement.setString(1, isbn);

				rowDeleted = statement.executeUpdate() > 0;
				connection.commit();

			}
			return rowDeleted;
		}

		public boolean updatebook(Book book) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = bdConnection.BdConnexion.getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);) {
				statement.setString(1, book.getTitle());
				statement.setString(2, book.getAuthor());
				statement.setString(3, book.getLanguage());
				statement.setInt(4, book.getYear());
				statement.setString(5, book.getAbstract());
				statement.setString(6, book.getISBN());
				rowUpdated = statement.executeUpdate() > 0;
				connection.commit();

			}
			return rowUpdated;
		}

}


