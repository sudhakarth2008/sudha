//import MercuryDemoTours;

package Orange_Pim;
import org.testng.annotations.Test;

import html.OR.*;
import html.TestHTMLReporter5;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.*;

import org.apache.commons.io.FileUtils;
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


 
public class AddEmployees
{
	public String UserName,Password;
	public String FirstName,MiddleName,LastName,
	EmployeeId,CreateLogincheckbox,UserName1,Password1,ConfirmPassword,Status;
	
	WebDriver driver;
	TestHTMLReporter5 TH3 = new TestHTMLReporter5();	
	String HtmlOutputFileName;
	String error;

	
	
	public  int iRow;
	public  void AddEmployees( WebDriver driver	)throws Exception
	{
		this.driver=driver;
	}
	
	@Test
	public  void DatadrivenTest_AddEmployess( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC01.xls","Sheet1");

				 for(int i=1;i<3;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
					 FirstName=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,2);
					 MiddleName=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,3);
					 LastName=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,4);
					EmployeeId=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,5);
					//CreateLogincheckbox=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,6);
					UserName1=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,6);
					Password1=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,7);
					ConfirmPassword=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,8);
					Status=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,9 );
						
						
					 iRow=i;
					// call_allmethods(iRow);
				 }
				 
				 
	}
	
	
	public  void PIM_MenuBar( )throws Exception
	{  
		driver.findElement(By.xpath(OR.Home_MainMenu_PIM_click)).click();
	}
	
	
	
	public  void AddEmployees1( String FirstName,String MiddleName,String LastName,String EmployeeId,String CreateLoginDetailscheckbox,String UserName1,
			String Password1,String ConfirmPassword,String Status)throws Exception
	{  
		 // try {
			  
			 // HtmlOutputFileName= TH3.CretaeHTMLFile("TC05 Orange HRM addemp","Chrome");
		driver.findElement(By.xpath(OR.PIM_Addemployee_click)).click();
	
		
		driver.findElement(By.xpath(OR.firstname_sendkeys)).sendKeys(FirstName);
		System.out.println("firstname is"+FirstName);
		
		driver.findElement(By.xpath(OR.middlename_sendkeys)).sendKeys(MiddleName);
		System.out.println("middlename is"+MiddleName);

		driver.findElement(By.xpath(OR.lastname_sendkeys)).sendKeys(LastName);
		System.out.println("lastname is"+LastName);
		
		driver.findElement(By.xpath(OR.EmployeeId_defaultno)).clear();
		driver.findElement(By.xpath(OR.EmployeeId_defaultno)).sendKeys(EmployeeId);
		
		driver.findElement(By.xpath(OR.CreateLoginDetails_checkbox)).click();
		driver.findElement(By.xpath(OR.UserName_sendkeys)).sendKeys(UserName1);
		driver.findElement(By.xpath(OR.Password_sendkeys)).sendKeys(Password1);
		driver.findElement(By.xpath(OR.ConfirmPassword_sendkeys)).sendKeys(ConfirmPassword);
		
		Select listbox =new Select(driver.
			 	findElement(By.xpath(OR.Status_listbox)));
			 	
			 	listbox.selectByVisibleText(Status);
			 	
		driver.findElement(By.xpath(OR.save)).click();
		

		  
//	} catch (NoSuchElementException e) {
		
		
		
		
		//TH3.HTMLScreenShot("Login Failed ","	Invalid Credentials  ","Fail", HtmlOutputFileName,driver);
			  
			// error=  e.getMessage();
			//TH3.HTMLScreenShot(error,error,"Fail", HtmlOutputFileName,driver);
		
			
		    	
	// }
		  
	  
		  
		
	}
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		driver=TestBrowser.OpenChromeBrowser();
		HtmlOutputFileName= TH3.CretaeHTMLFile("TC05 Orange HRM addemp","Chrome");
		
		Login l1=new Login();
		l1.Login(driver);
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		 TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		// 
		l1.OrangeHRMSigninClick();
		 TH3.HTMLScreenShot("click sign in button","navigated  to homepage Successfully ","Pass", HtmlOutputFileName,driver);
	  
		 
		 
		 WebElement ele= driver.findElement(By.xpath(OR.Home_MainMenu_PIM_click));
		  
			if(ele.isDisplayed())
			{
				
				
				TH3.HTMLScreenShot("Login Success ","	Navigated to  Orange pim Page  ","Pass", HtmlOutputFileName,driver);
			}
			else
			{
				
				TH3.HTMLScreenShot("Login Failed ","	Invalid Credentials  ","Fail", HtmlOutputFileName,driver);
			
			}

		//TH3.HTMLCloser(HtmlOutputFileName); 
		
		AddEmployees Ae=new AddEmployees();
			Ae.AddEmployees(driver);
			Ae.PIM_MenuBar();
			Ae.AddEmployees1(FirstName,MiddleName,LastName,
					EmployeeId,CreateLogincheckbox,UserName1,Password1,ConfirmPassword,Status);
		    
			/*employeedetails1 ed=new employeedetails1();
			 ed.employeedetails(driver);
			ed.employeedetails(FirstName,MiddleName,LastName,
			EmployeeId,CreateLogincheckbox,UserName1,Password1,ConfirmPassword,Status);*/
			
			PimEmployeeList pim = new PimEmployeeList();
			pim.PimEmployeeList(driver);
			
			//EmployeeId
			
			
			// Employee List Search By ID
			System.out.println(" ");
			System.out.println("___________Starts_________________");	
			Boolean str=false;
			str=pim.Search_EmployeeExist_in_EmployeeList(iRow, EmployeeId);
			if(str==true)
			System.out.println("YES-Employee ID is present in Employee List");
			else
			System.out.println("No-Employee ID is not present in Employee List");	
			System.out.println("__________Ends__________________");	
			
			
			pim.Export_Employeelist();
			
			driver.quit();
			
			
	}
	
	
}
