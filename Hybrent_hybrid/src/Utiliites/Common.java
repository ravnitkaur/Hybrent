package Utiliites;

import AutomationFramework.genericKeywords;

public class Common
{
	  public static void parseidentifyByAndlocator(String identifyByAndLocator)
	  {
	    
	    try
	    {
	      genericKeywords.locatorDescription = identifyByAndLocator.substring(0, identifyByAndLocator.indexOf("#"));
	      identifyByAndLocator = identifyByAndLocator.substring(identifyByAndLocator.indexOf("#") + 1);
	    }
	    catch (Exception e)
	    {
	      genericKeywords.locatorDescription = "";
	    }
	    finally
	    {
	    	genericKeywords.identifier = identifyByAndLocator.substring(0, identifyByAndLocator.indexOf("=", 0)).toLowerCase();
	    	genericKeywords.locator = identifyByAndLocator.substring(identifyByAndLocator.indexOf("=", 0) + 1);
	      
	    	genericKeywords.idType = identifierType.valueOf(genericKeywords.identifier);
	    }
	  }
	  
	  public static enum identifierType
	  {
	    xpath, 
	    name, 
	    id, 
	    lnktext, 
	    partiallinktext, 
	    classname, 
	    cssselector, 
	    tagname;
	  }
	  
}