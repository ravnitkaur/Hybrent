package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Invoices;
import pageObject.LoginPage;
import pageObject.ReceivePageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

import com.relevantcodes.extentreports.ExtentReports;

	public class Receive extends ApplicationKeyword
	{
	public static String UserName = "admin";
	public static String Password = "goouser";
	public static String URL = "https://qa4.test.hybrent.com/b/#/login/";


//	public static String ItemDescription;
//	public static String ItemMfrNumber;
//	public static String ItemTestID;
//	public static String SkuName;
	public static String facility_Name;
	public static String vendor_Name;
	
	public static String ItemDescription = "ItemDesTest001";
	public static String ItemMfrNumber = "ItemMfrNumber001";
	public static String ItemTestID = "ItemTestID001";
	public static String SkuName = "sku001";
	

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
	public void Tc_Receive_01() throws InterruptedException
	{
		testStarts("Tc_Receive_01()", "Verify that PO with 'Assigned', 'Confirmed' or 'Partial Received' status appear on page.");
		LoginPage.OpenBrowserAndLogin();	
		ReceivePageObject.pageLinkandwait();
		List<String> status = new ArrayList<String>( Arrays.asList("All", "Assigned" , "Confirmed", "Partial Received"));
		clickOn(OR.Receive_statusDropdown);
		List<WebElement> actualStatus = driver.findElements
				(By.xpath("//*[@id='status']//ul/li/div[@role='option']"));		
		 if(status.size() == actualStatus.size())
		 {
			 for(int i=0; i<status.size(); i++)
			{	
				 if(status.get(i).equals(actualStatus.get(i).getText()))
				 	{	
					testLogPass(status.get(i)+" Option matched with " +actualStatus.get(i).getText());					
				 	}
				else
				{
					testLogFail(status.get(i)+" Option doesnot matched with " +actualStatus.get(i).getText());					
				}
			}
		 }	
			else
			{
				testLogFail("Both the Lists Donot have same number of Options");
			}
		 closeBrowser();
	}
	@Test
	public void Tc_Receive_03() throws InterruptedException
	{
		testStarts("Tc_Receive_03()", "Verify that following dropdown filters appear on page. Vendor Status Type Facility Department Created By");
		LoginPage.OpenBrowserAndLogin();	
		ReceivePageObject.pageLinkandwait();
		if(isElementDisplayed(OR.Receive_vendorDropdown, 10))
		{
			testLogPass("Vendor DropDown is Present");
		}
		else
		{
			testLogFail("Vendor DropDown is not Present");
			
		}
		if(isElementDisplayed(OR.Receive_statusDropdown, 10))
		{
			testLogPass("Status DropDown is Present");
		}
		else
		{
			testLogFail("Status DropDown is not Present");
			
		}
		if(isElementDisplayed(OR.Receive_facilityDropdown, 10))
		{
			testLogPass("Facility DropDown is Present");
		}
		else
		{
			testLogFail("Facility DropDown is not Present");
			
		}
		if(isElementDisplayed(OR.Receive_departmentDropdown, 10))
		{
			testLogPass("Department DropDown is Present");
		}
		else
		{
			testLogFail("Department DropDown is not Present");
			
		}
		if(isElementDisplayed(OR.Receive_typeDropdown, 10))
		{
			testLogPass("Type DropDown is Present");
		}
		else
		{
			testLogFail("Type DropDown is not Present");
			
		}
		if(isElementDisplayed(OR.Receive_createdByDropdown, 10))
		{
			testLogPass("CreatedBy DropDown is Present");
		}
		else
		{
			testLogFail("CreatedBy DropDown is not Present");
			
		}
		closeBrowser();
	}
	
	@Test
	public void Tc_Receive_05() throws InterruptedException
	{
		testStarts("Tc_Receive_05()", "Verify that “Notes for PO #” window appears when user clicks on notes icon with count.");
		LoginPage.OpenBrowserAndLogin();	
		ReceivePageObject.pageLinkandwait();
		clickOn(OR.Receive_NotesLink);
		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
		verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");
		closeBrowser();
	}
	@Test
	public void Tc_Receive_06() throws InterruptedException
	{
		testStarts("Tc_Receive_06()", "Verify that “Add Note for PO #” pop up appears when user clicks on “Add New Note”");
		LoginPage.OpenBrowserAndLogin();
		ReceivePageObject.pageLinkandwait();
		clickOn(OR.Receive_NotesLink);
		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
		clickOn(OR.Receive_AddNewNotesLink);
		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
		verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");
		closeBrowser();
	}
	@Test
	public void Tc_Receive_07() throws InterruptedException
	{
		testStarts("Tc_Receive_07()", "Verify that “PO # XXXX11 Documents” pop up appears when clicks on Documents icon with count.");
		LoginPage.OpenBrowserAndLogin();
		ReceivePageObject.pageLinkandwait();
		clickOn(OR.Receive_DocsLink);
		waitForElementToDisplay(OR.Receive_DocsLinkText, 10);
		String s=getText(OR.Receive_firstPONum);
		verifyElementText(OR.Receive_DocsLinkText, "PO # "+s+" Documents");
		closeBrowser();
	}
	@Test
	public void Tc_Receive_09() 
	{
		testStarts("Tc_Receive_09()", "Verify that “Print PO” preview window appears when user clicks on Print Po option in action dropdown");
		LoginPage.OpenBrowserAndLogin();
		ReceivePageObject.pageLinkandwait();
		clickOn(OR.Receive_DrillDownIcon);
		clickOn(OR.Receive_PrintPOLink);
		waitForElementToDisplay(OR.Receive_PrintPOText, 10);		
		verifyElementText(OR.Receive_PrintPOText, " Print PO");
		closeBrowser();
	}
	@Test
	public void Tc_Receive_10() 
	{
		testStarts("Tc_Receive_10()", "Verify that user gets redirected to “INVOICE FOR PO #” page, on clicking “Add Invoice” option.");
		LoginPage.OpenBrowserAndLogin();
		ReceivePageObject.pageLinkandwait();
		clickOn(OR.Receive_DrillDownIcon);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitForElementToDisplay(OR.Order_PO_first_Addinvoice, 60);
		clickOn(OR.Order_PO_first_Addinvoice);
		verifyElementText(OR.Receive_InvoiceForText, "INVOICE FOR PO #:");
		closeBrowser();
	}
	
	
	
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}
	
}
