package jp.co.central_soft.train2019.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.central_soft.train2019.bean.EmployeeListDispBean;
import jp.co.central_soft.train2019.bean.IdInputBean;
import jp.co.central_soft.train2019.service.EmployeeService;

@WebServlet("/EmployeeListDispServlet")
public class EmployeeListDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		EmployeeService empServ = new EmployeeService();
		EmployeeListDispBean bean = empServ.findAll();

		//request.getSession().setAttribute("info", bean);
		HttpSession ss = request.getSession();
		IdInputBean iib = (IdInputBean) ss.getAttribute("LoginInfo");
		request.setAttribute("bean",bean);
		request.setAttribute("bean_ss", iib);
		RequestDispatcher disp = request.getRequestDispatcher("/employeeListDisp.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
