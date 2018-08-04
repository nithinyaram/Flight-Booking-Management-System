package com.javapages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fsearchj
 */
@WebServlet("/fsearchj")
public class fsearchj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fsearchj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<link rel='stylesheet'"
				+ " href='search.css'>"
				+ "</head>");
		out.println("<body>");
		
		String name=request.getParameter("t1");
		String id=request.getParameter("t2");
		String src=request.getParameter("t3");
		String dis=request.getParameter("t4");
		String cost=request.getParameter("t5");
		
		
		
		
		//System.out.println(cgpa);
		int i=0;
		
		
		out.println("<div class=\"d1\">\r\n" + 
				"\r\n" + 
				"  <ul>\r\n" + 
				"    <li><a class=\"active\" href=\"fMainpage.html\">Home</a></li>\r\n" + 
				"    <li><a href=\"finsert.html\">Insert</a></li>\r\n" + 
				"    <li><a href=\"fMainpage.html\">Delete</a></li>\r\n" + 
				"    <li><a href=\"fsearch.html\">Serach</a></li>\r\n" + 
				"    <li><a href=\"findex.jsp\">Show</a></li>\r\n" + 
				"    \r\n" + 
				"\r\n" + 
				"  </ul>\r\n" + 
				"\r\n" + 
				"  </div>");
		
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
			
			java.sql.Connection connection = null;
			java.sql.Statement statement = null;
			java.sql.ResultSet resultSet = null;
			
			try{ 
				connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
				statement=connection.createStatement();
				if(name!=null) {
					i=1;
					String sql ="SELECT * FROM record  where name='"+name+"'";
					resultSet = statement.executeQuery(sql);	
				}
				else if(id!=null) {
					i=1;
					out.println("Not empty");
					String sql ="SELECT * FROM record  where id='"+id+"'";
					resultSet = statement.executeQuery(sql);
					
				}
				else if(src!=null) {
					i=1;
					String sql ="SELECT * FROM record  where src='"+src+"'";
					resultSet = statement.executeQuery(sql);
					
				}
				else if(dis!=null)
				{
					i=1;
					
					String sql ="SELECT * FROM record  where dis='"+dis+"'";
					resultSet = statement.executeQuery(sql);
				
				}
				else if(cost!=null) {
					 if(cost.equals("below 500")) {
						// out.println(cgpa);
						 String sql ="SELECT * FROM record  where cost<'500'";
						 resultSet = statement.executeQuery(sql);
						 i=1;
						
					 }
					 else if(cost.equals("above 500")) {
						 //out.println(cgpa);
						 String sql ="SELECT * FROM record  where cost>'500'";
						 resultSet = statement.executeQuery(sql);
						 i=1;
						
					 }
					 else if(cost.equals("below 1500")) {
						 //out.println(cgpa);
						 String sql ="SELECT * FROM record  where cost<'1500'";
						 resultSet = statement.executeQuery(sql);
						 i=1;
						
					 }
					 else if(cost.equals("1000")) {
						 //out.println(cgpa);
						 String sql ="SELECT * FROM record  where cost='1000'";
						 resultSet = statement.executeQuery(sql);
						 i=1;
						
					 }
					 else if(cost.equals("2000")) {
						 //out.println(cgpa);
						 String sql ="SELECT * FROM record  where cost='2000'";
						 resultSet = statement.executeQuery(sql);
						 i=1;
						
					 }
					
					 else if(cost.equals("above 2000")) {
						 //out.println(cgpa);
						 String sql ="SELECT * FROM record  where cost>'2000'";
						 resultSet = statement.executeQuery(sql);
						 i=1;
						
					 }	 else {
						 out.println("No record ");
					 }
				}
						
			
				out.println("<br>");
				out.println("<table id='customers' align='center'  border= 1px solid style='border-collapse:collapse;'>\r\n <tr>");
				out.println("<tr>\r\n" + 
						"<td><b>Flight Id</b></td>\r\n" + 
						"<td><b>Flight Name</b></td>\r\n" + 
						"<td><b>Source</b></td>\r\n" + 
						"<td><b>Distination</b></td>\r\n" + 
						"<td><b>Distance(Km)</b></td>\r\n" + 
						"<td><b>Cost</b></td>\r\n" + 
						"<td><b>Seats Avilable</b></td>\r\n" + 
						"\r\n" + 
						"</tr>");
				if(i==1) {
				if(!resultSet.next()) {
				    System.out.println("No Data Found.");
				} else {
					resultSet.previous();
				
				while(resultSet.next()){
					out.println("<br>");
					
					
					
					
					
					out.println("<tr>");
					out.println("<td>"+resultSet.getString("id")+"</td>");
					out.println("<td>"+resultSet.getString("name")+"</td>");
					
					out.println("<td>"+resultSet.getString("src")+"</td>");
					out.println("<td>"+resultSet.getString("dis")+"</td>");
					out.println("<td>"+resultSet.getString("distance")+"</td>");
				    out.println("<td>"+resultSet.getString("cost")+"</td>");
				   out.println("<td>"+resultSet.getString("seats")+"</td>");
				   
					out.println("</tr>");
				} }
				}
				else {
					out.println("Zero");
				}
				}
				catch (Exception e) {
					e.printStackTrace();
					}
					

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
