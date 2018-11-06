<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	
	<div align="center">

		<form action="UserUthorizedServlet" method="POST">
			<hr>
			<label>username:</label><br/>
			 <input type="text" name="username"	id="username" placeholder="username" required /><br />
			 
			  <label>password:</label>
			<br /> <input type="password" name="password" id="password" placeholder="password" required /><br />
			
			<br /> <input type="submit" value="Enviar" />

		</form>

	</div>

</body>
</html>