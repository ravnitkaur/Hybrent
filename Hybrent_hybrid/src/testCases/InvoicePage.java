package testCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Invoices;
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
	public static String InvoiceName;
	public String InvoiceNum;

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
	public void Tc_INV_01() throws InterruptedException
	{
		testStarts("Tc_INV_01", "Verify that following dropdown filters(Vendor,Status,Search By ,Due Date,Facility,Departments,Ordered By	) appear on page");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		openBrowser(URL);
		LoginPage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);
		//get the By default Facility Name of USer	
		clickOn(OR.Orders_Link);
		
		clickOn(OR.Order_status_dropdown);
		clickOn(OR.Order_PO_StatusDropdown_Assigned);
		clickOn(OR.Order_PO_SearchBtn);
		String s=getText(OR.conditionForNoOrder);
		if (s.trim().equalsIgnoreCase("No Order Found"))
		{
			testLogInfo("Assigned State has no orders");
			clickOn(OR.Order_status_dropdown);
			clickOn(OR.Order_PO_StatusDropdown_Confirmed);
			if(s.trim().equalsIgnoreCase("No Order Found"))
			{
				testLogInfo("Confirmed State has no orders");
				clickOn(OR.Order_status_dropdown);
				clickOn(OR.Order_PO_StatusDropdown_PartialReceived);


				if(s.trim().equalsIgnoreCase("No Order Found"))
				{
					testLogInfo("PartialReceived State has no orders");
					clickOn(OR.Order_status_dropdown);
					clickOn(OR.Order_PO_StatusDropdown_Completed);
					if(s.trim().equalsIgnoreCase("No Order Found"))
					{
						testLogInfo("Completed State has no orders");
						testLogFail("There are no orders for which the Invoice could be generated");
					}
				}
				else
				{		
					CreateInvoice();
				}
			}
			else
			{		
				CreateInvoice();
			}
		}
		else
		{		
			CreateInvoice();
		}

		closeBrowser();

	}
	
	public void CreateInvoice() throws InterruptedException
	{
		//waitTime(3);
		clickOn(OR.Order_PO_first_dropdown);
		waitForElementToDisplay(OR.Order_PO_first_invoice, 60);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitForElementToDisplay(OR.Order_PO_first_Addinvoice, 60);
		clickOn(OR.Order_PO_first_Addinvoice);
		waitForElementToDisplay(OR.Order_PO_Invoice_Header, 60);
		String PoNum=getText(OR.Invoice_InvoicePONum);
		System.out.println(PoNum);
		String InvoiceNum="TestInvoice00";
		typeIn(OR.Invoice_InvoiceDesc, InvoiceNum);
		clickOn(OR.Invoice_SaveButton);
		clickOn(OR.Invoice_ConfirmButton);

		testLogInfo("Second Test case starts");

		//waitForElementToDisplay(OR.Invoice_SelectFirstInvoice,60);
		String PONUmberHeader=getText(OR.Invoice_PONUmInHeader).trim();
		System.out.println(PONUmberHeader);
		//			String InvoiceName=getText(OR.Invoice_SelectFirstInvoice);
		//			System.out.println(InvoiceName);
		clickOn(OR.Invoice_SelectFirstInvoice);
		String header1=getText(OR.Invoice_PageHeadTextIncludingPONum).trim();
		System.out.println(header1);
		if(header1.contains(PONUmberHeader))
		{
			testLogPass("Edit PO page is opened");

		}
		else
		{
			testLogFail("Edit PO page is not opened");

		}

		testLogInfo("Third Test case starts");
		
		clickOn(OR.Invoice_DocButton);
		//waitForElementToDisplay(OR.Invoice_clickOnUploadFIle,12);
		WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path --- " + projectPath);
		elem.sendKeys(projectPath + "/assets/image.jpeg");
		String nameOfFile_Expected="image.jpeg";
		String s2=getText(OR.Invoice_UploadDocName).trim();
		if(s2.contains(nameOfFile_Expected));
		{

			System.out.println("Name matched");
		}

		clickOn(OR.Invoice_closeButton);
		clickOn(OR.Request_InvoicePageLink);	

		//			clickOn(OR.Invoice_SelectAllUserDropDown);
		//			clickOn(OR.Invoice_SelectAllUser);
		typeIn(OR.Invoice_SearchInInvoiceTextBox, PoNum);
		//clickOn(OR.Invoice_SelectPending);
		//WebElement elem2=driver.findElement(By.xpath("//div[@class='input-sm ui-select-container ui-select-bootstrap dropdown ng-not-empty ng-valid ng-touched ng-dirty ng-valid-parse']"));
		//elem2.click();
		//WebElement ele3=elem2.findElement(By.xpath("//*[text(),'Pending']"));
		//ele3.click();
		clickOn(OR.Invoice_SearchButton);
		//waitForElementToDisplay(OR.Invoice_SelectFirstPONUmFromInvoicePage,60);
		//waitForElement(OR.Invoice_SelectFirstPONUmFromInvoicePage,30);
		Thread.sleep(4000);
		verifyElementText(OR.Invoice_SelectFirstPONUmFromInvoicePage, PoNum);
		
		clearEditBox(OR.Invoice_SearchInInvoiceTextBox);
		typeIn(OR.Invoice_SearchInInvoiceTextBox, InvoiceNum);
		clickOn(OR.Invoice_SearchButton);
		Thread.sleep(4000);
		//waitForElement(OR.Invoice_SelectFirstInvoiceFromInvoicePage, 30);
		//waitForElement(OR.Invoice_SelectFirstInvoiceFromInvoicePage,30);
		String abc=getText(OR.Invoice_SelectFirstInvoiceFromInvoicePage);
		if(abc.equalsIgnoreCase(InvoiceNum))
		{
			testLogPass("Invoice is searched with PO number");								
		}
		else
		{
			testLogFail("Invoice is not searched with PO number");	
		}
		clearEditBox(OR.Invoice_SearchInInvoiceTextBox);
		typeIn(OR.Invoice_SearchInInvoiceTextBox, nameOfFile_Expected);
		clickOn(OR.Invoice_SearchButton);
		Thread.sleep(4000);
		//waitForElement(OR.Invoice_SelectFirstPONUmFromInvoicePage,30);
		
		System.out.println("Passed111---");
		//waitForElementToDisplay(OR.Invoice_SelectFirstPONUmFromInvoicePage,30);
		verifyElementText(OR.Invoice_SelectFirstPONUmFromInvoicePage , PoNum);
		
	}

	
	@Test(priority=2)
	public void Tc_INV_09_10() throws InterruptedException
	{
		testStarts("Tc_SPO_09 and 10", "Verify that Invoice PDF gets downloaded when user clicks Download PDF button"
				+ " Verify that Invoice Print preview appears when user clicks Print button.");

		// verifyLinkText(OR.Login_Moreinfo_linktext);
		LoginPage.OpenBrowserAndLogin();
		Invoices.typeAndSearchInvoice();
		clickOn(OR.Invoice_DownoadPDF);		
		clickOn(OR.Invoice_PrintPDF);
		waitForElementToDisplay(OR.Invoice_PrintPReviewWindow,10);
		String IvnoiceText=getText(OR.Invoice_PrintPReviewWindow);
		if(IvnoiceText.contains("Print Invoice"))
		{
			testLogInfo("Print Preview window opens ");
			
		}
		closeBrowser();
	}
	
	@Test(priority=3)
	public void Tc_INV_02() throws InterruptedException
	{
		testStarts("Tc_SPO_02", "Verify that following dropdown(VendorStatusSearch By Due Date ,Facility, Departments, Ordered By  ) filters appear on page.");
		LoginPage.OpenBrowserAndLogin();
		clickOn(OR.Request_InvoicePageLink);		
		//Vendor DropDpwn		
	    verifyElementText(OR.Invoice_vendorDropDownLabels, "Vendor:");
	    if(isElementDisplayed(OR.Invoice_vendorDropDowns, 10))
	    {
	    	testLogPass("Vendor DropDownPresent");
	    }
	    else
	    {
	    	testLogFail("Vendor DropDown not Present");
	    }	    
	  //Status DropDpwn	    
	    verifyElementText(OR.Invoice_statusDropDownLabel, "Status:");
	    if(isElementDisplayed(OR.Invoice_statusDropDowns, 10))
	    {
	    	testLogPass("Status DropDownPresent");
	    }
	    else
	    {
	    	testLogFail("Status DropDown not Present");
	    }
	    //Search By Due date DropDpwn	    
	    verifyElementText(OR.Invoice_SearchBYDueDateLabel, "Search by Due-Date");
	    if(isElementDisplayed(OR.Invoice_SearchBYDueDateDropDowns, 10))
	    {
	    	testLogPass("Search by Due Date DropDownPresent");
	    }
	    else
	    {
	    	testLogFail("Search by Due Date DropDown not Present");
	    }	    
	    //Search By Facility DropDpwn	    
	    verifyElementText(OR.Invoice_FacilityLabel, "Facility");
	    if(isElementDisplayed(OR.Invoice_facilityDateDropDowns, 10))
	    {
	    	testLogPass("Search by Facility DropDown Present");
	    }
	    else
	    {
	    	testLogFail("Search by Facility DropDown not Present");
	    }	    
	    //Search By Department DropDpwn	    
	    verifyElementText(OR.Invoice_departmentLabel, "Departments");
	    if(isElementDisplayed(OR.Invoice_departmentDropDown, 10))
	    {
	    	testLogPass("Search by Department Drop Down Present");
	    }
	    else
	    {
	    	testLogFail("Search by Department Drop Down not Present");
	    }	    	    
	    //Search By Ordered DropDpwn	    
	    verifyElementText(OR.Invoice_OrderedByLabel, "Ordered By:");
	    if(isElementDisplayed(OR.Invoice_OrderedByDropDown, 10))
	    {
	    	testLogPass("Search by Due Date DropDownPresent");
	    }
	    else
	    {
	    	testLogFail("Search by Due Date DropDown not Present");
	    }
	   closeBrowser();
	}
	
	@Test(priority=4)
	public void Tc_INV_03() throws InterruptedException
	{
		testStarts("Tc_INV_03", "Edit Invoice > Verify that “Send to accounting” button appears on top right side of page.");
		LoginPage.OpenBrowserAndLogin();
		if(!Invoices.IntactAndQucikBook_Toggle())
		{
			Invoices.typeAndSearchInvoice();
			clickOn(OR.Invoice_SelectFirstInvoice);
			verifyElementText(OR.Invoice_SentToAccounting, "Send To Accounting");
			testLogPass("Sent to Accounting button is present");
		}
		else
		{
			testLogInfo("Either of the toggles 'Intact' or 'QuickBook' is enabled as a result Sent to Accounting button is not present");
		}
	}
	
	@Test(priority=5)
	public void Tc_INV_04()
	{
		testStarts("Tc_INV_04", "Verify that invoice gets deleted on clicking corresponding Delete button.");
		LoginPage.OpenBrowserAndLogin();
		Invoices.typeAndSearchInvoice();
		waitForElementToDisplay(OR.Invoice_Delete, 10);
		//waitTime(400);
		clickOn(OR.Invoice_Delete);
//		clickOn(OR.Invoice_confirmButton);
//		verifyElementText(OR.Invoice_NoInvoiceFoundMessage, "No Invoice Found");	
		closeBrowser();
	}
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}	
	
	
	
	
}		
		

		

		
		
	
		

