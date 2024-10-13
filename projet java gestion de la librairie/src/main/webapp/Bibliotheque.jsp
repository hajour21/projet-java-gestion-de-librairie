


<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="addition.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Books</title>
    </head>
    <body>
        <%
            Vector<Book> bookss = (Vector<Book>)request.getAttribute("books");
            String username = (String)request.getSession().getAttribute("role");
            
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="font-family: Arial; ">
            <div class="container-fluid">
                <p class="navbar-brand" > - <a class="btn btn-primary" role="button" href="./Deconnexion">Se déconnecter</a></p>
            </div>
        </nav>
        <hr>
        <h1>All Books</h1>
        <table class="table table-hover table-dark table-striped"  style="font-family: Arial;">
            <thead>
            <tr>
               <th scope="col">  <td>Title</td>
                <th scope="col">  <td>ISBN</td>
                <th scope="col">  <td>Authors</td>
                <th scope="col">  <td>Language</td>
                <th scope="col">  <td>Year</td>
                <th scope="col">  <td>Abstract</td>
            <th scope="col">  <td></td>
                
            </tr>
            </thead>
            <tbody>
            <%
            
            for(int i = 0 ; i < bookss.size() ; i++){
            Book book = bookss.get(i);
            String title = book.getTitle();
            String isbn = String.valueOf(book.getISBN());
            String author = book.getAuthor();
            String Language = book.getLanguage();
            int year = book.getYear();
            String abstracte = book.getAbstract();
            

        %>
            
            <tr>
                <th scope="row"><td><%= title %></td>
                <td><%= isbn %></td>
                <td><%= author %></td>
                <td><%= Language %></td>
                <td><%= year %></td>
                <td><%= abstracte %></td>
                
                <td><a name="ftit" href="./DeleteBook?ftit=<%=book.getTitle() %>"> Delete </a></td>
        </tr>    
        
            <% } %>
            </tbody>
        </table>
        <hr>
        <form action="./Addbook" method="POST">
            <div class="mb-3"><label  class="form-label">Title</label><input  class="form-control"  type="text" name="title"/><br></div>
            <div class="mb-3"><label  class="form-label">ISBN</label><input  class="form-control"  type="text" name="isbn"/><br></div>
            <div class="mb-3"><label  class="form-label">Author</label><input class="form-control" type="text" name="author"/><br></div>
            <div class="mb-3"><label  class="form-label">Language</label><input  class="form-control"  type="text" name="Language"/><br></div>
            <div class="mb-3"><label  class="form-label">Abstract</label><input  class="form-control"  type="text" name="abstract"/><br></div>
            <div class="mb-3"><label  class="form-label">Year</label><input  class="form-control"  type="text" name="year"/><br></div>
            
           
            <input class="btn btn-primary" type="Submit" value="Ajouter"/>
        </form>
        
    </body>
</html>
