//package pageObject;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import AutomationFramework.ApplicationKeyword;
//import AutomationFramework.OR;
//
//public class organisation_settings extends ApplicationKeyword {
//	
//	public static void croswalkIDToggle()
//	{
//		  try
//          {
//				
//			  String className=getAttributeValue(OR.Shop_crosswalktogglevalue, "class");
//			  if(className.contains("bootstrap-switch-off"))
//			  { 
//				  testLogInfo("Toggle for crosswalkID is OFF");
//			  	  clickOn(OR.Shop_Menu);
//			  	  clickOn(OR.Shop_Allfieldsbutton);
//	              waitForElementToDisplay(OR.Shop_waitdropdown, 60);
//	              
//	              
//	              int one = driver.findElements(By.xpath("//*[@ng-repeat='option in options | filter: searchFilter']")).size();
//		            for(int i=1; i<=one; i++)
//		      	  	{
//		      	  		String keywords=driver.findElement(By.xpath("//*[@ng-repeat='option in options | filter: searchFilter']/a/span")).getText();
//		      	  		if(keywords.matches(facility_Name))
//		               {  
//		            	   getAttributeValue(OR.Shop_SHopfor_selectedFAcility, "disabled");
//		            	   testLogPass("Go the text '"+facility+ "' Matches with selected Facility" );
//		               }
//		      	  	}
//			  	  
//			  
//			  
//			  }
//			  
//			  else
//			  {
//				  testLogInfo("Toggle for crosswalkID is ON");
//				  clickOn(OR.Shop_Menu);
//				  clickOn(OR.Shop_Allfieldsbutton);
//		          waitForElementToDisplay(OR.Shop_waitdropdown, 60);
//			  }
//          }
//				  
//  
//          catch(Exception e)
//          {
//              testLogFail("Notification  Error '" + e.toString()+ "'");
//          }
//		  
//
//		  
//	}
//		
//		  public boolean checkOptions(String[] expected)
//		  
//		  {
//			  
			  
		
		
		
		
	
	
//}
