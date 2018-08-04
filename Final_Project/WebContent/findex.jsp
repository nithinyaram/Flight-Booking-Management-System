<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "pro";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<head>
	<link rel="stylesheet" href="indexcss.css">
</head>

	<div class="d1">

  <ul>
    <li><a class="active" href="fMainpage.html">Home</a></li>
    <li><a href="finsert.html">Insert</a></li>
    <li><a href="fdelete.html">Delete</a></li>
    <li><a href="fsearch.html">Serach</a></li>
    <li><a href="fupdate.html">Update</a></li>
    <li><a href="findex.jsp">Show</a></li>
    

  </ul>

  </div>


<table id='customers' align='center'  border= 1px solid style='border-collapse:collapse;'>
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Flight Id</b></td>
<td><b>Flight Name</b></td>
<td><b>Source</b></td>
<td><b>Distination</b></td>
<td><b>Distance</b></td>
<td><b>Cost</b></td>
<td><b>No of Seats</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM record";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("src") %></td>
<td><%=resultSet.getString("dis") %></td>
<td><%=resultSet.getString("distance") %></td>
<td><%=resultSet.getString("cost") %></td>
<td><%=resultSet.getString("seats") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>