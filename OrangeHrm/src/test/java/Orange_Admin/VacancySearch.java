//import MercuryDemoTours;

package  Orange_Admin;
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


 
public class VacancySearch
{
	public String UserName,Password;
	public String vacancy,JobTitle;
	
	public  int iRow;
	WebDriver driver;
	
	public  void vacancies(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	@Test
	public  void DatadrivenTest_Vacancysearch( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC02.xls","Sheet4");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet4",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet4",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
					 
					 
					 vacancy=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet4",i,2);
					 System.out.println(" vacancy is "+vacancy);
					 
					 JobTitle=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet4",i,3);
					 System.out.println(" JobTitle is "+JobTitle);
					
					
					 
						
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
		
		
		VacancySearch Ae=new VacancySearch();
			Ae.vacancies(driver);
			
		//Search by Vacancy
			System.out.println(" ");
			System.out.println("___________Starts_________________");	
			Boolean str=false;
			
			str=Ae.Search_Vacancies_in_VacancySearch(iRow,vacancy);
			if(str==true)
			System.out.println("YES-VacancySearch is present in VacancySearch");
			else
			System.out.println("No-VacancySearch is not present in VacancySearch");	
			System.out.println("__________Ends__________________");	
			
			
			Boolean str1=false;
			str1=Ae.Search_Vacancies_By_JobTitle(iRow,JobTitle);
			if(str1==true)
			System.out.println("YES-JobTitle is present in Search");
			else
			System.out.println("No-JobTitle is not present in Search");	
			System.out.println("__________Ends__________________");	
			
			
			
			
			
		
			// New method starts
			System.out.println(" ");
			System.out.println("___________Starts_________________");
			System.out.println("****Export VacancySearch method starts here****");	
			Ae.ExportVacancyList();
			System.out.println("___________Ends_________________");
			
					
	}		
	
					
		  		//driver.quit();
			

	// starts method for  Vacancy Search 
		public  Boolean Search_Vacancies_in_VacancySearch(int iRow,String VacancySearch1)throws Exception
		{ 
			
			
			System.out.println("VacancySearch is : "+ VacancySearch1);
			
			Boolean Record_Present=false;
			
		     Actions actions = new Actions(driver);   
			 WebElement ele=driver.findElement(By.xpath(OR.Recruitment_focus));
			 actions.moveToElement(ele).click().perform();
			 
			 driver.findElement(By.xpath(OR.vacancies_click)).click();
		
			 driver.findElement(By.xpath(OR.Vacancies_search_click)).click();	
			
			
	        //No. of columns
	        List  columns = driver.findElements(By.xpath(OR.Vacancies_columns)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(OR.Vacancies_Rows)); 
	        System.out.println("No of rows are : " + rows.size());
	        
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 2 +"]";
					    
					        WebElement CellText1=driver.findElement(By.xpath(str1));
					    		   
					    	String valueIneed1 = CellText1.getText();
					       
					        
						    	if (VacancySearch1.equals(valueIneed1) )
						    	{
						    	    	 Record_Present=true;
						    	    	 System.out.println("True- VacancySearch Text Value is: " + valueIneed1);
						    	    	 return Record_Present;
						    	    	 //Employee ID exist in employee list
						    	}
						    	else
						    	{
						    		 System.out.println("Cell Text Value is:" + valueIneed1);
								     System.out.println("Seracching for VacancySearch is:" +VacancySearch1);
						    	}
						    	
						  					    	
					    }  //After for loop
					    
					    System.out.println("*******VacancySearch method completed*****");
					    return Record_Present;
					    
	
	
}
				
			// Ends method for  VacancySearch
				
				public  void ExportVacancyList()throws Exception
				{ 
					 
					
					 Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.Recruitment_focus));
					 actions.moveToElement(ele).click().perform();
					 
					 driver.findElement(By.xpath(OR.vacancies_click)).click();
					
	
					
					 driver.findElement(By.xpath(OR.Vacancies_search_click)).click();	
					
				
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.Vacancies_columns)); 
			        //System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.Vacancies_Rows)); 
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
							    	        eat.PutCellData( "E://OrangeHrm//TC02.xls","Sheet5",i,k,valueIneed1);
							    	        else
							    	        eat.PutCellData( "E://OrangeHrm//TC02.xls","Sheet5",i,k,"Blank Data");
							    	        	
							    	   }
							    }
			   
				}	
		
				
				
				
				
				
				
				
				
				
				// starts method for  Vacancy Search 
				public  Boolean Search_Vacancies_By_JobTitle(int iRow,String JobTitle)throws Exception
				{ 
					
					
					System.out.println("JobTitle is : "+ JobTitle);
					
					Boolean Record_Present=false;
					
				     Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.Recruitment_focus));
					 actions.moveToElement(ele).click().perform();
					 
					 driver.findElement(By.xpath(OR.vacancies_click)).click();
				
					 driver.findElement(By.xpath(OR.Vacancies_search_click)).click();	
					
					
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.Vacancies_columns)); 
			        System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.Vacancies_Rows)); 
			        System.out.println("No of rows are : " + rows.size());
			        
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