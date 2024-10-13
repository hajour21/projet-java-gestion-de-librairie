<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="style.css">
        <title>Login</title>
        
    </head>
<body class="main-bg">
           
        <div class="login-container text-c animated flipInX">
                <div>
                    <h1 class="logo-badge text-whitesmoke"><span class="fa fa-user-circle"></span></h1>
                </div>
                    <h3 class="text-whitesmoke">Sign In Book App</h3>
                    <p class="text-whitesmoke">Sign In</p>
                <div class="container-content">
                    <form class="margin-t" action="./Authentification" method="post" >
       <%
        String err = (String)request.getAttribute("error");
        String etat = (String)request.getAttribute("etat");
        %>
        
        
         <% if (err != null) { %>
            <h5 style="color: red"><%= err %></h5><br>
            <% }%>
            <% if (etat != null) { %>
            <h5 style="color: green">utilisateur cree avec succes!</h5><br>
            <% }%>
       
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="username" name="username" required/><br>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="*****" name="password" required/><br>
                        </div>
                        <button type="submit" class="form-button button-l margin-b">Sign In</button>
        
                        <p class="text-whitesmoke text-center"><small>Do not have an account?</small></p>
                        <a class="text-darkyellow" href="./creationcompte.jsp"><small>Sign Up</small></a>
                    </form>
                </div>
            </div>
</body>