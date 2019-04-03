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


public class TEST44 {
	

	WebDriver driver;
	


	@Test
	public  void MyHtm4() throws Exception {
		
		
		
	
		TestHTMLReporter5 TH3 = new TestHTMLReporter5();	
		String HtmlOutputFileName;
		
		 HtmlOutputFileName= TH3.CretaeHTMLFile("TC04_Add Employee","Chrome");
		  
		 // System.out.println("HtmlOutputFileName path is : "+HtmlOutputFileName);
		   driver=TestBrowser.OpenChromeBrowser();
				  
		  driver.get("http://www.newtours.demoaut.com/");
		  TH3.HTMLScreenShot("Open Mercury Demo tours","	Succefully Opened","Pass", HtmlOutputFileName,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH3.HTMLScreenShot("Enter user Name","User Name Succefully Entered","Pass", HtmlOutputFileName,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH3.HTMLScreenShot("Enter Password","	Password Succefully passed ","Pass", HtmlOutputFileName,driver);
		  
		//  driver.findElement(By.xpath(OR.MLPage_SignInButton)).click();
		  TH3.HTMLCloser(HtmlOutputFileName); 
		  driver.quit();
	
	}

	
	
	@Test
	public  void MyHtm5() throws Exception {
		
		TestHTMLReporter5 TH3 = new TestHTMLReporter5();	
		String HtmlOutputFileName;
		    
		 HtmlOutputFileName= TH3.CretaeHTMLFile("TC05_Add Employee","Chrome");
		  
		 // System.out.println("HtmlOutputFileName path is : "+HtmlOutputFileName);
		   driver=TestBrowser.OpenChromeBrowser();
				  
		  driver.get("http://www.newtours.demoaut.com/");
		  TH3.HTMLScreenShot("Open Mercury Demo tours","	Succefully Opened","Pass", HtmlOutputFileName,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		  TH3.HTMLScreenShot("Enter user Name","User Name Succefully Entered","Pass", HtmlOutputFileName,driver);
		  
		  driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		  TH3.HTMLScreenShot("Enter Password","	Password Succefully passed ","Pass", HtmlOutputFileName,driver);
		  
		//  driver.findElement(By.xpath(OR.MLPage_SignInButton)).click();
		  TH3.HTMLCloser(HtmlOutputFileName); 
		  driver.quit();
	
	}
	
	
	
		@BeforeTest
	    public void suiteSetup1() throws Exception {
			

			  String xlsFile="C://Users//sudhakar//Desktop//HTML Report//HtmlTemplates//TC05.xls";
			  String xlsFileSheet="Sheet1";
			 
			 ExcelApiTest3 eat = new ExcelApiTest3();
			 eat.clearsheetdata(xlsFile,xlsFileSheet);
	    }  
		
		
		
		@AfterTest
	    public void AftersuiteSetup2() throws Exception {
			 
			 TestHTMLReporter5 TH5 = new TestHTMLReporter5();	
			 TH5.Regression_CretaeHTMLFile();
			
			
	    }    
		
			
	
}

	
	