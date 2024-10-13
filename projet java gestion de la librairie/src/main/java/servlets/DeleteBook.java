package servlets;
import addition.Book;
import bdConnection.BdConnexion;

import java.io.IOException;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.lang.System.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null && role.equals("admin")){
        try {
            String title1 = request.getParameter("ftit");
            Connection cnx = BdConnexion.getConnection();
            Statement stmt = cnx.createStatement();
            int statut = stmt.executeUpdate("DELETE FROM bibliotheque.t_books WHERE title   =" +title1);
            int statut1 = stmt.executeUpdate("DELETE FROM bibliotheque.t_books WHERE title =" +title1);
            
            
            Vector<Book> book = new Vector<Book>();
            
            ResultSet reslt = stmt.executeQuery("SELECT * FROM bibliotheque.t_books");
            while (reslt.next()){
                String title = reslt.getString("title");
                String isbn = reslt.getString("isbn");
                String author = reslt.getString("authors");
                String language = reslt.getString("lang");
                int year = reslt.getInt("year");
                String abstracte = reslt.getString("abstract");
                
                Book  b = new Book(title,isbn,author,language,year,abstracte);
                book.add(b);
            }
            request.setAttribute("books", book);
            //-----------------
            request.setAttribute("result", "Book Deleted!");
            getServletContext().getRequestDispatcher("/Bibliotheque.jsp").forward(request, response);
            
        } catch (SQLException ex) {
        }
    }
    }}



 	