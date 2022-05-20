package com.hibernatecapstone.AssetManagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {  	
        /*Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        /*StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
        									applySettings(cfg.getProperties()).
        									build();
        
        SessionFactory factory = cfg.buildSessionFactory();*/
        
       /* Employee emp = new Employee();
    	
    	emp.setEmpId(102);
    	emp.setEmpName("Raj");
    	emp.setPassword("123#");
        
        Assets ast = new Assets();
    	
    	ast.setAssetId(103);
    	ast.setSerialNo(20);
    	ast.setPrNo(10);
    	ast.setAssetType("General");
    	ast.setAssetPrice(100);
    	ast.setAssetLocation("Nashik");*/
        
        EmployeeDAO empdao = new EmployeeDAO();
        
        //empdao.addNewEmployeeWithAsset(emp, ast);
    	
    	//empdao.getAssetDetails(103);
        
        //empdao.updateEmployeePassword("456$",102);
        
        //empdao.deleteEmployeeAsset(102);
    }
}

