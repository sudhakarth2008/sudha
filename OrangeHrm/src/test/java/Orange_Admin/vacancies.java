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


 
public class vacancies
{
	public String UserName,Password;
	public String 
	Recruitment_focus,vacancies_click,AddJobVacancy_jobTitle_listbox,
	AddJobVacancy_name_sendkeys,
	AddJobVacancy_hiringManager_sendkeys,
	AddJobVacancy_noofPositions_sendkeys,AddJobVacancy_save_click,Vacancies_Add_Backbutton_click;
	
	public  int iRow;
	WebDriver driver;
	
	public  void vacancies(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	@Test
	public  void DatadrivenTest_AddEmployess( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC02.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet1",i,1);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					
					 
					 
					 
					 AddJobVacancy_jobTitle_listbox=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet1",i,2);
					
					 AddJobVacancy_name_sendkeys=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet1",i,3);
					
					 AddJobVacancy_hiringManager_sendkeys=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet1",i,4);
					 
					 AddJobVacancy_noofPositions_sendkeys=eat.getCellData("E://OrangeHrm//TC02.xls","Sheet1",i,5);
					
						
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
				 
	}
	
	
	
	public  void vacancies( String Recruitment_focus,String vacancies_click,
			String AddJobVacancy_jobTitle_listbox,
			String AddJobVacancy_name_sendkeys,String AddJobVacancy_hiringManager_sendkeys,
			String AddJobVacancy_noofPositions_sendkeys,String AddJobVacancy_save_click,String Vacancies_Add_Backbutton_click
			)throws Exception
	{  
		Actions actions = new Actions(driver);   
		 WebElement ele=driver.findElement(By.xpath(OR.Recruitment_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 driver.findElement(By.xpath(OR.vacancies_click)).click();
		 
		 driver.findElement(By.xpath(OR.AddButton_click)).click();
		 

	Select listbox1=new Select(driver.findElement(By.xpath(OR.AddJobVacancy_jobTitle_listbox)));
	listbox1.selectByVisibleText(AddJobVacancy_jobTitle_listbox);
			
	driver.findElement(By.xpath(OR.AddJobVacancy_name_sendkeys)).sendKeys(AddJobVacancy_name_sendkeys);
	System.out.println("vacancyname is"+AddJobVacancy_name_sendkeys);
			
	driver.findElement(By.xpath(OR.AddJobVacancy_hiringManager_sendkeys)).sendKeys(AddJobVacancy_hiringManager_sendkeys);
	System.out.println("Hiringmanager is"+AddJobVacancy_hiringManager_sendkeys);
	
	driver.findElement(By.xpath(OR.AddJobVacancy_noofPositions_sendkeys)).sendKeys(AddJobVacancy_noofPositions_sendkeys);
	System.out.println("NoOfPositions is"+AddJobVacancy_noofPositions_sendkeys);
	
	 driver.findElement(By.xpath(OR.AddJobVacancy_save_click)).click();
	 
	 driver.findElement(By.xpath(OR.Vacancies_Add_Backbutton_click)).click();
		 
		/* Select listbox1=new Select(driver.	findElement(By.xpath(OR.jobtitle_listbox)));
		listbox1.selectByVisibleText(jobtitle_listbox);
		
	
	
	 	Select listbox2 =new Select(driver.findElement(By.xpath(OR.vacancy_listbox)));
		listbox2.selectByVisibleText(vacancy_listbox);
					
						 	
		Select listbox3=new Select(driver.findElement(By.xpath(OR.HiringManager_listbox)));
		listbox3.selectByVisibleText(HiringManager_listbox);
							
								 	
		Select listbox =new Select(driver.findElement(By.xpath(OR.status_listbox)));
		listbox.selectByVisibleText(status_listbox);*/
									
			 	
		
			 	
		
	}
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		driver=TestBrowser.OpenChromeBrowser();
		 
		Login l1=new Login();
		l1.Login(driver);
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		l1.OrangeHRMSigninClick();
		
		
		vacancies Ae=new vacancies();
			Ae.vacancies(driver);
			
			Ae.vacancies(Recruitment_focus, vacancies_click,
					AddJobVacancy_jobTitle_listbox,
					AddJobVacancy_name_sendkeys,
					AddJobVacancy_hiringManager_sendkeys,
					AddJobVacancy_noofPositions_sendkeys,AddJobVacancy_save_click,Vacancies_Add_Backbutton_click);
			
	
					
		  		//driver.quit();
			
			
	}

	
	
}
