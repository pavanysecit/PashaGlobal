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

public class Mobile_Superbet_InValidLogin_AccountId_CardNo_ValidCredentials_Failure {

	private static AppiumDriver<MobileElement> driver;

	@Given("^Mobile: Chrome browser, valid URL, Go button, pasha global\\(super bet\\) Invalid account id, Invalid password and login button$")
	public void mobile_Chrome_browser_valid_URL_Go_button_pasha_global_super_bet_Invalid_account_id_Invalid_password_and_login_button() throws Throwable {
		
	}

	@When("^Mobile:Open the chrome browser, Enter the valid URL, click on Go button, select the super bet client,  click on login button, enter Invalid account id & password  with both mail and account id and click on Login butotn$")
	public void mobile_Open_the_chrome_browser_Enter_the_valid_URL_click_on_Go_button_select_the_super_bet_client_click_on_login_button_enter_Invalid_account_id_password_with_both_mail_and_account_id_and_click_on_Login_butotn() throws Throwable {
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

		WebElement login = driver.findElement(By.id("txt_Login_Email"));
		login.sendKeys("jklosi124@gmail.com");
		Thread.sleep(1000);
		WebElement login1 = driver.findElement(By.id("txt_login_password"));
		login1.sendKeys("test@123");
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.id("btnLogin"));
		submit.click();
		Thread.sleep(5000);

		WebElement message = driver.findElement(By.cssSelector(".vtext.vlogin_password"));
		System.out.println();
		Assert.assertEquals("Please verify your email and password!", message.getText());	
		System.out.println("Valid user message is displayed for user: "+message.getText());

		//Verify the invalid email format
		login.clear();
		login.sendKeys("jklosi124@gmail.com.");
		submit.click();
		Thread.sleep(5000);
		WebElement message1 = driver.findElement(By.cssSelector(".vtext.vlogin_email"));
		Assert.assertEquals("* Please Enter valid Email", message1.getText());	
		System.out.println("Valid user message1 is displayed for user: "+message1.getText() );


		//Invalid account number
		login.clear();
		login.sendKeys("123456789");
		submit.click();
		Thread.sleep(5000);
		WebElement message2 = driver.findElement(By.cssSelector(".vtext.vlogin_password"));
		Assert.assertEquals("Please verify your email and password!", message2.getText());	
		System.out.println("Valid user message2 is displayed for user: "+  message2.getText());

		// Valid account num and password length lesser than 3
		login.clear();
		login.sendKeys("3180143384");
		login1.clear();
		login1.sendKeys("112");
		submit.click();
		Thread.sleep(5000);
		WebElement message3 = driver.findElement(By.cssSelector(".vtext.vlogin_password"));
		Assert.assertEquals("*Please enter minimum 4 character password.", message3.getText());	
		System.out.println("Valid user message3 is displayed for user: "+ message3.getText());


		//Valid suribet client credentials for superbet client
		login.clear();
		login.sendKeys("pmansoorktr@gmail.com");
		login1.clear();
		login1.sendKeys("mansoor@123");
		submit.click();
		Thread.sleep(5000);
		WebElement message4 = driver.findElement(By.cssSelector(".vtext.vlogin_password"));
		Assert.assertEquals("Invalid Account Id for Superbet", message4.getText());	
		System.out.println("Valid user message4 is displayed for user: "+ message4.getText() );

	}

	@Then("^Mobile: User should not be able to login website successfully post entering defined error message should be addressed for user in superbet client$")
	public void mobile_User_should_not_be_able_to_login_website_successfully_post_entering_defined_error_message_should_be_addressed_for_user_in_superbet_client() throws Throwable {
		driver.quit();
	}
}
