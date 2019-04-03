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
/*
Openbrowser
openurl
login
booleanJobtitle_CEO
export
logout
*/


 
public class pim_jobtitle_search
{
	public String UserName,Password;
	public String JobTitle;
	
	public  int iRow;
	WebDriver driver;
	
	public  void pim_jobtitle_search (WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	@Test
	public  void DatadrivenTest( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://BOOLEAN//TC02_BOOLEAN_JOBTITLE.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://BOOLEAN//TC02_BOOLEAN_JOBTITLE.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://BOOLEAN//TC02_BOOLEAN_JOBTITLE.xls","Sheet1",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
					 
					 
					 JobTitle=eat.getCellData("E://BOOLEAN//TC02_BOOLEAN_JOBTITLE.xls","Sheet1",i,2);
					 System.out.println(" Job Title is "+JobTitle);
					 
					// JobTitle=eat.getCellData("E://OrangeHrm//TC02_BOOLEAN_JOBTITLE.xls","Sheet4",i,3);
					// System.out.println(" JobTitle is "+JobTitle);
					
					
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
				 
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		driver=TestBrowser.OpenChromeBrowser();
		 
		Login l1=new Login();
		l1.Login(driver);
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		l1.OrangeHRMSigninClick();
		
		
		pim_jobtitle_search PJT=new pim_jobtitle_search();
			PJT.pim_jobtitle_search(driver);
			
			
		//Search by JobTitleSearch
			System.out.println(" ");
			System.out.println("___________Starts_________________");	
			Boolean str=false;
			
			str=PJT.pim_jobtitle_search(iRow, JobTitle);
			if(str==true)
			System.out.println("YES-PJTSearch");
			else
			System.out.println("No-PJTSearch");	
			System.out.println("__________Ends__________________");	
			
			
			Boolean str1=false;
			str1=PJT.pim_jobtitle_search(iRow, JobTitle);
			if(str1==true)
			System.out.println("YES-PJT Search");
			else
			System.out.println("No-PJT Search");	
			System.out.println("__________Ends__________________");	
			
			
			
			
			
		
			// New method starts
			System.out.println(" ");
			System.out.println("___________Starts_________________");
			System.out.println("****Export VacancySearch method starts here****");	
		    PJT.ExportEmpList();
			System.out.println("___________Ends_________________");
			driver.quit();
					
	}		
	
					
		  		

	// starts method for  Vacancy Search 
		public  Boolean  pim_jobtitle_search(int iRow,String  JobTitle)throws Exception
		{ 
			
			
			System.out.println(" pim_jobtitle_searchis : "+  JobTitle);
			
			Boolean Record_Present=false;
			
		     Actions actions = new Actions(driver);   
			 WebElement ele=driver.findElement(By.xpath(OR.pim_focus));
			 actions.moveToElement(ele).click().perform();
			 
			 Actions actions1 = new Actions(driver);   
			 WebElement ele1=driver.findElement(By.xpath(OR.Employee_focus));
			actions1.moveToElement(ele1).click().perform();
			
			
			Select listbox =new Select(driver.findElement(By.xpath(OR.Jobtitle_listbox)));
			 listbox.selectByVisibleText("ALL");
			 
			 
			 driver.findElement(By.xpath(OR.Jobtitle_search_click)).click();
		
			
			
	        //No. of columns
	        List  columns = driver.findElements(By.xpath(OR.NoColumns)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(OR.NoRows)); 
	        System.out.println("No of rows are : " + rows.size());
	        
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 2 +"]";
					    
					        WebElement CellText1=driver.findElement(By.xpath(str1));
					    		   
					    	String valueIneed1 = CellText1.getText();
					       
					        
						    	if ( JobTitle.equals(valueIneed1) )
						    	{
						    	    	 Record_Present=true;
						    	    	 System.out.println("True-  JobTitle Text Value is: " + valueIneed1);
						    	    	 return Record_Present;
						    	    	 //Employee ID exist in employee list
						    	}
						    	else
						    	{
						    		 System.out.println("Cell Text Value is:" + valueIneed1);
								     System.out.println("Seracching for  JobTitle is:" + JobTitle);
						    	}
						    	
						  					    	
					    }  //After for loop
					    
					    System.out.println("*******JobTitle method completed*****");
					    return Record_Present;
					    
	
	
}
				
			// Ends method for  VacancySearch
				
				public  void ExportEmpList()throws Exception
				{ 
					 

					 Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.pim_focus));
					 actions.moveToElement(ele).click().perform();

					 Actions actions1 = new Actions(driver);   
					 WebElement ele1=driver.findElement(By.xpath(OR.Employee_focus));
					 actions1.moveToElement(ele1).click().perform();

						Select listbox =new Select(driver.findElement(By.xpath(OR.Jobtitle_listbox)));
						 listbox.selectByVisibleText("CEO");
						 
					 
					 driver.findElement(By.xpath(OR.Jobtitle_search_click)).click();
					
	
					
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.NoColumns)); 
			        //System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.NoRows)); 
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
							    	        eat.PutCellData( "E://BOOLEAN//TC02_BOOLEAN_JOBTITLE.xls","Sheet4",i,k,valueIneed1);
							    	        else
							    	        eat.PutCellData( "E://BOOLEAN//TC02_BOOLEAN_JOBTITLE.xls","Sheet4",i,k,"Blank Data");
							    	        	
							    	   }
							    }
			   
				}	
		
				
				
				
				
				
				
				
				
				
				// starts method for  Vacancy Search 
				public  Boolean Search_Vacancies_By_JobTitle(int iRow,String JobTitle)throws Exception
				{ 
					
					
					System.out.println("JobTitle is : "+ JobTitle);
					
					Boolean Record_Present=false;
					 Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.pim_focus));
					 actions.moveToElement(ele).click().perform();

					 Actions actions1 = new Actions(driver);   
					 WebElement ele1=driver.findElement(By.xpath(OR.Employee_focus));
					 actions1.moveToElement(ele1).click().perform();

						Select listbox =new Select(driver.findElement(By.xpath(OR.Jobtitle_listbox)));
						 listbox.selectByVisibleText(JobTitle);
						 
					 
					 driver.findElement(By.xpath(OR.Jobtitle_search_click)).click();
					
	
						
				        //No. of columns
				        List  columns = driver.findElements(By.xpath(OR.NoColumns)); 
				        //System.out.println("No of columns are : " + columns.size());
				        
				        //No.of rows 
				        List  rows = driver.findElements(By.xpath(OR.NoRows)); 
				       // System.out.println("No of rows are : " + rows.size());
				        
				       
							    for ( int i=1 ; i<=rows.size() ;i++)
							    {
							      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 3 +"]";
							    
							        WebElement CellText1=driver.findElement(By.xpath(str1));
							    		   
							    	String valueIneed1 = CellText1.getText();
							       
							        
								    	if (JobTitle.equals(valueIneed1) )
								    	{
								    	    	 Record_Present=true;
								    	    	 System.out.println("True- JobTitle Text Value is: " + valueIneed1);
								    	    	 return Record_Present;
								    	    	 //Employee ID exist in employee list
								    	}
								    	else
								    	{
								    		 System.out.println("Cell Text Value is:" + valueIneed1);
										     System.out.println("Seracching for JobTitle is:" +JobTitle);
								    	}
								    	
								  					    	
							    }  //After for loop
							    
							    System.out.println("*******JobTitle method completed*****");
							    return Record_Present;
							    
			
			
		}				
				
				
				
}