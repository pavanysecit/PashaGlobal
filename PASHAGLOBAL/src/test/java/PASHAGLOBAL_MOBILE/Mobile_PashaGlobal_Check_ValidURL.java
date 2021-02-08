package PASHAGLOBAL_MOBILE;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Mobile_PashaGlobal_Check_ValidURL {
	private static AppiumDriver<MobileElement> driver;
	
	@Given("^Mobile: Chrome browser, pasha global valid URL and Go button$")
	public void mobile_chrome_browser_pasha_global_valid_URL_and_Go_button() throws Throwable {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "ASUS X00TD");
		cap.setCapability("udid", "JAAAGF10Z743V8H");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("ignoreUnimportantViews", true);
		
		URL url=new URL("http://10.10.13.84:4723/wd/hub");
		
		driver=new AndroidDriver<MobileElement>(url,cap);
		
		System.out.println("Appium started sucessfully");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://onlinegames.pashaglobal.com");
		Thread.sleep(3000);

	}

	@When("^Mobile: Open the chrome browser, Enter the valid  pasha global URL and click on Go button$")
	public void mobile_open_the_chrome_browser_Enter_the_valid_pasha_global_URL_and_click_on_Go_button() throws Throwable {
	   boolean plogo = driver.findElement(By.className("pasha_logo")).isDisplayed();
	   Assert.assertTrue(plogo);
	}

	@Then("^Mobile: User should be able to see the pasha global logo after login$")
	public void mobile_user_should_be_able_to_see_the_pasha_global_logo_after_login() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}