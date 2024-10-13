/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import addition.Book;
import addition.User;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author njehm
 */
public class Bookss extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User u1 = (User) request.getSession().getAttribute("user");
            Vector<Book> books = new Vector<Book>();
            Connection cnx = BdConnexion.getConnection();
            Statement stmt = cnx.createStatement();
            System.out.println("SELECT * FROM bibliotheque.t_books WHERE title NOT IN (SELECT bibliotheque.t_book_user.id_book FROM t_book_user WHERE t_book_user.id_user =" + u1.getLogin() +")");
            ResultSet reslt = stmt.executeQuery("SELECT * FROM bibliotheque.t_books WHERE title NOT IN (SELECT bibliotheque.t_book_user.id_book FROM t_book_user WHERE t_book_user.id_user = " + u1.getLogin() +")"); 
            while (reslt.next()){
            	   String Title = reslt.getString("Title");
                   String ISBN = reslt.getString("ISBN");
                   String Author = reslt.getString("Author");
                   String Language = reslt.getString("Language");
                   int Year = reslt.getInt("Year");
                   String Abstract = reslt.getString("Abstract");
                   Book  b = new Book(Title,ISBN ,Author ,Language ,Year ,Abstract);
                   books.add(b);
            }
            request.setAttribute("books", books);
            getServletContext().getRequestDispatcher("/Bibliotheque.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Bookss.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Sho rt description";
    }// </editor-fold>

}
