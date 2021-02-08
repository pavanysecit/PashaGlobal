package PASHAGLOBAL_MOBILE;

import java.net.URL;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Mobile_Superbet_Login_AccountId_CardNo_ValidCredentials_Success {
	
	private static AppiumDriver<MobileElement> driver;
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, pasha global\\(super bet\\) valid account id, valid password and login button$")
	public void mobile_Chrome_browser_valid_URL_Go_button_pasha_global_super_bet_valid_account_id_valid_password_and_login_button() throws Throwable {

	}

	@When("^Mobile:Open the chrome browser, Enter the valid URL, click on Go button, select the super bet client,  click on login button, enter valid account id & password  with both mail and account id and click on Login butotn$")
	public void mobile_Open_the_chrome_browser_Enter_the_valid_URL_click_on_Go_button_select_the_super_bet_client_click_on_login_button_enter_valid_account_id_password_with_both_mail_and_account_id_and_click_on_Login_butotn() throws Throwable {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "ASUS X00TD");
		cap.setCapability("udid", "JAAAGF10Z743V8H");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("skipDeviceInitialization", true);
		cap.setCapability("skipServerInstallation", true);
		cap.setCapability("ignoreUnimportantViews", true);
		cap.setCapability("disableAndroidWatchers", true);
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		
		driver=new AndroidDriver<MobileElement>(url,cap);
		
		System.out.println("Appium started sucessfully");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://onlinegames.pashaglobal.com");

	   //clicking on login button and entering valid credentials
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UnserlnkLogin")));
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@onclick ='SuperBetAccounts()']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("jiklosi124@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("test@123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spaccountid")));
		WebElement AccountID = driver.findElement(By.id("spaccountid"));
		Assert.assertTrue(AccountID.isDisplayed());
		WebElement CurrentyType = driver.findElement(By.id("DisplayBalance2"));
		String currency = CurrentyType.getText();
		Assert.assertEquals("GYD", currency);
		System.out.println("Login with valid mail ID is successfull");
		
		//Logoff from the account 
		WebElement logoff = driver.findElement(By.id("login_but"));
		logoff.click();
		Thread.sleep(5000);

		
		//Login with valid Account ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UnserlnkLogin")));
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@onclick ='SuperBetAccounts()']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("3180143384");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("test@123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spaccountid")));
		WebElement AccountId = driver.findElement(By.id("spaccountid"));
		Assert.assertTrue(AccountId.isDisplayed());
		WebElement Currency1 = driver.findElement(By.id("DisplayBalance2"));
		Assert.assertEquals("GYD", Currency1.getText());
		System.out.println("Login with valid Account ID is successfull");
		
	}

	@Then("^Mobile: User should be able to login website successfully post entering valid online account details and online account balance should be displayed  for superbet client$")
	public void mobile_User_should_be_able_to_login_website_successfully_post_entering_valid_online_account_details_and_online_account_balance_should_be_displayed_for_superbet_client() throws Throwable {
	    driver.quit();
	}
}