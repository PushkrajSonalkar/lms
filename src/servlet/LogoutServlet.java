package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("index.jsp").include(request, response);  
          
        HttpSession session=request.getSession();  
        session.invalidate();  
          
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Logout Successful');");
        out.println("location='index.jsp';");
        out.println("</script>");  
          
        out.close();  
	}
}
