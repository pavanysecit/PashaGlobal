package PASHAGLOBAL_MOBILE;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobile_Login_CardNo_InValidCredentials_Failure {
	WebDriver driver;
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, Invalid card number, card pin and login button$")
	public void mobile_chrome_browser_valid_URL_Go_button_Invalid_card_number_card_pin_and_login_button() throws Throwable {
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
		
		driver.navigate().to("https://onlinegames.pashaglobal.com");
	}

	@When("^Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter invalid card number & card pin and click on Login butotn$")
	public void mobile_open_the_chrome_browser_Enter_the_valid_URL_click_on_Go_button_click_on_login_button_enter_invalid_card_number_card_pin_and_click_on_Login_butotn() throws Throwable {
	   //clicking on login button and entering valid credentials
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div")).click();
		Thread.sleep(1000);
		
		WebElement UN = driver.findElement(By.id("txt_Login_Email"));
		UN.sendKeys("2111649489988867");
		Thread.sleep(1000);
		
		WebElement PWD = driver.findElement(By.id("txt_login_password"));
		PWD.sendKeys("1125");
		Thread.sleep(1000);
		WebElement login  = driver.findElement(By.id("btnLogin"));
		login.click();
		Thread.sleep(3000);
		
		String actual = driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/span[2]")).getText();
		String expected = "Please Enter a Valid Card Number and Pin-6 !";
		Assert.assertEquals(expected, actual);
		
		UN.clear();
		UN.sendKeys("2111649489988826");
		Thread.sleep(1000);
		
		PWD.clear();
		PWD.sendKeys("1234");
		Thread.sleep(2000);
		
		login.click();
		Thread.sleep(2000);
		
		String actual1 = driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/span[2]")).getText();
		String expected1 = "Incorrect Pin";
		Assert.assertEquals(expected1, actual1);
	}

	@Then("^Mobile: User should be failed to login to the website post entering invalid card details for suribet client$")
	public void mobile_user_should_be_failed_to_login_to_the_website_post_entering_invalid_card_details_for_suribet_client() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}
