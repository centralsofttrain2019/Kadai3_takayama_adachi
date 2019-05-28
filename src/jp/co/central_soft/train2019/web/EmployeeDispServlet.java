package jp.co.central_soft.train2019.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.IdInputBean;
import jp.co.central_soft.train2019.service.EmployeeService;

@WebServlet("/EmployeeDispServlet")
public class EmployeeDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EmployeeDispServletが実行されました。");

		String eidStr = request.getParameter("eid");
		if(eidStr.matches("^[0-9]*$")) {
			int eid = Integer.parseInt(eidStr);
			EmployeeService empServ = new EmployeeService();
			EmployeeDispBean bean = empServ.findByKey(eid);

			HttpSession ss = request.getSession();
			IdInputBean iib = (IdInputBean) ss.getAttribute("LoginInfo");
			iib.setMessage(bean.getMessage());
			request.setAttribute("bean",bean);
			request.setAttribute("bean_ss", iib);
			RequestDispatcher disp = request.getRequestDispatcher("/employeeDisp.jsp");
			disp.forward(request, response);
		}
		else {
			HttpSession ss = request.getSession();
			IdInputBean bean = (IdInputBean) ss.getAttribute("LoginInfo");
			bean.setMessage("idは数字を入力してください");
			request.setAttribute("bean",bean);
			RequestDispatcher disp = request.getRequestDispatcher("/idInput.jsp");
			disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
