 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String email=request.getParameter("email");
session.putValue("email",email);
%>
<body>
<html>
<form action=".jsp" method="post">
Please enter your email :<input type="text" name="email" /><br>
<input type="submit" /> </form> </body>
</html>