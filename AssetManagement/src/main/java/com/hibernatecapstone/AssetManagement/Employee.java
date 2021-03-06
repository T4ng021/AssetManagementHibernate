package com.hibernatecapstone.AssetManagement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_table")
public class Employee {

	
	private String empName;
	@Id
	private int empId;
	private String password;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "assertId", unique = true)
	private Assets asset;
	
	public Employee( int empId,String empName,String password,Assets asset) {
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.asset = asset;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Assets getAsset() {
		return asset;
	}
	public void setAsset(Assets asset) {
		this.asset = asset;
	}
	
	
	
	
}
