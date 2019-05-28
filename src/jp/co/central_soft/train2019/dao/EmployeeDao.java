package jp.co.central_soft.train2019.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.EmployeeListDispBean;

public class EmployeeDao {

	private static final String SELECT_SQL =
			"SELECT * FROM employees WHERE EmployeeID = ?";

	private static final String SELECT_ALL_SQL =
			"SELECT * FROM employees ";

	private Connection con;

	public EmployeeDao(Connection con)
	{
		super();
		this.con = con;
	}

	public EmployeeDispBean findByKey(int id) throws SQLException
	{
		EmployeeDispBean emp = new EmployeeDispBean();

		PreparedStatement stmt = con.prepareStatement(SELECT_SQL);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		try
		{
			if(rs.next()) {
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setEmployeeName(rs.getString("EmployeeName"));
				emp.setHeight(rs.getBigDecimal("Height"));
				emp.setEmail(rs.getString("Email"));
				emp.setWeight(rs.getBigDecimal("Weight"));
				emp.setHireFiscalYear(rs.getInt("HireFiscalYear"));
				emp.setBirthday(rs.getDate("Birthday").toLocalDate());
				emp.setBloodType(rs.getString("BloodType"));
			} else {
				emp.setMessage("お探しの従業員は見つかりませんでした。");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			if(rs!=null)
				rs.close();
		}
		return emp;
	}

	public EmployeeListDispBean findAll() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeListDispBean eList = new EmployeeListDispBean();
		//List<EmployeeDispBean> emp = new ArrayList<EmployeeDispBean>();

		PreparedStatement stmt = con.prepareStatement(SELECT_ALL_SQL);
		//stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next()) {
				EmployeeDispBean emp = new EmployeeDispBean();
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setEmployeeName(rs.getString("EmployeeName"));
				emp.setHeight(rs.getBigDecimal("Height"));
				emp.setEmail(rs.getString("Email"));
				emp.setWeight(rs.getBigDecimal("Weight"));
				emp.setHireFiscalYear(rs.getInt("HireFiscalYear"));
				emp.setBirthday(rs.getDate("Birthday").toLocalDate());
				emp.setBloodType(rs.getString("BloodType"));
				eList.add(emp);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			if(rs!=null)
				rs.close();
		}
		return eList;
	}
}
