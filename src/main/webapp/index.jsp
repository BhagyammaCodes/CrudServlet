<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Scriptlet tag -->
<%System.out.println("this is java code");%>

<%
int a=7;
System.out.println(a);
%>

<%! int  b=8; %>
<%System.out.println(a); %>

<h1><%=b %></h1>

<h3 style="color:red"><%= LocalDate.now() %></h3>

<%@include file="insert.html" %>

<%=this %>
</body>
</html>