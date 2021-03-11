package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Mobile_OnlineGame_Click_TryNow_CheckBalance extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_Click_TryNow_CheckBalance() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Try Now link and default balance$")
	public void mobile_Chrome_browser_valid_URL_Go_button_valid_login_details_Online_games_link_Try_Now_link_and_default_balance() throws Throwable {
	   
	}

	@When("^Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Try Now link on any slot game and check balance$")
	public void mobile_Navigate_to_pasha_global_website_by_entering_valid_URL_click_on_online_games_link_click_on_Try_Now_link_on_any_slot_game_and_check_balance() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		//Clicking on Try Now link
		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		//WebElement trynow = driver.findElement(By.xpath("//*[contains(@onclick,'GameInfo/SG_FruitClub.jpg')]//following::li"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@onclick,'SG_FruitClub.jpg')]/parent::ul/li[2]")));
		WebElement trynow = driver.findElement(By.xpath("//li[contains(@onclick,'SG_FruitClub.jpg')]/parent::ul/li[2]"));
		String actual1 = trynow.getText();
		String expected1 = "Try Now";
		Assert.assertEquals(expected1, actual1);
		Thread.sleep(2000);
		trynow.click();
		Thread.sleep(3000);
		driver.context("NATIVE_APP");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String actual2 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected2 = "5,000.00";
		Assert.assertEquals(expected2, actual2);
		System.out.println("Current Balance of the account in Trynow mode is : "+actual2);
	}

	@Then("^Mobile: Try Now page should get loaded along with default balance of (\\d+)$")
	public void mobile_Try_Now_page_should_get_loaded_along_with_default_balance_of(int arg1) throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}