package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OR {

	// Login Page
	public static String Login_link="LinkLogin#lnktext=Login with Hybrent";
	public static String HeaderLogo = "Logo#xpath=//img";
	public static String Label_username = "Labelusername#xpath=//*[@for='userName']";
	public static String Label_password = "Labelpassword#xpath=//*[@for='password']";
	public static String Login_Username = "Input_UserName#xpath=//input[@id='userName']";
	public static String Login_Password = "Input_Password#xpath=//input[@id='password']";
	public static String Login_Submit = "LoginBtn#xpath=//*[@type='submit']";
	public static String Login_Error = "Error#xpath=//h2[contains(text(),'Error?')]";
	public static String Login_Validation = "ErrorValidation#xpath=//*[contains(text(),'Invalid user name or password.')]";
	public static String Login_okay = "Errorok#xpath=//*[@class='confirm']";

	// Shop
	public static String Shop_Menu= "ShopMenu#xpath=//*[@href='#/shop']";
	public static String Shop_Shopfor = "ShopFor#xpath=//*[contains(text(),'Shopping for')]";
	public static String Shop_SHopfor_ShopfaclitySelect = "SelectShopfaclity#xpath=//*[@title='Select Facility']";
	public static String Shop_SHopfor_getfacilityName = "getfacilityName#xpath=//*[@ng-click='selectItem();']";
	public static String Shop_SHopfor_allfacilityArray = "allfacilityArray#xpath=//td";
	public static String Shop_SHopfor_selectedFAcility = "selectedFAcility#xpath=//*[@disabled='disabled']";
	public static String Shop_SHopfor_cancelButtonPopup = "cancelButtonPopup#xpath=//*[@ng-click='cancel()']";
	public static String Shop_SHopfor_Shopfaclity = "Shopfaclity#xpath=//*[text()='Select Facility']";

	public static String Shop_SHopfor_SearchMenu_SKU = "SearchMenu_SKU#xpath=//*[contains(@ng-click, 'setSelectedItem(getPropertyForObject(option,settings.idProp))') and contains(text(),'SKU')]";
	public static String Shop_SHopfor_SearchBox= "SearchBox#xpath=//*[@id='search']";
	public static String Shop_SHopfor_Search_itemdesc= "Search_itemdesc#xpath=//item-info";
	//    public static String Shop_SHopfor_Search_vendorName= "Search_vendorName#xpath=//vendor-info/span";
	public static String Shop_SHopfor_Search_Match= "Search_Match#xpath=//*[@id='matchselect']";
	public static String Shop_SHopfor_Search_skuName= "skuName#xpath=//*[@ng-if='col.ui_access_key=='sku'']/span/mark";
	public static String Shop_SHopfor_SelectfirstItemvendorName= "SelectvendorName#xpath=(//vendor-info)[1]/span";
	public static String Shop_SHopfor_clickvendorsinDropdown= "clickvendorsinDropdown#xpath=//*[@id='vendor']";
	public static String Shop_SHopfor_allvendorsinDropdown= "allvendorsinDropdown#xpath=//*[@id='vendor']/option";

	public static String Shop_SHopfor_MyInventoryradiobutton="MyInventoryradiobutton#xpath=//*[@id='searchShop']/div[1]";
	public static String Shop_SHopfor_RecentlyOrderedradiobutton="RecentlyOrderedradiobutton#xpath=//*[@id='searchShop']/div[2]";
	public static String Shop_SHopfor_MostOrderedradiobutton="MostOrderedradiobutton#xpath=//*[@id='searchShop']/div[3]";
	public static String Shop_SHopfor_FavOrderedradiobutton="FavOrderedradiobutton#xpath=//*[@id='searchShop']/div[4]";

	public static String Shop_SHopfor_ResultGridTab="ResultGridTab#xpath=//*[@id='ng-view']/div/div[2]/div[3]/grid-layout/div[2]/div/div/div/div/table/thead/tr/th[7]/a";

	public static String Shop_SHopfor_favtab="favtab#xpath=//i[@ng-if='isFavorite']";
	public static String Shop_SHopfor_myInventoryFavTab="myInventoryFavTab#xpath=//i[@ng-if='!isFavorite']";  

	public static String Shop_orgPage="orgPage#xpath=//*[@href='#/admin/organization']";
	public static String Shop_FeaturesPage="FeaturesPage#xpath=//ul[@class='nav nav-tabs']/li[2]/a";  

	//ORGsettings page

	public static String orgsetting_crosswalk="crosswalk#xpath=//*[@id='use_cross_walk_as_item_identifier']";
	public static String orgsetting_crosswalktext="crosswalktext#xpath=//input[@id='cross_walk_desc']";
	//

	public static String Shop_SHopfor_drilldownicon="drilldownicon#xpath=//button[@ng-readonly='moveingToPunchOutSite']";
	public static String Shop_SHopfor_showTourText="showTourText#xpath=//ul[@ng-readonly='moveingToPunchOutSite']/li[1]/a";

	public static String Shop_SHopfor_createNewLAyout="createNewLAyout#xpath=//li[@ng-click='newShopTableGrid(false);]";
	public static String Shop_SHopfor_Layoutpopup="Layoutpoup#xpath=//div[@class='headtext']";
	public static String Shop_SHopfor_Layoutpoupclose="Layoutpoupclose#xpath=//*[@class='close pull-right']";

	public static String Shop_SHopfor_copyLayoutpoup="copyLayoutpoup#xpath=//a[contains(text(),'Copy Current Layout')]";

	public static String Shop_SHopfor_showtourtextONPOPUP="showtourtext#xpath=//h3[contains(text(),'Shop: Search For')]";
	public static String Shop_SHopfor_showtourNextButtonText="showtourNextButtonText#xpath=//button[contains(text(),'Next �')]";
	//public static String Shop_SHopfor_showtourENDbuttonTExt="showtourENDbuttonTExt#xpath=//button[contains(text(),'End tour')]";
	public static String Shop_SHopfor_showtourENDbuttonTExt="showtourENDbuttonTExt#xpath=(//button[@ng-click='tour.end();'])[1]";

	public static String Shop_SHopfor_allFieldsBtn="allFieldsBtn#xpath=//div[@options='searchKeysList']/div/button";

	public static String Shop_SHopfor_Search_vendorName_Price= "Search_vendorName_price#xpath=//*[@current-price='item.purchase_price']/div";
	public static String Shop_SHopfor_Search_Addtocart= "Search_AddtocartBtn#xpath=//*[@ng-click='$ctrl.addItemToCart(item)']";


	public static String Shop_GrandTotal = "GrandTotal#xpath=//*[@tour-step='cart-grand-total']/td";
	public static String Shop_GeneratePo = "GeneratePo#xpath=(//*[@id='btnAdd'])[1]";

	public static String Shop_Allfieldsbutton = "Shop_Allfieldsbutton#xpath=//*[@ng-click='toggleDropdown()']";
	public static String Shop_waitdropdown = "Shop_waitdropdown#xpath=//*[@role='menuitem']";
	public static String Shop_orgpage = "Shop_Shop_orgpage#xpath=//*[@ng-href='#/admin/organization']";
	public static String Shop_orgFeaturesPage = "Shop_orgFeaturesPage#xpath=//ul[@class='nav nav-tabs']";
	public static String Shop_crosswalktogglevalue ="Shop_crosswalktogglevalue#xpath=//*[@class='col-sm-8 user-action-switch']/div";
	public static String Shop_crosswalktoggleON ="Shop_crosswalktoggleON#xpath=";
	public static String Shop_dropDownText ="Shop_dropDownText#xpath=//*[@ng-show='settings.selectionLimit > 1']/a ";
	public static String Shop_searchfield= "searchfield#xpath=//*[@id='search']";
	public static String Shop_ifnoItemfield= "ifnoItemfield#xpath=//tr[@ng-if='!items.length']/td";
	//public static String Shop_wait= "ifnoItemfield#xpath=//tr[@ng-if='!items.length']/td";

	public static String Shop_showTour= "showTour#xpath=//li[@ng-click='startTour();']";
	public static String Shop_mouseoverviewtype= "mouseoverviewtype#xpath=//li[@class='dropdown-submenu pull-left']";

	public static String Shop_waitfor = "mouseoverviewtype#xpath=//ul[@class='dropdown-menu dropdown-menu-less-padding dropdown-menu-round-bordered']";
	public static String Shop_tableviewText = "tableviewText#xpath=//ul[@class='dropdown-menu dropdown-menu-less-padding dropdown-menu-round-bordered']/li[1]";
	public static String Shop_tableviewIdentifier = "tableviewIdentifier#xpath=//*[@id='isotopeContainer']";
	public static String Shop_tableview = "tableview#xpath=//*[contains(text(),'Table')]";

	//public static String Shop_gridViewText = "gridViewText#xpath=//ul[@class='dropdown-menu dropdown-menu-less-padding dropdown-menu-round-bordered']/li[2]";
	public static String Shop_gridView = "gridView#xpath=//*[contains(text(),'Grid')]";
	public static String Shop_layoutshover = "layoutshover#xpath=//*[@class='dropdown-submenu pull-left ng-scope']";
	public static String Shop_userlayout = "layoutshover#xpath=//li[@class='dropdown-submenu pull-left ng-scope']/ul/";

	public static String Shop_selectmatchdropdown = "selectmatchdropdown#xpath=//*[@id='matchselect']";
	public static String Shop_elementwithcross ="elementwithcross#xpath=//*[@ng-if='currentUser.user.id == layout.created_by])";
	public static String Shop_waitforelements ="Shop_waitforelements#xpath=//*[@class='col-sm-18 ng-scope']";
	public static String Shop_countoffacilities ="Shop_countoffacilities#xpath=//*[@style='border-right: none;vertical-align: middle;']";
	public static String Shop_countofitems ="Shop_countofitems #xpath=//tr[@ng-repeat='data in $ctrl.selectList | orderBy:'name' | filter: { name:search.searchKeyword } | offset: (search.currentPage - 1) * search.iPerPage | limitTo: search.iPerPage']/span";
	public static String Shop_VendorSelect = "VendorSelect#xpath=//*[@id='vendor']";	 
	//Manage Inventory
	public static String manageInventory_waitforelements ="waitforelements#xpath=//*[@ng-repeat='item in items']";

	public static String Shop_drilldownCreateLayout = "drilldownCreateLayout#xpath=//a[text()='Create New Layout']";
	public static String Shop_drilldownChangeLayout = "drilldownChangeLayout#xpath=//a[text()='Change Current Layout']";
	public static String Shop_drilldownLayoutNameText = "drilldownLayoutNameText#xpath=//label[text()='Layout Name']/../div/input";
	public static String Shop_drilldownCreateLayoutSave = "drilldownCreateLayoutSave#xpath=//button[text()='Save']";
	public static String Shop_drilldownChangeLayoutPopup = "drilldownChangeLayoutPopup#xpath=//span[text()='Configure Shop Layout ---automation layout---']";
	public static String Shop_drilldownChangeLayoutClose = "drilldownChangeLayoutClose#xpath=//span[text()='Configure Shop Layout ---automation layout---']/../button";
	public static String Shop_drilldownRemoveLayout = "drilldownRemoveLayout#xpath=//a[contains(text(),'---automation layout---')]/../i";
	public static String Shop_drilldownLayouts = "drilldownLayouts#xpath=//a[text()='Layouts']";
	public static String Shop_drilldownRemoveLayoutYes = "drilldownRemoveLayoutYes#xpath=//button[@class='confirm']";

	//*[@ng-repeat='item in items']

	// Dashboard Page
	public static String DashBoard_AdminDropdown = "DropDown_Admin#xpath=//admin-menu/a";
	public static String DashBoard_Report_Montly = "Report_Month#xpath=//*[@class='current-day-year ng-binding']";
	public static String DashBoard_Report_Monthly_Dolors = "Report_Montly_Dolors#xpath=(//*[@class='current-day-temperature ng-binding'])[1]";
	public static String DashBoard_Report_Monthly_txt = "Report_Monthly_txt#xpath=(//*[@class='current-day-date']/span)[1]";
	public static String DashBoard_Report_PartialReviews = "PartialReviews#xpath=(//*[@class='current-day-temperature ng-binding'])[2]";
	public static String DashBoard_Report_PartialReviews_txt = "PartialReviews_txt#xpath=(//*[@class='current-day-date']/span)[2]";
	public static String DashBoard_Report_Day = "Day#xpath=(//*[@class='current-days ng-binding'])[1]";
	public static String DashBoard_Report_Day_txt = "DayText#xpath=(//*[@class='current-days_2'])[1]";
	public static String DashBoard_Report_Hours = "Hours#xpath=(//*[@class='current-days ng-binding'])[2]";
	public static String DashBoard_Report_Hours_txt = "hoursText#xpath=(//*[@class='current-days_2'])[2]";
	public static String DashBoard_Report_avgventor_txt = "avgventorText#xpath=(//*[@class='current-day-date']/span)[3]";
	public static String DashBoard_Report_RecentOrder_txt = "Txt_recentorder#xpath=//*[text()='Recent Orders']";
	public static String DashBoard_Report_NewsEvent_txt = "Txt_NewsEvent#xpath=//*[text()='News & Events']";
	public static String DashBoard_Report_NewsDate = "NewsDate#xpath=//*[@class='newsicon in-active']";
	public static String DashBoard_Report_NewsTime = "NewsTime#xpath=//*[@class='news-time ng-binding']";
	public static String DashBoard_Report_News = "News#xpath=//*[@class='news-sub-teaser']";
	public static String DashBoard_Report_News_Header = "NewsHeader#xpath=//*[@class='pagehead']";
	public static String DashBoard_Report_Newstitle1 = "NewsTitle#xpath=(//*[@class='news-sub-head ng-binding'])[1]";
	public static String DashBoard_Report_NewsPage_title1 = "NewsTitle1#xpath=(//h5)[1]";




	public static String Admin_ItemCatalog = "ItemCatalog#xpath=//a[@href='#/items-catalog']";

	// Item Catalog

	public static String ItemCatalog_statusDropdown="statusDropdown#xpath=//*[@id='status']";
	public static String ItemCatalog_searchbutton="searchbutton#xpath=//*[@ng-submit='formSearchFn()']/button";
	public static String ItemCatalog_waitforeditbuttonclass="waitforeditbuttonclass#xpath=//*[@class='btn btn-primary ng-scope']"; 
	public static String ItemCatalog_inactiveitem="inactiveitem#xpath=//*@id='itemmasterListing']/tr/span";
	public static String ItemCatalog_AddPage_AddItemText = "AddItemText#xpath=//*[text()='Add Item']";
	public static String ItemCatalog_AddPage_ItemDetails = "Txt_ItemDetails#xpath=//*[text()='Item Detail']";
	public static String ItemCatalog_AddPage_temText = "AddItemText#xpath=//*[text()='Item Detail']";
	public static String ItemCatalog_AddItem = "Btn_AddItem#xpath=//button[contains(text(),'Add Item')]";

	public static String ItemCatalog_AddItem_ItemDetails_Description = "ItemDetails_Description#xpath=//*[@id='desc']";
	public static String ItemCatalog_AddItem_ItemDetails_alias = "ItemDetails_alias#xpath=//*[@id='alias']";
	public static String ItemCatalog_AddItem_ItemDetails_MfrDetails = "ItemDetails_MfrDetails#xpath=//*[@id='mfr']";
	public static String ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown = "ItemDetails_MfrDropdown#xpath=//*[@class='input-group-btn']/button";
	public static String ItemCatalog_AddItem_Man_Select = "ManSelect#xpath=(//*[@ng-click='save(manufacturer.id, manufacturer.name)'])[1]";
	public static String ItemCatalog_AddItem_Man_Save = "Save#xpath=//*[@type='submit']";
	public static String ItemCatalog_AddItme_TestId = "TestId#xpath=//*[@id='item_identifier']";
	public static String ItemCatalog_Vendors = "Vendors#xpath=//a[contains(text(),'Vendors')]";
	public static String ItemCatalog_VendorsTab = "VendorsTab#lnktext=Vendors";
	public static String ItemCatalog_AddVendors = "AddVendors#xpath=//input[@value='Add Vendor']";
	public static String ItemCatalog_Add_Vendorsname = "Vendorsname#xpath=//*[@id='tbl_add_vendor1']/tbody/tr[1]/td[2]/div[1]/div/span/span[1]";
	public static String ItemCatalog_Add_VendorsnameSelect = "VendorsnameSelect#xpath=//table[@id='tbl_add_vendor1']/tbody/tr/td[4]/select";
	public static String ItemCatalog_firstvendor = "firstvendor#xpath=//*[@id='tbl_add_vendor1']/tbody/tr[1]/td[2]/div[1]/div/span/span[2]/span";


	// public static String ItemCatalog_Add_allvendorsfromdropdown = "VendorsnameSelect#xpath=//table[@id='tbl_add_vendor1']/tbody/tr/td[4]/select";
	public static String ItemCatalog_Add_VendorsSkuName = "VendorsSkuName#xpath=(//input[@type='text'])[11]";
	public static String ItemCatalog_Add_VendorsMinOrderQty = "VendorsMinOrderQty#xpath=//input[@ng-model='v.min_order_qty']";
	public static String ItemCatalog_AddItem_MapValidation = "MapValidation#xpath=//*[contains(text(),'Do you want to map this item to your various facilities?')]";
	public static String ItemCatalog_AddItem_MapValidation_Cancel = "MapValidation_Cancel#xpath=//*[@class='cancel']";
	public static String ItemCatalog_AddItem_MapValidation_yes = "MapValidation_Yes#xpath=//*[@class='confirm']";
	public static String ItemCatalog_AddItem_VendorSelect_First = "VendorSelect_First#xpath=(//*[@ng-bind-html='vendor.name | highlight: $select.search'])[1]";

	public static String ItemCatalog_mapallbuttontopright ="mapallbuttontopright#xpath=//*[contains(text(),'More Options')]";
	public static String ItemCatalog_mapwithalltopright ="mapwithalltopright#xpath=//a[text()='Map with all facility']";
	public static String ItemCatalog_verifytextpopup ="verifytextpopup #xpath= //*[@class='modal-header']/div/span";
	public static String ItemCatalog_purchaseprice ="purchaseprice#xpath= //input[@ng-model='purchase_price']";
	public static String ItemCatalog_mapallbutton ="mapallbutton#xpath=//button[@type='submit']";
	// Add item Map faility
	public static String ItemCatalog_AddItem_Map_Header = "Map_Header#xpath=//*[@class='headtext']";
	public static String ItemCatalog_AddItem_Map_SearchFacility_Text = "SearchFacilityText#xpath=//*[text()='Search Facility']";
	public static String ItemCatalog_AddItem_Map_SearchFacility ="SearchFacility#xpath=//*[@id='facility-search']";
	public static String ItemCatalog_AddItem_Map_AddFacility ="AddFacility#xpath=//*[@id='tblMapFacility']/tbody/tr[2]/td[2]/button";
	public static String ItemCatalog_AddItem_Map_PurchagePrice ="PurchagePrice#xpath=//*[@id='purchase-price0']";
	public static String ItemCatalog_AddItem_Map_GPOPurchagePrice ="GPOPurchagePrice#xpath=//*[@name='gpo_contract_price']";
	public static String ItemCatalog_AddItem_Map_GPOPurchagePriceSave ="GPOPurchagePriceSave#xpath=(//button[contains(text(),'Save')])[1]";
	public static String ItemCatalog_AddItem_Map_Closepage ="Close#xpath=//*[@class='modal-header']/div/div/div/button";

	// Notification
	public static String Notification_Bell = "Bell#xpath=//*[@id='notification-count']";
	public static String Notification_First = "FirstNotification#xpath=(//*[@class='notifiy-detail ng-binding'])[1]";
	public static String Notification_First_Time = "FirstNotificationTime#xpath=(//*[@class='notifiy-time ng-binding'])[1]";
	public static String Notification_ViewAll = "ViewAll#xpath=//*[@id='all-notifications']";
	public static String Notification_Mynotification = "Mynotification#xpath=//*[contains(text(),'My NOTIFICATIONS')]";
	public static String Notification_Btn_Refresh = "BtnRefresh#xpath=//*[text()='Refresh']";
	public static String NotficationPage_Text = "txt_Notification#xpath=//div[contains(text(),'Notification Settings')]";
	public static String NotficationPage_Text_Event = "txt_Event#xpath=//*[text()='Event']";
	public static String NotficationPage_Text_MobilePush = "txt_MobilePush#xpath=//*[text()='Mobile Push']";
	public static String NotficationPage_Text_Email = "txt_Email#xpath=//*[text()='Email Notification']";
	public static String NotficationPage_Text_Web = "txt_Web#xpath=//*[text()='Web Notification']";
	public static String NotficationPage_FirstNotificationText = "FirstNotification#xpath=(//*[@id='gridNotificationListing']//p)[1]";


	// User Setting
	public static String User = "User#xpath=//*[@class='user-cont']";
	public static String User_Profile = "Profile#xpath=//a[@href='#/user/update-profile']";
	public static String User_NotificationSetting = "NotificationSetting#xpath=//*[@href='#/notification/settings']";
	public static String User_alert = "alert#xpath=//*[@href='#/user/update-profile/alert']";
	public static String User_Survey = "Survey#xpath=//a[text()='Survey']";
	public static String User_ChangePassword = "ChangePassword#xpath=//a[text()='Change Password']";
	public static String User_SwitchUser = "SwitchUser#xpath=//*[@href='#/selectuser']";

	// My Card
	public static String MyCart = "MyCart#xpath=//*[@href='#/my-cart']";
	public static String MyCart_cartFor = "text_cartFor#xpath=//*[contains(text(),'Cart for')]";
	public static String MyCart_cartFor_Details = "text_cartFor_Details#xpath=//*[@select-list='shippingLocations']/a";

	// Profile
	public static String Profile_UserProdile = "UserProfile#xpath=//span[text()='User Profile']";
	public static String Profile_Btn_Update = "Btn_Update#xpath=//button[text()='Update']";
	public static String Profile_Btn_cancel = "Btn_Cancel#xpath=//*[@value='Cancel']";
	public static String Profile_Label_Name = "Label_Name#xpath=//*[@for='name']";
	public static String Profile_Label_Email = "Label_email#xpath=//*[@for='email']";
	public static String Profile_Label_phone = "Label_phone#xpath=//*[@for='phone']";
	public static String Profile_Label_Photo = "Label_Photo#xpath=//*[@for='pic']";
	public static String Profile_Label_Facility = "Label_Facility#xpath=//label[text()='Facility']";
	public static String Profile_Label_Dept = "Label_Dept#xpath=//label[text()='Department:']";
	public static String Profile_Label_Inventory = "Label_Inventory#xpath=//label[text()='Inventory']";
	public static String Profile_Label_Journeydate = "Label_Journeydate#xpath=//label[text()='Joining Date:']";
	public static String Profile_Label_QuickBook = "Label_QuickBook#xpath=//label[text()='Quick Books:']";

	// Alert
	public static String Alert_txt_userAlert = "txt_userAlert#xpath=//span[text()='User Alert']";
	public static String Alert_Btn_Update = "Btn_Update#xpath=//button[text()='Update']";
	public static String Alert_Btn_cancel = "Btn_Cancel#xpath=//*[@value='Cancel']";

	// Survey
	public static String Survey_txt_Survey = "txt_survey#xpath=//*[@class='headtext']/span";
	public static String Survey_btn_Clickhere = "btn_Clickher#xpath=//button[text()='Click here to start!']";

	// change password
	public static String Cpwd_txt_changepassword = "txt_changepassword#xpath=//div[contains(text(),'Change Password')]";
	public static String Cpwd_txt_oldpassword = "txt_oldpassword#xpath=//*[@for='oldPassword']";
	public static String Cpwd_txt_newpassword = "txt_newpassword#xpath=//*[@for='newPassword']";
	public static String Cpwd_txt_confirmpassword = "txt_confirmpassword#xpath=//*[@for='confirmPassword']";
	public static String Cpwd_btn_submit = "Btn_Submit#xpath=//*[@type='submit']";

	// Switch User
	public static String SwitchUser_txt_Msg = "Selectuser#xpath=//*[text()='Select user to login']";

	// Report
	public static String ViewMoreReport = "ViewReport#xpath=//*[contains(text(),'View More Reports')]";

	//manage Inventory
	public static String manageInvenLink = "manageInvenLink#xpath=//a[@href='#/inventory']";
	public static String manage_stsusDropdwn = "manage_stsusDropdwn#xpath=//*[@id='status']";
	public static String manage_searchButton = "searchButton#xpath=//button[text()='Search']";
	public static String manage_inactiveitem= "inactiveitem#xpath=//*[@class='item-description']/span";
}





