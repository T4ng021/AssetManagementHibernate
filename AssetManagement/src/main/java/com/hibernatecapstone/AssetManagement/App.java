package com.hibernatecapstone.AssetManagement;

import java.util.Scanner;

public class App 
{

	public static void main( String[] args )
    {  	
        
    	String ans,new_password,eName ="";
    	String pass ="",assetType = "", assetLocation = "";
    	int choice = 0, empId = 0, assetId = 0;
        int assetPrice = 0, serialNo = 0, prNo = 0;
    	Scanner sc = new Scanner(System.in);
    	EmployeeDAO empdao = new EmployeeDAO();
    	Assets ast = new Assets(assetId, serialNo, prNo, assetType, assetPrice, assetLocation);
    	Employee emp = new Employee(  empId, eName, pass, ast);
    	
    	do {
    		System.out.println("Please select from the below menu ");
    		System.out.println("1. Add New Employee with Asset ");
    		System.out.println("2. Get Asset Details ");
    		System.out.println("3. Update Employee Password ");
    		System.out.println("4. Delete Employee with Asset ");
    		System.out.println("5. Get Asset Details with Max Price ");
    		System.out.println("6. Count of Employees ");
    		System.out.println("7. Display Employee with Asset ");
    		System.out.println("8. Display Employees in Descending Order ");
    		System.out.println("9. Get Averge Price of Asset per Location ");
    		
    		System.out.println("\nPlease enter your choice here : ");
    		choice = sc.nextInt();
    		
    		switch(choice) {
    			
    			case 1: System.out.println("Enter the Employee Id : ");
    					empId = sc.nextInt();
    					System.out.println("Enter the Employee Name : ");
    					eName = sc.next();
    					System.out.println("Enter the Password : ");
    					pass = sc.next();
    					System.out.println("Enter the Asset Id : ");
    					assetId = sc.nextInt();
    					System.out.println("Enter the Serial No : ");
    					serialNo = sc.nextInt();
    					System.out.println("Enter the Pr No : ");
    					prNo = sc.nextInt();
    					System.out.println("Enter the Asset Type : ");
    					assetType = sc.next();
    					System.out.println("Enter the Asset Price : ");
    					assetPrice = sc.nextInt();
    					System.out.println("Enter the Asset Location : ");
    					assetLocation = sc.next();
    					empdao.addNewEmployeeWithAsset(emp,ast);
    					break;
    					
    			case 2: System.out.println("Enter the Asset Id of the Asset to be displayed : ");
    					assetId = sc.nextInt();
    					empdao.getAssetDetails(assetId);
    					break;
    					
    			case 3: System.out.println("Enter the Employee Id of the Employee for which password is to be updated : ");
						empId = sc.nextInt();
						System.out.println("Enter the new password to be updated to : ");
						new_password = sc.next();
    					empdao.updateEmployeePassword(new_password,empId);
    					break;
    					
    			case 4: System.out.println("Enter the Employee Id of the Employee to be deleted : ");
    					empId = sc.nextInt();
    					empdao.deleteEmployeeAsset(empId);
    					break;
    					
    			case 5: empdao.getAssetWithMaxPrice();
    					break;
    					
    			case 6: empdao.getCountOfEmployee();
    					break;
    					
    			case 7: System.out.println("Enter the Employee Id of the Employee to be displayed: ");
    					empId = sc.nextInt();
    					empdao.getEmployeeAssetDetails(empId);
    					break;
    					
    			case 8: empdao.getEmployeeInDescOrder();
    					break;
    					
    			case 9: empdao.getAvgPricePerLocationUsingNamedQuery();
    					break;
    		}
    		
    		System.out.println("\nDo you want to continue? Press y to continue OR Press any other key to Exit");
    		ans = sc.next();
    		
    	}while("y".equalsIgnoreCase(ans));
    	
    	sc.close();  
    }//main
}//class
