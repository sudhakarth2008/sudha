package Orange_Admin;


import org.openqa.selenium.WebDriver;

public class OR {
	

public static String sTargetTestCaseExcelPath="";	
public static String sTargetFolderPath="";	
public static String sTestCaseName="";	

public static String username_sendkey="//input[@id='txtUsername']";
public static String password_sendkey="//input[@id='txtPassword']";
public static String login_click="//input[@id='btnLogin']";

//recruitment starts

public static String Recruitment_focus="//a[@id='menu_recruitment_viewRecruitmentModule']";

public static String vacancies_click="//a[@id='menu_recruitment_viewJobVacancy']";

public static String AddButton_click="//input[@id='btnAdd']"; 

public static String AddJobVacancy_jobTitle_listbox="//select[@id='addJobVacancy_jobTitle']";

public static String AddJobVacancy_name_sendkeys="//input[@id='addJobVacancy_name']";

public static String AddJobVacancy_hiringManager_sendkeys="//input[@id='addJobVacancy_hiringManager']";


public static String AddJobVacancy_noofPositions_sendkeys="//input[@id='addJobVacancy_noOfPositions']";

public static String AddJobVacancy_save_click="//input[@id='btnSave']"; 

public static String Vacancies_Add_Backbutton_click="//input[@id='btnBack']";



//vacancy search starts
public static String vacancy_listbox="//select[@id='vacancySearch_jobVacancy']";

public static String Vacancies_search_click="//input[@id='btnSrch']";

public static String Vacancies_columns="//*[@id='resultTable']/thead/tr/th";

public static String Vacancies_Rows="//*[@id='resultTable']/tbody/tr/td[2]";

//vacancy search Ends

//public static String jobtitle_listbox="//select[@id='vacancySearch_jobTitle']";


//public static String HiringManager_listbox="//select[@id='vacancySearch_hiringManager']";


//public static String status_listbox="//select[@id='vacancySearch_status']";

//Admin_Qualification Starts

public static String  Admin="//a[@id='menu_admin_viewAdminModule']";

public static String Qualification_Focus="//a[@id='menu_admin_Qualifications']";

public static String Qualification_skills_click="//a[@id='menu_admin_viewSkills']";

public static String Skills_Add="//input[@id='btnAdd']";

public static String AddSkill_Name="//input[@id='skill_name']";

public static String AddSkill_Description="//textarea[@id='skill_description']";

public static String AddSkill_Save="//input[@id='btnSave']";

public static String skillcoloumns="//*[@id='recordsListTable']/thead/tr/th";

public static String SkillRows="//*[@id='recordsListTable']/tbody/tr/td[2]";

}

