<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Movies</title>
</head>
<body>
	<%
	List<Movie> list = (List<Movie>) request.getAttribute("list");
	%>
<h1 align="center">Movie Details</h1>
<br>
<div align="center">
	<table border="1 px" align="center">
		<tr>
			<th>Name</th>
			<th>Image</th>
			<th>Language</th>
			<th>Genre</th>
			<th>Rating</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<%
		for (Movie movie : list) {
		%>
		<tr>
			<td><%=movie.getName()%></td>
			<td><img height="75px" width="75px" alt="<%=movie.getName()%>" src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movie.getPicture()) %>"></td>
			<td><%=movie.getLanguage()%></td>
			<td><%=movie.getGenre()%></td>
			<td><%=movie.getRating()%></td>
			<td><button>Edit</button></td>
			<td><a href="delete-movie?id=<%=movie.getId() %>>"></a><button>Delete</button></a></td>

		</tr>
		<%
		}
		%>
	</table>
	<br><a href="home.html"><button>Back</button></a>>
	</div>>
</body>
</html>