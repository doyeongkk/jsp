package kr.or.ddit.servlet.sumCalculation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/sum.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sumParameter = Integer.parseInt(req.getParameter("start"));
		int sumParameter2 = Integer.parseInt(req.getParameter("end"));

		int result = 0;

		for (int i = sumParameter; i <= sumParameter2; i++) {
			result += i;
		}
		
		logger.debug("{}",result);

		HttpSession session = req.getSession();
		session.setAttribute("session", result);

		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);
	}
}





