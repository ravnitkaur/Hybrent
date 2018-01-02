package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pageObject.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.genericKeywords;

import org.testng.annotations.BeforeClass; 


public class testCases extends ApplicationKeyword{
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
		        public void Tc_POC_001()
		        {
		            testStarts("Tc_Login_001", "Verify the field displays correctly in login page");
	
		            // verifyLinkText(OR.Login_Moreinfo_linktext);
		            openBrowser(URL);
		            verifyPageTitle("Hybrent");
		            verifyElement(OR.HeaderLogo);
		            verifyElementText(OR.Label_username, "User Name:  ");
		            verifyElementText(OR.Label_password, "Password:");
		            typeIn(OR.Login_Username, "admin");
		            typeIn(OR.Login_Password, "goouser");
		            clickOn(OR.Login_Submit);
	
	
		            verifyPageTitle("Dashboard");
		            clickOn(OR.DashBoard_AdminDropdown);
		            clickOn(OR.Admin_ItemCatalog);
	            verifyPageTitle("Items Catalog : List");
		            clickOn(OR.ItemCatalog_AddItem);
		            typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, "Testing");
		            typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, "mrf-Testing-101");
		            clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
		            clickOn(OR.ItemCatalog_AddItem_Man_Select);
		            clickOn(OR.ItemCatalog_AddItem_Man_Save);
	
		        }
	
		       @Test
		        public void Tc_Login_001()
		        {
		            testStarts("Tc_Login_001", "Verify that system does not allow user to Login with “Invalid Credentials”");
		            openBrowser(URL);
		            LoginPage.login("dsds", "dsdskjk");
		            waitForElementToDisplay(OR.Login_Error, 60);
		            verifyElement(OR.Login_Error);
		            verifyElementText(OR.Login_Validation, "Invalid user name or password.");
		            verifyElement(OR.Login_Error);
		            waitForElementToDisplay(OR.Login_okay, 60);
		            clickOn(OR.Login_okay);
		            closeBrowser();
		        }
	
		       @Test
		        public void Tc_Login_002()
		        {
		            testStarts("Tc_Login_002", "Verify that system allows user to Login with 'Valid Credentials'");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.Shop_Menu, 60);
		            verifyPageTitle("Dashboard");
		            closeBrowser();
		        }
	
		       @Test
		        public void Tc_Dashboard_001()
		        {
		            testStarts("Tc_Dashboard_001, Tc_Dashboard_003",  "Verify that recent notifications appear on clicking Notification (bell) icon button.\n"
		            		+ "Verify that user gets redirected to “My Notifications” page, on clicking “View All” button\"");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.Notification_Bell, 60);
		            clickOn(OR.Notification_Bell);
		            Dashboard.NotificationCount();
		            closeBrowser();
		        }
	
		       @Test
		        public void Tc_Dashboard_002()
		        {
		            testStarts("Tc_Dashboard_002", "Verify that user gets redirected to “Notification Settings” page, on clicking “Notification Settings” button");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.User, 60);
		            clickOn(OR.User);
		            waitForElementToDisplay(OR.User_NotificationSetting, 60);
		            clickOn(OR.User_NotificationSetting);
		            Dashboard.verificationNotificationPage();
		            closeBrowser();
		        }
		       @Test
		        public void Tc_Dashboard_003()
		        {
		            testStarts("Tc_Dashboard_003", "Verify that user gets redirected to “My Notifications” page, on clicking “View All” button");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.Notification_Bell, 60);
		            clickOn(OR.Notification_Bell);
		            
		            clickOn(OR.Notification_ViewAll);
	
		        }
	
		       @Test
		        public void Tc_Dashboard_004()
		        {
		            testStarts("Tc_Dashboard_004", "Verify that user is redirected to Cart page on clicking Shopping Cart icon button.");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.MyCart, 60);
		            MycartPage.verificationMycartPage();
		            closeBrowser();
		        }
	
		       @Test
		       public void Tc_Dashboard_005()
		        {
		            testStarts("Tc_Dashboard_005", "Verify that user gets redirected to “Profile” page, on clicking Profile button.");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.User, 60);
		            clickOn(OR.User);
		            waitForElementToDisplay(OR.User_Profile, 60);
		            clickOn(OR.User_Profile);
		            profilePage.profileverification();
		            closeBrowser();
		        }
	
		       @Test
		        public void Tc_Dashboard_007()
		        {
		            testStarts("Tc_Dashboard_007", "Verify that user gets redirected to user alerts page on clicking  alerts option..");
		            openBrowser(URL);
		            LoginPage.login(UserName, Password);
		            waitForElementToDisplay(OR.User, 60);
		            clickOn(OR.User);
		            waitForElementToDisplay(OR.User_alert, 60);
		            clickOn(OR.User_alert);
		            Alertpage.VerifyAlert();
		            closeBrowser();
		        }
	
