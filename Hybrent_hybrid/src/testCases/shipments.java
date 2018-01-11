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
import pageObject.shipment;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

import com.relevantcodes.extentreports.ExtentReports;

public class shipments  extends ApplicationKeyword
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
		public void Tc_SH_01() throws InterruptedException
		{
			testStarts("Tc_SPO_01", "Verify that user can search shipments by Shipment#, Tracking # and PO# ");
			openBrowser(URL);
			LoginPage.login(UserName, Password);
			shipment.InitialSteps();
			String ShipmentNum=getText(OR.Shipment_FirstShipmentNum);			
			String PoNum=getText(OR.Shipment_ShipmentPONum);			
			String TrackingNum=getText(OR.Shipment_TrackingNum);			
			typeIn(OR.Shipment_SearchTextBox, ShipmentNum); 
			shipment.searchAndWait();			
			verifyElementText(OR.Shipment_FirstShipmentNum, ShipmentNum);
			shipment.clearAndWait();
			typeIn(OR.Shipment_SearchTextBox, PoNum); 
			shipment.searchAndWait();
			verifyElementText(OR.Shipment_ShipmentPONum, PoNum );
			shipment.clearAndWait();
			typeIn(OR.Shipment_SearchTextBox, TrackingNum); 
			shipment.searchAndWait();
			verifyElementText(OR.Shipment_TrackingNum, TrackingNum);
			closeBrowser();
		}

		@Test
		public void Tc_SH_02() throws InterruptedException
		{
			testStarts("Tc_SH_02", "Verify that status dropdown appears with(Pending Shipped Partial Received Received) options");
			openBrowser(URL);
			LoginPage.login(UserName, Password);
			shipment.InitialSteps();			
			List<String> list = new ArrayList<String>( Arrays.asList("All", "Pending", "Shipped", "Partial Receive", "Received"));		
			List<WebElement> options = driver.findElements
					(By.xpath("//*[@id='sel1']/option"));	
			boolean textFound;
			if(options.size() == list.size())
			{
				for(String lm:list)
				{
					textFound=false;
					for(WebElement we:options)  
					{
						if(we.getText().trim().equals(lm))
						{
							textFound=true;
							
						}
					}
				

					if(textFound)
					{
						testLogPass("Text '" + lm + "' exists in dropdown.");
					}
					else
					{
						testLogFail("Text '" + lm + "' does not exist in dropdown.");
					}
				}
			}
			else
			{
				//fail because size is not equal
				testLogFail("Size of two arrayList is not equal");
			}
					closeBrowser();				
		}
		
		@Test
		public void Tc_SH_03() throws InterruptedException
		{
			testStarts("Tc_SH_03", "Verify that user gets redirected to shipment details screen on clicking “Shipment #”.");
			openBrowser(URL);
			LoginPage.login(UserName, Password);
			shipment.InitialSteps();
			String ShipmentNum=getText(OR.Shipment_FirstShipmentNum);
			clickOn(OR.Shipment_FirstShipmentNum);
			waitForElementToDisplay(OR.Shipment_ShipmentDetailPAge, 60);
			String DetailPageText=getText(OR.Shipment_ShipmentDetailPAge);
			if(DetailPageText.trim().contains("SHIPMENT#")&&DetailPageText.trim().contains(ShipmentNum))
			{
				testLogPass("Successfully matched the Text and User is redirected to Shipment detail page");
			}
			else
			{
				testLogFail("Successfully matched the Text and User is not redirected to Shipment detail page");
			}
		 closeBrowser();
		}
		
		@Test
		public void Tc_SH_04() throws InterruptedException
		{
			testStarts("Tc_SH_04", "Verify that “Receive” button appears for pending and Partial received shipments.”.");
			openBrowser(URL);
			LoginPage.login(UserName, Password);
			shipment.InitialSteps();
			selectFromDropdown(OR.Shipment_StatusDropDown, "Pending");
			shipment.searchAndWait();
			clickOn(OR.Shipment_FirstShipmentNum);
			shipment.receiveTextandCloseButton();
			waitForElementToDisplay(OR.Shipment_FirstShipmentNum, 60);
			selectFromDropdown(OR.Shipment_StatusDropDown, "Partial Receive");
			shipment.searchAndWait();
			clickOn(OR.Shipment_FirstShipmentNum);
			shipment.receiveTextandCloseButton();
			closeBrowser();
		}
		
		

@AfterTest
public void endReport(){
	//closeBrowser();
	extent.flush();
}
		
		
}
