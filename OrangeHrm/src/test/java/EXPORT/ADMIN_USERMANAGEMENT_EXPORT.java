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
ADMIN USERSEXPORT
LOGOUT*/

public class ADMIN_USERMANAGEMENT_EXPORT
{
	
	
public String UserName,Password;
	
	
	public  int iRow;
	WebDriver driver;
	
	
		
	public  void ADMIN_USERMANAGEMENT_EXPORT(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	@Test
	public  void Export_Admin_Qualification( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC05_USERMANAGEMENT.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC05_USERMANAGEMENT.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC05_USERMANAGEMENT.xls","Sheet1",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
						
					 iRow=i;
					 call_allmethods(iRow);
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
						 
						ADMIN_USERMANAGEMENT_EXPORT AE=new ADMIN_USERMANAGEMENT_EXPORT();
						
					AE.ADMIN_USERMANAGEMENT_EXPORT(driver);
					AE.user_management_export();
	
	
					}
				 public void user_management_export()throws Exception
				 {
					 Actions actions1 = new Actions(driver);   
					 WebElement ele1=driver.findElement(By.xpath(OR.ADMIN_focus));
					 actions1.moveToElement(ele1).click().perform();
					 
					 
					 Actions actions2 = new Actions(driver);   
					 WebElement ele2=driver.findElement(By.xpath(OR.ADMIN_USERMANAGEMENT_focus));
					 actions2.moveToElement(ele2).click().perform();
					 
					 driver.findElement(By.xpath(OR.ADMIN_USERS_click)).click();
					 
					 List  columns = driver.findElements(By.xpath(OR.ADMIN_COLUMNS_click)); 
				        System.out.println("No of columns are : " + columns.size());
				        
				        List  Rows = driver.findElements(By.xpath(OR.ADMIN_ROWS_click)); 
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
					    	        eat.PutCellData( "E://OrangeHrm//TC05_USERMANAGEMENT.xls","Sheet4",i,k,valueIneed1);
					    	        else
					    	        eat.PutCellData( "E://OrangeHrm//TC05_USERMANAGEMENT.xls","Sheet4",i,k,"Blank Data");
					    	        	
					    	   }
					    }
	   

				        
}
				 
	}