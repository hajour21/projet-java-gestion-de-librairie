<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            Nom: <input type="text" name="fname" /><br>
            Prenom: <input type='text' name="lname"/><br>
          
            Mot de passe: <input type="password" name="password" /><br>
            ID: <input type='text' name="id" /><br>
  <i>Genre :</i> <input type="radio" id="male" name="Genre" value="Male"
         checked>
  <label for="male">Male</label>
<input type="radio" id="female" name="Genre" value="Female"
         checked>
  <label for="female">Female</label><br>


<label for="grade">Grade :</label>
	<input list="grades" name="grade">
<datalist id="grades"> 
    <option value="Student">
    <option value="Teacher">
    <option value="Author">
  </datalist><br>
<label for="Adresse">Adresse :</label>
  <input type = "text" id="Adresse" name="Adresse" size="40"   ><br>
 <label for="Email">E-mail :</label>
 <input type="email" name="email" ><br>
 <label for="Telephone">Telephone :</label>
 <input type= "text" id="telephone" name="telephone" >
            
 <input type="Submit" value="Creat" >
        </form>
    </body>
</html>
