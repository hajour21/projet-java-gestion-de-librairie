package servlets;

import addition.User;
import bdConnection.BdConnexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Authentification" )
public class Authentification extends HttpServlet {   
	private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pw = request.getParameter("password");
        
        if (username.equals("admin") && pw.equals("enet2022")) {
            
            request.getSession().setAttribute("role","admin");
            response.sendRedirect("./Addbook");
            
        } else {
            try {
                User u1 = getUser(username,pw);
                if (u1 == null) {
                    request.setAttribute("error", "Erreur: utilisateur non reconnu");
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    request.getSession().setAttribute("user", u1);
                    response.sendRedirect("./Bookss");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }
    

    public User getUser(String login, String password) throws SQLException{
        Connection connexion = BdConnexion.getConnection();
        Statement stmt = connexion.createStatement(); 
        try{
        ResultSet resultat = stmt.executeQuery("SELECT * FROM bibliotheque.t_users WHERE (password = '"+ password + "' AND login = '"+ login+"')");
        System.out.println("resulta"+resultat);
        
        if (resultat != null) {
            resultat.next();
        System.out.println("resultat2");
        String fname= resultat.getString("first_name");
        String lname = resultat.getString("family_name");
        String email = resultat.getString("email");
        int telephone = resultat.getInt("telephone");
        String gendre = resultat.getString("gendre");
        String grade = resultat.getString("grade");
        String address = resultat.getString("address");
        String password1 = resultat.getString("password");
            User user = new User(login , password1 , fname, lname, gendre ,grade ,address , email , telephone);
            return user;
        }else {
            return null;}
        } catch (SQLException ex) {
                Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
            } return null;
    } 

}
