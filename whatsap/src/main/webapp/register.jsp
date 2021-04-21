<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><font color=red size=6>${result}</font></center>

	<form method="post" action="createprofile">
		<p>Registration Page</p>
		Name : <input type=text name=name><br>
		Password : <input type=password name=pass><br>
		Email : <input type=email name=email><br>
		Address : <input type=text name=address><br>
		<input type=submit value=Register><br>
	</form>
	
	<br> your detail is below
	<br> ${p1}
	<br> ${p2}
	<br> ${p3}
	<br> ${p4}
</body>
</html>