//import MercuryDemoTours;

package  EXPORT;
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
import java.text.SimpleDateFormat;

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
/*OPEN BROWSER
OPEN URL
LOGIN
pimempidsearch
pimempidexport

LOGOUT*/

public class pimempnamesearch
{
	
	
public String UserName,Password;
public String empid,empname;	
	
	public  int iRow;
	WebDriver driver;
	
	
		
	public  void pimempnamesearch(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	@Test
	public  void pim_searchby_name( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://BOOLEAN//TC02_pimempidsearch.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://BOOLEAN//TC02_pimempidsearch.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://BOOLEAN//TC02_pimempidsearch.xls","Sheet1",i,1);
					 empname=eat.getCellData("E://BOOLEAN//TC02_pimempidsearch.xls","Sheet1",i,3);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 
					 System.out.println(" empname is "+empname);
					 
						
					 iRow=i;
					 call_allmethods(iRow);
					 driver.quit();
					 
				 }
				 
	}
	
				 public   void call_allmethods(int iRow )throws Exception
					{  
						
						
						
						driver=TestBrowser.OpenChromeBrowser();
						
						//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						 
						Login l1=new Login();
						l1.Login(driver);
						l1.openOrangeHRM();
						l1.OrangeHRMlogin(UserName,Password);
						l1.OrangeHRMSigninClick();
						
						pimempnamesearch ps=new pimempnamesearch();
						ps.pimempnamesearch(driver);
						
						
						
						Boolean str1=false;
						str1=ps.namesearch(iRow,empname);
						if(str1==true)
						System.out.println("YES-PJT Search");
						else
						System.out.println("No-PJT Search");	
						System.out.println("__________Ends__________________");	
						
						
						
						
						
					
						// New method starts
						System.out.println(" ");
						System.out.println("___________Starts_________________");
						System.out.println("****Export VacancySearch method starts here****");	
					  ps.pimexport();
						System.out.println("___________Ends_________________");
						driver.quit();
								
						
	
					}
				 
				 
				 public Boolean namesearch(int iRow, String empname)throws Exception
				 {
					 
					 Boolean Record_Present=false;
					 
					 Actions actions1 = new Actions(driver);   
					 WebElement ele1=driver.findElement(By.xpath(OR.Pim_focus1));
					 actions1.moveToElement(ele1).click().perform();
					 
					 
					 
					 
					 driver.findElement(By.xpath(OR.emp_listclick)).click();
					 
					 driver.findElement(By.xpath(OR.emp_name)).clear();
					 
					 driver.findElement(By.xpath(OR.emp_name)).sendKeys(empname);
					 
					 driver.findElement(By.xpath(OR.emp_searchclick)).click();
					 
					 List  columns = driver.findElements(By.xpath(OR.empcoloumns)); 
				        System.out.println("No of columns are : " + columns.size());
				        
				        List  Rows = driver.findElements(By.xpath(OR.emprows)); 
				        System.out.println("No of Rows are : " + Rows.size());
				        
				        
				        for ( int i=1 ; i<=Rows.size() ;i++)
					    {
					      	String str3="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 3 +"]";
					      	String str4="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 4 +"]";
					       
					      //*[@id="resultTable"]/tbody/tr[1]/td[3]
					      	
					      	WebElement CellText3=driver.findElement(By.xpath(str3));
					      	WebElement CellText4=driver.findElement(By.xpath(str4));
					      	
					    	String valueIneed1 = CellText3.getText() + " " + CellText4.getText();
					    	System.out.println("Web Table Employee Name is ....."+valueIneed1);
					       
					        
						    	if (empname.equals(valueIneed1) )
						    	{
						    	    	 Record_Present=true;
						    	    	 System.out.println("True- EmployeeID Text Value is: " + valueIneed1);
						    	    	 return Record_Present;
						    	    	 //Employee ID exist in employee list
						    	}
						    	else
						    	{
						    		 System.out.println("Cell Text Value is:" + valueIneed1);
								     System.out.println("Seracching for Employee ID is:" +empid);
						    	}
						    	
						  					    	
					    }  //After for loop
					    
					    System.out.println("*******Employee Serach method completed*****");
	   
			return Record_Present;

		}
	// Ends method for  Search EmployeeList by ID 
		
		
		
				 
				 
				 
				 
				 			 
				 public void pimexport()throws Exception
				 {
					 Actions actions1 = new Actions(driver);   
					 WebElement ele1=driver.findElement(By.xpath(OR.Pim_focus1));
					 actions1.moveToElement(ele1).click().perform();
					 
					 
					 
					 
					 driver.findElement(By.xpath(OR.emp_listclick)).click();
					 
					 driver.findElement(By.xpath(OR.emp_name)).sendKeys("Linda");
					 
					 driver.findElement(By.xpath(OR.emp_searchclick)).click();
					 
					 List  columns = driver.findElements(By.xpath(OR.empcoloumns)); 
				        System.out.println("No of columns are : " + columns.size());
				        
				        List  Rows = driver.findElements(By.xpath(OR.emprows)); 
				        System.out.println("No of Rows are : " + Rows.size());
				        
				        
				    	ExcelApiTest3 eat = new ExcelApiTest3();
				         
	        		    for ( int i=1 ; i<=Rows.size() ;i++)
					    {
					    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
					    	   {
					      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
					      		   
					      		//*[@id="resultTable"]/tbody/tr[1]/td[2]
					    		    WebElement CellText1=driver.findElement(By.xpath(str1));
					    		   
					    	        String valueIneed1 = CellText1.getText();
					    	      //  System.out.println("Cell Text Value is: " + valueIneed1);
					    	        
					    	      
					    	        if (valueIneed1 !=null)
					    	        eat.PutCellData( "E://BOOLEAN//TC02_pimempidsearch.xls","Sheet5",i,k,valueIneed1);
					    	        else
					    	        eat.PutCellData( "E://BOOLEAN//TC02_pimempidsearch.xls","Sheet5",i,k,"Blank Data");
					    	        	
					    	   }
					    }
	   

				        
}
				 
	}