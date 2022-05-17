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
    	Assets ast = new Assets();
    	
    	ast.setAssetId(101);
    	ast.setSerialNo(20);
    	ast.setPrNo(10);
    	ast.setAssetType("General");
    	ast.setAssetPrice(100);
    	ast.setAssetLocation("Nashik");
    	
        Configuration cfg = new Configuration().configure().addAnnotatedClass(com.hibernatecapstone.AssetManagement.Assets.class);
        
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
        									applySettings(cfg.getProperties()).
        									build();
        
        SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(ast);
        
        tx.commit();
    }
}

