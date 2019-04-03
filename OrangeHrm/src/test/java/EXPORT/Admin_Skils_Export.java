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
EXPORT
LOGOUT*/

 
public class Admin_Skils_Export
{
	public String UserName,Password;
	
	
	public  int iRow;
	WebDriver driver;
	
	
	
	public  void Admin_Skils_Export(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	@Test
	public  void Export_Admin_Qualification( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC05pimexport.xls","Sheet4");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC05pimexport.xls","Sheet4",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC05pimexport.xls","Sheet4",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
				 driver.quit();
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
		
		Admin_Skils_Export AE = new Admin_Skils_Export();
		AE.Admin_Skils_Export(driver);
		AE.ExportVacancyList();
		
	}
				
			// Ends method for  VacancySearch
				
				public  void ExportVacancyList()throws Exception
				{ 
					
					
					 Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.pim_focus));
					 actions.moveToElement(ele).click().perform();
					 
					 driver.findElement(By.xpath(OR.EMPlist_click)).click();
				
					 //driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(Skill_Name);
						//System.out.println("AddSkill_Name is"+Skill_Name);
				
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.EMPcolumn)); 
			        System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.EMProws)); 
			        System.out.println("No of rows are : " + rows.size());
			        
			       
			      
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
							    	        eat.PutCellData( "E://OrangeHrm//TC05pimexport.xls","Sheet5",i,k,valueIneed1);
							    	        else
							    	        eat.PutCellData( "E://OrangeHrm//TC05pimexport.xls","Sheet5",i,k,"Blank Data");
							    	        	
							    	   }
							    }
			   
				}	
		
				
				
			 
				
}