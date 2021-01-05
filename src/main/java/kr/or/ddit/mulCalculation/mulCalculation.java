package kr.or.ddit.mulCalculation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(mulCalculation.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/mul.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mulParameter = Integer.parseInt(req.getParameter("start"));
		int mulParameter2 = Integer.parseInt(req.getParameter("end"));
	
		int result = mulParameter * mulParameter2;
		
		logger.debug("{}",result);
		

			HttpSession session = req.getSession();
		    session.setAttribute("session", result);
			
		    req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
		
		
		
	
	}
	
	
	
}
