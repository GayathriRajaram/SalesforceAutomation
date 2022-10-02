package Com.Salesforce.test.basetest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Com.Salesforce.test.utility.CommonUtilities;
import Com.Salesforce.test.utility.GenerateReports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

		public static WebDriver driver = null;
		public static WebDriverWait wait = null;
		public static Logger logger =LogManager.getLogger(BaseTest.class);
		public static GenerateReports report=null;
		@BeforeTest
		public static void setupBeforeTest() {
			report=GenerateReports.getInstane();
			report.startExtentReports();
		}
		@Parameters({ "browsername" })
		
		@BeforeMethod
		
		public static void setUp(String browsername, Method m ) {
			logger.info("before method execution started");
			report.startsingleTestReport(m.getName());
			getdriver(browsername);
			CommonUtilities CU = new CommonUtilities();
			Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
			String url = CU.getApplicationProperty("url", applicationPropertiesFile);
			gotourl(url);
			waitUntilPageLoads();
		}
		
		@AfterMethod
		public static void tearDown() {
			logger.info("after method execution is started");
			closeBrowser();
		}	
		@AfterTest
		public static void teardownAfterTest() {
			report.endReport();
		}
		public static void closeBrowser() {
			
			driver.close();
		}
		public static void getdriver(String browser) {
			switch(browser) {
			case "firefox":
					WebDriverManager.firefoxdriver().setup();
						
			driver=new FirefoxDriver();
							break;
			case "chrome":	
				 	WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
							break;
			case "edge"	:
				    WebDriverManager.edgedriver().setup();
				         driver=new EdgeDriver();
				         break;
			default: break;
			
			}			 
			
		}
		public static void gotourl(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}
		public static void closebrowser() {
			driver.close();
		}
		public static void closeallbrowser() {
			driver.quit();
		}
		public static String getPageTitle() {
			return driver.getTitle();
		}

		private static void waitUntilPageLoads() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		}
		public static void refreshPage() {
			driver.navigate().refresh();
			report.logTestinfo("current page is refreshed");
		}
		
		public static void entertext(WebElement element, String text,String objname ) {
			if(element.isDisplayed()) {
				clearelement( element, objname);
			     element.sendKeys(text);
			     report.logTestinfo("The text is entered on "+objname);
			}else
				report.logTestfail("the element is not displayed"+objname);
		}	
 		
		public static String readText(WebElement element, String objectName) {
			waitUntilVisible(element, objectName);
			String text = element.getText();
			return text;
		}

		
		public static void waitUntilVisible(WebElement element, String objName) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public static void waitUntilAlertIsPresent() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
		}

		public static void waitUntilElementToBeClickable(By locator, String objName) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		public static Alert switchToAlert() {
			waitUntilAlertIsPresent();
			return driver.switchTo().alert();

		}
		public static void AcceptAlert(Alert alert) {

			report.logTestinfo("Alert accepted");
			alert.accept();

		}

		public static String getAlertText(Alert alert) {

			return alert.getText();

		}

		public static void dismisAlert() {
			waitUntilAlertIsPresent();
			Alert alert = switchToAlert();
			alert.dismiss();
		    report.logTestinfo("Alert dismissed");

		}
		public static void clearelement(WebElement element,String objname){
			element.clear();
			report.logTestinfo("Cleared "+objname);
			
		}
		public static void clickelement(WebElement element,String objname) {
			if (element.isDisplayed()) {
				element.click();
				report.logTestinfo("The element "+objname+"  is clicked");
			}else
				report.logTestfail("The element "+objname+"is not displayed");
			
		}

		public static void WaitExplicit(WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public static void WaituntilElementLocated(String xpath) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		
		public static void WaituntilClickable(WebElement path) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(path));
			
		}
		
		public static void methodforSelectClass(WebElement element,String Text) {
			Select select=new Select(element);
			select.selectByVisibleText(Text);
		}
		
		public static void logintosalesforce() throws Exception {
			
			CommonUtilities CU = new CommonUtilities();
			Properties applicationPropertiesFile = CU.loadFile("applicationProperties");

			String url = CU.getApplicationProperty("url", applicationPropertiesFile);
			String UserName = CU.getApplicationProperty("username", applicationPropertiesFile);
			String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			WebElement username = driver.findElement(By.xpath(".//input[@id='username']"));
			entertext(username, UserName, "username");
			WebElement password = driver.findElement(By.xpath(".//input[@id='password']"));
			entertext(password, passwrd, "password");
			WaituntilElementLocated("//input[@id='Login']");
			WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
			clickelement(login, "Login");
		}
		public static void ImplicitWaitmethod() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		public static void pageLoadmethod() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		public static void WaituntilElementLocate(By locator,String element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		public static void assertEqualsMethod(String expected,String actual) {
			 assertEquals(expected,actual);
		}
		public static void IsDisplaymethod(WebElement errormessage) throws Exception {
			boolean result = errormessage.isDisplayed();

			if (result) {
				String path=TakeScreenShotElement(errormessage);
				report.attachScreeshot(path);
				report.logTestpassed("Test case passed");
			}else
				report.logTestfail("Test case failed");
			
		}
		public static void verifyelement(WebElement element) throws Exception {
			if (element.isDisplayed()) {
				TakeScreenShotElement(element);
				report.logTestinfo("Userdropdown menu is there");
				report.logTestpassed("Test case passed");
			} else
			   report.logTestfail("Test case Failed");
		}
		public static void logout() {
			driver.findElement(By.cssSelector("#userNavLabel")).click();
			WebElement logout=driver.findElement(By.linkText("Logout"));
			clickelement(logout,"logout");
			driver.manage().timeouts().getPageLoadTimeout();
		}
		public static void selectByTextData(WebElement element, String text, String objName) {
			Select selectCity = new Select(element);
			selectCity.selectByVisibleText(text);
			report.logTestinfo(objName + " seelcted " + text);

		}

		public static void selectByIndexData(WebElement element, int index, String objName) {
			Select selectCity = new Select(element);
			selectCity.selectByIndex(index);
		}

		public static void selectByValueData(WebElement element, String text) {
			Select selectCity = new Select(element);
			selectCity.selectByValue(text);
		}
		public static void Switchtowindow(String parentwin) {
			Set <String> windows=driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			while(it.hasNext()) {
				String childwin=it.next();


				if(!parentwin.equals(childwin))
				{
				driver.switchTo().window(childwin);

				report.logTestinfo(driver.switchTo().window(childwin).getTitle());
				//driver.close();
				
			}
		}
		}
		public static void switchToWindowOpned(String mainWindowHandle) {
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
				if (!mainWindowHandle.equalsIgnoreCase(handle))
					driver.switchTo().window(handle);
			}
			report.logTestinfo("switched to new window");
		}
		public static void modalcontainermethod() {
		WebElement modalContainer = driver.findElement(
                By.id("tryLexDialog"));
		modalContainer.findElement(By.id("tryLexDialogX")).click();
		driver.switchTo().defaultContent();
		}
		public static WebElement selectFromList(List<WebElement> list,String text) {
			WebElement country=null;
			for (WebElement i : list) {
				if (i.getText().equalsIgnoreCase(text)) {
					System.out.println("selected=" +i.getText());
					country=i;
					break;
				}
				
			}
			return country;
		}
		public static void Takescreeshotofscreen() {
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			File dstFile=new File(System.getProperty("user.dir")+"/screenshots/"+filename+".jpg");
			
			try {
				FileHandler.copy(srcfile, dstFile);
			} catch (IOException e) {
				e.printStackTrace();
				report.logTestinfo("problem occured during take screenshot");
				
			}
		}
		public static String TakeScreenShotElement(WebElement element) throws Exception {
			File srcfile=element.getScreenshotAs(OutputType.FILE);
			String text=element.getText();
			String filename=new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			File dstFile=new File(System.getProperty("user.dir")+"/screenshots/"+text+filename+".jpg");
			try {
				FileHandler.copy(srcfile, dstFile);
				report.logTestinfo(filename+"screenshot taken");
			} catch (IOException e) {
				e.printStackTrace();
				report.logTestinfo("problem occured during take screenshot");			
			}
			return dstFile.getAbsolutePath();
			}
		public static void Takescreeshotofscreen1() {
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			File dstFile=new File(System.getProperty("user.dir")+"/screenshots/"+filename+".jpg");
			
			try {
				FileHandler.copy(srcfile, dstFile);
			} catch (IOException e) {
				e.printStackTrace();
				report.logTestinfo("problem occured during take screenshot");
				
			}
		}
		public static void TakeScreenShotElement1(WebElement element) {
			File srcfile=element.getScreenshotAs(OutputType.FILE);
			String filename=new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			File dstFile=new File(System.getProperty("user.dir")+"/screenshots/"+filename+".jpg");
			try {
				FileHandler.copy(srcfile, dstFile);
			} catch (IOException e) {
				e.printStackTrace();
				report.logTestinfo("problem occured during take screenshot");
				
			}
			}
		
}