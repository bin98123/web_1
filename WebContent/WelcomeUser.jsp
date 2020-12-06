<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.getSession(false);
	if (session == null) {
	%>
	<a href="http://localhost:8080/TypingGame/home.jsp"> Home</a>
	<a href="http://localhost:8080/TypingGame/login.jsp"> Login</a>
	<%
		} else {
	// Already created.
	%>
	<a href="http://localhost:8080/TypingGame/login.jsp"> Logout</a>
	<%
		}
	String name = request.getParameter("name");
	%>
	<br>
	<br>
	<table>
		<%
			out.println("Welcome: " + name);
		%>
	</table>
	<form method="POST" action="InRoom">
		<input type="submit" value="VÀO PHÒNG">
	</form>
	<form method="POST" action="CreateRoom">
		<input type="submit" value="TẠO PHÒNG">
	</form>
	<form method="POST" action="StartGame">
		<input type="submit" value="CHƠI THỬ">
	</form>
</body>
</html>
