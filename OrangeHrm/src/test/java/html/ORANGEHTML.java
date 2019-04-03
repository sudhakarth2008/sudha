package html;
//import MercuryDemoTours;


import org.testng.annotations.Test;
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
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//import MercuryDemoTours.OR;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;
import html.*;

import java.awt.Desktop;
import java.io.*;

//import SamSung.*;


public class ORANGEHTML {
	

	WebDriver driver;
	TestHTMLReporter5 TH3 = new TestHTMLReporter5();	
	String HtmlOutputFileName;
	String error;

	@Test
	public  void OrangeHTML() throws Exception {
		
		 
		  try {
		        
		 HtmlOutputFileName= TH3.CretaeHTMLFile("TC05 Orange HRM addemp","Chrome");
		  
		 // System.out.println("HtmlOutputFileName path is : "+HtmlOutputFileName);
		   driver=TestBrowser.OpenChromeBrowser();
				  
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  TH3.HTMLScreenShot("Open OrangeHRM","	Succefully Opened","Pass", HtmlOutputFileName,driver);
		  
		  driver.findElement(By.xpath(OR.OH_username_sendkey)).sendKeys("Admin");
		  TH3.HTMLScreenShot("Enter user Name","User Name Succefully Entered","Pass", HtmlOutputFileName,driver);
		  
		  driver.findElement(By.xpath(OR.OH_password_sendkey)).sendKeys("admin123");
		  TH3.HTMLScreenShot("Enter Password","	Password Succefully passed ","Pass", HtmlOutputFileName,driver);
		  
			
		  driver.findElement(By.xpath(OR.OH_login_click)).click();
		 
		  
		  
		  
		  
		WebElement ele=  driver.findElement(By.xpath(OR.OH_Home_MainMenu_PIM_click));
		  
		if(ele.isDisplayed())
		{
			
			orangepim();
			TH3.HTMLScreenShot("Login Success ","	Navigated to  Orange pim Page  ","Pass", HtmlOutputFileName,driver);
		}
		else
		{
			
			TH3.HTMLScreenShot("Login Failed ","	Invalid Credentials  ","Fail", HtmlOutputFileName,driver);
		
		}


		  
	} catch (NoSuchElementException e) {
		
		
		
		
		TH3.HTMLScreenShot("Login Failed ","	Invalid Credentials  ","Fail", HtmlOutputFileName,driver);
			  
			 error=  e.getMessage();
			TH3.HTMLScreenShot(error,error,"Fail", HtmlOutputFileName,driver);
		
			
		    	
	 }
		  
	  
		  
     finally
     {
    	 
    	 
    		 
         TH3.HTMLCloser(HtmlOutputFileName); 
    	 driver.quit();
     }
		  
	
	}

	
public  void orangepim() throws Exception
{
	 try {
	
	
	Actions actions = new Actions(driver);   
	 WebElement ele=driver.findElement(By.xpath(OR.OH_Home_MainMenu_PIM_click));
	Thread.sleep(1000);
	 actions.moveToElement(ele).build().perform();
	 Thread.sleep(1000);
	TH3.HTMLScreenShot("PIM Selected","	Successfully Selected  ","Pass", HtmlOutputFileName,driver);
		
	driver.findElement(By.xpath(OR.OH_EMPlist_click)).click();
	Thread.sleep(1000);
		TH3.HTMLScreenShot("EMPlist Selected","	Successfully Selected  ","Pass", HtmlOutputFileName,driver);

		Actions actions1 = new Actions(driver);   
		 WebElement ele1=driver.findElement(By.xpath(OR.OH_PIM_Addemployee_click));
				 actions1.moveToElement(ele1).build().perform();
				 Thread.sleep(1000);
				 TH3.HTMLScreenShot("Add Emp Selected","	Successfully Selected  ","Pass", HtmlOutputFileName,driver);
		
		
		Thread.sleep(1000);
	driver.findElement(By.xpath(OR.OH_PIM_Addemployee_click)).click();
	Thread.sleep(1000);
	
		TH3.HTMLScreenShot("Add Emp Selected","	Successfully Selected  ","Pass", HtmlOutputFileName,driver);
		} catch (NoSuchElementException e) {
			
			
			
			
			TH3.HTMLScreenShot("Login Failed ","	Invalid Credentials  ","Fail", HtmlOutputFileName,driver);
				  
				 error=  e.getMessage();
				TH3.HTMLScreenShot(error,error,"Fail", HtmlOutputFileName,driver);
			
				
			    	
		 }
			  
		  
			  
	     finally
	     {
	    	 
	    	 
	    		 
	         TH3.HTMLCloser(HtmlOutputFileName); 
	    	 driver.quit();
	     }
			 
/*Select listbox =new Select(driver.
	findElement(By.xpath(OR.MFFPage_PassengersCountListbox)));
	listbox.selectByVisibleText("2");
	
	Select listbox1 =new Select(driver.
	findElement(By.xpath(OR.MFFPage_DepartingFromListbox)));
    listbox1.selectByVisibleText("London");
		
	Select listbox2 =new Select(driver.
	findElement(By.xpath(OR.MFFPage_DepartingStartMonthListbox)));
	listbox2.selectByVisibleText("February");
		
	Select listbox3 =new Select(driver.
	findElement(By.xpath(OR.MFFPage_DepartingStartDateListbox)));
	listbox3.selectByVisibleText("10");
				
	Select listbox4 =new Select(driver.
	findElement(By.xpath(OR.MFFPage_ArrivingIn)));
	listbox4.selectByVisibleText("Paris");	
	
	Select listbox5 =new Select(driver.findElement(By.xpath(OR.MFFPage_ReturningEndMonthListbox)));
	listbox5.selectByVisibleText("March");
				
	Select listbox6 =new Select(driver.
	findElement(By.xpath(OR.MFFPage_ReturningEndDateListbox)));
	listbox6.selectByVisibleText("14");
	
	driver.findElement(By.xpath(OR.MFFPage_FirstClassRadioButton)).click();
	
	Select listbox7 =new Select(driver.
	findElement(By.xpath(OR.MFFPage_AirLineListbox)));
	listbox7.selectByVisibleText("Unified Airlines");
	
	*/
}    
					  
	

/*

	@Test
	public  void MyHtm1() throws Exception {
		
		
		  TestHTMLReporter5 TH = new TestHTMLReporter5();
		  String HtmlOutputFileName= TH.CretaeHTMLFile("TC08_Add Employee","Chrome");
		  
		  System.out.println("HtmlOutputFileName path is : "+HtmlOutputFileName);
		  WebDriver driver=TestBrowser.OpenChromeBrowser();
		 	
		  driver.get("http://www.newtours.demoaut.com/");
		  TH.HTMLScreenShot("Enter  user Name","	Succefully Entered","Pass", HtmlOutputFileName,driver);

		  driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH.HTMLScreenShot("Enter  user Name","	Succefully Entered","Pass", HtmlOutputFileName,driver);
	
		  driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH.HTMLScreenShot("Enter Password","	Succefully passed ","Pass", HtmlOutputFileName,driver);
		  
		  
		  
		  
		  
		  
	
		  TH.HTMLCloser(HtmlOutputFileName);
		  driver.quit();  
		
	}
	

	

	@Test
	public  void MyHtm2() throws Exception {

		  TestHTMLReporter5 TH1 = new TestHTMLReporter5();	  
		  String HtmlOutputFileName= TH1.CretaeHTMLFile("TC02_Add Employee","Chrome");
		  
		  System.out.println("HtmlOutputFileName path is : "+HtmlOutputFileName);
		  WebDriver driver2=TestBrowser.OpenChromeBrowser();
		  
		  driver2.get("http://www.newtours.demoaut.com/");
		  TH1.HTMLScreenShot("Enter  user Name","	Succefully Entered","Pass", HtmlOutputFileName,driver2);
		  
		  driver2.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH1.HTMLScreenShot("Enter  Password Name","	Succefully Entered","Pass", HtmlOutputFileName,driver2);

		  driver2.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH1.HTMLScreenShot("Enter Password","	Succefully passed ","Pass", HtmlOutputFileName,driver2);
	
		  TH1.HTMLCloser(HtmlOutputFileName);
		  driver2.quit();
	}
	
	

	@Test
	public  void MyHtm3() throws Exception {
		


		 TestHTMLReporter5 TH4 = new TestHTMLReporter5();	  
		  String HtmlOutputFileName= TH4.CretaeHTMLFile("TC03_Add Employee","Chrome");
		  
		  //  System.out.println("HtmlOutputFileName path is : "+HtmlOutputFileName);
	
		  WebDriver driver3=TestBrowser.OpenChromeBrowser();
		
	
		  
		  driver3.get("http://www.newtours.demoaut.com/");
		  TH4.HTMLScreenShot("Open Browser","	Succefully Entered","Pass", HtmlOutputFileName,driver3);

		  
		  TH4.HTMLScreenShot("Open 1","	Open 1 Selected ","Pass", HtmlOutputFileName,driver3);
		  
		  TH4.HTMLScreenShot("Open 2","	Open 2 Selected ","Pass", HtmlOutputFileName,driver3);
		  
		  
		  driver3.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH4.HTMLScreenShot("Enter  user Name","	Succefully Entered","Pass", HtmlOutputFileName,driver3);
		  
	
		  
		  driver3.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH4.HTMLScreenShot("Enter Password","	Succefully passed ","Pass", HtmlOutputFileName,driver3);

		 
		  TH4.HTMLCloser(HtmlOutputFileName);
		  driver3.quit();
		  
		  
		
	}*/
	
	
	/*
	@Test
	public  void Mydifftime() throws Exception {
		
		 SimpleDateFormat sdfDate1 = new SimpleDateFormat("dd-MMM-yyyy h:mm:ss a"); 
		 Date d1 = new Date();
		 String strDate1 = sdfDate1.format(d1);
		 
		 	Thread.sleep(120);
		 
		 SimpleDateFormat sdfDate2 = new SimpleDateFormat("dd-MMM-yyyy h:mm:ss a"); 
		 Date d2 = new Date();
		 String strDate2 = sdfDate2.format(d2);
		 
		 long difference1 = d1.getTime() - d2.getTime();
		 System.out.println(difference1/1000);
		 
		 /*
		 
		/* String time1 = "12:00:00";
			String time2 = "12:01:00";
	 
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime();
			System.out.println(difference/1000);*/
		
	
		
	//}
	
	
	
	
	
		@BeforeSuite
	    public void suiteSetup1() throws Exception {
			

			  String xlsFile="C://Users//sudhakar//Desktop//HTML Report//HtmlTemplates//TC05.xls";
			  String xlsFileSheet="Sheet1";
			 
			 ExcelApiTest3 eat = new ExcelApiTest3();
			 eat.clearsheetdata(xlsFile,xlsFileSheet);
	    }  
		
		
		
		@AfterSuite
	    public void AftersuiteSetup2() throws Exception {
			 
			 TestHTMLReporter5 TH5 = new TestHTMLReporter5();	
			 TH5.Regression_CretaeHTMLFile();
			
			
	    }    
		
			
	
}

	
	