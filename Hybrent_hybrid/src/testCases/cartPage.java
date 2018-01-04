package testCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.LoginPage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.genericKeywords;

public class cartPage extends ApplicationKeyword{
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
	public void Tc_Cart_03() throws InterruptedException
	{
		testStarts("Tc_Cart_03" ," Verify that user can search/scan with “Item Name, SKU, MFR” in the Add Item search field..");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription );
		String ItemName=getText(OR.MyCart_firstItemName);
		System.out.println(ItemName);
		waitForElementToDisplay(OR.MyCart_firstItemName, 15);
		if(ItemName.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with " + ItemName);
		}
		else
		{
			testLogFail("Item is not searched with " + ItemName);			
		}
		clearEditBox(OR.MyCart_searchInCart);
		waitForElementToDisplay(OR.MyCart_searchInCart, 15);
		typeIn(OR.MyCart_searchInCart,SkuName);
		waitForElementToDisplay(OR.MyCart_searchInCart, 15);
		String getskuName=getText(OR.MyCart_firstItemSkuName);
		System.out.println(getskuName);
		waitForElementToDisplay(OR.MyCart_firstItemName, 15);
		if(getskuName.equalsIgnoreCase(SkuName))
		{
			testLogPass("Item is searched with " + SkuName);
		}
		else
		{
			testLogFail("Item is not searched with " + SkuName);			
		}	
		clearEditBox(OR.MyCart_searchInCart);
		waitForElementToDisplay(OR.MyCart_searchInCart, 15);
		typeIn(OR.MyCart_searchInCart,ItemMfrNumber);
		waitForElementToDisplay(OR.MyCart_searchInCart, 15);
		String ItemNameforManufctr=getText(OR.MyCart_firstItemName);
		waitForElementToDisplay(OR.MyCart_firstItemName, 15);
		if(ItemName.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with " + ItemMfrNumber);
		}
		else
		{
			testLogFail("Item is not searched with " + ItemMfrNumber);			
		}	
		//clickOn(OR.MyCart_addItemInCart);
		closeBrowser();		
	}

	@Test
	public void Tc_Cart_05() throws InterruptedException
	{
		testStarts("Tc_Cart_05" ," Verify that user can search/scan with “Item Name, SKU, MFR” in the Add Item search field..");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		
		waitForElementToDisplay(OR.MyCart_drillDown, 10);	
		checkIfCartIsEmpty();
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		waitForElementToDisplay(OR.MyCart_firstItemName, 15);
		clickOn(OR.MyCart_addItemInCart);
		String qtyBeforeIncrease=getText(OR.MyCart_qtyOfItemBeforeAfter);
		clickOn(OR.MyCart_plusIcon);
		String qtyAfterIncrease=getText(OR.MyCart_qtyOfItemBeforeAfter);	
  	  	int beforeplus_Items=Integer.parseInt(qtyBeforeIncrease);  
  	  	int after_plus=Integer.parseInt(qtyAfterIncrease);
  	  	int final_Items=beforeplus_Items+1;
  	  	if(after_plus==final_Items)
  	  	{
  	  		testLogPass("Item Qty is increased after clicking on + icon");
  	  		
  	  	}
  	  	else
  	  	{
  	  	testLogFail("Item Qty is not increased after clicking on + icon");
  	  		
  	  	}
  	 clickOn(OR.MyCart_minusIcon);
  	 Thread.sleep(4000);
  	 String qtyAfterdecrese=getText(OR.MyCart_qtyOfItemBeforeAfter);
  	 int intqtyafterDecrese=Integer.parseInt(qtyAfterdecrese);  
  	 if(intqtyafterDecrese==1)
	  	{
	  		testLogPass("Item Qty is decreased after clicking on - icon");  		
	  	}
	  	else
	  	{
	  		testLogFail("Item Qty is not decreased after clicking on + icon");		
	  	}
		clickOn(OR.MyCart_editItemQty);
		typeIn(OR.MyCart_editItemQtyTextBox, "10");
		clickOn(OR.MyCart_submitQty);
		
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		String qtyAftertypedQty=getText(OR.MyCart_qtyOfItemBeforeAfter);
		int afterQtyTypedIn=Integer.parseInt(qtyAftertypedQty); 
		Thread.sleep(3000);
		if(afterQtyTypedIn==110)
  	  	{
  	  		testLogPass("Item Qty is changed after entering QTY manually in text box"); 		
  	  	}
  	  	else
  	  	{
  	  		testLogFail("Item Qty is not changed after entering QTY manually in text box"); 		
  	  	}
		closeBrowser();
	}
	
	@Test
	public void Tc_Cart_06()
	{
		testStarts("Tc_Cart_06" ,"Verify that user is able to add “Special Instructions” for each vendor.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		//waitForElementToDisplay(OR.MyCart_firstItemName, 15);
		clickOn(OR.MyCart_addItemInCart);
		if(isElementDisplayed(OR.MyCart_SiTextBox, 15))
		{
			String typeTextManually="SI for Test";
			typeIn(OR.MyCart_SiTextBox, typeTextManually);
			String returnedValue=getAttributeValue(OR.MyCart_SiTextBox, "value");
			if(returnedValue.equals(typeTextManually))
			{
				testLogPass("SI added in the text Box");
			}
			else
			{
				testLogFail("SI is not added in the text Box");
				
			}
			
		}
		else
		{
			testLogFail("SI Text Box is not present");
			
		}
		closeBrowser();
		
	}
	
	@Test
	public void Tc_Cart_07()
	{
		testStarts("Tc_Cart_07" ,"Verify that user can manually add PO number by selecting “Use PO#” checkbox.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		
		//waitForElementToDisplay(OR.MyCart_drillDown, 10);		
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		//waitForElementToDisplay(OR.MyCart_firstItemName, 15);
		clickOn(OR.MyCart_addItemInCart);
		if(isElementPresent(By.xpath("//*[@ng-click='test_check(key)']")))
		{
			clickOn(OR.MyCart_UsemyPOCheckBox);
			String POMAnually="PO#1234";
			typeIn(OR.MyCart_typePONumber, POMAnually);
			
			String returnedValue=getAttributeValue(OR.MyCart_typePONumber, "value");
			if(returnedValue.equals(POMAnually))
			{
				testLogPass("PO number added in the text Box");
			}
			else
			{
				testLogFail("PO number is not added in PO box");				
			}			
		}
		else
		{
			testLogFail("PO field is not present");			
		}
	 closeBrowser();	
	}
	
	@Test
	public void Tc_Cart_08()
	{
		testStarts("Tc_Cart_08" ,"Verify that vendor gets removed from cart when user clicks on “Remove Vendor from cart” option in dropdown with vendor name.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_drillDownVendor);
		clickOn(OR.MyCart_removeVendor);
	    clickOn(OR.MyCart_confirmButton);
	    clickOn(OR.MyCart_confirmButton);			
		verifyElementText(OR.MyCart_emptycartText, "Your cart is Empty");	
		closeBrowser();
		
	}
	@Test
	public void Tc_Cart_09()
	{
		testStarts("Tc_Cart_09" ," “Verify that users gets redirected to “Vendors Account Setup” on clicking “ Account Setup. ");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart, "ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);	
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_drillDownVendor);
		clickOn(OR.MyCart_accountSetUp); 
		waitForElementToDisplay(OR.MyCart_vendorAccountSetUp, 10);
		verifyPageTitle("Vendors Account Setup");		
		closeBrowser();		
	}
	
	@Test
	public void Tc_Cart_10()
	{
		testStarts("Tc_Cart_10" ,"Verify that “Departments” pop up appears when user clicks on Attach  department hyperlink.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);	
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_AddDepartmenthyperLink);
		waitForElementToDisplay(OR.MyCart_AddDepartmentText, 10);
		verifyElementText(OR.MyCart_AddDepartmentText, "Departments");
//		String departmentText=getText(OR.MyCart_AddDepartmentText);
//		System.out.println(departmentText);
//		if(departmentText.equals("Departments"))
//		{
//			testLogPass("Department Pop up is shown");			
//		}
//		else
//		{
//			testLogFail("Department Pop up is not shown");			
//		}
		closeBrowser();	
	}
	@Test
	public void Tc_Cart_12()
	{
		testStarts("Tc_Cart_12" ,"Verify that “Departments” pop up appears when user clicks on Attach  department hyperlink.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);	
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_AddPhysicianhyperLink);
		waitForElementToDisplay(OR.MyCart_AddPhysicianText, 10);
		verifyElementText(OR.MyCart_AddPhysicianText, "Physicians");
		closeBrowser();
	
	}
	
	@Test
	public void Tc_Cart_11()
	{
		testStarts("Tc_Cart_11" ,"Verify that “Departments” pop up appears when user clicks on Attach  department hyperlink.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_drillDown);
		clickOn(OR.MyCart_PrintPO);
		waitForElementToDisplay(OR.MyCart_PrintPOPopUpText, 10);
		verifyElementText(OR.MyCart_PrintPOPopUpText, "Order Items SKU");
		closeBrowser();
	
	}
	

	
	@Test
	public void Tc_Cart_13()
	{
		testStarts("Tc_Cart_13" ,"Verify that when user clicks on “Clear Current cart”, items added in current facility gets cleared.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_drillDown);
		clickOn(OR.MyCart_clearCurrentCart);
		clickOn(OR.MyCart_yesInPopup);
		clickOn(OR.MyCart_OKInPopup);
		waitForElementToDisplay(OR.MyCart_emptycartText, 10);
		verifyElementText(OR.MyCart_emptycartText, "Your cart is Empty");
		closeBrowser();
	
	}
	
	@Test
	public void Tc_Cart_14()
	{
		testStarts("Tc_Cart_14" ,"Verify that when user clicks on “Clear all Cart”, items added in all facilities gets cleared..");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.Shop_Menu);
		String facility_Name=getText(OR.Shop_SHopfor_getfacilityName);
		System.out.println(facility_Name);
		clickOn(OR.MyCart);
		checkIfCartIsEmpty();	
		waitForElementToDisplay(OR.MyCart_cartIconNumber, 10);
		String s1=getText(OR.MyCart_cartIconNumber);
		int qtyInCartbefore=Integer.parseInt(s1);
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		clickOn(OR.MyCart_addItemInCart);
		waitForElementToDisplay(OR.MyCart_cartIconNumber, 10);
		String s2=getText(OR.MyCart_cartIconNumber);
		int qtyInCartAfter=Integer.parseInt(s2);
		if(qtyInCartAfter==(qtyInCartbefore+1))
		{
			testLogInfo( "One item is added to cart");
		}
		else
		{
			testLogInfo("Item qty is not increased");
		}
		clickOn(OR.MyCart_drillDown);
		clickOn(OR.MyCart_clearAllCarts);
		clickOn(OR.MyCart_yesInPopup);
		clickOn(OR.MyCart_OKInPopup);
		waitForElementToDisplay(OR.MyCart_emptycartText, 10);
		verifyElementText(OR.MyCart_emptycartText, "Your cart is Empty");
		clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
		waitForElementToDisplay(OR.Shop_SHopfor_Shopfaclity, 60);
		verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
		waitForElementToDisplay(OR.Shop_countoffacilities, 60);
				int one = driver.findElements(By.xpath("//*[@style='border-right: none;vertical-align: middle;']")).size();
				System.out.println(one);
				String xpath;
				String selectedFacility;
				//	            Map<String, String> countofItems = new HashMap<String, String>();
				String itemCountText;
//				WebElement btn;
				for(int i=1; i<=one; i++)
				{
					xpath="(//table[@class='table table-responsive table-striped table-bordered']/tbody/tr["+i+"]";
					selectedFacility=driver.findElement(By.xpath(xpath+"/td)")).getText();
//					System.out.println(selectedFacility);
					itemCountText=driver.findElement(By.xpath(xpath+"/td[2]/div/span)")).getText();
					System.out.println(itemCountText);
					String temp=itemCountText.substring(1,2);
					//System.out.println(temp);
					int qtyInFac=Integer.parseInt(temp);	
					System.out.println(qtyInFac);

					if(qtyInFac != 0)
					{  
						testLogFail(selectedFacility + "has" + qtyInFac + "items");
						break;
					}
				
					
				}

				if(facility_Name==null)
				{
					testLogFail("Could not Got the text '"+facility_Name+ "' Matches with selected Facility" );
				}

				clickOn(OR.Shop_SHopfor_cancelButtonPopup);
				closeBrowser();		
	}
	
	

	@Test
	public void Tc_Cart_15()
	{
		testStarts("Tc_Cart_15" ,"Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button.");
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		addNewItem();
		clickOn(OR.MyCart);
		if(!boolcheckCartIsEmpty())
		{
			clickOn(OR.MyCart_drillDown);
			clickOn(OR.MyCart_showTourButton);
			String s=getText(OR.MyCart_showtourtextONPOPUP);
			verifyElementText(OR.MyCart_showtourtextONPOPUP, "Cart: List of Items");
			
		}
		else
		{
		typeIn(OR.MyCart_searchInCart,"ItemDesc");
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		clickOn(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_drillDown);
		clickOn(OR.MyCart_showTourButton);
		String s=getText(OR.MyCart_showtourtextONPOPUP);
		
		}
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
	public void checkIfCartIsEmpty()
	{
		
		if(isElementDisplayed(OR.MyCart_drillDown, 15))
		{
			clickOn(OR.MyCart_drillDown);
			clickOn(OR.MyCart_clearCurrentCart);
			clickOn(OR.MyCart_yesInPopup);
			clickOn(OR.MyCart_OKInPopup);
		}
		else
		{
			testLogInfo("NO item is present in current cart");	
		}
		
	}
	
	public  boolean boolcheckCartIsEmpty()
	{
		
		if(isElementDisplayed(OR.MyCart_drillDown, 15))
		{
			return false;
		}
		
		return true;
	
	}
	
	
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
	clickOn(OR.ItemCatalog_AddItem_Map_Closepage);
//	clickOn(OR.Shop_Menu);
//	waitForElementToDisplay(OR.Shop_SHopfor_SearchBox, 15);
//
//	selectFromDropdown(OR.Shop_SHopfor_Search_Match, "Exact match");
//	waitForElementToDisplay(OR.Shop_SHopfor_Search_itemdesc, 15);
//	typeIn(OR.Shop_SHopfor_SearchBox,ItemDescription);
//	String itemname=getAttributeValue(OR.Shop_SHopfor_Search_itemdesc, "name");

	
	}
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}
}


