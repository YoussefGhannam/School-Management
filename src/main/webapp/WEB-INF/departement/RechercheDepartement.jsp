<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/webapp/index">Mini annuaire de l’ENS</a>
    </nav>

    <div class="container mt-4">
        <h2>Departement</h2>
        <form action="searchDepartement" method="post">
            <div class="form-group">
                <label for="departementId">Departement Nom:</label>
                <input type="text" class="form-control" id="departementNom" name="departementNom">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
    <!-- Display search results -->
        <div class="container mt-5">
        </br>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Nom</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <% String nom = (String) request.getAttribute("nom");
        if (nom != "") {%>
        	<td>${id }</td>
        	<td>${nom }</td>
        	
      </tr>
      <%} 
      else {%>
      <p>No Data Found</p>
      <%} %>
      <!-- Add more rows here if needed -->
    </tbody>
  </table>	
  </div>

    <!-- Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
</body>


</html>