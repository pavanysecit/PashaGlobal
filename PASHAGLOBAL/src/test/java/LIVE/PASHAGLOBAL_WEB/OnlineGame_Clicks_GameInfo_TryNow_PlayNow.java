package LIVE.PASHAGLOBAL_WEB;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineGame_Clicks_GameInfo_TryNow_PlayNow {
WebDriver driver;
	
	@Given("^Chrome browser, valid URL, Go button, valid login details, Online games link, Game Info link, TryNow link and PlayNow link$")
	public void chrome_browser_valid_URL_Go_button_valid_login_details_Online_games_link_Game_Info_link_TryNow_link_and_PlayNow_link() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		new PashaGlobal_Web_URL_Login(driver);
	}

	@When("^Navigate to pasha global website by entering valid URL, click on online games link, click on Game Info link on any slot game , Click on TryNow link and Click on PlayNow link$")
	public void navigate_to_pasha_global_website_by_entering_valid_URL_click_on_online_games_link_click_on_Game_Info_link_on_any_slot_game_Click_on_TryNow_link_and_Click_on_PlayNow_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		//Clicking on GameInfo link
		driver.findElement(By.xpath("/html/body/div[19]/div[4]/div/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/ul/li[3]/div[1]/div/div[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		
		String actual = driver.findElement(By.xpath("/html/body/div[17]/div/h3")).getText();
		String expected = "Game Info";
		Assert.assertEquals(expected, actual);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[17]/div/h3/label")).click();
		Thread.sleep(3000);
	}

	@Then("^Game info page for particular slot game should get displayed$")
	public void game_info_page_for_particular_slot_game_should_get_displayed() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[19]/div[4]/div/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/ul/li[3]/div[1]/div/div[2]/ul/li[2]")).click();
		Thread.sleep(2000);
		
		
	}

	@Then("^TryNow page should get displayed with default balance of (\\d+)$")
	public void trynow_page_should_get_displayed_with_default_balance_of(int arg1) throws Throwable {
	    
	}

	@Then("^PlayNow page should get displayed for that particular game which is clicked$")
	public void playnow_page_should_get_displayed_for_that_particular_game_which_is_clicked() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}
