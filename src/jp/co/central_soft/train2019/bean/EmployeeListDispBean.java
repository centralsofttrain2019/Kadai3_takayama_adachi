package jp.co.central_soft.train2019.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListDispBean {

	private List<EmployeeDispBean> eList = new ArrayList<>();

//	public List<EmployeeDispBean> geteList() {
//		return eList;
//	}
//
//	public void seteList(List<EmployeeDispBean> eList) {
//		this.eList = eList;
//	}

	public int size() {
		return eList.size();
	}

	public EmployeeDispBean get(int index) {
		return eList.get(index);
	}

	public void add(EmployeeDispBean emp) {
		// TODO 自動生成されたメソッド・スタブ
		this.eList.add(emp);
	}



}
