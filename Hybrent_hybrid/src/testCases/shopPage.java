package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.LoginPage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.genericKeywords;

public class shopPage extends ApplicationKeyword{
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
	public void Tc_Shop_1() throws InterruptedException
	{
		testStarts("Tc_Shop_1", "Verify that only ACTIVE items are appearing on page.");
		openBrowser	(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		verifyPageTitle("Dashboard");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/inventory']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.manageInvenLink);
		waitForElementToDisplay(OR.manageInventory_waitforelements, 60);
		verifyPageTitle("Manage Inventory : List");
		System.out.println(driver.getTitle());
		selectFromDropdown(OR.manage_stsusDropdwn, "InActive");		           
		clickOn(OR.manage_searchButton);
		waitForElementToDisplay(OR.manage_inactiveitem, 60);
		String InactiveItemab=getText(OR.manage_inactiveitem);
		System.out.println(InactiveItemab);
		WebElement element2 = driver.findElement(By.xpath("//*[@href='#/shop']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element2);
		clickOn(OR.Shop_Menu);
		waitForElementToDisplay(OR.Shop_searchfield, 60);
		typeIn(OR.Shop_searchfield, InactiveItemab);
		waitForElementToDisplay(OR.Shop_ifnoItemfield, 60);
		verifyElementText(OR.Shop_ifnoItemfield, "No Item Found");
		closeBrowser();
	}
	
	@Test
	public void Tc_Shop_2_3()
	{
		testStarts("Tc_Shop_2 and Tc_Shop_3()" , "Verify that “Select Facility” pop up appears when user clicks on facility name with “Shopping for” label"
				+ " Verify that “selected” button appears as disabled for the facility which is displayed on Shop page.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		String facility_Name=getText(OR.Shop_SHopfor_getfacilityName);
		System.out.println(facility_Name);
		clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
		waitForElementToDisplay(OR.Shop_SHopfor_Shopfaclity, 60);
		verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");

		waitForElementToDisplay(OR.Shop_countoffacilities, 60);
		int one = driver.findElements(By.xpath("//*[@style='border-right: none;vertical-align: middle;']")).size();
		System.out.println(one);
		boolean facFound=false;
		String xpath;
		String selectedFacility;
		WebElement btn;
		for(int i=1; i<=one; i++)
		{
			xpath="(//table[@class='table table-responsive table-striped table-bordered']/tbody/tr["+i+"]";
			selectedFacility=driver.findElement(By.xpath(xpath+"/td)")).getText();               
			System.out.println(selectedFacility);
			if(selectedFacility.equals(facility_Name))
			{  
				facFound=true;
				btn= driver.findElement(By.xpath(xpath+"/td[2]/div/button)"));
				if(btn.getAttribute("disabled")!=null)
				{
					testLogPass("Go the text '"+selectedFacility+ "' Matches with selected Facility" );
				}
				else
				{
					testLogFail("'" + facility_Name + "' is not selected in popup." );
				}
				break;
			}

		}
		if(!facFound)
		{
			testLogFail("Could not Got the text '"+facility_Name+ "' Matches with selected Facility" );
		}
		clickOn(OR.Shop_SHopfor_cancelButtonPopup);
		closeBrowser();
	}

	@Test
	public void Tc_Shop_4() throws InterruptedException
	{
		testStarts("Tc_Shop_4" , "Verify that user can search item on basis of “Item Name, SKU, MFR” and Vendor filter..");
		openBrowser(URL);
		LoginPage.login(UserName, Password);

		waitForElementToDisplay(OR.Shop_Menu, 60);
		
//		ItemDescription = "ItemDes"+ApplicationKeyword.randomAlphaNumeric(4);
//		ItemMfrNumber = "ItemMfrNumber"+ApplicationKeyword.randomAlphaNumeric(4);
//		ItemTestID = "ItemTestID"+ApplicationKeyword.randomAlphaNumeric(4);
//		SkuName = "sku"+ApplicationKeyword.randomAlphaNumeric(4);
//		verifyPageTitle("Dashboard");
//		clickOn(OR.DashBoard_AdminDropdown);
//		clickOn(OR.Admin_ItemCatalog);
//		waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);
//		clickOn(OR.ItemCatalog_AddItem);
//		typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, ItemDescription);
//		typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, ItemMfrNumber);
//		typeIn(OR.ItemCatalog_AddItme_TestId, ItemTestID);
//		clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
//		clickOn(OR.ItemCatalog_AddItem_Man_Select);
//		clickOn(OR.ItemCatalog_VendorsTab);
//		clickOn(OR.ItemCatalog_AddVendors);
//		clickOn(OR.ItemCatalog_Add_Vendorsname);
//		waitForElementToDisplay(OR.ItemCatalog_AddItem_VendorSelect_First, 60);
//		clickOn(OR.ItemCatalog_AddItem_VendorSelect_First);
//		typeIn(OR.ItemCatalog_Add_VendorsSkuName, SkuName);
//		typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty, "3");
//		vendor_Name=getText(OR.ItemCatalog_firstvendor);
//		System.out.println(vendor_Name);
//		clickOn(OR.ItemCatalog_AddItem_Man_Save);
//		waitForElementToDisplay(OR.ItemCatalog_AddItem_MapValidation, 60);
//		verifyElementText(OR.ItemCatalog_AddItem_MapValidation, "Do you want to map this item to your various facilities?");
//		clickOn(OR.ItemCatalog_AddItem_MapValidation_yes);
//		getText(OR.ItemCatalog_AddItem_Map_Header);
//		verifyElementText(OR.ItemCatalog_AddItem_Map_SearchFacility_Text, "Search Facility");
//		clickOn(OR.ItemCatalog_mapallbuttontopright);
//		clickOn(OR.ItemCatalog_mapwithalltopright);
//		waitForElementToDisplay(OR.ItemCatalog_verifytextpopup, 60);
//		verifyElementText(OR.ItemCatalog_verifytextpopup, "Map with all facilities");
//		typeIn(OR.ItemCatalog_purchaseprice, "60");
//		clickOn(OR.ItemCatalog_mapallbutton);
//		waitForElementToDisplay(OR.ItemCatalog_AddItem_Map_Closepage, 60);
//		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);
		clickOn(OR.Shop_Menu);
//		waitForElementToDisplay(OR.Shop_SHopfor_SearchBox, 15);
//		//selectFromDropdown(OR.Shop_SHopfor_Search_Match, "Exact match");
//		waitForElementToDisplay(OR.Shop_SHopfor_Search_itemdesc, 15);
		typeIn(OR.Shop_SHopfor_SearchBox,ItemDescription);
		String itemname=getAttributeValue(OR.Shop_SHopfor_Search_itemdesc, "name");

		if(itemname.equals(ItemDescription))
		{
			testLogPass("Same item is searched '"+itemname+ "' on cart page" );
		}
		else
		{
			testLogFail("Same item is not searched '"+itemname+ "' on cart page" );
		}

		//        //search by sku
		clearEditBox(OR.Shop_SHopfor_SearchBox);
		waitForElementToDisplay(OR.Shop_SHopfor_SearchBox, 15);

		typeIn(OR.Shop_SHopfor_SearchBox,SkuName);
		//waitForElementToDisplay(OR.Shop_SHopfor_Search_skuName, 10);
		String skuaftersearch=getText(OR.Shop_SHopfor_Search_skuName);
		//        
		if(skuaftersearch.equals(SkuName))
		{
			testLogPass("Same item is searched '"+skuaftersearch+ "' on cart page" );

		}
		else
		{
			testLogFail("Same item is not searched '"+skuaftersearch+ "' on cart page" );
		}

		//        //search with mfr#
		clearEditBox(OR.Shop_SHopfor_SearchBox);
		waitForElementToDisplay(OR.Shop_SHopfor_SearchBox, 15);

		//search with vendor name
		System.out.println(vendor_Name);
		selectFromDropdown(OR.Shop_VendorSelect, vendor_Name);

		waitForElementToDisplay(OR.Shop_SHopfor_SearchBox, 15);
		String vendoraftersearch=getText(OR.Shop_SHopfor_SelectfirstItemvendorName);
		//        
		if(vendoraftersearch.equals(vendor_Name))
		{
			testLogPass("Same item is searched '"+vendoraftersearch+ "' on cart page" );

		}
		else
		{
			testLogFail("Same item is not searched '"+vendoraftersearch+ "' on cart page" );
		}
		//Thread.sleep(4000);
		closeBrowser();

	}
	@Test
	public void Tc_Shop_5()
	{
		testStarts("Tc_Shop_5" , "Verify that user can switch between following tabs using corresponding radio button.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_RecentlyOrderedradiobutton);
		verifyElementText(OR.Shop_SHopfor_LastorderedText, "Last Ordered");
		clickOn(OR.Shop_SHopfor_MostOrderedradiobutton);
		verifyElementText(OR.Shop_SHopfor_PoCountText, "PO Count");      	
		clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
		verifyAttribute(OR.Shop_SHopfor_favtab, "ng-if", "isFavorite");		
		clickOn(OR.Shop_SHopfor_MyInventoryradiobutton);
		verifyAttribute(OR.Shop_SHopfor_myInventoryFavTab, "ng-if", "!isFavorite");	
		closeBrowser();
	}


	@Test
	public void Tc_Shop_6()
	{
		testStarts("Tc_Shop_6" , "Verify that 'All fields' dropdwon appears with following options.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		clickOn(OR.Shop_Menu);
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Shop_orgPage);
		clickOn(OR.Shop_FeaturesPage);
		String crossWalkclass=getAttributeValue(OR.orgsetting_crosswalk, "class");
		boolean orgSettingActive=false;
		String crosswalkIDText="";
		if(crossWalkclass.contains("not-empty"))
		{
			//to get the text in input tag
			crosswalkIDText=getAttributeValue(OR.orgsetting_crosswalktext, "value");	
			testLogInfo("CrosswalkID Toggle is Active with value "+ crosswalkIDText);
			orgSettingActive=true;
		}
		else if(crossWalkclass.contains("ng-empty"))
		{
			testLogInfo("CrosswalkID Toggle is not Active");
		}
		waitForElementToDisplay(OR.Shop_Menu, 60);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_allFieldsBtn);
		List<String> exp = new ArrayList<String>( Arrays.asList("SKU", "Mfr Number", "Description", "Quick code", "You can select maximum 2 keys for search."));
		if(orgSettingActive)
		{
			exp.add(crosswalkIDText);
		}
		List<WebElement> options = driver.findElements
				(By.xpath("//ul[@class='dropdown-menu dropdown-menu-form']/li[@role='presentation']"));
		boolean itemFound;
		if(options.size() == exp.size())
		{
			for(String lm:exp)
			{
				itemFound=false;
				for(WebElement we:options)  
				{	
					if(we.getText().toLowerCase().trim().equals(lm.toLowerCase()))
					{
						itemFound=true;
						break;
					}
				}

				if(itemFound)
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
	public void Tc_Shop_7()
	{
		testStarts("Tc_Shop_7" , "Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		//waitForElementToDisplay(OR.Shop_SHopfor_waitdrilldownicon, 60);  
		clickOn(OR.Shop_SHopfor_showTourText);
		//Since the xpath is relative to text of the element, we do not need to compare the text again. 
		//No need for explicit messages because method 'getText' implicitly does messaging on the basis of whether text found or not.
		getText(OR.Shop_SHopfor_showtourtextONPOPUP);
		//Since getText would automatically initialize genericKeyword class' static variable webElement, we can use same variable further
		//Since as per current structure of the page, xpath is not possible for finding out buttons,
		//because there are so many elements with same structure, so we will find parent of the search elem and then find buttons relative to the parent.
		WebElement searchParent = genericKeywords.webElement.findElement(By.xpath(".."));
		List<WebElement> btns = searchParent.findElements(By.tagName("button"));
		if(btns == null || btns.size() == 0)
		{
			testLogFail("No buttons found in tour popup.");
		}
		else
		{
			String nextBtnText=btns.get(0).getText();
			if(nextBtnText.contains("Next"))
			{
				testLogPass("Successfully Matched the Text 'Next' with button '" + nextBtnText + "'");
			}
			else
			{
				testLogFail("Could not match Text 'Next' with button '" + nextBtnText + "'");
			}
			
			String endBtnText=btns.get(1).getText();
			if(endBtnText.contains("End tour"))
			{
				testLogPass("Successfully Matched the Text 'End tour' with button '" + endBtnText + "'");
			}
			else
			{
				testLogFail("Could not match Text 'End tour' with button '" + endBtnText + "'");
			}		
			
			btns.get(1).click();
			testLogInfo("Click on :End tour");
		}
		
		closeBrowser();
	}  	
	
	@Test
	public void Tc_Shop_08()
	{
		testStarts("Tc_Shop_8", "Verify that user can switch between table view and grid view using \"view type\" option in the dropdown.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);	
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		mouseOver(OR.Shop_mouseoverviewtype);
		clickOn(OR.Shop_gridView);
		waitForElementToDisplay(OR.Shop_SHopfor_drilldownicon, 30);
		if(isElementPresent(By.xpath("//div[@id='isotopeContainer']")))
		{
			testLogPass("Successfully changed to GRID View");
		}
		else
		{
			testLogFail("View is not changed to GRID view");
		}
		clickOn(OR.Shop_SHopfor_drilldownicon);
		mouseOver(OR.Shop_mouseoverviewtype);
		clickOn(OR.Shop_tableview);

		waitForElementToDisplay(OR.Shop_SHopfor_drilldownicon, 30);
		
		if(!isElementPresent(By.xpath("//div[@id='isotopeContainer']")))
		{
			testLogPass("Successfully changed to TABLE View");
		}
		else
		{
			testLogFail("View is not changed to TABLE view");
		}

		closeBrowser();
	}
	
	@Test
	public void Tc_Shop_09()
	{
		testStarts("Tc_Shop_9" , "Verify that \"Configure Shop Layout\" pop up appears when user clicks on change current layout.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		clickOn(OR.Shop_drilldownCreateLayout);
		typeIn(OR.Shop_drilldownLayoutNameText, "autolayout");
		String NameofLayout="Configure Shop Layout "+"autolayout";
		clickOn(OR.Shop_drilldownCreateLayoutSave);
		clickOn(OR.Shop_drilldownCreateLayoutSave);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		clickOn(OR.Shop_drilldownChangeLayout);
		waitForElementToDisplay(OR.Shop_drilldownChangeLayoutPopup, 30);
		String actualName=getText(OR.Shop_changeLayoutTextPopUP);
		if(NameofLayout.equalsIgnoreCase(actualName))
		{
			testLogPass("User has opened Change layout Pop up with name "+ actualName);
			
		}
		clickOn(OR.Shop_drilldownChangeLayoutClose);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		mouseOver(OR.Shop_drilldownLayouts);
		clickOn(OR.Shop_drilldownRemoveLayout);
		clickOn(OR.Shop_drilldownRemoveLayoutYes);
		waitForElementToDisplay(OR.Shop_SHopfor_drilldownicon, 30);
		closeBrowser();
	}

	@Test
	public void Tc_Shop_10()
	{
		testStarts("Tc_Shop_10" , "Verify that \"Layout\" pop up appears when user clicks on on Create new layout or copy current layout option..");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		clickOn(OR.Shop_drilldownCreateLayout);	
		verifyElementText(OR.Shop_SHopfor_Layoutpopup, "Layout");		
		clickOn(OR.Shop_SHopfor_Layoutpoupclose);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		clickOn(OR.Shop_SHopfor_copyLayoutpoup);		
		verifyElementText(OR.Shop_SHopfor_Layoutpopup, "Layout");
		clickOn(OR.Shop_SHopfor_Layoutpoupclose);
		
		closeBrowser();
	}
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}
	
}
