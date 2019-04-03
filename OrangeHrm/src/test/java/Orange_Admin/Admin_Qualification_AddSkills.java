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


 
public class Admin_Qualification_AddSkills
{
	public String UserName,Password;
	public String Skill_Name,Skill_Description,AddSkill_Name,AddSkill_Description;
	
	public  int iRow;
	WebDriver driver;
	
	
	
	public  void Admin_Qualification(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	
	
	
	@Test(priority=1)
	public  void Admin_Qualification_Skills_Add( )throws Exception
	{  
		ExcelApiTest3 eat = new ExcelApiTest3();
	
		 
		 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet4");
		 System.out.println("numberowsInputdata" + numberowsInputdata);

			 for(int i=1;i<2;i++)
			 {		 
				
				 
				 
				 
				 UserName=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet1",i,0);
				 Password=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet1",i,1);
				 System.out.println("User name is"+UserName);
				 System.out.println(" Password is "+Password);
				 
				 Skill_Name=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet1",i,2);
				 Skill_Description=eat.getCellData("E://OrangeHrm//TC03_Admin_Qualification_skills.xls","Sheet1",i,3);

				 iRow=i;
				SkillAdd_allmethods(iRow,Skill_Name,Skill_Description); 
				 
			 } 
	}
			 
			 
			 public   void SkillAdd_allmethods(int iRow,String Skill_Name,String Skill_Description )throws Exception
				{  
					
					
					
					driver=TestBrowser.OpenChromeBrowser();
					
					//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					 
					Login l1=new Login();
					l1.Login(driver);
					l1.openOrangeHRM();
					l1.OrangeHRMlogin(UserName,Password);
					l1.OrangeHRMSigninClick();
		
						  driver.findElement(By.xpath(OR.Admin)).click();	
						
					     Actions actions = new Actions(driver);   
						 WebElement ele=driver.findElement(By.xpath(OR.Qualification_Focus));
						 actions.moveToElement(ele).click().perform();
				
						 driver.findElement(By.xpath(OR.Qualification_skills_click)).click();
						 
						 driver.findElement(By.xpath(OR.Skills_Add)).click();
			 
						 SimpleDateFormat sdfDate1 = new SimpleDateFormat("dd-MMM-yyyy h:mm:ss a"); 
						 Date now1 = new Date();
						 String strDate1 = sdfDate1.format(now1);
						 String s3=Skill_Name.concat(strDate1); 
						 
						driver.findElement(By.xpath(OR.AddSkill_Name)).sendKeys(s3);
						System.out.println("Skill_Name is"+s3);
						
						driver.findElement(By.xpath(OR.AddSkill_Description)).sendKeys(Skill_Description);
						System.out.println("Skill_Description is"+Skill_Description);
						
						driver.findElement(By.xpath(OR.AddSkill_Save)).click();
						
						driver.quit();
		
				}

	
	
				
				
				
}