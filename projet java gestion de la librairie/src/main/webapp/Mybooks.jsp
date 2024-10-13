
<%@page import="addition.*"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Books</title>
    </head>
    <body>
        <%
            Vector<Book> books = (Vector<Book>)request.getAttribute("book");
            User user = (User)request.getSession().getAttribute("user");
            
        %>
        <hr>
        <p><%=user.getFname() %> <%= user.getLname()%><a href="./Deconnexion">logOut</a></p>
        <p><a href="./Books"> All Books</a> - <a href="./Mybooks">My Books</a></p>
        <h1>Mes formations</h1>
        <table>
                      <tr>
                 <td>Title</td>
                <td>ISBN</td>
                <td>Authors</td>
                <td>Language</td>
                 <td>Year</td>
                 <td>Abstract</td>
              <td></td>
                
            </tr>
            
            <tbody>
            <%
            
            for(int i = 0 ; i < books.size() ; i++){
            Book book = books.get(i);
            String title = book.getTitle();
            String isbn = String.valueOf(book.getISBN());
            String author = book.getAuthor();
            String Language = book.getLanguage();
            int year = book.getYear();
            String abstracte = book.getAbstract();
            

        %>
            
            <tr>

                <td><%= title %></td>
                <td><%= isbn %></td>
                <td><%= author %></td>
                <td><%= Language %></td>
                <td><%= year %></td>
                <td><%= abstracte %></td>
                
            <td><a name="bis" name="mid" href="./ViewBook?bis=<%=book.getISBN() %>&mid=<%= user.getLogin() %>"> View </a></td>
           
            </tr>
            <% } %>
        </table>
    </body>
</html>
