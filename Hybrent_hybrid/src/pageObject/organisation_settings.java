package pageObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class organisation_settings extends ApplicationKeyword {
	
	
	//For User Page
	 public static void adminAndUserPage()
     {	
		 	clickOn(OR.DashBoard_AdminDropdown);
			clickOn(OR.Users_page);
			waitForElementToDisplay(OR.Users_FirstUserName, 10);					 
     }
	 public static void searchAndUserWait()
     {	
	 
		 clickOn(OR.Users_SearchButton);
		 waitForElementToDisplay(OR.Users_SearchTextBox, 10);	
	 
     }
	 
	 public static void verifyTabs()
     {
	 
	 List<String> tabs = new ArrayList<String>( Arrays.asList("User", "User Access", "Item Catalog Access", "PO Alerts", "Facility Access", "Vendor Access", "Notification Access"));
	 List<WebElement> actualTabs = driver.findElements
				(By.xpath("//ul[@class='nav nav-tabs']//a[@class='nav-link ng-binding']"));
		if(tabs.size() == actualTabs.size())
		{
			for(int i=0; i<tabs.size(); i++)
			{
				if(tabs.get(i).equals(actualTabs.get(i).getText()))
				{	
					testLogPass(tabs.get(i)+" Tab matched with " +actualTabs.get(i).getText());					
				}
				else
				{
					testLogFail(tabs.get(i)+" Tab doesnot matched with " +actualTabs.get(i).getText());	
				
				}
			}
			
		}	
							
					
		else
		{
			testLogFail("Both the Lists Donot have same number of Tabs");
		}
	 
     }
	
	 
	 //For Facility Page
	
	 public static void AdminAndFacilityLink()
     {	
		 	clickOn(OR.DashBoard_AdminDropdown);
			clickOn(OR.Facilty_FacilityLink);	
			waitForElementToDisplay(OR.Facilty_WaitforTableElem, 10);
     }
	 
}