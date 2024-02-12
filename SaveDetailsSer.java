package myProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveDetailsSer")
public class SaveDetailsSer extends HttpServlet 
{
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		
		AddEmpDetails e=new AddEmpDetails();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setAddress(address);
		e.setCity(city);
		e.setCountry(country);
		
		int status=SaveDetails.save(e);
		if(status>0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Record saved successfully");
			rd.forward(request, response);
		}
			else
			{
				pw.println("Record not saved");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
		    }
	}

}
