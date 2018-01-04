package testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

import com.relevantcodes.extentreports.ExtentReports;

public class InvoicePage extends ApplicationKeyword
{
	public static String UserName = "admin";
	public static String Password = "goouser";
	public static String URL = "https://qa4.test.hybrent.com/b/#/login/";


	public static String ItemDescription;
	public static String ItemMfrNumber;
	public static String ItemTestID;
	public static String SkuName;
	public static String facility_Name;
	public static String vendor_Name;


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
	public void Tc_INV_01()
	{
		testStarts("Tc_SPO_01", "Verify that following dropdown filters(Vendor,Status,Search By ,Due Date,Facility,Departments,Ordered By	) appear on page");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		clickOn(OR.Orders_Link);
		clickOn(OR.Order_status_dropdown);
		clickOn(OR.Order_PO_StatusDropdown_Assigned);
		clickOn(OR.Order_PO_SearchBtn);
		waitTime(10);
		clickOn(OR.Order_PO_first_dropdown);
		waitTime(10);
		if (driver.findElements(By.xpath("(//a[text()='Invoices'])[1]")).size() != 0)
		  {
		   WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		   Actions action = new Actions(driver);
		   action.moveToElement(element).build().perform();
		   clickOn(OR.Order_PO_first_Addinvoice);
		   getText(OR.Order_PO_Invoice_Header);
		  
		  } 
	}
//			else if (driver.findElements(By.xpath("(//a[text()='Invoices'])[1]")).size() == 0) 
//		  {
//		   clickOn(OR.Order_status_dropdown);
//		   clickOn(OR.Order_PO_StatusDropdown_Confirmed);
//		   clickOn(OR.Order_PO_SearchBtn);
//		   waitTime(10);
//		   clickOn(OR.Order_PO_first_dropdown);
//		   waitTime(10);
//		   if (driver.findElements(By.xpath("(//a[text()='Invoices'])[1]")).size() != 0) {
//		    WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
//		    Actions action = new Actions(driver);
//		    action.moveToElement(element).build().perform();
//		    clickOn(OR.Order_PO_first_Addinvoice);
//		    getText(OR.Order_PO_Invoice_Header);
//		   }
//		  }
		//clickOn(OR.Request_InvoicePageLink);
		//verifyElementText(OR., "");
		
		
//		}
		
		
	}	
		

