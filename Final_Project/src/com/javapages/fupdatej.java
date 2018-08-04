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
 * Servlet implementation class fupdatej
 */
@WebServlet("/fupdatej")
public class fupdatej extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fupdatej() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<link rel='stylesheet'"
				+ " href='search.css'>"
				+ "</head>");
		out.println("<body>");
		
		String oname=request.getParameter("t1");
		String nname=request.getParameter("t11");
		String otime=request.getParameter("t2");
		String ntime=request.getParameter("t22");
		String odate=request.getParameter("t3");
		String ndate=request.getParameter("t33");
		
		//String cost=request.getParameter("t5");
		
		
		
		
		//System.out.println(cgpa);
		int i=0;
		
		
		out.println("<div class=\"d1\">\r\n" + 
				"\r\n" + 
				"  <ul>\r\n" + 
				"    <li><a class=\"active\" href=\"fMainpage.html\">Home</a></li>\r\n" + 
				"    <li><a href=\"finsert.html\">Insert</a></li>\r\n" + 
				"    <li><a href=\"fMainpage.html\">Delete</a></li>\r\n" + 
				"    <li><a href=\"fsearch.html\">Serach</a></li>\r\n" + 
				"    <li><a href=\"fupdate.html\">Update</a></li>\r\n" + 
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
				if(oname!=null) {
					i=1;
					String sql ="UPDATE record SET name='"+nname+"' where name='"+oname+"'";
					statement.executeUpdate(sql);	
				}
				else if(otime!=null) {
					i=1;
					out.println("Not empty");
					String sql ="UPDATE record SET id='"+ntime+"' where id='"+otime+"'";
					statement.executeUpdate(sql);
					
				}
				else if(odate!=null) {
					i=1;
					out.println("Not empty");
					String sql ="UPDATE record SET date='"+ndate+"' where name='"+odate+"'";
					statement.executeUpdate(sql);
				}
					 else {
						 out.println("No record ");
					 }
				
						
			
				
			
				}
				catch (Exception e) {
					e.printStackTrace();
					}
					
    	

			out.println("<center><div style='color:Blue; font-size:30px;padding-top:100px;'><b>Record Succesfully Updated</b></div></center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
