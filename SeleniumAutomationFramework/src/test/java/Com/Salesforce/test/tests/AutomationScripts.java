package Com.Salesforce.test.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import Com.Salesforce.test.utility.GenerateReports;
import Com.Salesforce.test.utility.GenerateReports;
import Com.Salesforce.test.basetest.BaseTest;
import Com.Salesforce.test.utility.CommonUtilities;
import Com.Salesforce.test.utility.Constants;

public class AutomationScripts extends BaseTest {
	
	
	@Test
	public static void loginwithvalidCredentials02() throws Exception{
		logintosalesforce();
		report.logTestinfo(getPageTitle());
	}
	@Test
	public static void loginErrorMessage01() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");

		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String UserName = CU.getApplicationProperty("username", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
		WebElement username = driver.findElement(By.xpath(".//input[@id='username']"));
		entertext(username,UserName,"username");
		WebElement password = driver.findElement(By.xpath(".//input[@id='password']"));
		clearelement(password,"password");
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickelement(login,"login");
		WebElement errormessage = driver.findElement(By.xpath("//input[@id='Login']"));
		IsDisplaymethod(errormessage);

	}
	@Test
	public static void checkRememberMe03() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String UserName = CU.getApplicationProperty("username", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
		WebElement username = driver.findElement(By.xpath(".//input[@id='username']"));
		entertext(username,UserName,"username");
		WebElement password = driver.findElement(By.xpath(".//input[@id='password']"));
		entertext(password, passwrd, "password");
		WebElement rememberme = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		clickelement(rememberme,"rememberme");
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickelement(login,"login");
		pageLoadmethod();
		WebElement result = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		IsDisplaymethod(result);
		String currenturl = driver.getCurrentUrl();
		report.logTestinfo(currenturl);
		logout();
		pageLoadmethod();
		ImplicitWaitmethod();
		String actualurl=(driver.getCurrentUrl());
		WebElement identity = driver.findElement(By.cssSelector("#idcard-identity"));
		IsDisplaymethod(identity);
	}
	@Test
	public static void forgotPassword4A() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		WebElement forgotpwd = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickelement(forgotpwd,"forgotpwd");
		WebElement Id = driver.findElement(By.xpath("//input[@id='un']"));
		entertext(Id,"testsree@tekarch.com","username");
		WebElement continuebutton = driver.findElement(By.xpath("//input[@id='continue']"));
		clickelement(continuebutton,"continuebutton");
		WebElement actualmessage = driver.findElement(By.xpath("//h1[@id='header']"));
		IsDisplaymethod(actualmessage);
	}
	@Test
	public static void wrongCredential4B() throws Exception {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		String UserName = CU.getApplicationProperty("username", applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
		WebElement username = driver.findElement(By.xpath(".//input[@id='username']"));
		entertext(username,"admin123","username");
		WebElement password = driver.findElement(By.xpath(".//input[@id='password']"));
		entertext(password, "123", "password");	
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		clickelement(login,"login");
		ImplicitWaitmethod();
		WebElement result = driver.findElement(By.xpath("//div[@id='error']"));
		IsDisplaymethod(result);
	}
	@Test
	public static void selectUsermenuDropDown05() throws Exception {
    	logintosalesforce();
		WebElement usermenu=driver.findElement(By.cssSelector("#userNavButton"));
		clickelement(usermenu,"usermenu");
		WebElement result = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		ImplicitWaitmethod();
		verifyelement(result);
		WebElement result1 = driver.findElement(By.linkText("My Profile"));
		verifyelement(result1);
		WebElement result2 = driver.findElement(By.linkText("Developer Console"));
		verifyelement(result2);
		WebElement result3 = driver.findElement(By.linkText("Switch to Lightning Experience"));
		verifyelement(result3);
		WebElement result4 = driver.findElement(By.linkText("My Settings"));
		verifyelement(result4);
		WebElement home=driver.findElement(By.linkText("Home"));
		clickelement(home,"Home");

	}

	@Test
	public static void SelectMyProfileoptionusermenudropdown06() throws Exception {
		logintosalesforce();
		WebElement usermenu = driver.findElement(By.cssSelector("#userNavLabel"));
		clickelement(usermenu, "usermenu");
		WaituntilElementLocate(By.linkText("My Profile"), "myprofile");
		WebElement profile = driver.findElement(By.linkText("My Profile"));
		clickelement(profile, "profile");
		ImplicitWaitmethod();
		waitUntilElementToBeClickable(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]"), "icon");
		WaituntilElementLocate(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]"), "icon");
		pageLoadmethod();
		WebElement editicon = driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]"));
		ImplicitWaitmethod();
		Thread.sleep(2000);
		clickelement(editicon, "editicon");
		report.logTestinfo("Hello waiting for frame");
		WaituntilElementLocate(By.xpath("//*[@id=\"contactInfoContent\"]"), "frame");
		driver.switchTo().frame("contactInfoContentId");
		report.logTestinfo("switching to about tab");
		WaituntilElementLocate(By.xpath("//a[contains(text(),'About')]"), "About");
		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		clickelement(about, "about");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		entertext(lastname, "Sree", "lastname");
		TakeScreenShotElement(lastname);
		WebElement save = driver.findElement(By.xpath("//input[@value=\"Save All\"]"));
		clickelement(save, "save");
		driver.switchTo().defaultContent();
		WebElement post = driver.findElement(By.xpath("//a[@id=\"publisherAttachTextPost\"]"));
		clickelement(post, "post");
		TakeScreenShotElement(post);
		WebElement postframe = driver.findElement(By.xpath("//iframe[@class=\"cke_wysiwyg_frame cke_reset\"]"));
		driver.switchTo().frame(postframe);
		WebElement posttext = driver.findElement(By.xpath(
				"/html/body[@class=\"chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr placeholder cke_show_borders\"]"));
		entertext(posttext, "Hello welcome", "posttext");
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//*[@id=\"publishersharebutton\"]"), "share");
		WebElement share = driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]"));
		clickelement(share, "share");
		WaituntilElementLocate(By.xpath("//*[@id=\"publisherAttachContentPost\"]"), "File");
		Thread.sleep(2000);
		WebElement File = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]"));
		clickelement(File, "File");
		WaituntilElementLocate(By.linkText("Upload a file from your computer"), "upload");
		WebElement upload = driver.findElement(By.linkText("Upload a file from your computer"));
		clickelement(upload, "upload");
		WaituntilElementLocate(By.id("chatterFile"), "choosefile");
		WebElement choosefile = driver.findElement(By.id("chatterFile"));
		choosefile.sendKeys("C:\\Users\\Gayathri\\Downloads\\test.txt");
		driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]")).click();
		report.logTestinfo("post was shared");
		Actions action = new Actions(driver);
		ImplicitWaitmethod();
		WaituntilElementLocate(By.id("displayBadge"), "id");
		WebElement uploadphoto = driver.findElement(By.id("displayBadge"));
		action.moveToElement(uploadphoto).build().perform();
		Thread.sleep(2000);
		WaituntilElementLocate(By.id("uploadLink"), "addphoto");
		driver.findElement(By.id("uploadLink")).click();
		report.logTestinfo("file uploaded");
		driver.switchTo().frame("uploadPhotoContentId");
		WebElement choosephoto = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]"));
		choosephoto.sendKeys("C:\\Users\\Gayathri\\Downloads\\download.jpg");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]")).click();
		WaituntilElementLocate(By.xpath("//input[@class='btn saveButton']"), "save");
		driver.findElement(By.xpath("//input[@class='btn saveButton']")).click();
		Thread.sleep(2000);
		report.logTestinfo("Photouploaded");

	}
	@Test
	public static void mySettingfomUserMenu07() throws Exception {
		logintosalesforce();
		driver.findElement(By.cssSelector("#userNavLabel")).click();
		WebElement mysetting=driver.findElement(By.linkText("My Settings"));
		clickelement(mysetting,"mysetting");
		Thread.sleep(3000);
		//WaituntilElementLocated("#PersonalInfo_font");
		WebElement personal=driver.findElement(By.cssSelector("#PersonalInfo_font"));
		clickelement(personal,"personal");
		Thread.sleep(2000);
		WebElement loginhistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		clickelement(loginhistory,"loginhistory");
		Thread.sleep(2000);
		WebElement downloadfile=driver.findElement(By.partialLinkText("Download login histo"));
		clickelement(downloadfile,"downloadfile");
		WebElement displaylayout=driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		clickelement(displaylayout,"displaylayout");
		WebElement customizetab=driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		clickelement(customizetab,"customizetab");
		WebElement customdropdown=driver.findElement(By.cssSelector("#p4"));
		Select select=new Select(customdropdown);
		select.selectByVisibleText("Salesforce Chatter");
		WebElement availabletab=driver.findElement(By.cssSelector("#duel_select_0"));
		Select select1=new Select(availabletab);
		select1.selectByValue("report");
		WebElement addicon=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		clickelement(addicon,"addicon");
		WebElement savebtn=driver.findElement(By.xpath("//input[@class='btn primary']"));
		clickelement(savebtn,"savebtn");
		
	}
	
	@Test
	public static void selectDeveloperConsole08() throws Exception {
		logintosalesforce();
		String parentwin=driver.getWindowHandle();
		WebElement usermenu=driver.findElement(By.cssSelector("#userNavLabel"));
		clickelement(usermenu,"usermenu");
		String abc=TakeScreenShotElement(usermenu);
		report.attachScreeshot(abc);
		//WaituntilElementLocated("Developer Console");
		WebElement devconsole=driver.findElement(By.linkText("Developer Console"));
		clickelement(devconsole,"devconsole");
		String path=TakeScreenShotElement(devconsole);
		report.attachScreeshot(path);
		//report.attachScreeshot("");
		switchToWindowOpned(parentwin);
		driver.switchTo().window(parentwin);
		report.logTestinfo(parentwin);
	}
	@Test
	public static void logoutFromSalesForce09() throws Exception {
		logintosalesforce();
		logout();
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		report.logTestinfo(currenturl);
		
	}
	@Test
	public static void creatanAccount10(Method m) throws Exception {
		logintosalesforce();
		WebElement account=driver.findElement(By.linkText("Accounts"));
		clickelement(account,"account");	
		WaituntilElementLocated("//*[@id=\"tryLexDialog\"]");
		modalcontainermethod();
		Thread.sleep(2000);
		WebElement newaccount=driver.findElement(By.xpath("//input[@name='new']"));
		clickelement(newaccount,"newaccount");
		WebElement acname=driver.findElement(By.xpath("//input[@id='acc2']"));
		entertext(acname,"Test123","acname");
		WebElement type=driver.findElement(By.id("acc6"));
		methodforSelectClass(type,"Technology Partner");
		WebElement priority=driver.findElement(By.id("00N4x00000Ws2ri"));
		methodforSelectClass(priority,"High");	
		WebElement save=driver.findElement(By.xpath("//input[@name='save']"));
		clickelement(save,"save");
		driver.getCurrentUrl();
		WebElement createdaccount=driver.findElement(By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
		String actual=createdaccount.getText();
		Assert.assertEquals(actual, "Test123");
		report.logTestpassed(logger.getName());
		String path=TakeScreenShotElement(createdaccount);
		report.attachScreeshot(path);
	}
	@Test
	public static void creatNewview11() throws Exception {
		logintosalesforce();
		WebElement account=driver.findElement(By.linkText("Accounts"));
		clickelement(account,"account");
		WaituntilElementLocated("//*[@id=\"tryLexDialog\"]");
		modalcontainermethod();
		WebElement newview=driver.findElement(By.linkText("Create New View"));
		clickelement(newview,"newview");
		WaituntilElementLocated("//*[@id=\"fname\"]");
		driver.findElement(By.id("fname")).sendKeys("NewView123");
		driver.findElement(By.id("devname")).sendKeys("NewView123");
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")).click();	
		WebElement selectedoption=driver.findElement(By.name("fcf"));
		Select select=new Select(selectedoption);
		WebElement option=select.getFirstSelectedOption();
		String actual=option.getText();
	    assertEquals(actual,"NewView123");
		String path=TakeScreenShotElement(option);
		report.logTestpassed(logger.getName());
		report.attachScreeshot(path);
	}
	@Test
	public static void createEditView12(Method m) throws Exception {
		logintosalesforce();
		ImplicitWaitmethod();
		pageLoadmethod();
		WebElement account=driver.findElement(By.linkText("Accounts"));
		clickelement(account,"account");
		WaituntilElementLocated("//*[@id=\"tryLexDialog\"]");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		By edit=(By.linkText("Edit"));
		WaituntilElementLocate(edit ,"edit");
		driver.findElement(edit).click();
		WaituntilElementLocate(By.id("fname"),"viewname");
		WebElement fname=driver.findElement(By.xpath("//input[@id='fname']"));
		entertext(fname,"Account456","viewname");
		WaituntilElementLocate(By.id("devname"),"viewuniquename");
		WebElement uniqueviewname=driver.findElement(By.xpath("//input[@id='devname']"));
		entertext(uniqueviewname,"Account456","viewname");
		WebElement accountfilter=driver.findElement(By.id("fcol1"));
		methodforSelectClass(accountfilter,"Account Name");
		WebElement accountfilter1=driver.findElement(By.id("fop1"));
		methodforSelectClass(accountfilter1,"contains");
		driver.findElement(By.id("fval1")).sendKeys("a");
		WebElement accountdropdown=driver.findElement(By.id("colselector_select_0"));
		methodforSelectClass(accountdropdown,"Last Activity");
		WaituntilElementLocate(By.xpath("//a[@id='colselector_select_0_right']//img[@class='rightArrowIcon']"),"Addicon");
		driver.findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@class='rightArrowIcon']")).click();
		driver.findElement(By.xpath("//input[@class='btn primary' and @type='submit']")).click();
		WebElement result=driver.findElement(By.xpath("//div[@class='x-grid3-hd-inner x-grid3-hd-ACCOUNT_LAST_ACTIVITY']"));
		TakeScreenShotElement(result);
		String actual=result.getText();
		assertEqualsMethod("Last Activity",actual);
		report.logTestpassed(m.getName());
			
	}	
	@Test
	public static void mergeAccounts13(Method m) throws Exception {
		logintosalesforce();
		WaituntilElementLocated("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a");
		driver.findElement(By.linkText("Merge Accounts")).click();
		WaituntilElementLocated("//input[@id='srch']");
		driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("Test");
		driver.findElement(By.xpath("//div/input[@name='srchbutton']")).click();
		WebElement checkbox=driver.findElement(By.id("cid1"));
		if(checkbox.isSelected()) {
			checkbox.click();
		}
		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]")).click();
		WaituntilElementLocated("//input[@name='save']");
		driver.findElement(By.xpath("//input[@name='save']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		try {
		Boolean result=driver.findElement(By.linkText("Test123")).isDisplayed();
		if(result)
			report.logTestfail(m.getName());
		
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
			System.out.println("Merge was successful");
		}
		catch(Exception e) {
			report.logTestinfo(e.getMessage());
			report.logTestpassed(m.getName());
		}
		
	}
	@Test	
	public static void creatReport14(Method m) throws Exception {
		
		logintosalesforce();
		pageLoadmethod();
		ImplicitWaitmethod();
		WebElement account=driver.findElement(By.linkText("Accounts"));
		clickelement(account,"account");
		WaituntilElementLocated("//*[@id=\"tryLexDialog\"]");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WebElement activity=driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		clickelement(activity,"activity");
		WaituntilElementLocate(By.xpath("//input[@id='ext-gen20']")," Date");
		WebElement Datefield=driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		clickelement(Datefield,"datefield");				
		WaituntilElementLocate(By.xpath("//img[@id='ext-gen152']"),"Fromicon");
		driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
		WaituntilElementLocate(By.xpath("//button[contains(@id,'ext-gen')]"),"Date");
		driver.findElement(By.xpath("//button[contains(@id,'ext-gen')]")).click();
		WaituntilElementLocate(By.xpath("//img[@id='ext-gen154']"),"to");
		WebElement to=driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		clickelement(to,"to");
		WaituntilElementLocate(By.xpath("//button[contains(@id,'ext-gen')]"),"Date");
		driver.findElement(By.xpath("//button[contains(@id,'ext-gen')]")).click();
		Thread.sleep(2000);
		WaituntilElementLocate(By.xpath("//button[@id='ext-gen49']"),"save");
		driver.findElement(By.xpath("//button[@id='ext-gen49']")).click();
		WebElement savedialog=driver.findElement(By.xpath("//div[@id='ext-gen304']"));
		savedialog.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("Report1");
		savedialog.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).sendKeys("accountreport1");
		savedialog.findElement(By.xpath("//button[@id='ext-gen306']")).click();
		driver.switchTo().defaultContent();
						
	}
	@Test
	public static void oppourtunitiesDropDown15() throws Exception {
		logintosalesforce();
		WaituntilElementLocated("//a[@class='brandPrimaryFgr']");
		WebElement opportunities=driver.findElement(By.linkText("Opportunities"));
		clickelement(opportunities,"Opportunities");
		WebElement opportunitiesdropdown= driver.findElement(By.id("fcf"));
		Select select=new Select(opportunitiesdropdown);
		List <WebElement> options=select.getOptions();
		int size=options.size();
		for(int i=0;i<size;i++) {
			WebElement op=options.get(i);
			report.logTestfail(op.getText());
			TakeScreenShotElement(op);
		}
	}
	@Test
	public static void createnewOppourtunity16() throws Exception {
		logintosalesforce();
		WebElement opportunities=driver.findElement(By.linkText("Opportunities"));
		clickelement(opportunities,"Opportunities");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']")).click();
		driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("newopppo");
		driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("Test1");
		driver.findElement(By.xpath("//input[@id='opp9']")).click();
		driver.findElement(By.xpath("//a[@class='calToday']")).click();
		driver.switchTo().defaultContent();
		WebElement element1=driver.findElement((By.xpath("//select[@id='opp6']")));
		methodforSelectClass(element1, "Web ");
		WebElement element=driver.findElement(By.xpath("//select[@id='opp11']"));
		methodforSelectClass(element,"Value Proposition");
		WebElement textbox=driver.findElement(By.xpath("//input[@id='opp12']"));
		entertext(textbox,"70","Accountname");		
		driver.findElement(By.xpath("//input[@id='opp17']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@name='save']")).click();
		WebElement newoppo=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[1]/h2"));
		TakeScreenShotElement(newoppo);
		report.logTestinfo(newoppo.getText());
		}
	@Test
	public static void OppoPipelineReport17() throws Exception {
		logintosalesforce();
		//ImplicitWaitmethod();
		pageLoadmethod();
		WaituntilElementLocate(By.linkText("Opportunities")," opportunities");
		WebElement opportunities=driver.findElement(By.linkText("Opportunities"));
		clickelement(opportunities,"Opportunities");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		WaituntilElementLocate( By.linkText("Opportunity Pipeline")," Opportunity Pipeline");
		WebElement OpportunityPipeline=driver.findElement(By.linkText("Opportunity Pipeline"));
		clickelement(OpportunityPipeline,"Opportunity Pipeline");
		TakeScreenShotElement(OpportunityPipeline);
		report.attachScreeshot("GENERATE_REPORT_PATH");
		String actual=driver.getTitle();
		assertEqualsMethod( "Opportunity Pipeline ~ Salesforce - Developer Edition", actual);
		report.logTestinfo("Test passed");
		
	}
	@Test
	public static void stuckoppoReport18() throws Exception {
		logintosalesforce();
		//ImplicitWaitmethod();
		pageLoadmethod();
		WaituntilElementLocate(By.linkText("Opportunities")," opportunities");
		WebElement opportunities=driver.findElement(By.linkText("Opportunities"));
		clickelement(opportunities,"Opportunities");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		WaituntilElementLocate( By.linkText("Stuck Opportunities")," Stuck Opportunities");
		WebElement stuckreport=driver.findElement(By.linkText("Stuck Opportunities"));
		clickelement(stuckreport,"Stuck Opportunities");
		TakeScreenShotElement(stuckreport);
		String actual=driver.getTitle();
		String expect="Stuck Opportunities ~ Salesforce - Developer Edition";
		assertEqualsMethod( expect, actual);
		report.logTestpassed(actual);
		
	}
	@Test
	public static void quaterlySummeryReport19() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Opportunities")," opportunities");
		WebElement opportunities=driver.findElement(By.linkText("Opportunities"));
		clickelement(opportunities,"Opportunities");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		WebElement quaterly=driver.findElement(By.id("quarter_q"));
		methodforSelectClass(quaterly,"Current FQ");
		WebElement quaterly1=driver.findElement(By.id("open"));
		methodforSelectClass(quaterly1,"All Opportunities");
		driver.findElement(By.xpath("//tbody/tr[3]/td[1]/input[1]")).click();
		String expected="Opportunity Report ~ Salesforce - Developer Edition";
		String actual=driver.getTitle();
		assertEqualsMethod(expected,actual);
		report.logTestinfo(actual);
		driver.navigate().back();
		
	}
	@Test
	public static void checkLeadsTab20() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Leads")," Leads");
		WebElement Leads=driver.findElement(By.linkText("Leads"));
		clickelement(Leads,"Leads");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		String expected="Leads: Home ~ Salesforce - Developer Edition";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		report.logTestpassed(actual);
	}
	@Test
	public static void leadSelectView21() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Leads")," Leads");
		WebElement Leads=driver.findElement(By.linkText("Leads"));
		clickelement(Leads,"Leads");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WebElement leadsdrop=driver.findElement(By.id("fcf"));
		Select select=new Select(leadsdrop);
		List <WebElement>options=select.getOptions();
		for(WebElement op:options) {
			report.logTestinfo(op.getText());
		TakeScreenShotElement(op);
		}
	}	
	@Test
	public static void defaultView22() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Leads")," Leads");
		WebElement Leads=driver.findElement(By.linkText("Leads"));
		clickelement(Leads,"Leads");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WebElement leadsdrop=driver.findElement(By.id("fcf"));
		methodforSelectClass(leadsdrop,"My Unread Leads");
		logout();
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Leads")," Leads");
		WebElement Leads1=driver.findElement(By.linkText("Leads"));
		clickelement(Leads1,"Leads");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WebElement leadsdrop1=driver.findElement(By.id("fcf"));
		Select select1=new Select(leadsdrop1);
		WebElement defaultoption=select1.getFirstSelectedOption();
		String selectedoption=defaultoption.getText();
		report.logTestinfo(defaultoption.getText());
		TakeScreenShotElement(defaultoption);
		assertEquals(selectedoption,"My Unread Leads");
		WaituntilElementLocate(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/input[1]"),"Go");
		WebElement go=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/input[1]"));
		clickelement(go,"go");
		report.logTestinfo(driver.getTitle());
	}
	@Test
	public static void todaysLead23() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Leads")," Leads");
		WebElement Leads=driver.findElement(By.linkText("Leads"));
		clickelement(Leads,"Leads");
		report.logTestinfo("test is running");		
		WebElement lead=driver.findElement(By.id("fcf"));
		methodforSelectClass(lead,"Today's Leads");
		String url=driver.getCurrentUrl();
		report.logTestinfo("test is done  :"+  url);
		
	}
	@Test
	public static void checkNewbuttonLeadspage24() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Leads")," Leads");
		WebElement Leads=driver.findElement(By.linkText("Leads"));
		clickelement(Leads,"Leads");
		WaituntilElementLocate(By.id("tryLexDialog"),"dialog");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//input[@name='new']"),"new");
		WebElement newbutton=driver.findElement(By.xpath("//input[@name='new']"));
		clickelement(newbutton,"new");	
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='save']")).click();
		WebElement heading=driver.findElement(By.xpath("//h2[@class='topName']"));
		assertEquals(heading.getText(),"ABCD");
		TakeScreenShotElement(heading);
		report.logTestpassed("Test passed");
	}
	@Test
	public static void createNewContact25() throws Exception {
		
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//tbody/tr[1]/td[2]/input[1]"),"new");
		WebElement newbutton=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clickelement(newbutton,"newbutton");
		WebElement lastname=driver.findElement(By.cssSelector("input#name_lastcon2"));
		entertext(lastname,"lname","lastname");
		WebElement accountname=driver.findElement(By.cssSelector("input#con4"));
		entertext(accountname,"acname","accountname");
		WebElement save=driver.findElement(By.xpath("//input[@class='btn' and @tabindex='31']"));
		clickelement(save,"save");
		WaituntilElementLocate(By.xpath("//h2[contains(text(),'Contact Detail')]"),"NewContact");
		WebElement element=driver.findElement(By.xpath("//h2[contains(text(),'Contact Detail')]"));
		TakeScreenShotElement(element);
		String actual=element.getText();
		assertEquals(actual,"Contact Detail");
		report.logTestpassed("Testpassed");
	}
	@Test
	public static void createNewcontactView26() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.linkText("Create New View"),"createnewview");
		WebElement newview=driver.findElement(By.linkText("Create New View"));
		clickelement(newview,"newview");
		WebElement viewname=driver.findElement(By.id("fname"));
		entertext(viewname,"viewtest","viewname");
		WebElement uniquename=driver.findElement(By.id("devname"));
		entertext(uniquename,"viewtest","uniquename");
		WebElement save=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickelement(save,"save");
		Select select=new Select(driver.findElement(By.id("\"00B4x00000IYqmQ_listSelect\"")));
		WebElement selectedview=select.getFirstSelectedOption();
		TakeScreenShotElement(selectedview);
		String actual=selectedview.getText();
		assertEquals(actual,"viewtest");
		report.logTestpassed("Test passed");
	}
	@Test
	public static void checkRecentlyCreatedView27() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WebElement recentdrop=driver.findElement(By.id("hotlist_mode"));
		String title=driver.getTitle();
		methodforSelectClass(recentdrop,"Recently Created");
		report.logTestinfo(title);
	}
	@Test
	public static void mycontactView28() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WebElement dropdown=driver.findElement(By.id("fcf"));
		methodforSelectClass(dropdown,"My Contacts");
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
		WaituntilElementLocate(By.xpath("//*[@id=\"00B4x00000Gr5UH_topNav\"]"),"navbar");
		WebElement element=driver.findElement(By.xpath("//*[@id=\"00B4x00000Gr5UH_topNav\"]"));
		Boolean result=driver.findElement(By.xpath("//*[@id=\"00B4x00000Gr5UH_topNav\"]")).isDisplayed();
		TakeScreenShotElement(element);
		if(result)
			report.logTestpassed("Contacts displayed:passed");
		else
			report.logTestfail("no contacts so failed");
		
	}	
	
	@Test
	public static void viewContactPage29() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[1]/h3"),"Recentcontact");
		WebElement contact=driver.findElement(By.linkText("sree"));
		clickelement(contact,"contact");
		TakeScreenShotElement(contact);
		WaituntilElementLocate(By.xpath("//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2"), "details");
		Boolean result=driver.findElement(By.xpath("//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2")).isDisplayed();
		if(result)
			report.logTestpassed("contact details displayed:passed");
		else
			report.logTestfail("No contacts :failed");
	}
	@Test
	public static void newViewerrormessage30() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.linkText("Create New View"),"createnewview");
		WebElement newview=driver.findElement(By.linkText("Create New View"));
		clickelement(newview,"newview");
		WebElement uniquename=driver.findElement(By.id("devname"));
		entertext(uniquename,"viewtest","uniquename");
		WebElement save=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickelement(save,"save");
		WebElement errormsg=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));
		TakeScreenShotElement(errormsg);
		if(errormsg.isDisplayed())
			report.logTestpassed("you should give view name to save the newview");
		else
			report.logTestfail("Testcase failed");
	}
	@Test
	
	public static void checkCanecelbuttonCreatenewView31() throws Exception {
		
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.linkText("Create New View"),"createnewview");
		WebElement newview=driver.findElement(By.linkText("Create New View"));
		clickelement(newview,"newview");
		WebElement viewname=driver.findElement(By.id("fname"));
		entertext(viewname,"ABCD","viewname");
		WebElement uniquename=driver.findElement(By.id("devname"));
		entertext(uniquename,"EFGH","uniquename");
		WebElement cancel=driver.findElement(By.xpath("//input[@name='cancel']"));
		clickelement(cancel,"cancelbutton");
		WebElement dropdown=driver.findElement(By.id("fcf"));
		try {
		methodforSelectClass(dropdown,"ABCD");
		}
		catch(Exception e) {
			System.out.println("TestcasePassed: View is not created");
		}
		TakeScreenShotElement(dropdown);
		
		
	}
	@Test
	
	public static void checkSaveNewbuttonContact32() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Contacts")," Contacts");
		WebElement Contacts=driver.findElement(By.linkText("Contacts"));
		clickelement(Contacts,"Contacts");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//tbody/tr[1]/td[2]/input[1]"),"new");
		WebElement newbutton=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clickelement(newbutton,"newbutton");
		WebElement lastname=driver.findElement(By.cssSelector("input#name_lastcon2"));
		entertext(lastname,"Test000","lastname");
		WebElement accountname=driver.findElement(By.cssSelector("input#con4"));
		entertext(accountname,"Test123","accountname");
		WebElement savenew=driver.findElement(By.xpath("//input[@name='save_new']"));
		clickelement(savenew,"savenew");
		WebElement editcontact=driver.findElement(By.xpath("//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2"));
		IsDisplaymethod(editcontact);
		TakeScreenShotElement(editcontact);
		
	}
	@Test
	
	public static void verifyfnameLnameofuser33() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Home")," Home");
		WebElement Home=driver.findElement(By.linkText("Home"));
		clickelement(Home,"Home");
		WaituntilElementLocate(By.linkText("Test Sree")," Test Sree");
		WebElement fullname=driver.findElement(By.linkText("Test Sree"));
		clickelement(fullname,"fullname");
		WebElement profileimg=driver.findElement(By.xpath("//*[@id=\"photoSection\"]/span[2]/img[1]"));
		IsDisplaymethod(profileimg);
		

	}
	@Test
	
	public static void verifyeditLastnameofuser34() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Home")," Home");
		WebElement Home=driver.findElement(By.linkText("Home"));
		clickelement(Home,"Home");
		modalcontainermethod();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.linkText("Test Sree")," Test Sree");
		WebElement fullname=driver.findElement(By.linkText("Test Sree"));
		clickelement(fullname,"fullname");		
		waitUntilElementToBeClickable(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]"), "icon");
		WebElement editicon = driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]"));
		pageLoadmethod();			
		Thread.sleep(2000);
		clickelement(editicon,"pencilicon");
		Thread.sleep(2000);
		WaituntilElementLocate(By.xpath("//*[@id=\"contactInfoContent\"]"), "frame"); 
		 driver.switchTo().frame("contactInfoContentId");
		WaituntilElementLocate(By.xpath("//a[contains(text(),'About')]"), "About");
		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		clickelement(about, "about");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		entertext(lastname, "ABCD", "lastname");
		WebElement save = driver.findElement(By.xpath("//input[@value=\"Save All\"]"));
		clickelement(save, "save");
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.partialLinkText("Test")," Test");
		WebElement updatedname=driver.findElement(By.partialLinkText("Test"));
		Assert.assertEquals("Test ABCD", "Test ABCD");
		TakeScreenShotElement(updatedname);
		WaituntilElementLocate(By.cssSelector("#userNav")," usermenu");
		WebElement usermenu=driver.findElement(By.cssSelector("#userNav"));
		Assert.assertEquals("Test ABCD", "Test ABCD");
		TakeScreenShotElement(usermenu);
	
	}
	@Test
	
	public static void verifyTabcustamization35()  {
	try {
		logintosalesforce();
		pageLoadmethod();
		WebElement alltabimg=driver.findElement(By.xpath("//a/img[@title='All Tabs']"));
		clickelement(alltabimg,"alltabimg");
		waitUntilElementToBeClickable(By.cssSelector(".btnImportant"),"custamizetab");
		WebElement custamizetab=driver.findElement(By.cssSelector(".btnImportant"));
		clickelement(custamizetab,"custamizetab");
		waitUntilElementToBeClickable(By.id("duel_select_1"),"selectedtab");
		WebElement selectedtab=driver.findElement(By.id("duel_select_1"));
		methodforSelectClass(selectedtab,"Card Payment Methods");
		waitUntilElementToBeClickable(By.xpath("//a/img[@class='leftArrowIcon']"),"removearrow");
		WebElement removearrow=driver.findElement(By.xpath("//a/img[@class='leftArrowIcon']"));
		clickelement(removearrow,"removearrow");
		TakeScreenShotElement(removearrow);
		try {
		WebElement Availabletab=driver.findElement(By.id("duel_select_0"));
		methodforSelectClass(Availabletab,"Card Payment Methods");
		report.logTestinfo("card payment method tab is avaialble on available tab");
		
		}
		catch(Exception e) {
		report.logTestinfo("Selected tab is not removed");
		}
		WebElement save=driver.findElement(By.xpath("//input[@class='btn primary']"));
		clickelement(save,"save");
		pageLoadmethod();
		try {
			WebElement removedtab=driver.findElement(By.linkText("Card Payment Methods"));
			methodforSelectClass(removedtab,"Card Payment Methods");
			report.logTestinfo("card payment method tab is available");
			TakeScreenShotElement(removedtab);
			}
			catch(Exception e) {
			report.logTestinfo("Selected tab is  removed");
			}
		logout();
		logintosalesforce();
		pageLoadmethod();
		try {
			WebElement removedtab=driver.findElement(By.linkText("Card Payment Methods"));
			methodforSelectClass(removedtab,"Card Payment Methods");
			report.logTestpassed("card payment method tab is  available");
			}
			catch(Exception e) {
			report.logTestpassed("Selected tab is removed");
			}
	}catch(Exception e) {
		report.logTestFailedWithException(e);
	}
    }
	
	@Test
	public static void blockinganEventCalender36() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Home")," Home");
		WebElement Home=driver.findElement(By.linkText("Home"));
		clickelement(Home,"Home");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"),"today");
		WebElement today=driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		clickelement(today,"today");
		WaituntilElementLocate(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"),"8PM");
		WebElement schedule=driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
		clickelement(schedule,"schedule");
		WaituntilElementLocate(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"),"combo");
		WebElement combo=driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		clickelement(combo,"combo");
		String mainWindow=driver.getWindowHandle();
		Switchtowindow(mainWindow);	
		//driver.switchTo().defaultContent();
		WebElement other=driver.findElement(By.linkText("Other"));
		clickelement(other,"other");
		driver.switchTo().window(mainWindow);
		WaituntilElementLocate(By.xpath("//*[@id=\"EndDateTime_time\"]"),"endtime");
		//WebElement time=driver.findElement(By.xpath("//*[@id=\"timePickerItem_47\"]"));
		//TakeScreenShotElement(time);
		WebElement endtime=driver.findElement(By.xpath("//*[@id=\"EndDateTime_time\"]"));
		clickelement(endtime,"endtime");
		WaituntilElementLocate(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"),"save");
		WebElement save=driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		clickelement(save,"save");
		WaituntilElementLocate(By.xpath("//*[@id=\"p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:i\"]/div/div"),"appointment");
		WebElement appointment=driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:i\"]/div/div"));
		IsDisplaymethod(appointment);
		TakeScreenShotElement(appointment);
		
		
	}
	
	public static void blockingEventRecurring37() throws Exception {
		logintosalesforce();
		WaituntilElementLocate(By.linkText("Home")," Home");
		WebElement Home=driver.findElement(By.linkText("Home"));
		clickelement(Home,"Home");
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		WaituntilElementLocate(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"),"today");
		WebElement today=driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		clickelement(today,"today");
		WaituntilElementLocate(By.xpath("//*[@id=\"p:f:j_id25:j_id61:26:j_id64\"]/a"),"7PM");
		WebElement schedule=driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:26:j_id64\"]/a"));
		clickelement(schedule,"schedule");
		WaituntilElementLocate(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"),"combo");
		WebElement combo=driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		clickelement(combo,"combo");
		String mainWindow=driver.getWindowHandle();
		Switchtowindow(mainWindow);	
		WebElement other=driver.findElement(By.linkText("Other"));
		clickelement(other,"other");
		driver.switchTo().window(mainWindow);
		WaituntilElementLocate(By.xpath("//*[@id=\"EndDateTime_time\"]"),"endtime");
		WebElement endtime=driver.findElement(By.xpath("//*[@id=\"EndDateTime_time\"]"));
		clickelement(endtime,"endtime");
		WaituntilElementLocate(By.xpath("//*[@id=\"IsRecurrence\"]"),"recurrence");
		WebElement recurrence=driver.findElement(By.xpath("//*[@id=\"IsRecurrence\"]"));
		clickelement(recurrence,"recurrence");
		WaituntilElementLocate(By.xpath("//*[@id=\"rectypeftw\"]"),"weekly");
		WebElement weekly=driver.findElement(By.xpath("//*[@id=\"rectypeftw\"]"));
		clickelement(weekly,"weekly");
		WaituntilElementLocate(By.xpath("//*[@id=\"RecurrenceEndDateOnly\"]"),"enddate");
		WebElement enddate=driver.findElement(By.xpath("//*[@id=\"RecurrenceEndDateOnly\"]"));
		entertext(enddate,"10/10/2022", "enddate");
		WaituntilElementLocate(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"),"save");
		WebElement save=driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		clickelement(save,"save");
		WaituntilElementLocate(By.xpath("//*[@id=\"p:f:j_id25:j_id69:26:j_id71:0:j_id72:calendarEvent:i\"]/div/div"),"recurrence");
		WebElement recurrence1=driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id69:26:j_id71:0:j_id72:calendarEvent:i\"]/div/div"));
		IsDisplaymethod(recurrence1);
		WaituntilElementLocate(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[2]/span[2]/a[3]/img"),"monthview");
		WebElement monthview=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[2]/span[2]/a[3]/img"));
		clickelement(monthview,"monthview");
		WaituntilElementLocate(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[2]/span[4]/a[2]/img"),"leftarrow");
		WebElement rightarrow=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[2]/span[4]/a[2]/img"));
		clickelement(rightarrow,"rightarrow");
		WaituntilElementLocate(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[6]/div[2]"),"events");
		WebElement event1=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[6]/div[2]"));
		IsDisplaymethod(event1);
		TakeScreenShotElement(event1);
		WaituntilElementLocate(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[6]/div[2]"),"events");
		WebElement event2=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[6]/div[2]"));
		IsDisplaymethod(event2);
		TakeScreenShotElement(event2);
		
	}

}