package com.ngo.server.pojos;

import java.io.Serializable;

public class Emp implements Serializable {
	
	private int id;
	private String empName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
