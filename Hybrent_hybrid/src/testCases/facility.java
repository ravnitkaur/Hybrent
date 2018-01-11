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

public class facility extends ApplicationKeyword{
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
	public void Tc_Fac_01()
	{
		testStarts("Tc_Fac_01" , "Verify that user can search facility by name using the search text field. ");
		LoginPage.OpenBrowserAndLogin();
		organisation_settings.AdminAndFacilityLink();
		String firstFacName=getText(OR.Facilty_firstFacility).substring(1);
		typeIn(OR.Facilty_SearchBox, firstFacName);
		clickOn(OR.Facilty_SearchButton);
		waitForElementToDisplay(OR.Facilty_WaitforTableElem, 10);
		String FacNameAfterSearch=getText(OR.Facilty_firstFacility).substring(1);
		System.out.println(firstFacName);
		System.out.println(FacNameAfterSearch);
		if(firstFacName.equals(FacNameAfterSearch))
		{
			testLogPass("Search is working. User is able to search with Facility Name");
			
		}
		else
		{
			testLogFail("Search is not working. User is not able to search with Facility Name");
		}
		closeBrowser();
		}
	
	@Test
	public void Tc_Fac_02()
	{
		testStarts("Tc_Fac_02" , "Verify that “Add Facility” pop up opens on clicking Add button.");
		LoginPage.OpenBrowserAndLogin();
		organisation_settings.AdminAndFacilityLink();
		clickOn(OR.Facilty_AddFacilityButton);
		waitForElementToDisplay(OR.Facilty_AddFacilityText, 10);
		verifyElementText(OR.Facilty_AddFacilityText, "Add Facility");
		closeBrowser();
	}
	
	@Test
	public void Tc_Fac_03()
	{
		testStarts("Tc_Fac_03" , "Verify that tabs(Facility Details, Shipping Address, Invoice Address) appears on Add/Edit facility pop up.");
		LoginPage.OpenBrowserAndLogin();
		organisation_settings.AdminAndFacilityLink();
		clickOn(OR.Facilty_AddFacilityButton);	
		waitForElementToDisplay(OR.Facilty_AddFacilityText, 10);
		List<String> tabs = new ArrayList<String>( Arrays.asList("Facility Detail", "Shipping Address", "Invoice Address"));
		
		List<WebElement> actualTabs = driver.findElements
					(By.xpath("//ul[@class='nav nav-tabs']//a[@class='nav-link ng-binding']"));
		 
		 if(tabs.size() == actualTabs.size())
			{
			 for(int i=0; i<tabs.size(); i++)
				{				 
				 if(tabs.get(i).equals(actualTabs.get(i).getText()))
				 	{	
					testLogPass(tabs.get(i)+" Tab matched with " +actualTabs.get(i).getText());					
				 	}
				else
				{
					testLogFail(tabs.get(i)+" Tab doesnot matched with " +actualTabs.get(i).getText());					
				}
			}
			}
			else
			{
				testLogFail("Both the Lists Donot have same number of Tabs");
			}
			
		closeBrowser();
	}
	
	@Test
	public void Tc_Fac_04()
	{
		testStarts("Tc_Fac_04" , "Verify that 'Edit Facility' page opens when on clicking Edit button.");
		LoginPage.OpenBrowserAndLogin();
		organisation_settings.AdminAndFacilityLink();
		clickOn(OR.Facilty_EditFacility);	
		waitForElementToDisplay(OR.Facilty_EditFacilityText, 10);
		verifyElementText(OR.Facilty_EditFacilityText, "Edit Facility");
		closeBrowser();
	}
	
//	@Test
//	public void Tc_Fac_05()
//	{
//		testStarts("Tc_Fac_05" , "Verify that facility name drill down expand and display all associated departments when user clicks on “-” button.");
//		LoginPage.OpenBrowserAndLogin();
//		organisation_settings.AdminAndFacilityLink();
//		clickOn(OR.Facilty_firstdrillDown);
//		waitForElementToDisplay(OR.Facilty_firstDepartmentName, 10);
//		String s=getText(OR.Facilty_firstDepartmentName);
//		System.out.println(s);
////		waitForElementToDisplay(OR.Facilty_EditFacilityText, 10);
////		verifyElementText(OR.Facilty_EditFacilityText, "Edit Facility");
//		closeBrowser();
//	}
	
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}
}
