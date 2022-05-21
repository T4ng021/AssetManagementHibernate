package com.hibernatecapstone.AssetManagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@SuppressWarnings({"deprecation","unchecked","rawtypes"})
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
	
	public void getAssetWithMaxPrice() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		String q = "select assetId,serialNo,prNo,assetType,max(assetPrice),assetLocation "
        		+ "from Assets a";
    	Query query = session.createQuery(q);
    	List<Object[]> lst = query.list();
    	
    	for(Object[] o : lst) {
    		System.out.println("Asset Id        : " + o[0]);
    		System.out.println("Asset Serial No : " + o[1]);
    		System.out.println("Asset Pr No     : " + o[2]);
    		System.out.println("Asset Type      : " + o[3]);
    		System.out.println("Asset Price     : " + o[4]);
    		System.out.println("Asset Location  : " + o[5]);
    	}
		
		tx.commit();
		session.close();
	}
	
	public void getCountOfEmployee() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		String q = "select count(*) from Employee e";
		Query query = session.createQuery(q);
		List lst = query.list();
		
		for(Object i : lst) {
			System.out.println(i);
		}
		
		tx.commit();
		session.close();
	}
	
	public void getEmployeeAssetDetails(int empId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp = (Employee) session.get(Employee.class,empId);
		
		System.out.println("\n Employee Id     : "+emp.getEmpId() +
				            "\n Employee Name  : " + emp.getEmpName() +
				            "\n Asset Id       : " + emp.getAsset().getAssetId() +
				            "\n Asset Location : " + emp.getAsset().getAssetLocation()
				          );
		
		tx.commit();
		session.close();
		
	}
	
	public void getEmployeeInDescOrder() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		String q = "from Employee e order by empId desc";
		 
		Query query = session.createQuery(q);
		List<Employee> empList = query.list();
		
		for(Employee e : empList ) {
			System.out.println("\nEmployee Id   : " + e.getEmpId());
			System.out.println("Employee Name : " + e.getEmpName());
		}
		
		tx.commit();
		session.close();
	}
	
	public void getAvgPricePerLocationUsingNamedQuery() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.getNamedQuery("Assets.getAvgPerLocation");
    	List<Object[]> oList = query.list();
    	
    	for(Object[] o : oList) {
    		System.out.println("\nAverage Price : " + o[0]);
    		System.out.println("Asset Location  : " + o[1]);
    	}
		
		tx.commit();
		session.close();
	}
}
