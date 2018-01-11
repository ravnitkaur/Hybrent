package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
	
	
	@AfterTest
	public void endReport(){
		//closeBrowser();
		extent.flush();
	}
}
