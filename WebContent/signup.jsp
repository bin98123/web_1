<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee Register Form</h1>
		<form action="<%=request.getContextPath()%>/UserRegisterSuccess"
			method="post">
			<table style="with: 80%">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Account Name</td>
					<td><input type="text" name="userNameIG" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPassword" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="userEmail" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>