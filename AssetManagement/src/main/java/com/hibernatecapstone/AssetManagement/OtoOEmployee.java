package com.hibernatecapstone.AssetManagement;

public interface OtoOEmployee {

	public void addNewEmployeeWithAsset(Employee emp, Assets ast);
	public void getAssetDetails(int asset_id);
	public void updateEmployeePassword(String new_password,int employee_id);
	public void deleteEmployeeAsset(int employee_id);
}
