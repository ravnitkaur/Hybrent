package pageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class LoginPage  extends ApplicationKeyword{
	
	 public static void login(String Username, String Password)
     {	
		 //waitForElementToDisplay(OR.Login_link, 60);
		// waitForElementToDisplay(OR.Label_password, 60);
//		 if(isElementDisplayed(OR.Login_link))
//		 {
//			 waitForElementToDisplay(OR.Login_link, 60);
//			 clickOn(OR.Login_link);
//		 }
//		 else
//		 {
			 //waitForElementToDisplay(OR.Login_Username, 60); 
			 verifyElementText(OR.Label_password, "Password:");
	         typeIn(OR.Login_Username, Username);
	         typeIn(OR.Login_Password, Password);
	         clickOn(OR.Login_Submit);
			 
		 }
 //        waitForElementToDisplay(OR.Label_username, 60);
 //        verifyPageTitle("Login");
//         verifyElement(OR.HeaderLogo);
//         verifyElementText(OR.Label_username, "User Name:");
//         verifyElementText(OR.Label_password, "Password:");
//         typeIn(OR.Login_Username, Username);
//         typeIn(OR.Login_Password, Password);
//         clickOn(OR.Login_Submit);
     }

   

