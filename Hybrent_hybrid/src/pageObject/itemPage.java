package pageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class itemPage extends ApplicationKeyword {
	
	public static String UserName = "admin";
    public static String Password = "goouser";
    public static String URL = "https://qa4.test.hybrent.com/b/#/login/";
	public static void AddItemPage()
    {
        verifyElementText(OR.ItemCatalog_AddPage_AddItemText, "Add Item");
        verifyElementText(OR.ItemCatalog_AddPage_ItemDetails, "Item Detail");



        verifyElementText(OR.ItemCatalog_Vendors, "Vendors");
        verifyElementText(OR.ItemCatalog_Vendors, "Vendors");
        verifyElementText(OR.Profile_Label_phone, "Phone");
        verifyElementText(OR.Profile_Label_Photo, "Photo:");
        verifyElementText(OR.Profile_Label_Facility, "Facility");
        verifyElementText(OR.Profile_Label_Dept, "Department:");
        verifyElementText(OR.Profile_Label_Inventory, "Inventory");
        verifyElementText(OR.Profile_Label_Journeydate, "Joining Date:");
        verifyElementText(OR.Profile_Label_QuickBook, "Quick Books:");
        verifyPageTitle("User Profile");
    }
    
    public static void invalidValidation()
    {
        clickOn(OR.ItemCatalog_AddItem);
        typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, "Hari-Test");
        typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, "mrf-Testing-101");
        clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
        clickOn(OR.ItemCatalog_AddItem_Man_Select);
        clickOn(OR.ItemCatalog_AddItem_Man_Save);
    }
    
    

}
