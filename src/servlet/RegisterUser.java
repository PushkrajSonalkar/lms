package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;

@WebServlet("/RegiUser")
public class RegisterUser extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String user = req.getParameter("uname");
		int id=1;
		String email= req.getParameter("email");
		String psw = req.getParameter("psw");
		String cpsw = req.getParameter("cpsw");
		if(cpsw.equals(psw)) 
		{
			RegisterUser.Save(user, email, psw);
		}
		else {
			resp.sendRedirect("RegisterUser.jsp");
			
		}
		
	}
	public static void Save(String u, String e,String p) 
	{
		try
		{
			Connection con = DB.getCon();
			
			PreparedStatement ps = con.prepareStatement("insert into book_user where email=? and password=?");
			ps.setString(1, e);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
			}
			con.close();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
