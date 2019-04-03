//import MercuryDemoTours;

package Orange_Pim;
import org.testng.annotations.Test;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Timestamp;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.*;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;


 
public class PimEmployeeList
{
	public String UserName,Password;
	
	public String EmployeeId,EmployeeName;
	
	
	
	
	public  int iRow;
	WebDriver driver;
	
	public  void PimEmployeeList(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	

	public  void PIM_MenuBar( )throws Exception
	{  
		driver.findElement(By.xpath(OR.Home_MainMenu_PIM_click)).click();
	}
	
	
	@Test
	public  void DatadrivenTest_AddEmployess( )throws Exception
	{  
		
		  	  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://BOOLEAN//TC02_empnameid.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
			         UserName=eat.getCellData("E://BOOLEAN//TC02_empnameid.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://BOOLEAN//TC02_empnameid.xls","Sheet1",i,1);
					 
					 System.out.println("User Name is :"+UserName);
	
					 EmployeeId=eat.getCellData("E://BOOLEAN//TC02_empnameid.xls","Sheet1",i,2);
					 EmployeeName =eat.getCellData("E://BOOLEAN//TC02_empnameid.xls","Sheet1",i,3);
				
					 iRow=i;
					call_allmethods(iRow);
				 }
				 
				 
	}
	

	public void call_allmethods(int iRow )throws Exception
	{  
		
		driver=TestBrowser.OpenChromeBrowser();
		
		Login l1=new Login();
		l1.Login(driver);
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		l1.OrangeHRMSigninClick();
		
		PimEmployeeList e1=new PimEmployeeList();
		e1.PimEmployeeList(driver);
		e1.PIM_MenuBar();  

		//int a=10;
		//String str="Raju sfsdssdf";
	
		
		// Employee List Search By ID
		System.out.println(" ");
		System.out.println("___________Starts_________________");	
		Boolean str=false;
		str=e1.Search_EmployeeExist_in_EmployeeList(iRow,EmployeeId);
		if(str==true)
		System.out.println("YES-Employee ID is present in Employee List");
		else
		System.out.println("No-Employee ID is not present in Employee List");	
		System.out.println("__________Ends__________________");	
		
		
			
		// Employee List Search By Name
		System.out.println(" ");
		System.out.println("___________Starts_________________");	
		Boolean str1=false;
		str1=e1.Search_EmployeeExist_in_EmployeeList_ByName(iRow,EmployeeName);
		if(str1==true)
			System.out.println("YES-Employee Name is present in Employee List");
		else
			System.out.println("No-Employee Name is not present in Employee List");
		System.out.println("__________Ends__________________");	
		
		
		
		// New method starts
		System.out.println(" ");
		System.out.println("___________Starts_________________");
		System.out.println("****Export EmployeeList method starts here****");	
		e1.Export_Employeelist();
		System.out.println("___________Ends_________________");
		
		
	driver.quit();
		
	}
	
	
	
	// starts method for  Search EmployeeList by ID 
	public  Boolean Search_EmployeeExist_in_EmployeeList(int iRow,String EmployeeId)throws Exception
	{ 
		
		
		System.out.println("Employee ID is : "+ EmployeeId);
		
		Boolean Record_Present=false;
		
		
		
		driver.findElement(By.xpath(OR.Employeelist_click)).click();
		
		driver.findElement(By.xpath(OR.SearchButton_click)).click();
		
        //No. of columns
        List  columns = driver.findElements(By.xpath(OR.EmployeeList_Numberof_Columns)); 
        System.out.println("No of columns are : " + columns.size());
        
        //No.of rows 
        List  rows = driver.findElements(By.xpath(OR.EmployeeList_Numberof_Rows)); 
        System.out.println("No of rows are : " + rows.size());
        
				    for ( int i=1 ; i<=rows.size() ;i++)
				    {
				      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 2 +"]";
				      	
				      //*[@id="resultTable"]/tbody/tr[1]/td[2]
				      	
				      //*[@id="resultTable234"]/tbody/tr[1]/td[4]
				      	
				    
				        WebElement CellText1=driver.findElement(By.xpath(str1));
				    		   
				    	String valueIneed1 = CellText1.getText();
				       
				        
					    	if (EmployeeId.equals(valueIneed1) )
					    	{
					    	    	 Record_Present=true;
					    	    	 System.out.println("True- EmployeeID Text Value is: " + valueIneed1);
					    	    	 return Record_Present;
					    	    	 //Employee ID exist in employee list
					    	}
					    	else
					    	{
					    		 System.out.println("Cell Text Value is:" + valueIneed1);
							     System.out.println("Seracching for Employee ID is:" +EmployeeId);
					    	}
					    	
					  					    	
				    }  //After for loop
				    
				    System.out.println("*******Employee Serach method completed*****");
   
		return Record_Present;

	}
// Ends method for  Search EmployeeList by ID 
	
	
	
	
	// starts method for  Search EmployeeList by ID 
		public  Boolean Search_EmployeeExist_in_EmployeeList_ByName(int iRow,String EmployeeName)throws Exception
		{ 
			
			Boolean Record_Present=false;
			
			
			
			driver.findElement(By.xpath(OR.Employeelist_click)).click();
			
			Thread.sleep(6000);
			driver.findElement(By.xpath(OR.EmployeeName_sendkeys)).sendKeys(EmployeeName);
			Thread.sleep(7000);
			//System.out.println("Employeename is"+EmployeeName);
			
	
			driver.findElement(By.xpath(OR.SearchButton_click)).click();
			
	        List  columns = driver.findElements(By.xpath(OR.EmployeeList_Numberof_Columns)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	  
	        List  rows = driver.findElements(By.xpath(OR.EmployeeList_Numberof_Rows)); 
	        System.out.println("No of rows are : " + rows.size());
	        
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					      	String str3="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 3 +"]";
					      	String str4="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 4 +"]";
					       
