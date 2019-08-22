<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
{
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
.error {
	color: #ff0000;
}
</style>
</head>
<body>

<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/philips" user="root"/>

<sql:query dataSource="${ds}" var="result"> 
    SELECT * from Publisher;
</sql:query>

<h3>This is the result ${result}</h3>
<form action="details" method="post">
Book_name <input name="name"><br>
Book_genre <input name="genre"><br>
Book_author <input name="author"><br>
<select name="category">
    <c:forEach var="row" items="${result.rows}">   
      <option value='<c:out value="${row.value}"/>'></option>
    </c:forEach>
</select>
<input name="submit" value="submit" type="submit">
</form>


<br>
<br>
<br>

<table>
<tr> 
<th>id</th>
<th>name</th>
<th>genre</th>
<th>author</th>
</tr>
<c:forEach items = "${books}" var="p">
<tr> <td>${p.id}</td> <td>${p.name}</td> <td>${p.genre}</td> <td>${p.author}</td></tr> 
<!-- above line calls the get method() and gets the property values -->
</c:forEach>
</table>


</body>
</html>