//		       @Test
//		        public void Tc_Dashboard_008()
//		        {
//		            testStarts("Tc_Dashboard_008", "Verify that “Pending Survey” pop up appears when user clicks on survey option.");
//		            openBrowser(URL);
//		            LoginPage.login(UserName, Password);
//		            waitForElementToDisplay(OR.User, 60);
//		            clickOn(OR.User);
//		            clickOn(OR.User_Survey);
//		            surveyPage.VerifySurvey();
//		            closeBrowser();
//		        }
//	
//		       @Test
//		        public void Tc_Dashboard_009()
//		        {
//		            testStarts("Tc_Dashboard_009", "Verify that “Change Password” pop up appears when user clicks on Change Password option.");
//		            openBrowser(URL);
//		            LoginPage.login(UserName, Password);
//		            waitForElementToDisplay(OR.User, 60);
//		            clickOn(OR.User);
//		            clickOn(OR.User_ChangePassword);
//		            ChangePasswordPage.VerifyChangePassword();
//		            closeBrowser();
//		        }
//	
//		       @Test
//		        public void Tc_Dashboard_010()
//		        {
//		            testStarts("Tc_Dashboard_010", "Verify that “Select user to login” screen appears when user clicks on switch user option.");
//		            openBrowser(URL);
//		            LoginPage.login(UserName, Password);
//		            waitForElementToDisplay(OR.User, 60);
//		            clickOn(OR.User);
//		            clickOn(OR.User_SwitchUser);
//		            SwitchUserpage.VerifySwitchUser();
//		            closeBrowser();
//		        }
//	
//		       @Test
//		        public void Tc_Dashboard_011()
//		        {
//		            testStarts("Tc_Dashboard_011", "Verify that user gets redirected to corresponding Report on clicking View More Reports button.");
//		            openBrowser(URL);
//		            LoginPage.login(UserName, Password);
//		            Reports.VerifyViewReport();
//		            closeBrowser();
//		        }
//	
//		       @Test
//		        public void Tc_Dashboard_012()
//		        {
//		            testStarts("Tc_Dashboard_012", "Verify that relevant data appears under Monthly Purchase Order Value, Number of Backorders and Vendor Performance sections");
//		            openBrowser(URL);
//		            LoginPage.login(UserName, Password);
//		            Dashboard.MonthlyReport();
//		            Dashboard.PartialReviews();
//		            Dashboard.Avgperformance();
//		            closeBrowser();
//		        }
//	
//		       @Test
//		        public void Tc_Dashboard_013()
//		        {
//		            testStarts("Tc_Dashboard_013, Tc_Dashboard_014, Tc_Dashboard_015", "Verify that “Recent Orders” and “News & Events” sections appear on Page.\n"
//		            		+"Verify that user gets redirected to corresponding news on clicking any news.\r\n" + 
//		            		"Verify that user gets redirected to corresponding PO details on clicking any PO link under \"“Recent Orders” section,\r\n" + 
//		            		"");
//		            openBrowser(URL);
//		            LoginPage.login(UserName, Password);
//		            Dashboard.PartialReviews();
//		            Dashboard.Avgperformance();
//		            Dashboard.VerifyOrders();
//		            driver.navigate().back();
//		            Dashboard.News();
//		            closeBrowser();
//		            Dashboard.verifyNews();
//		        }	      
	
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
		//	            clickOn(OR.DashBoard_AdminDropdown);
		//	            clickOn(OR.Admin_ItemCatalog);
		//	            waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);
		//	            verifyPageTitle("Items Catalog : List");


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



		//clickOn(OR.ItemCatalog_AddItem);
		//	            typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, "Rav-Test");
		//	            typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, "mrf101");
		//	            clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
		//	            clickOn(OR.ItemCatalog_AddItem_Man_Select);
		//	            clickOn(OR.ItemCatalog_VendorsTab);
		//	            clickOn(OR.ItemCatalog_AddVendors);
		//	            clickOn(OR.ItemCatalog_Add_Vendorsname);
		//	            clickOn(OR.ItemCatalog_Add_VendorsnameSelect);
		//	           typeIn(OR.ItemCatalog_Add_VendorsSkuName, "Aut01");
		//	           clickOn(OR.ItemCatalog_AddItem_Man_Save);  

	}
	//
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
		//	            Map<String, String> countofItems = new HashMap<String, String>();
		//	            String itemCountText;
		WebElement btn;
		for(int i=1; i<=one; i++)
		{


			//String facility=driver.findElement(By.xpath("(//*[@style='border-right: none;vertical-align: middle;'])["+i+"]")).getText();
			xpath="(//table[@class='table table-responsive table-striped table-bordered']/tbody/tr["+i+"]";
			selectedFacility=driver.findElement(By.xpath(xpath+"/td)")).getText();

			//	                itemCountText=driver.findElement(By.xpath(xpath+"/td[2]/div/span)")).getText();
			//	                //itemCountText=itemCountText.substring(1,1); 
			//	                System.out.println(itemCountText);
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
		//adding new item
		ItemDescription = "ItemDes"+ApplicationKeyword.randomAlphaNumeric(4);
		ItemMfrNumber = "ItemMfrNumber"+ApplicationKeyword.randomAlphaNumeric(4);
		ItemTestID = "ItemTestID"+ApplicationKeyword.randomAlphaNumeric(4);
		SkuName = "sku"+ApplicationKeyword.randomAlphaNumeric(4);


		//  openBrowser(URL);
		//  LoginPage.login(UserName, Password);
		//waitForElementToDisplay(OR.Shop_Menu, 60);
		verifyPageTitle("Dashboard");
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Admin_ItemCatalog);
		waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);

		clickOn(OR.ItemCatalog_AddItem);
		typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, ItemDescription);
		typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, ItemMfrNumber);
		typeIn(OR.ItemCatalog_AddItme_TestId, ItemTestID);
		clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
		clickOn(OR.ItemCatalog_AddItem_Man_Select);
		clickOn(OR.ItemCatalog_VendorsTab);
		clickOn(OR.ItemCatalog_AddVendors);



		clickOn(OR.ItemCatalog_Add_Vendorsname);

		//        String VendorName=getText(OR.ItemCatalog_Add_Vendorsname);
		waitForElementToDisplay(OR.ItemCatalog_AddItem_VendorSelect_First, 60);
		clickOn(OR.ItemCatalog_AddItem_VendorSelect_First);
		typeIn(OR.ItemCatalog_Add_VendorsSkuName, SkuName);
		typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty, "3");

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

		//typeIn(OR.ItemCatalog_popupFAcilitySearch, facility_Name);  
		// clickOn(OR.ItemCatalog_popupFAcilitySearchbutton);
		//waitForElementToDisplay(OR.ItemCatalog_wait_untilsearch,60); 
		//clickOn(OR.ItemCatalog_AddItem_Map_AddFacility);

		//typeIn(OR.ItemCatalog_AddItem_Map_PurchagePrice, "60");
		//typeIn(OR.ItemCatalog_AddItem_Map_GPOPurchagePrice, "10");
		//clickOn(OR.ItemCatalog_AddItem_Map_GPOPurchagePriceSave);
		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);
		//WebElement btn=driver.findElement(By.xpath(//button[@class='close'));
		clickOn(OR.Shop_Menu);
		waitForElementToDisplay(OR.Shop_SHopfor_SearchBox, 15);

		selectFromDropdown(OR.Shop_SHopfor_Search_Match, "Exact match");
		waitForElementToDisplay(OR.Shop_SHopfor_Search_itemdesc, 15);
		//        //search the added item on shop page
		typeIn(OR.Shop_SHopfor_SearchBox,ItemDescription);
		//waitForElementToDisplay(OR.Shop_SHopfor_Search_itemdesc, 15);
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
		verifyElementText(OR.Shop_SHopfor_ResultGridTab, "Last Ordered");

		clickOn(OR.Shop_SHopfor_MostOrderedradiobutton);
		verifyElementText(OR.Shop_SHopfor_ResultGridTab, "PO Count");

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
			System.out.println("entered");
			exp.add(crosswalkIDText);
		}

		List<WebElement> options = driver.findElements
				(By.xpath("//ul[@class='dropdown-menu dropdown-menu-form']/li[@role='presentation']"));

		Boolean itemFound;
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
					testLogPass("Text '" + lm + "' does not exist in dropdown.");
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
		typeIn(OR.Shop_drilldownLayoutNameText, "---automation layout---");
		clickOn(OR.Shop_drilldownCreateLayoutSave);
		clickOn(OR.Shop_drilldownCreateLayoutSave);

		clickOn(OR.Shop_SHopfor_drilldownicon);
		clickOn(OR.Shop_drilldownChangeLayout);

		waitForElementToDisplay(OR.Shop_drilldownChangeLayoutPopup, 30);

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
	
	//---------------------------------------------CART PAGE STARTS--------------------------------------
	
	
	@Test
	public void Tc_Cart_1_2()
	{
		testStarts("Tc_Cart_1 and Tc_Cart_2()" , "Verify that “Select Facility” popup appears when user clicks on facility name with “Cart for” label."
				+ " Verify that “selected” button appears as disabled for the facility which is displayed on Shop page.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		String facility_Name=getText(OR.Shop_SHopfor_getfacilityName);
		System.out.println(facility_Name);
		
		clickOn(OR.MyCart);
		clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
		waitForElementToDisplay(OR.Shop_SHopfor_Shopfaclity, 60);
		verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");

		waitForElementToDisplay(OR.Shop_countoffacilities, 60);
		int one = driver.findElements(By.xpath("//*[@style='border-right: none;vertical-align: middle;']")).size();
		System.out.println(one);
		boolean facFound=false;
		String xpath;
		String selectedFacility;
		//	            Map<String, String> countofItems = new HashMap<String, String>();
		//	            String itemCountText;
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
	public void Tc_Cart_15()
	{
		testStarts("Tc_Shop_15" ,"Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		verifyPageTitle("Dashboard");	
	}

	
	@Test
	public void addNewItem()
	{
	waitForElementToDisplay(OR.Shop_Menu, 60);
	//adding new item
	ItemDescription = "ItemDes"+ApplicationKeyword.randomAlphaNumeric(4);
	ItemMfrNumber = "ItemMfrNumber"+ApplicationKeyword.randomAlphaNumeric(4);
	ItemTestID = "ItemTestID"+ApplicationKeyword.randomAlphaNumeric(4);
	SkuName = "sku"+ApplicationKeyword.randomAlphaNumeric(4);


	//  openBrowser(URL);
	//  LoginPage.login(UserName, Password);
	//waitForElementToDisplay(OR.Shop_Menu, 60);
	verifyPageTitle("Dashboard");
	clickOn(OR.DashBoard_AdminDropdown);
	clickOn(OR.Admin_ItemCatalog);
	waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);

	clickOn(OR.ItemCatalog_AddItem);
	typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, ItemDescription);
	typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, ItemMfrNumber);
	typeIn(OR.ItemCatalog_AddItme_TestId, ItemTestID);
	clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
	clickOn(OR.ItemCatalog_AddItem_Man_Select);
	clickOn(OR.ItemCatalog_VendorsTab);
	clickOn(OR.ItemCatalog_AddVendors);



	clickOn(OR.ItemCatalog_Add_Vendorsname);

	//        String VendorName=getText(OR.ItemCatalog_Add_Vendorsname);
	waitForElementToDisplay(OR.ItemCatalog_AddItem_VendorSelect_First, 60);
	clickOn(OR.ItemCatalog_AddItem_VendorSelect_First);
	typeIn(OR.ItemCatalog_Add_VendorsSkuName, SkuName);
	typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty, "3");

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

	
	}
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}
}
