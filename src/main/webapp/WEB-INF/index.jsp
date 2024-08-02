<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<meta charset="UTF-8">
<title>Annuaire Application</title>
</head>
<body>

	<div class="container mt-5">
        <h1 class="text-center mb-4">Annuaire Application</h1>
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        Menu utilisation
                    </div>
                    <div class="card-body">
                        <ul class="list-group">
                            <li class="list-group-item"><a href="/webapp/list_etudiant">Liste complète des étudiants</a></li>
                            <li class="list-group-item"><a href="/webapp/searchEtudiant">Recherche d’un étudiant</a></li>
                            <li class="list-group-item"><a href="/webapp/list_departement">Liste complète des départements</a></li>
                            <li class="list-group-item"><a href="/webapp/searchDepartement">Recherche d’un département</a></li>
                            <li class="list-group-item"><a href="/webapp/list_filiere">Liste complète des filières</a></li>
                            <li class="list-group-item"><a href="/webapp/searchFiliere">Recherche d’une filière</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        Menu administration
                    </div>
                    <div class="card-body">
                        <ul class="list-group">
                            <li class="list-group-item"><a href="/webapp/insert_etudiant">Insertion d’un nouvel étudiant</a></li>
                            <li class="list-group-item"><a href="/webapp/insert_departement">Insertion d’un nouveau département</a></li>
                            <li class="list-group-item"><a href="/webapp/insert_filiere">Insertion d’une nouvelle filière</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
		
	

</body>
</html>