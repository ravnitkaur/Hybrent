package testCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

import com.relevantcodes.extentreports.ExtentReports;

public class requestService extends ApplicationKeyword{
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
	public void Tc_SPO_01()
	{
		testStarts("Tc_SPO_01", "Verify that user can search service items on the basis of Item Name, alias, MFR, SKU in the search field.");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);	
		clickOn(OR.Request_MenuLink);
		verifyElementText(OR.Request_VendorText, "Vendor: ");	
		clickOn(OR.Request_vendorDropDown);	
		String lstElem=driver.findElement(By.xpath("//*[@id='vendor']/ul/li/div[contains(@id,'ui-select-choices-row-')]")).getText();	
		waitForElementToDisplay(OR.Shop_Menu, 60);
		//adding new item
		ItemDescription = "ItemDes"+ApplicationKeyword.randomAlphaNumeric(4);
		ItemMfrNumber = "ItemMfrNumber"+ApplicationKeyword.randomAlphaNumeric(4);
		ItemTestID = "ItemTestID"+ApplicationKeyword.randomAlphaNumeric(4);
		SkuName = "sku"+ApplicationKeyword.randomAlphaNumeric(4);
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Admin_ItemCatalog);
		waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);

		clickOn(OR.ItemCatalog_AddItem);
		typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, ItemDescription);
		typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, ItemMfrNumber);
		typeIn(OR.ItemCatalog_AddItme_TestId, ItemTestID);
		clickOn(OR.Request_isServicePOToggle);
		clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
		clickOn(OR.ItemCatalog_AddItem_Man_Select);
		clickOn(OR.ItemCatalog_VendorsTab);
		clickOn(OR.ItemCatalog_AddVendors);
		clickOn(OR.ItemCatalog_Add_Vendorsname);		        
		waitForElementToDisplay(OR.ItemCatalog_AddItem_VendorSelect_First, 60);
		clickOn(OR.ItemCatalog_AddItem_VendorSelect_First);		
		typeIn(OR.ItemCatalog_Add_VendorsSkuName, SkuName);
		typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty, "3");
		selectFromDropdown(OR.Request_Duration, "For One Time");
		vendor_Name=getText(OR.ItemCatalog_firstvendor);
		System.out.println(vendor_Name);
		clickOn(OR.ItemCatalog_AddItem_Man_Save);
		waitForElementToDisplay(OR.ItemCatalog_AddItem_MapValidation, 60);
		verifyElementText(OR.ItemCatalog_AddItem_MapValidation, "Do you want to map this item to your various facilities?");
		clickOn(OR.ItemCatalog_AddItem_MapValidation_yes);
		getText(OR.ItemCatalog_AddItem_Map_Header);
		verifyElementText(OR.ItemCatalog_AddItem_Map_SearchFacility_Text, "Search Facility");
		clickOn(OR.ItemCatalog_mapallbuttontopright);
		clickOn(OR.ItemCatalog_mapwithalltopright);
		//selectFromDropdown(OR.ItemCatalog_maptoAllfacilities, "Map with all facility");
		waitForElementToDisplay(OR.ItemCatalog_verifytextpopup, 60);
		verifyElementText(OR.ItemCatalog_verifytextpopup, "Map with all facilities");
		typeIn(OR.ItemCatalog_purchaseprice, "60");
		clickOn(OR.ItemCatalog_mapallbutton);
		waitForElementToDisplay(OR.ItemCatalog_AddItem_Map_Closepage, 60);	
		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);
		clickOn(OR.Request_MenuLink);
		waitForElementToDisplay(OR.Request_drillDown, 20);
		typeIn(OR.Request_searchBox, ItemDescription);
		
		waitForElementToDisplay(OR.Request_getItemName, 20);
		String ItemDescAfterSearch=getText(OR.Request_getItemName);
		System.out.println(ItemDescAfterSearch);
		if(ItemDescAfterSearch.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with Item Description");

		}
		else
		{
			testLogFail("Item is not searched with Item Description");

		}
		clearEditBox(OR.Request_searchBox);
		waitForElementToDisplay(OR.Request_searchBox, 20);
		typeIn(OR.Request_searchBox, SkuName);
		waitForElementToDisplay(OR.Request_getSkuName, 20);
		String skuAfterSearch=getText(OR.Request_getSkuName);
		if(skuAfterSearch.equalsIgnoreCase(SkuName))
		{
			testLogPass("Item is searched with sku");

		}
		else
		{
			testLogFail("Item is not searched with sku");

		}
		clearEditBox(OR.Request_searchBox);
		waitForElementToDisplay(OR.Request_searchBox, 20);
		typeIn(OR.Request_searchBox, ItemMfrNumber);
		waitForElementToDisplay(OR.Request_getSkuName, 20);
		if(ItemDescAfterSearch.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with mfr#");

		}
		else
		{
			testLogFail("Item is not searched with mfr#");

		}
		closeBrowser();
	}

	@Test
	public void Tc_SPO_02()
	{
		testStarts("Tc_SPO_02", "Verify that “Add Service” pop up appears when user clicks on Add New Service option. ");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		clickOn(OR.Request_MenuLink);
		waitForElementToDisplay(OR.Request_drillDown, 20);
		clickOn(OR.Request_drillDown);

		clickOn(OR.Request_createNewService);
		verifyElementText(OR.Request_createNewServicePopUpText, "Add Service");	
		closeBrowser();

	}
	@Test
	public void Tc_SPO_03()
	{
		testStarts("Tc_SPO_03", "Verify that Service location dropdown with department and facility appears on the page. ");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		clickOn(OR.Request_MenuLink);

		//if(isElementDisplayed(OR.Request_ServiceLocationText, 20))
		//{
			verifyElementText(OR.Request_ServiceLocationText, "Service Location:");	
			int one=driver.findElements(By.xpath("//select[@id='shippingLocation']//optgroup")).size();
			int two=driver.findElements(By.xpath("//select[@id='shippingLocation']//option")).size();
			testLogInfo("Number of Facilities in the DropDown is: "+ one);
			testLogInfo("Number of Departments in the DropDown is: "+ two);
			System.out.println(two);
		//}
				            
//		else
//		{
//			testLogFail("Service Location:  dropDown not present.");	
//
//		}				            
		closeBrowser();
	}


	@Test
	public void Tc_SPO_04()
	{
		testStarts("Tc_SPO_04", "Verify that Service Date field with calendar option appears on page. ");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		clickOn(OR.Request_MenuLink);
		//verifyElementText(OR.Request_ServiceDateText, "Service Date:");
		String s=getText(OR.Request_ServiceDateText);
		System.out.println(s);
		if(s.equals("Service date:"))
		{
			testLogPass("Service Date Text is Present on the page");
			
		}
		else
		{
			testLogFail("Service Date Text is notPresent on the page");
		}
		clickOn(OR.Request_CalenderIcon);
		
		if(isElementDisplayed(OR.Request_calenderIconAttribte))
		{
			testLogPass("Calender icon is Present on the page");
			
		}
		else
		{
			testLogFail("Calender icon is not Present on the page");
		}
		closeBrowser();

	}

	@Test
	public void Tc_SPO_05() throws InterruptedException
	{
		testStarts("Tc_SPO_05", " Verify that list of service vendor appears in the Vendor dropdown.");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		clickOn(OR.Request_MenuLink);
		verifyElementText(OR.Request_VendorText, "Vendor: ");	
		clickOn(OR.Request_vendorDropDown);	
		List<WebElement> lstElem=driver.findElements(By.xpath("//*[@id='vendor']/ul/li/div[contains(@id,'ui-select-choices-row-')]"));
		
		for(WebElement we:lstElem)
		{
			testLogPass("All the vendors in the Vendor DropDown are: "+ we.getText());
		}

	}
	@AfterTest
	public void endReport()
	{
		//closeBrowser();
		extent.flush();
	}


}
