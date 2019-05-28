package jp.co.central_soft.train2019.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.IdInputBean;
import jp.co.central_soft.train2019.service.EmployeeService;

@WebServlet("/IdInputServlet")
public class IdInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IdInputServletが実行されました。");

		String eidStr = request.getParameter("eid");
		if(eidStr.matches("^[0-9]*$")) {
			int eid = Integer.parseInt(eidStr);
			EmployeeService empServ = new EmployeeService();
			EmployeeDispBean edBean = empServ.findByKey(eid);
			IdInputBean bean = new IdInputBean(LocalDate.now(), edBean);
			bean.setMessage("");
			request.getSession().setAttribute("LoginInfo", bean);
			request.setAttribute("bean",bean);
			RequestDispatcher disp = request.getRequestDispatcher("/idInput.jsp");
			disp.forward(request, response);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("/loginError.jsp");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
