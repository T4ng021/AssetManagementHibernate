package com.hibernatecapstone.AssetManagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO implements OtoOEmployee{

	SessionFactory sessionFactory;
	
	public void addNewEmployeeWithAsset(Employee emp, Assets ast) {
		
		emp.setAsset(ast);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		tx.commit();
		session.close();
	}
	
	public void getAssetDetails(int asset_id) {
			
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Assets asset = (Assets) session.get(Assets.class,asset_id);
		
		System.out.println("\n Asset Id : "+asset.getAssetId() +
				            "\n Asset Price : " + asset.getAssetPrice() +
				            "\n Asset Type : " + asset.getAssetType() +
				            "\n Pr No : " + asset.getPrNo() +
				            "\n Serial No : " + asset.getSerialNo()
				          );
		
		tx.commit();
		session.close();
		
	}
	
	public void updateEmployeePassword(String new_password,int employee_id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp = (Employee) session.get(Employee.class, employee_id);
		
		emp.setPassword(new_password);
		
		session.update(emp);
		
		tx.commit();
		session.close();
	}
	
	public void deleteEmployeeAsset(int employee_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp = (Employee) session.get(Employee.class, employee_id);
		session.delete(emp);
		
		tx.commit();
		session.close();
	}
}
