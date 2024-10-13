<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="style.css">
        
        <title>Creer un nouveau compte</title>
    </head>
    <body>
        <%
        String err = (String)request.getAttribute("error");
        %>
        <h1 style="text-align: center">Creation de compte</h1>
        <% if (err != null) { %>
            <h5 style="color: red"><%= err %></h5><br>
            <% }%>
        <form action="./CreationCompte1" method="post">
         <h4 style="text-align: center">   Nom: <input type="text" name="fname" required/></h4>
         <h4 style="text-align: center">   Prenom: <input type='text' name="lname" required/></h4>
          
          <h4 style="text-align: center">  Mot de passe: <input type="password" name="password" required/></h4>
          <h4 style="text-align: center">  ID: <input type='text' name="id" required/></h4>
  <h4 style="text-align: center"> <i>Genre :</i> </h4><input type="radio" id="male" name="Genre" value="Male"
         checked>
 <h4 style="text-align: center"> <label for="male">Male</label>
<input type="radio" id="female" name="Genre" value="Female"
         checked>
  <label for="female">Female</label></h4>


<h4 style="text-align: center"><label for="grade">Grade :</label>
	<input list="grades" name="grade"></h4>
<h4 style="text-align: center"><datalist id="grades"> 
    <option value="Student">
    <option value="Teacher">
    <option value="Author">
  </datalist></h4>
<h4 style="text-align: center"><label for="Adresse">Adresse :</label>
  <input type = "text" id="Adresse" name="Adresse" size="40" required  ></h4>
<h4 style="text-align: center"> <label for="Email">E-mail :</label> 
 <input type="email" name="email" required></h4>
<h4 style="text-align: center"> <label for="Telephone">Telephone :</label>
 <input type= "text" id="telephone" name="telephone" required></h4>
            
 <h4 style="text-align: center"> <input type="Submit" value="Crée" ></h4>
        </form>
    </body>
</html>
