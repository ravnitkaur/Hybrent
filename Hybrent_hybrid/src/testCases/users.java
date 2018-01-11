package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.organisation_settings;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

import com.relevantcodes.extentreports.ExtentReports;

public class users extends ApplicationKeyword{
	public static String UserName = "admin";
	public static String Password = "goouser";
	public static String URL = "https://qa4.test.hybrent.com/b/#/login/";

	
	
	
	@BeforeTest
	public void startReport(){
		try
		{
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
			//extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Harikrishnan");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));	        	 

		}
		catch(Exception e)
		{
			testLogFail("unable to generate the pass report "+e.toString());   
		}
	}	
	@Test
	public void Tc_Users_01()
	{
		testStarts("Tc_Users_01" , "Verify that Search text field with facilities and status dropdown appear on page.");
		LoginPage.OpenBrowserAndLogin();	
		organisation_settings.adminAndUserPage();
		verifyElementText(OR.Users_SearchByText, "Search by");
		verifyElementText(OR.Users_FacilityText, "Facilities");
		verifyElementText(OR.Users_StatusText, "Status");
		 if(isElementDisplayed(OR.Users_FacilityDropDown, 10))
		    {
		    	testLogPass("Faciliy DropDownPresent");
		    }
		 else
		    {
		    	testLogFail("Faciliy DropDown not Present");
		    }
		 if(isElementDisplayed(OR.Users_StatusDropDown, 10))
		    {
		    	testLogPass("Status DropDownPresent");
		    }
		 else
		    {
		    	testLogFail("Status DropDown not Present");
		    }
		 closeBrowser();
		 
		 
	}
	
	@Test
	public void Tc_Users_02()
	{
		testStarts("Tc_Users_02" , "Verify that corresponding search results appear on page when user searches with any valid name, nickname and email.");
		LoginPage.OpenBrowserAndLogin();	
		organisation_settings.adminAndUserPage();
		clickOn(OR.Users_EditFirstUser);	
		String firstUserName=getAttributeValue(OR.Users_NameEditBox, "value");
		System.out.println(firstUserName);
		String firstNickName=getAttributeValue(OR.Users_NickNameEditBox, "value");
		String firstEmail=getAttributeValue(OR.Users_EmailEditBox, "value");
		clickOn(OR.Users_ClosePopup);
		waitForElementToDisplay(OR.Users_SearchTextBox, 10);		
		//waitTime(3000);	
		typeIn(OR.Users_SearchTextBox, firstUserName);
		organisation_settings.searchAndUserWait();
		String ActualFirstAndNickName=getText(OR.Users_FirstUserName);
		System.out.println(ActualFirstAndNickName);
		if(ActualFirstAndNickName.contains(firstUserName))
		{
			testLogPass("User is searched with FirstName");			
		}
		else
		{
			testLogFail("User is not searched with FirstName");
		}
		clearEditBox(OR.Users_SearchTextBox);
		//waitForElementToDisplay(OR.Users_SearchTextBox, 10);	
		typeIn(OR.Users_SearchTextBox, firstNickName);
		organisation_settings.searchAndUserWait();
		String ActualNickName=getText(OR.Users_FirstUserName);
		if(ActualNickName.contains(firstNickName))
		{
			testLogPass("User is searched with NickName");
			
		}
		else
		{
			testLogFail("User is not searched with NickName");
		}
		clearEditBox(OR.Users_SearchTextBox);
		//waitForElementToDisplay(OR.Users_SearchTextBox, 10);
		typeIn(OR.Users_SearchTextBox, firstEmail);
		organisation_settings.searchAndUserWait();
		String email=getText(OR.Users_FirstUserEmail);
		if(email.contains(firstEmail))
		{
			testLogInfo("User is searched with Email");
			
		}
		else
		{
			testLogFail("User is not searched with Email");
		}
		closeBrowser();
		
	}
	
