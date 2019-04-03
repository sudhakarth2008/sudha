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


 
public class Admin_Qualification
{
	
	WebDriver driver;
	
		
	public  void Admin_Qualification(WebDriver driver )throws Exception
	{  
			  this.driver=driver;
	}
	
	
	@Test(priority=1)
	public  void Admin_Skills_Add( )throws Exception
	{  	
		Admin_Qualification_AddSkills AQ = new Admin_Qualification_AddSkills();
		AQ.Admin_Qualification_Skills_Add();
	}
		
	
	@Test(priority=2)
	public  void Admin_Skills_Search( )throws Exception
	{  
		Admin_Qualification_SearchSkills AS= new Admin_Qualification_SearchSkills();
		AS.Search_Admin_Qualification();
		
	}
	
	@Test(priority=3)
	public  void Export_Skills() throws Exception
	{  
		Admin_Skils_Export AE1= new Admin_Skils_Export();
         AE1.Export_Admin_Qualification();
		
	}
		
				
				
}