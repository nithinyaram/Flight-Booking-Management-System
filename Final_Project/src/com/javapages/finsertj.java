package com.javapages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.DriverManager;
/**
 * Servlet implementation class finsertj
 */
@WebServlet("/finsertj")
public class finsertj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finsertj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String id=request.getParameter("p1");
		String name=request.getParameter("p2");
		String src=request.getParameter("p3");
		String dis=request.getParameter("p4");
		String distance=request.getParameter("p5");
		String cost=request.getParameter("p6");
		String seats=request.getParameter("p7");
		
		
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

					String sql ="INSERT INTO record(id,name,src,dis,distance,cost,seats) "
							+ "values('"+id+"','"+name+"','"+src+"','"+dis+"','"+distance+"','"+cost+"','"+seats+"')";
					
					statement.executeUpdate(sql);
					
					 

					
			}
			catch (Exception e) {
				e.printStackTrace();
				}
			out.println("Record Successfully Inserted");
			response.sendRedirect("finsert.html");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