	@Test
	public void Tc_Users_03_08()
	{
		testStarts("Tc_Users_03_08" , "Verify that “Add User” page opens on clicking Add button and verify user tabs appears same in ADD screen");
		LoginPage.OpenBrowserAndLogin();	
		organisation_settings.adminAndUserPage();
		clickOn(OR.Users_AddNewUser);
		waitForElementToDisplay(OR.Users_AddUserPopupText, 10);
		verifyElementText(OR.Users_AddUserPopupText, "Add User");
		organisation_settings.verifyTabs();	
		closeBrowser();	
	}
	
	@Test
	public void Tc_Users_04_08()
	{
		testStarts("Tc_Users_04_08" , "Verify that “Edit User” page opens on clicking edit button and verify user tabs appears same in EDit screen");
		LoginPage.OpenBrowserAndLogin();	
		organisation_settings.adminAndUserPage();
		clickOn(OR.Users_EditUserButton);
		waitForElementToDisplay(OR.Users_EditUserPopupText, 10);
		verifyElementText(OR.Users_EditUserPopupText, "Edit User");
		organisation_settings.verifyTabs();
		closeBrowser();	
	}
	
	@Test
	public void Tc_Users_06()
	{
		testStarts("Tc_Users_06" , "Create User > Verify that Save button appears disabled unless all mandatory fields are filled.");
		LoginPage.OpenBrowserAndLogin();	
		organisation_settings.adminAndUserPage();
		clickOn(OR.Users_ChangePasswordButton);
		waitForElementToDisplay(OR.Users_ChangePasswordPopUpText, 10);
		verifyElementText(OR.Users_ChangePasswordPopUpText, "Change Password");		
		closeBrowser();	
	}
	
//	@Test
//	public void Tc_Users_09()
//	{
//		testStarts("Tc_Users_09" , "Verify that Change password pop up appears when user clicks on Change password button.");
//		LoginPage.OpenBrowserAndLogin();	
//		organisation_settings.adminAndUserPage();
//		clickOn(OR.Users_AddNewUser);
//		waitForElementToDisplay(OR.Users_AddUserPopupText, 10);
//		String disabledAttribute=getAttributeValue(OR.Users_SaveButton, "disabled");
//		typeIn(OR.Users_NameEditBox, "Ravneet");
//		typeIn(OR.Users_EmployeeEditBox, "335");
//		typeIn(OR.Users_NickNameEditBox,"ruby");
//		typeIn(OR.Users_EmailEditBox, "ravneetkaur.qa@gmail.com");
//		typeIn(OR.Users_PasswordEditBox,"qwerty");
//		typeIn(OR.Users_ConfirmPasswordEditBox, "qwerty");
//		
//		List<WebElement> allFac = driver.findElements
//				(By.xpath("//*[@id='facility']/option"));		
//		for(int i=1; i<allFac.size(); i++)
//		{
//			selectFromDropdown(OR.Users_FacilityDropDownAddUSer, i);
//			waitForElementToDisplay(OR.Users_WaitDepartmentDropDownAddUSer, 10);
//			waitForElementToDisplay(OR.Users_WaitInventoryDropDownAddUSer, 10);
//			List<WebElement> departments = driver.findElements				
//					(By.xpath("//*[@id='department']/option"));
//			
//			List<WebElement> inventories = driver.findElements				
//					(By.xpath("//*[@id='inventory']/option"));
//			if(departments.size()<=1&&inventories.size()<=1)
//			{
//				testLogInfo("");
//			}
//								
//			else
//			{
//			selectFromDropdown(OR.Users_DepartmentDropDownAddUSer, i);
//			selectFromDropdown(OR.Users_InventoryDropDownAddUSer, i);
//			break;			
//			}
//		
//		}	
//		clickOn(OR.Users_vendorAccessTab);
//		clickOn(OR.Users_SelectVendorsDropDown);
//		clickOn(OR.Users_SelectAllVendors);
//		String disabledAttributeAfter=getAttributeValue(OR.Users_SaveButton, "disabled");
//		System.out.println(disabledAttributeAfter);
//		System.out.println(disabledAttribute);
//		closeBrowser();	
//	}
	
	
	
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}	
	
	
	
	
}
