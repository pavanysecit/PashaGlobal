package LIVE.PASHAGLOBAL_WEB;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PashaGlobal_Check_ValidURL {
WebDriver driver;
	
	@Given("^Chrome browser, pasha global valid URL and Go button$")
	public void chrome_browser_pasha_global_valid_URL_and_Go_button() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://pashaglobal.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("^Open the chrome browser, Enter the valid  pasha global URL and click on Go button$")
	public void open_the_chrome_browser_Enter_the_valid_pasha_global_URL_and_click_on_Go_button() throws Throwable {
	   boolean plogo = driver.findElement(By.className("pasha_logo")).isDisplayed();
	   Assert.assertTrue(plogo);
	}

	@Then("^User should be able to see the pasha global logo after login$")
	public void user_should_be_able_to_see_the_pasha_global_logo_after_login() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}