package LIVE.PASHAGLOBAL_WEB;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_MobileNo_ValidCredentials_Success {
	WebDriver driver;
	
	@Given("^Chrome browser, valid URL, Go button, valid mobile number, valid password and login button for suribet client$")
	public void chrome_browser_valid_URL_Go_button_valid_mobile_number_valid_password_and_login_button_for_suribet_client() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://pashaglobal.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("^Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter valid mobile number & password and click on Login butotn  for suribet client$")
	public void open_the_chrome_browser_Enter_the_valid_URL_click_on_Go_button_click_on_login_button_enter_valid_mobile_number_password_and_click_on_Login_butotn_for_suribet_client() throws Throwable {
	   //clicking on login button and entering valid account id credentials
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("9597171584");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("mansoor@123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		
		boolean menu = driver.findElement(By.id("DisplayBalance1")).isDisplayed();
		Assert.assertTrue(menu);
		Thread.sleep(1000);
	}

	@Then("^User should be able to login to pasha global website successfully post entering valid mobile number and balance should be displayed for suribet client$")
	public void user_should_be_able_to_login_to_pasha_global_website_successfully_post_entering_valid_mobile_number_and_balance_should_be_displayed_for_suribet_client() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}
