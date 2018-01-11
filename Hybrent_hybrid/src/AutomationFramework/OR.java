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
	
	public static String Shop_SHopfor_LastorderedText="LastorderedText#xpath=//th[@class='ng-scope text-left'][2]/a";
	public static String Shop_SHopfor_PoCountText="PoCountText#xpath=//th[@class='ng-scope text-right'][1]/a";
	
	
	
	public static String Shop_SHopfor_favtab="favtab#xpath=//i[@ng-if='isFavorite']";
	public static String Shop_SHopfor_myInventoryFavTab="myInventoryFavTab#xpath=//i[@ng-if='!isFavorite']";  

	public static String Shop_orgPage="orgPage#xpath=//*[@href='#/admin/organization']";
	public static String Shop_FeaturesPage="FeaturesPage#xpath=//ul[@class='nav nav-tabs']/li[2]/a";  	

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
	public static String Shop_orgFeatures2Page = "Shop_orgFeaturesPage#xpath=//a[text()='Features']";
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
	public static String Shop_changeLayoutTextPopUP= "changeLayoutTextPopUP=#xpath=//*[@class='headtext']/span";
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

	// My Cart
	public static String MyCart = "MyCart#xpath=//*[@href='#/my-cart']";
	public static String MyCart_cartFor = "text_cartFor#xpath=//*[contains(text(),'Cart for')]";
	public static String MyCart_cartFor_Details = "text_cartFor_Details#xpath=//*[@select-list='shippingLocations']/a";
	public static String MyCart_searchInCart = "searchInCart#xpath=//*[@id='searchInput']";
	public static String MyCart_addItemInCart = "addItemInCart#xpath=//button[@id='btnAdd']";
	public static String MyCart_firstItemName = "firstItemName#xpath=//ul[@id='suggestions']/li/div/div[1]/div/span/strong";
	public static String MyCart_firstItemSkuName = "firstItemSkuName#xpath=//*[@id='suggestions']/li[1]/div/div[3]/div[1]/span/small";	
	public static String MyCart_drillDown = "drillDown#xpath=//button[@class='btn btn-default dropdown-toggle']";
	public static String MyCart_clearCurrentCart = "clearCurrentCart#xpath=//a[contains(text(),'Clear Current Cart')]";
	public static String MyCart_yesInPopup = "MyCart_yesInPopup#xpath=//button[contains(text(),'Yes')]";
	public static String MyCart_OKInPopup = "OKInPopup#xpath=//button[contains(text(),'OK')]";
	
	public static String MyCart_qtyOfItemBeforeAfter = "qtyOfItemBeforeAfter#xpath=//*[@id='ng-view']/div/div/div[3]/div/div/div/table/tbody[1]/tr[3]/td[3]/div/span";
	public static String MyCart_plusIcon = "plusIcon#xpath=//button[@id='incr']";
	public static String MyCart_minusIcon = "minusIcon#xpath=//button[@id='dcr']";
	public static String MyCart_editItemQty = "editItemQty#xpath=//*[@editable-text='cartItem.newQty']//*[@class='item-qty-editable-label ng-binding']";
	public static String MyCart_editItemQtyTextBox = "editItemQtyTextBox#xpath=//div[@class='editable-controls form-group']/input";      
	public static String MyCart_submitQty = "submitQty#xpath=//*[@id='ng-view']/div/div/div[3]/div/div/div/table/tbody[1]/tr[3]/td[3]/form/div/span/button[1]";
	public static String MyCart_SiTextBox = "SiTextBox#xpath=//input[@class='cart-comment-box-without-value text-primary ng-pristine ng-untouched ng-valid']";
	public static String MyCart_UsemyPOCheckBox = "UsemyPOCheckBox#xpath=//*[@ng-click='test_check(key)']";
	public static String MyCart_typePONumber = "typePONumber #xpath=//*[@ng-show='checked_pos[key].show']//*[@class='form-control ng-pristine ng-valid ng-valid-maxlength ng-touched input-sm ng-untouched ng-empty']";

	public static String MyCart_drillDownVendor = "drillDownVendor#xpath=//span[@id='optionMenu']";
	public static String MyCart_removeVendor = "removeVendor#xpath=//*[contains(text(), 'Remove Vendor from Cart')]";   
	public static String MyCart_confirmButton = "confirmButton#xpath=//button[@class='confirm']";
	public static String MyCart_accountSetUp = "MyCart_accountSetUp#xpath=//*[contains(text(), 'Account setup')]"; 
	public static String MyCart_emptycartText = "MyCart_emptycartText#xpath=//*[@class='table']/tbody/tr/td/h3";
	public static String MyCart_vendorAccountSetUp = "vendorAccountSetUp#xpath=//*[@class='vendor-acc-header ng-binding']";
	
	public static String MyCart_AddDepartmenthyperLink = "AddDepartmenthyperLink#xpath=//a[@ng-click='selectDepartments(cartItem);']";
	public static String MyCart_AddDepartmentText = "AddDepartmentText#xpath=(//h4)[1]";
	public static String MyCart_AddPhysicianhyperLink = "AddPhysicianhyperLink#xpath=//a[@ng-click='selectPhysicians(cartItem);']";
	public static String MyCart_AddPhysicianText = "AddPhysicianText#xpath=(//h4)[1]";
	public static String MyCart_PrintPO= "PrintPO#xpath=//a[@ng-click='showPopUp()']";
	public static String MyCart_PrintPOPopUpText= "PrintPOPopUpText#xpath=//*[@class='modal-content ng-scope']/div/div/span";
	public static String MyCart_showTourButton= "showTourButton#xpath=//a[@ng-click='startTour();']";
	public static String MyCart_showtourtextONPOPUP="showtourtextONPOPUP#xpath=//h3[contains(text(),'Cart: List of Items')]";
	public static String MyCart_cartIconNumber="cartIconNumber#xpath=//*[@href='#/my-cart']/i/sup";
	public static String MyCart_clearAllCarts = "clearAllCarts#xpath=//*[@ng-click='clearCart()']";
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
	
	//Request PO
	public static String Request_MenuLink = "MenuLink#xpath=//a[@href='#/service-request/create']";
	public static String Request_drillDown = "Request_drillDown#xpath=//*[@class='pagehead']//*[@data-toggle='dropdown']";
	public static String Request_createNewService = "createNewService#xpath=//*[contains(text(),'Add New Service')]";
	public static String Request_createNewServicePopUpText = "createNewServicePopUpText#xpath=//div[@class='modal-header']/div/span";
	public static String Request_ServiceLocationText="ServiceLocationText#xpath=//*[@for='shippingLocation']/label";
	public static String Request_ServiceDateText="ServiceDateText#xpath=//label[@for='txtExpectedDate']";
	public static String Request_CalenderIcon="CalenderIcon#xpath=//*[@class='input-group-btn']//button[@class='btn btn-default btn-sm']";
	public static String Request_CalenderDate="CalenderDate#xpath=//button[@id='datepicker-26501-1837-title']";
	public static String Request_VendorText="VendorText#xpath=//label[@for='vendor']";
	public static String Request_Description="Description#xpath=//*[@id='item_description']";
	public static String Request_sku="sku#xpath=//*[@id='sku']";
	public static String Request_purchasePrice="purchasePrice#xpath=//*[@name='purchasePrice']";
	public static String Request_saveButton="saveButton#xpath=name=//*[@ng-click='addItem()']";
	public static String Request_searchBox="searchBox#xpath=//input[@id='searchInput']";
	public static String Request_requestService="requestService#xpath=//button[@id='btnAdd']";
	//public static String Request_isServicePOToggle="isServicePOToggle#xpath=//div[@class='bootstrap-switch-small bootstrap-switch-id-isService bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-animate bootstrap-switch-off']/div//span[@class='bootstrap-switch-handle-off bootstrap-switch-default']";
	public static String Request_isServicePOToggle="isServicePOToggle#xpath=//input[@id='isService']/../span[3]";
	
	
	public static String Request_getItemName="getItemName#xpath=//div[@class='col-sm-18']/span/strong";
	public static String Request_getSkuName="getSkuName#xpath=//div[@class='col-sm-7']/span/small";
	public static String Request_vendorDropDown="vendorDropDown#xpath=//*[@id='vendor']";
	public static String Request_calenderIconAttribte="calenderIconAttribte#xpath=//button[@ng-click='open($event)']";
	public static String Request_Duration="Duration#xpath=//*[@ng-show='item.is_service==1']/select";
	
	//ORDERS
	
	public static String Orders_Link="OrdersLink#xpath=//*[@href='#/orders']";
	public static String Order_PO_Doc_Icon ="PO_Doc_Btn#xpath=//i[@class='ng-scope fa fa-paperclip']";
	public static String Order_PO_Doc_HeaderTxt ="PO_Doc_HeaderTxt#xpath=//*[@class='headtext ng-binding']";
	public static String Order_PO_Doc_UploadFile ="PO_Doc_UploadFileTxt#xpath=//label[contains(text(),'Upload File')]";
	public static String Order_PO_Doc_CloseBtn ="PO_Doc_CloseBtn#xpath=//*[text()='Close']";
	public static String Order_PO_Doc_UploadFiles ="PO_Doc_UploadFile#xpath=//*[@id='pic']";
	    
	    public static String Order_PO_StatusDropdown_Cancelled ="Cancelled#xpath=//*[text()='Cancelled']";
	    public static String Order_PO_StatusDropdown_On_Hold ="On_Hold#xpath=//*[text()='On-Hold']";
	    public static String Order_PO_StatusDropdown_Changed ="Changed#xpath=//*[text()='Changed']";
	    public static String Order_PO_StatusDropdown_Assigned ="Assigned#xpath=//*[text()='Assigned']";
	    public static String Order_status_dropdown ="dropdown#xpath=//*[@id='status']";
	    public static String Order_PO_StatusDropdown_Confirmed ="Confirmed#xpath=(//*[text()='Confirmed'])[1]";
	    public static String Order_PO_SearchBtn ="SearchBtn#xpath=//button[text()='Search']";
	    public static String Order_PO_first_dropdown ="PO_first_dropdown#xpath=(//*[@class='fa fa-chevron-down'])[1]";
	    public static String Order_PO_first_printPo ="PO_first_PrintPo#xpath=(//*[text()='Print PO'])[1]";
	    public static String Order_PO_first_PoLog ="PO_first_PoLog#xpath=(//*[text()='PO Log'])[1]";
	    public static String Order_PO_PoLogHead ="PO_PoLogHead#xpath=(//*[@class='pagehead ng-binding'])[1]";
	    public static String Order_PO_first_invoice ="PO_first_invoice#xpath=(//a[text()='Invoices'])[1]";
	    public static String Order_PO_first_Addinvoice ="PO_first_Addinvoice#xpath=(//a[@ng-click='addInvoiceCall()'])[1]";
	    public static String Order_PO_Invoice_Header ="Invoice_Header#xpath=//*[contains(text(),'Invoice for PO #:')]";
	    public static String Order_PO_printPo_PDF ="PO_printPo_PDF#xpath=//*[@class='modal-header']//*[contains(text(),'Print PO')]";
	    public static String Order_PO_first_AllInvoice ="PO_first_AllInvoice#xpath=(//*[text()='All Invoices'])[1]";
	    public static String Order_PO_first_AllInvoice_Header ="PO_first_AllInvoice_Header#xpath=//*[@class='pagehead']";
	    public static String Order_PO_Title ="PO_Title#xpath=//*[@ng-click=\"order('PONUM')\"]";
	    public static String Order_PO_idList ="PO_Idlist#xpath=(//*[@ng-repeat='order in ordersData.purchaseOrders']/td/a)";
	    
	    public static String Assending ="Assending#xpath=//*[@class='fa fa-caret-up']";
	    public static String Descending ="Descending#xpath=//*[@class='fa fa-caret-down']";
	    public static String conditionForNoOrder ="conditionForNoOrder#xpath=//div[@class='panel-body']/tbody/tr/td";
	    public static String Order_PO_StatusDropdown_PartialReceived ="PartialReceived#xpath=//*[text()='Partial Received']";
	    public static String Order_PO_StatusDropdown_Completed ="Completed#xpath=//*[text()='Completed']";
	    public static String Order_FacilityDropDown ="FacilityDropDown#xpath=//*[@id='facility']";
	    
	    
	    
	    //INVOICE 
	
	public static String Request_InvoicePageLink="InvoicePageLink#xpath=//*[@href='#/invoice']";
	public static String Invoice_InvoiceDesc="InvoiceDesc#xpath=//input[@id='txtInvNo']";
	public static String Invoice_InvoicePONum="Invoice_InvoicePONum#xpath=//div[@class='pagehead']/span";
	public static String Invoice_AddItemInInvoice="AddItemInInvoice#xpath=//select[@name='POItems']";
	public static String Invoice_AddItemButton="AddItemButton#xpath=//button[@ng-click='AddItemToInvoice()']";
	public static String Invoice_ItemQtyField="ItemQtyField#xpath=//input[id='ItemQty']";
	public static String Invoice_SaveButton="SaveButton#xpath=//button[@ng-click='saveInvoice()']";
	public static String Invoice_ConfirmButton="ConfirmButton#xpath=//button[@class='confirm']";
	public static String Invoice_DocPopUPText="DocPopUPText#xpath=//div[@class='modal-header']/div[@class='headtext ng-binding']";
	public static String Invoice_DocButton="DocButton#xpath=//button[@ng-click='attachFiles()']";
	public static String Invoice_UploadButton="UploadButton#xpath=//*[@id='pic']../label";
	public static String Invoice_UploadDocName="UploadDocName#xpath=//div[@class='col-sm-18']/div/a";
	//public static String Invoice_closeButton="closeButton#xpath=//button[text()='cancel()']";
	public static String Invoice_closeButton="closeButton#xpath=//*[@class='fa fa-2x fa-times']";
	public static String Invoice_SearchInInvoiceTextBox="SearchInInvoiceTextBox#xpath=//*[@id='search']";
	public static String Invoice_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Invoice_SelectPending="SelectPending#xpath=//div[@class='input-sm ui-select-container ui-select-bootstrap dropdown ng-not-empty ng-valid ng-touched ng-dirty ng-valid-parse']";
	public static String Invoice_SelectFirstInvoice="SelectFirstInvoice#xpath=//*[@class='table']/tbody/tr[1]/td[1]/a";
	public static String Invoice_SelectFirstPO="SelectFirstPO#xpath=//*[@class='table']/tbody/tr[1]/td[2]";
	public static String Invoice_SelectAllUserDropDown="SelectAllUserDropDown#xpath=//input[@type='search']";
	public static String Invoice_SelectAllUser="SelectAllUser#xpath=//*[text()='All']";
	public static String Invoice_PageHeadText="PageHeadText#xpath=//div[@class='pagehead']";
	public static String Invoice_PageHeadTextIncludingPONum="PageHeadTextIncludingPONum#xpath=//div[@class='pagehead']/span";
	public static String Invoice_clickOnUploadFIle="clickOnUploadFIle#xpath=//*[@type='file']";
	public static String Invoice_PONUmInHeader="clickOnUploadFIle#xpath=//*[@class='pagehead']/span";
	public static String Invoice_SelectFirstPONUmFromInvoicePage="SelectFirstPONUmFromInvoicePage#xpath=//*[@class='table']/tbody/tr[1]/td[2]";
	public static String Invoice_SelectFirstInvoiceFromInvoicePage="SelectFirstInvoiceFromInvoicePage#xpath=//*[@class='table']/tbody/tr[1]/td[1]/a";
	public static String Invoice_DownoadPDF="Invoice_DownoadPDF#xpath=(//*[@class='fa fa-download'])[1]";
	public static String Invoice_PrintPDF="PrintPDF#xpath=(//*[@ng-click='openPDF()'])[1]";
	public static String Invoice_PrintPReviewWindow="PrintPReviewWindow#xpath=//*[contains(text(),'Print Invoice')]";
	public static String Invoice_vendorDropDownLabels="vendorDropDownLabels#xpath=//*[text()='Vendor:']";
	public static String Invoice_vendorDropDowns="vendorDropDown#xpath=//*[@name='vendor_name']";
	public static String Invoice_statusDropDowns="statusDropDown#xpath=//*[@name='status']";
	public static String Invoice_statusDropDownLabel="statusDropDownLabel#xpath=//label[@for='ddlStatus']";
	public static String Invoice_SearchBYDueDateDropDowns="statusDropDown#xpath=//*[@name='dateRange']";
	public static String Invoice_SearchBYDueDateLabel="statusDropDownLabel#xpath=//*[text()='Search by Due-Date']";
	
	public static String Invoice_FacilityLabel="facilityLabel#xpath=//*[text()='Facility']";
	public static String Invoice_facilityDateDropDowns="facilityDateDropDowns#xpath=//*[@name='facility']";
	public static String Invoice_departmentLabel="departmentLabel#xpath=//label[@for='depts']";
	public static String Invoice_departmentDropDown="departmentDropDown#xpath=//*[@name='depts']";
	public static String Invoice_OrderedByLabel="OrderedByLabel#xpath=//*[text()='Ordered By:']";
	public static String Invoice_OrderedByDropDown="OrderedByDropDown#xpath=//*[@name='ddlOrderby']";
	public static String Invoice_SentToAccounting="SentToAccounting#xpath=//button[contains(text()='SentToAccounting')]";
	public static String Invoice_Delete="Delete#xpath=(//i[@class='glyphicon glyphicon-trash text-danger action-button'])[1]";
	public static String Invoice_confirmButton="Invoice_confirmButton#xpath=//button[@class='confirm']";
	public static String Invoice_NoInvoiceFoundMessage="NoInvoiceFoundMessage#xpath=//*[text()='No Invoice Found']";
	
	
	//SHIPMENTS
	public static String Shipment_PageLink="PageLink#xpath=//*[@href='#/orders/shipments']";
	public static String Shipment_FirstShipmentNum="FirstShipmentNum#xpath=//*[@class='table table-striped']/tbody/tr[1]/td[1]/a";
	public static String Shipment_ShipmentPONum="ShipmentPONum#xpath=//*[@class='table table-striped']/tbody/tr[1]/td[2]";
	public static String Shipment_TrackingNum="TrackingNum#xpath=//*[@class='table table-striped']/tbody/tr[1]/td[6]/a";
	public static String Shipment_SearchTextBox="SearchTextBox#xpath=//*[@id='shipment-search']";
	public static String Shipment_SubmitButton="SubmitButton#xpath=//button[text()='Search']";
	//public static String Shipment_ShipmentDetailPAge="ShipmentDetailPage#xpath=//*[contains(text(),'Shipment#')]";
	public static String Shipment_ShipmentDetailPAge="ShipmentDetailPAge#xpath=//*[@class='pagehead ng-binding']";
	public static String Shipment_StatusDropDown="StatusDropDown#xpath=//*[@id='sel1']";
	
	public static String Shipment_ReceiveButtonText="ReceiveButtonText#xpath=//div[@class='pull-right']/button[3]";
	public static String Shipment_CloseButton="CloseButton#xpath=//div[@class='pull-right']/button[4]";

	//ORGSettings page

	public static String orgsetting_crosswalk="crosswalk#xpath=//*[@id='use_cross_walk_as_item_identifier']";
	public static String orgsetting_crosswalktext="crosswalktext#xpath=//input[@id='cross_walk_desc']";
	public static String orgsetting_IntactSetting="IntactSetting#xpath=//input[@id='intacct_integration']";
	public static String orgsetting_QuickBookIntegrationSetting="QuickBookIntegrationSetting#xpath=//input[@id='quick_book_integration']";		
	public static String orgsetting_AdminMenuText="AdminMenuText#xpath=//admin-menu//li[text()='Admin']";			
	public static String orgsetting_orgPageTextt="orgPageTextt#xpath=//div[@class='pagehead']";		
	public static String orgsetting_orgFeaturesPageText="orgFeaturesPage#xpath=//*[@class='sub-header-block' and text()='Inventory']";
	public static String orgsetting_orgBudgetPage="orgBudgetPage#xpath=//a[@href='#/admin/organization-budget']";
	public static String orgsetting_orgBudgetPageText="orgBudgetPageText#xpath=//div[@class='pagehead']";
	
	//Users Page
	public static String Users_page="Users_page#xpath=//*[@href='#/admin/users']";
	public static String Users_SearchByText="SearchByText#xpath=//*[@for='search-search']";
	public static String Users_SearchTextBox="SearchTextBox#xpath=//*[@class='form-group']//*[@id='search-search']";
	public static String Users_FacilityText="FacilityText#xpath=//*[@for='search-facility']";
	public static String Users_FacilityDropDown="FacilityDropDown#xpath=//*[@id='search-facility']";
	public static String Users_StatusText="Status#xpath=//*[@for='search-status']";
	public static String Users_StatusDropDown="StatusDropDown#xpath=//*[@id='search-status']";
	public static String Users_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Users_FirstUserName="FirstUserName#xpath=//*[@id='isotopeContainer']//*[@class='user-detail-container']//*[@class='ng-binding'][1]";
	public static String Users_FirstUserEmail="FirstUserEmail#xpath=//*[@id='isotopeContainer']//*[@class='user-detail-container']//*[@class='ng-binding'][3]";
	public static String Users_EditFirstUser="EditFirstUser#xpath=(//*[@ng-click='editUser(adminUserData.id)'])[1]";
	public static String Users_EditUserTextPopUp="EditUserTextPopUp#xpath=//*[contains,(text(), 'Edit User')]";
	public static String Users_NameEditBox="NameEditBox#xpath=//*[@id='name']";
	public static String Users_EmployeeEditBox="NameEditBox#xpath=//*[@id='employee_no']";
	public static String Users_NickNameEditBox="NickNameEditBox#xpath=//*[@id='nickname']";
	public static String Users_EmailEditBox="EmailEditBox#xpath=//*[@id='email']";
	public static String Users_PasswordEditBox="PasswordEditBox#xpath=//*[@id='password']";
	public static String Users_ConfirmPasswordEditBox="ConfirmPasswordEditBox#xpath=//*[@id='con_password']";
	public static String Users_ClosePopup="ClosePopup#xpath=//i[@class='fa fa-2x fa-times']";
	public static String Users_AddNewUser="AddNewUser#xpath=//button[@ng-click='createUser()']";
	public static String Users_AddUserPopupText="AddUserPopupText#xpath=//*[@class='modal-content']//span[2]";
	public static String Users_EditUserButton="EditUserButton#xpath=//button[@ng-click='editUser(adminUserData.id)']";
	public static String Users_EditUserPopupText="EditUserPopupText#xpath=//*[@class='modal-content']//span[1]";
	public static String Users_ChangePasswordButton="ChangePasswordButton#xpath=(//button[@ng-click='changePassword(adminUserData.id)'])[1]";
	public static String Users_ChangePasswordPopUpText="ChangePasswordPopUpText#xpath=//*[@class='headtext']";
	public static String Users_SaveButton="SaveButton#xpath=//*[@class='modal-footer']//button[@ng-click='saveUserFn(user)']";
	public static String Users_FacilityDropDownAddUSer="FacilityDropDownAddUSer#xpath=//*[@id='facility']";
	public static String Users_DepartmentDropDownAddUSer="FacilityDropDownAddUSer#xpath=//*[@id='department']";
	public static String Users_WaitDepartmentDropDownAddUSer="WaitFacilityDropDownAddUSer#xpath=//*[@id='department']/option";
	public static String Users_InventoryDropDownAddUSer="InventoryDropDownAddUSer#xpath=//*[@id='inventory']";
	public static String Users_WaitInventoryDropDownAddUSer="WaitInventoryDropDownAddUSer#xpath=//*[@id='inventory']";
	public static String Users_vendorAccessTab="vendorAccessTab#xpath=//li[@header='Vendor Access']/a";
	public static String Users_SelectVendorsDropDown="SelectVendorsDropDown#xpath=//*[@for='itemslist']//i[@class='fa fa-ellipsis-v autocomplete-show'";
	public static String Users_SelectAllVendors="SelectAllVendors#xpath=//button[contains(text(), 'Select all') and contains(@ng-click='selectAllItems()')]";

	
	//Facilities
	
	public static String Facilty_FacilityLink="FacilityLink#xpath=//*[@href='#/admin/facility']";	
	public static String Facilty_WaitforTableElem="WaitforTableElem#xpath=//*[@id='reqListing']";
	public static String Facilty_firstFacility="firstFacility#xpath=//*[@id='reqListing']//td[@class='ng-binding'][1]";
	public static String Facilty_SearchBox="SearchBox#xpath=//*[@id='search-search']";
	public static String Facilty_SearchButton="SearchButton#xpath=//button[@type='submit']";
	public static String Facilty_AddFacilityButton="AddFacilityButton#xpath=//button[@ng-click='createFacility()']";
	public static String Facilty_AddFacilityText="AddFacilityText#xpath=//*[@class='modal-header']//span[2]";
	public static String Facilty_EditFacility="EditFacility#xpath=//i[@class='fa fa-edit']";
	public static String Facilty_EditFacilityText="AddFacilityText#xpath=//*[@class='modal-header']//span[1]";
	public static String Facilty_firstDepartmentName="firstDepartmentName#xpath=(//ul[@class='facility_department_sublist']//li[@class='facility_department_sublistitem ng-binding ng-scope'])[1]";
	public static String Facilty_firstdrillDown="firstdrillDown#xpath=(//button[@class='btn btn-sm btn-default rounded-button ng-scope'])[1]";
	//Receive Module	
	public static String Receive_statusDropdownOptions="statusDropdownOptions#xpath=//*[@id='status']/ul/li//span[@class='ui-select-choices-row-inner']/span";
	public static String Receive_pageLink="pageLink#xpath=//*[@href='#/orders/receive']";
	public static String Receive_wait="wait#xpath=//*[@class='table']/thead/tr";
	public static String Receive_statusDropdown="statusDropdown#xpath=//*[@id='status']";
	public static String Receive_vendorDropdown="vendorDropdown#xpath=//*[@id='vendor']";
	public static String Receive_typeDropdown="typeDropdown#xpath=//*[@id='type']";
	public static String Receive_facilityDropdown="typeDropdown#xpath=//*[@id='facility']";
	public static String Receive_departmentDropdown="typeDropdown#xpath=//*[@id='depts']";
	public static String Receive_createdByDropdown="typeDropdown#xpath=//*[@id='creater']";
	public static String Receive_NotesLink="NotesLink#xpath=(//*[@class='pull-right dropdown']/a[@ng-click='openPONote(order)'])[1]";
	public static String Receive_NotesLinkText="NotesLinkText#xpath=(//*[@class='modal-header']//span[@class='ng-binding'])[1]";
	public static String Receive_AddNewNotesLink="AddNewNotesLink#xpath=//button[@ng-click='createNewNoteFn();']";
	public static String Receive_DocsLink="DocsLink#xpath=(//*[@class='pull-right dropdown']/a[@ng-click='attachFiles(order)'])[1]";
	public static String Receive_DocsLinkText="DocsLinkText#xpath=(//*[@class='modal-header']//*[@class='headtext ng-binding'])[1]";
	public static String Receive_DrillDownIcon="DrillDownIcon#xpath=(//*[@class='fa fa-chevron-down'])[1]";
	public static String Receive_PrintPOLink="PrintPOLink#xpath=(//*[@class='dropdown-menu']//*[@ng-click='openPDF()'])[1]";
	public static String Receive_PrintPOText="PrintPOText#xpath=(//*[@class='modal-header']//*[@class='ng-binding'])[1]";
	public static String Receive_InvoiceForText="InvoiceForText#xpath=(//*[@class='pagehead'])[1]";
	
	public static String Receive_AllInvoiceLink="AllInvoiceLink#xpath=(//a[text()='All Invoices'])[1]";
	public static String Receive_firstPONum="firstPONum#xpath=(//*[@class='table']//a[@class='ng-binding'])[1]";
	public static String Receive_PrintItems="PrintItems#xpath=(//*[@ng-click='downloadPdf(order)']";
	public static String Receive_PrintitemsText="PrintitemsText#xpath=(*//[@class='headtext']/span[1])";
	public static String Receive_firstPOHeadingText="firstPOHeadingText#xpath=(//*[class='pagehead ng-binding'])[1]";

}






