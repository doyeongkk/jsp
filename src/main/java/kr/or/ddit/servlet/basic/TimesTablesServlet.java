package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xml.internal.security.Init;

public class TimesTablesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset:utf-8");

		PrintWriter pw = resp.getWriter(); 
		pw.println("<html>"); 
		pw.println("   <head>");
		pw.println("      <title>Time Servlet</title>");
		pw.println("   </head>");
		pw.println("   <body> ");
		pw.println("<table border=1>");

		for (int i = 1; i <= 9; i++) {
			pw.print("<tr>");
			for (int j = 2; j <= 9; j++) {
				pw.println("<td>" + j + "*" + i + "=" + i * j + ("</td>"));
			}

			pw.println("</tr>");
		}

		pw.println("   </body>");
		pw.println("</html>");

		pw.flush();
		pw.close();
	}
		
	

}