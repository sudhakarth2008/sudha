package Orange_Pim;


import org.openqa.selenium.WebDriver;

public class OR {
	
public static String sTargetTestCaseExcelPath="";	
public static String sTargetFolderPath="";	
public static String sTestCaseName="";	



public static String username="//input[@id='txtUsername']";
public static String password="//input[@id='txtPassword'] ";
public static String login="//input[@id='btnLogin']";
//public static String admin="//a[@id='menu_admin_viewAdminModule']";

//PIM starts
public static String Home_MainMenu_PIM_click="//a[@id='menu_pim_viewPimModule']";

public static String PIM_Addemployee_click="//a[@id='menu_pim_addEmployee']";
//PIM ends


//Add employee starts


public static String firstname_sendkeys="//input[@id='firstName']";

public static String middlename_sendkeys="//input[@id='middleName']";

public static String lastname_sendkeys="//input[@id='lastName']";

public static String EmployeeId_defaultno="//input[@id='employeeId']";


public static String CreateLoginDetails_checkbox="//input[@id='chkLogin']";

public static String UserName_sendkeys="//input[@id='user_name']";

public static String Password_sendkeys="//input[@id='user_password']";

public static String ConfirmPassword_sendkeys="//input[@id='re_password']";

public static String Status_listbox="//select[@id='status']";

public static String save="//input[@id='btnSave']";

public static String Vacancies_Add_Backbutton_click="//input[@id='btnBack']";

//Add employee ends

//Pim Employee list Starts
public static String Employeelist_click="//a[@id='menu_pim_viewEmployeeList']";
public static String EmployeeName_sendkeys="//input[@id='empsearch_employee_name_empName']";
public static String SearchButton_click="//input[@id='searchBtn']";
public static String EmployeID_Serach_sendkeys ="//input [ @id='empsearch_id' ]";


public static String EmployeeList_Numberof_Columns="//*[@id='resultTable']/thead/tr/th";
public static String EmployeeList_Numberof_Rows="//*[@id='resultTable']/tbody/tr/td[2]";

}

