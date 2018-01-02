package pageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;


public class MycartPage extends ApplicationKeyword{
	public static void verificationMycartPage()
    {
        clickOn(OR.MyCart);
        getText(OR.MyCart_cartFor);
        getText(OR.MyCart_cartFor_Details);
        verifyPageTitle("My Cart");
    }

}
