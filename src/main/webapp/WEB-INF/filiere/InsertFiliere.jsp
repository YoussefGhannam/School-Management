<%@ page import ="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	PrintWriter outt = response.getWriter();
	int message = (int) request.getAttribute("message");        

	if (message == 0) { 
		outt.println("<meta http-equiv='refresh' content='3;URL=index'>");//redirects after 3 seconds
 	   	outt.println("<p style='color:red;font-size:20px;font-style:bold;text-align:center'>La Filiere n'a pas été inserer!</p>");
		
	}
	else {
        outt.println("<meta http-equiv='refresh' content='3;URL=index'>");//redirects after 3 seconds
        outt.println("<p style='color:green;font-size:20px;font-style:bold;text-align:center'>La Filiere a été inserer!</p>");
	}
	%>
	
	<p>${error }</p>
		
</body>
</html>