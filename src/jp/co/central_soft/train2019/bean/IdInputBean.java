package jp.co.central_soft.train2019.bean;

import java.time.LocalDate;

public class IdInputBean {

	private LocalDate ld;
	private EmployeeDispBean edBean;
	private String message;

	public IdInputBean() {}

	public IdInputBean(LocalDate ld, EmployeeDispBean edBean) {
		super();
		this.ld = ld;
		this.edBean = edBean;
		this.message = "";
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) {
		this.ld = ld;
	}

	public EmployeeDispBean getEdBean() {
		return edBean;
	}

	public void setEdBean(EmployeeDispBean edBean) {
		this.edBean = edBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getEmployeeId() {
		return this.edBean.getEmployeeID();
	}

	public String getEmployeeName() {
		return this.edBean.getEmployeeName();
	}
}
