package servlets;
import addition.User;
import addition.Book;
import bdConnection.BdConnexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mybooks" )
public class Mybooks extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User u1 = (User) request.getSession().getAttribute("user");
            Vector<Book> book = new Vector<Book>();
            Connection cnx = BdConnexion.getConnection();
            Statement stmt = cnx.createStatement();
            System.out.println("SELECT * FROM bibliotheque.t_books WHERE isbn NOT IN (SELECT id_book FROM bibliotheque.t_book_user WHERE bibliotheque.t_book_user.id_user =" +"'"+ u1.getLogin()+"'"+ ")");
            ResultSet reslt = stmt.executeQuery("SELECT * FROM bibliotheque.t_books WHERE isbn IN (SELECT bibliotheque.t_book_user.id_book FROM t_book_user WHERE t_book_user.id_user =" +"'"+ u1.getLogin()+"'"+")"); 
            while (reslt.next()){
               String Title = reslt.getString("Title");
                String ISBN = reslt.getString("ISBN");
                String Author = reslt.getString("Author");
                String Language = reslt.getString("Language");
                int Year = reslt.getInt("Year");
                String Abstract = reslt.getString("Abstract");
                Book  b = new Book(Title,ISBN , Author, Language,   Year, Abstract);
                book.add(b);
            }
            request.setAttribute("book", book);
            getServletContext().getRequestDispatcher("/Mybooks.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
}
