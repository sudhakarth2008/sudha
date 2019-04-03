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


 
public class Admin_Qualification_SearchSkills
{
	public String UserName,Password;
	public String Skill_Name,Skill_Description,AddSkill_Name,AddSkill_Description;
	
	public  int iRow;
	WebDriver driver;
	
	
	
	public  void Admin_Qualification(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	
	public  void Search_Admin_Qualification( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet4");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet4",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet4",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 

					 
					 
					 Skill_Name=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet4",i,2);
					 System.out.println(" Skill_Name is "+Skill_Name);
					 
					 Skill_Description=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet4",i,3);
					 System.out.println(" Skill_Description is "+Skill_Description);
					
					
					 
						
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
		
		
		Admin_Qualification_SearchSkills Ae=new Admin_Qualification_SearchSkills();
			Ae.Admin_Qualification(driver);
			
		//Search by Vacancy
			System.out.println(" ");
			System.out.println("___________Starts_________________");	
			Boolean str=false;
			
			str=Ae.Search_SkillName_in_Qualification(iRow,Skill_Name);
			if(str==true)
			{
			System.out.println("YES-Skill_Name is present in Skill_Name");
			}
			else
			{
			System.out.println("No-Skill_Name is not present in Skill_Name");	
			System.out.println("__________Ends__________________");	
			}
			
			Boolean str1=false;
			str1=Ae.Search_Skill_Description(iRow,Skill_Description);
			if(str1==true)
			System.out.println("YES-Skill_Description is present in Search");
			else
			System.out.println("No-Skill_Description is not present in Search");	
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
		public  Boolean Search_SkillName_in_Qualification(int iRow,String Skill_Name)throws Exception
		{ 
			
			
			System.out.println("Skill_Name is : "+ Skill_Name);
			
			Boolean Record_Present=false;
			driver.findElement(By.xpath(OR.Admin)).click();	
			
			//System.out.println("reached here1");
		     Actions actions = new Actions(driver);   
			 WebElement ele=driver.findElement(By.xpath(OR.Qualification_Focus));
			 actions.moveToElement(ele).click().perform();
			// System.out.println("reached here2");
			 driver.findElement(By.xpath(OR.Qualification_skills_click)).click();
			// System.out.println("reached here3");
		
			/* driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(Skill_Name);
				System.out.println("AddSkill_Name is"+Skill_Name);
				
			driver.findElement(By.xpath(OR.AddSkill_Description)).sendKeys(Skill_Description);
			System.out.println("AddSkill_Description is"+Skill_Description);*/
			
			
				
			 
	        //No. of columns
	        List  columns = driver.findElements(By.xpath(OR.skillcoloumns)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(OR.SkillRows)); 
	        System.out.println("No of rows are : " + rows.size());
	        
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					      	String str1="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 2 +"]";
					      	
					      //*[@id="recordsListTable"]/tbody/tr[2]/td[2]
					      	
					      //*[@id='recordsListTable']/tbody/tr/td[2]
					    
					        WebElement CellText1=driver.findElement(By.xpath(str1));
					    		   
					    	String valueIneed1 = CellText1.getText();
					       
					        
						    	if ( Skill_Name.equals(valueIneed1) )
						    	{
						    	    	 Record_Present=true;
						    	    	 System.out.println("True- Skill_Name Text Value is: " + valueIneed1);
						    	    	 return Record_Present;
						    	    	 //Employee ID exist in employee list
						    	}
						    	else
						    	{
						    		 System.out.println("Cell Text Value is:" + valueIneed1);
								     System.out.println("Seracching for Skill_Name is:" +Skill_Name);
						    	}
						    	
						  					    	
					    }  //After for loop
					    
					    System.out.println("*******Skill_Name method completed*****");
					    return Record_Present;
					    
	
	
}
				
			// Ends method for  VacancySearch
				
