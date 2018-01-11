package pageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class LoginPage  extends ApplicationKeyword{
	public static String UserName = "admin";
	public static String Password = "goouser";
	public static String URL = "https://qa4.test.hybrent.com/b/#/login/";

	 public static void login(String Username, String Password)
     {	
		 
//		 if(isElementDisplayed(OR.Login_link))
//		 {
//			 waitForElementToDisplay(OR.Login_link, 60);
//			 clickOn(OR.Login_link);
//		 }
//		 else
//		 {
//			 waitForElementToDisplay(OR.Label_username, 60);
//			 verifyElementText(OR.Label_password, "Password:");
//			 
//		 }
         waitForElementToDisplay(OR.Label_username, 60);
         verifyPageTitle("Login");
         verifyElement(OR.HeaderLogo);
         verifyElementText(OR.Label_username, "User Name:");
         verifyElementText(OR.Label_password, "Password:");
         typeIn(OR.Login_Username, Username);
         typeIn(OR.Login_Password, Password);
         clickOn(OR.Login_Submit);
     }

	 public static void OpenBrowserAndLogin()
     {
		 	openBrowser(URL);
			LoginPage.login(UserName, Password);
			waitForElementToDisplay(OR.Shop_Menu, 60); 
		 
		 
     }
	 
}
