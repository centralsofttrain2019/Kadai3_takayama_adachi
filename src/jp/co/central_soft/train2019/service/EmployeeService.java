package jp.co.central_soft.train2019.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.EmployeeListDispBean;
import jp.co.central_soft.train2019.dao.Dao;
import jp.co.central_soft.train2019.dao.EmployeeDao;

public class EmployeeService {

	public EmployeeDispBean findByKey(int eid) throws ServletException {
		EmployeeDispBean edp = null;
		try( Connection con = Dao.getConnection() ){
			EmployeeDao dao = new EmployeeDao(con);
			edp = dao.findByKey(eid);
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		return edp;
	}

	public EmployeeListDispBean findAll() throws ServletException {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeListDispBean edp = null;
		try( Connection con = Dao.getConnection() ){
			EmployeeDao dao = new EmployeeDao(con);
			edp = dao.findAll();
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		return edp;
	}

}
