package PASHAGLOBAL_MOBILE;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Mobile_OnlineGame_Categories_DifferentCategories {
	AppiumDriver<MobileElement> driver;

	public Mobile_OnlineGame_Categories_DifferentCategories() throws InterruptedException {
		this.driver = Mobile_PashaGlobal_URL_Login.getDriver();
	}
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link and different tabs for each game categories$")
	public void mobile_chrome_browser_valid_URL_Go_button_valid_login_details_Online_games_link_and_different_tabs_for_each_game_categories() throws Throwable {

	}

	@When("^Mobile: Navigate to pasha global website by entering valid URL, click on online games link and click on each tab to find out category$")
	public void mobile_navigate_to_pasha_global_website_by_entering_valid_URL_click_on_online_games_link_and_click_on_each_tab_to_find_out_category() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		//Clicking on different tab and verifying it
		driver.getContext();
		System.out.println(driver.getContext());
		Thread.sleep(2000);
//		MobileElement sub = driver.findElement(By.id("tabonlinegame"));
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click();", sub);
//		Thread.sleep(5000);
		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(5000);
		//tab.isDisplayed();
		//System.out.println(tab.isDisplayed());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Tab_0")));
		driver.findElement(By.id("Tab_0")).click();
		Thread.sleep(3000);
		String actual = driver.findElement(By.id("Tab_0")).getText();
		String expected = "ALL";
		Assert.assertEquals(expected, actual);
		Thread.sleep(2000);
		
		driver.findElement(By.id("Tab_1")).click();
		Thread.sleep(1000);
		String actual1 = driver.findElement(By.id("Tab_1")).getText();
		String expected1 = "Slots";
		Assert.assertEquals(expected1, actual1);
		Thread.sleep(2000);
		
		driver.findElement(By.id("Tab_2")).click();
		Thread.sleep(1000);
		String actual2 = driver.findElement(By.id("Tab_2")).getText();
		String expected2 = "Fruit";
		Assert.assertEquals(expected2, actual2);
		Thread.sleep(2000);
		
		driver.findElement(By.id("Tab_3")).click();
		Thread.sleep(1000);
		String actual3 = driver.findElement(By.id("Tab_3")).getText();
		String expected3 = "Cards";
		Assert.assertEquals(expected3, actual3);
		Thread.sleep(2000);
		
		driver.findElement(By.id("Tab_4")).click();
		Thread.sleep(1000);
		String actual4 = driver.findElement(By.id("Tab_4")).getText();
		String expected4 = "Roulettes";
		Assert.assertEquals(expected4, actual4);
		Thread.sleep(2000);
	}

	@Then("^Mobile: User should able to navigate to different tabs for each category$")
	public void mobile_user_should_able_to_navigate_to_different_tabs_for_each_category() throws Throwable {
	   driver.quit();
	}
}