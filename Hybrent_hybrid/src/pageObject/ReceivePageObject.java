package pageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class ReceivePageObject extends ApplicationKeyword {

	 public static void pageLinkandwait()
    {
		 clickOn(OR.Receive_pageLink);
		 waitForElementToDisplay(OR.Receive_wait, 10);
    }

}