					      //*[@id="resultTable"]/tbody/tr[1]/td[3]
					      	
					      	WebElement CellText3=driver.findElement(By.xpath(str3));
					      	WebElement CellText4=driver.findElement(By.xpath(str4));
					      	
					    	String valueIneed1 = CellText3.getText() + " " + CellText4.getText();
					    	System.out.println("Web Table Employee Name is ....."+valueIneed1);
					       
					        
						    	if (EmployeeName.equals(valueIneed1) )
						    	{
						    	    	 Record_Present=true;
						    	    	 System.out.println("True- EmployeeName Exist & Text Value is: " + valueIneed1);
						    	    	 return Record_Present;
						    	    	
						    	}
						    	else
						    	{
						    		 System.out.println("Cell Text Value is:" + valueIneed1);
								     System.out.println("Else - Searching for Employee Name is:" +EmployeeName);
						    	}
						    	
						  					    	
					    }  //After for loop
					    
					    System.out.println("*******Employee Serach method completed*****");
	   
			return Record_Present;
			

		}
	// Ends method for  Search EmployeeList by ID 
		
	
	
	
	
	
	
	
	public  void Export_Employeelist()throws Exception
	{ 
		
		
		driver.findElement(By.xpath(OR.Employeelist_click)).click();
		
		driver.findElement(By.xpath(OR.SearchButton_click)).click();
		
        //No. of columns
        List  columns = driver.findElements(By.xpath(OR.EmployeeList_Numberof_Columns)); 
        //System.out.println("No of columns are : " + columns.size());
        
        //No.of rows 
        List  rows = driver.findElements(By.xpath(OR.EmployeeList_Numberof_Rows)); 
       // System.out.println("No of rows are : " + rows.size());
        
       
      
        			ExcelApiTest3 eat = new ExcelApiTest3();
         
				    for ( int i=1 ; i<=rows.size() ;i++)
				    {
				    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
				    	   {
				      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
				      		   
				      		//*[@id="resultTable"]/tbody/tr[1]/td[2]
				    		    WebElement CellText1=driver.findElement(By.xpath(str1));
				    		   
				    	        String valueIneed1 = CellText1.getText();
				    	      //  System.out.println("Cell Text Value is: " + valueIneed1);
				    	        
				    	        if (valueIneed1 !=null)
				    	        eat.PutCellData( "E://BOOLEAN//TC02_empnameid.xls","Sheet5",i,k,valueIneed1);
				    	        else
				    	        eat.PutCellData( "E://BOOLEAN//TC02_empnameid.xls","Sheet5",i,k,"Blank Data");
				    	        	
				    	   }
				    }
   
	
				    /*   
			        Don't Delete the below comment code - I have to explain below Logic 
			        
			        WebElement CellText=driver.findElement(By.xpath(" //*[@id='resultTable']/tbody/tr[1]/td[8]"));
			        String valueIneed = CellText.getText();
			        System.out.println("Cell Text Value is: " + valueIneed);         
			      	String str="//*[@id='resultTable']/tbody/tr[1]/td[8]";
			      	String str1="//*[@id='resultTable']/tbody/tr["  +1+  "]"  + "/td" + "[" + 8 +"]"; 
			        */
	}
        
	
	
	
	}
	
	
	
	
	
		
	





















		
		/*PimEmployeeList Ae=new PimEmployeeList();
			Ae.AddEmployees(driver);
			Ae.PIM_MenuBar();
			Ae.AddEmployees(FirstName,MiddleName,LastName,
					EmployeeId,CreateLogincheckbox,UserName1,Password1,ConfirmPassword,Status);
		    
			employeedetails1 ed=new employeedetails1();
			 ed.employeedetails(driver);
			ed.employeedetails(FirstName,MiddleName,LastName,
			EmployeeId,CreateLogincheckbox,UserName1,Password1,ConfirmPassword,Status);*/
		
		
	
	
//driver.findElement(By.xpath(OR.EmployeeName_sendkeys)).click();

		//Thread.sleep(8000);
		
		
		//driver.findElement(By.xpath(OR.EmployeID_Serach_sendkeys)).sendKeys(EmployeeID1);
		
		//Thread.sleep(8000);
		
	//	driver.findElement(By.xpath(OR.EmployeeName_sendkeys)).sendKeys(EmployeeName);
		//System.out.println("Employeename is"+EmployeeName);
		
		
	//	Thread.sleep(8000);
		

