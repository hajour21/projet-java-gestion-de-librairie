package servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CreationCompte1" )
public class CreationCompte1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public CreationCompte1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	int id = Integer.parseInt(request.getParameter("id"));
        	String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gendre = request.getParameter("Gendre");
            String grade = request.getParameter("grade");
            String address = request.getParameter("Adresse");
           
            if (isValid(email) && !fname.isEmpty() && !lname.isEmpty() && !email.isEmpty() && !password.isEmpty() && fname != null && lname != null && email != null && password != null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } 
            catch (ClassNotFoundException e ) {
                System.out.println("ERROR DB DRIVER" + e.getMessage());
            }
            
            Connection cnx = bdConnection.BdConnexion.getConnection();
            Statement stmt = (Statement) cnx.createStatement();
            int statut = ((java.sql.Statement) stmt).executeUpdate("INSERT INTO bibliotheque.t_users (id_user,first_name, family_name, login, password,gendre,grade,address) VALUES ('"+id+"','"+fname+"', '"+lname+"', '"+email+"', '"+password+"', '"+gendre+"', '"+grade+"', '"+address+"'"+")");
            request.setAttribute("etat", Integer.toString(statut));
            System.out.println(statut);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Erreur: Verifier vos parametres saisis");
                getServletContext().getRequestDispatcher("/creationcompte.jsp").forward(request, response);
                }
        } catch (SQLException ex) {
            Logger.getLogger(CreationCompte1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public boolean isValid(String email){
        
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                                "[a-zA-Z0-9_+&*-]+)*@" +
                                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                                "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (email == null)
                return false;
            return pat.matcher(email).matches();
        }

    public String getServletInfo() {
        return "Short description";
    }

	}


