package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
    
	//doXXX �޼ҵ��� ����: req, res 
	// GET, POST, DELETE, PUSH, HEAD : HTTP �޼ҵ�
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������
		PrintWriter pw = resp.getWriter();
		pw.println("Hello, World");
		
		pw.flush();  // ���̻� �ۼ��� ������ �����Ƿ� �۾��� ������ �Ѵ�. 
		pw.close();  // ����� �ڿ� �ݳ� 
		
	}
     
   
	
	
}
