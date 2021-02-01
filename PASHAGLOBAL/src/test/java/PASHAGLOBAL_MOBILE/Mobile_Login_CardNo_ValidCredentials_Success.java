package PASHAGLOBAL_MOBILE;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobile_Login_CardNo_ValidCredentials_Success {
	WebDriver driver;
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, valid card number, valid card pin and login button$")
	public void mobile_chrome_browser_valid_URL_Go_button_valid_card_number_valid_card_pin_and_login_button() throws Throwable {
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
		
		URL url=new URL("http://10.10.13.84:4723/wd/hub");
		
		driver=new AndroidDriver<MobileElement>(url,cap);
		
		System.out.println("Appium started sucessfully");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://pashaglobal.com/");
	}

	@When("^Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter valid card number & valid card pin and click on Login butotn$")
	public void mobile_open_the_chrome_browser_Enter_the_valid_URL_click_on_Go_button_click_on_login_button_enter_valid_card_number_valid_card_pin_and_click_on_Login_butotn() throws Throwable {
	   //clicking on login button and entering valid account id credentials
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("2111649489988826");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("1125");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(6000);
		
		boolean menu = driver.findElement(By.id("DisplayBalance1")).isDisplayed();
		Assert.assertTrue(menu);
		Thread.sleep(1000);
	}

	@Then("^Mobile: User should be able to login to website successfully post entering valid card details and card balance should be displayed$")
	public void mobile_user_should_be_able_to_login_to_website_successfully_post_entering_valid_card_details_and_card_balance_should_be_displayed() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}