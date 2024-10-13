
package servlets;

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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Addbook" )
public class Addbook extends HttpServlet {

	private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null && role.equals("admin")){
        try {
    		String titre = request.getParameter("title");
    		String isbn = request.getParameter("ISBN");
    		String author = request.getParameter("Author");
    		String language = request.getParameter("language");
    		int year = Integer.parseInt(request.getParameter("year"));
    		String abstract1 = request.getParameter("abstract");
    		Book book = new Book(titre, isbn, author, language, year, abstract1);

    
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("./AddBook.jsp");
    		dispatcher.forward(request, response);
        
        }}}

    
    

