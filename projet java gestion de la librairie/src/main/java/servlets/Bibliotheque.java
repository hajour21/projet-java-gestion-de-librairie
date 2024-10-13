/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bdConnection.*;
import addition.Book;
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
@WebServlet("/Bibliotheque" )
public class Bibliotheque extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null && role.equals("admin")) {
        try {
            
            
            try {
                Class.forName("com.mysql.jdbc.Driver2");
            }
            catch (ClassNotFoundException e ) {
                System.out.println("ERROR DB DRIVER" + e.getMessage());
            }
            
            
            Vector<Book> book = new Vector<Book>();
            Connection cnx = BdConnexion.getConnection();
            Statement stmt = cnx.createStatement();
            ResultSet reslt = stmt.executeQuery("SELECT * FROM bibliotheque.t_books");
            System.out.println("resultaaaa"+reslt);
            while (reslt.next()){
                String Title = reslt.getString("Title");
                String ISBN = reslt.getString("ISBN");
                String Author = reslt.getString("Author");
                String Language = reslt.getString("Language");
                int Year = reslt.getInt("Year");
                String Abstract = reslt.getString("Abstract");
                Book  books = new Book(Title,ISBN ,Author ,Language ,Year ,Abstract);
                book.add(books);
           System.out.println(reslt.next());            }
            request.setAttribute("books", book);
            getServletContext().getRequestDispatcher("/Bibliotheque.jsp").forward(request, response);
        }
        catch (SQLException ex ) {
                Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