				public  void ExportVacancyList()throws Exception
				{ 
					driver.findElement(By.xpath(OR.Admin)).click();
					
					 Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.Qualification_Focus));
					 actions.moveToElement(ele).click().perform();
					 
					 driver.findElement(By.xpath(OR.Qualification_skills_click)).click();
				
					 //driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(Skill_Name);
						//System.out.println("AddSkill_Name is"+Skill_Name);
				
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.skillcoloumns)); 
			        System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.SkillRows)); 
			        System.out.println("No of rows are : " + rows.size());
			        
			       
			      
			        			ExcelApiTest3 eat = new ExcelApiTest3();
			         
							    for ( int i=1 ; i<=rows.size() ;i++)
							    {
							    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
							    	   {
							    		  
							    		  System.out.println("hai....112");
							      		   String str1="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
							      		
							      		 System.out.println("hai....113");
							      		   //*[@id="recordsListTable"]/tbody/tr[2]/td[2]
							      		   
							      		   //*[@id="recordsListTable"]/tbody/tr[2]/td[2]

							      		//*[@id='recordsListTable']/thead/tr/th
							    		    WebElement CellText1=driver.findElement(By.xpath(str1));
							    		    
							    		    System.out.println("hai....114");
							    		   
							    	        String valueIneed1 = CellText1.getText();
							    	        System.out.println("Cell Text Value is: " + valueIneed1);
							    	        
							    	        if (valueIneed1 !=null)
							    	        eat.PutCellData( "E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet5",i,k,valueIneed1);
							    	        else
							    	        eat.PutCellData( "E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet5",i,k,"Blank Data");
							    	        	
							    	   }
							    }
			   
				}	
		
				
				
			    // starts method for  Vacancy Search 
				public  Boolean Search_Skill_Description(int iRow,String Skill_Description)throws Exception
				{ 
					
					
					System.out.println("Skill_Description is : "+ Skill_Description);
					
					Boolean Record_Present=false;
					
					driver.findElement(By.xpath(OR.Admin)).click();	
					
					Actions actions = new Actions(driver);   
					 WebElement ele=driver.findElement(By.xpath(OR.Qualification_Focus));
					 actions.moveToElement(ele).click().perform();
					 
					 driver.findElement(By.xpath(OR.Qualification_skills_click)).click();
				
					// driver.findElement(By.xpath(OR.AddButton_click)).click();	
					
					 /*
					 
					 driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(Skill_Name);
					System.out.println("AddSkill_Name is"+Skill_Name);
					 
					
						driver.findElement(By.xpath(OR.AddSkill_Description)).sendKeys(Skill_Description);
						System.out.println("AddSkill_Description is"+Skill_Description);
					
						driver.findElement(By.xpath(OR.AddSkill_Save)).click();	 */
					
					
			        //No. of columns
			        List  columns = driver.findElements(By.xpath(OR.skillcoloumns)); 
			        System.out.println("No of columns are : " + columns.size());
			        
			        //No.of rows 
			        List  rows = driver.findElements(By.xpath(OR.SkillRows)); 
			        System.out.println("No of rows are : " + rows.size());
			        
							    for ( int i=1 ; i<=rows.size() ;i++)
							    {
							      	String str1="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 2 +"]";
							    
							   
							      	
							        WebElement CellText1=driver.findElement(By.xpath(str1));
							    		   
							    	String valueIneed1 = CellText1.getText();
							       
							        
								    	if (Skill_Description.equals(valueIneed1) )
								    	{
								    	    	 Record_Present=true;
								    	    	 System.out.println("True- Skill_Description Text Value is: " + valueIneed1);
								    	    	 return Record_Present;
								    	    	 //Employee ID exist in employee list
								    	}
								    	else
								    	{
								    		 System.out.println("Cell Text Value is:" + valueIneed1);
										     System.out.println("Seracching for Skill_Description is:" +Skill_Description);
								    	}
								    	
								  					    	
							    }  //After for loop
							    
							    System.out.println("*******Skill_Description method completed*****");
							    return Record_Present;
							    
			
			
		}			
				
				
				
}