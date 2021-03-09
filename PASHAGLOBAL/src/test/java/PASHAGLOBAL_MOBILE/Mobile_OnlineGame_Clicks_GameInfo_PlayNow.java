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


public class Mobile_OnlineGame_Clicks_GameInfo_PlayNow extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_Clicks_GameInfo_PlayNow() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Game Info link and PlayNow link$")
	public void mobile_Chrome_browser_valid_URL_Go_button_valid_login_details_Online_games_link_Game_Info_link_and_PlayNow_link() throws Throwable {
	   
	}

	@When("^Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Game Info link on any slot game and Click on PlayNow link$")
	public void mobile_Navigate_to_pasha_global_website_by_entering_valid_URL_click_on_online_games_link_click_on_Game_Info_link_on_any_slot_game_and_Click_on_PlayNow_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		//Clicking on GameInfo link

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		//WebElement gameinfo = driver.findElement(By.xpath("//*[contains(@onclick,'GameInfo/SG_FruitClub.jpg')]"));
		WebElement gameinfo = driver.findElement(By.xpath("/html/body/div[19]/div[4]/div/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/ul/li[7]/div[1]/div/div[2]/ul/li[1]"));
		String actual = gameinfo.getText();
		String expected = "Game Info";
		Assert.assertEquals(expected, actual);
		gameinfo.click();
		
		//Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@src ,'/GameInfo/SG_FruitClub.jpg')]")));
		boolean image = driver.findElement(By.xpath("//*[contains(@src ,'/GameInfo/SG_FruitClub.jpg')]")).isDisplayed();
		System.out.println(image);
		Assert.assertTrue(image);
		Thread.sleep(2000);
		System.out.println("Game Info page is loaded");
		driver.findElement(By.xpath("//*[contains(@onclick,'ClearContent();')]")).click();
		//driver.findElement(By.cssSelector(".close_icon.sprite_img")).click();
		Thread.sleep(5000);
	}

	@Then("^Mobile: Game info page for particular slot game should get displayed$")
	public void mobile_game_info_page_for_particular_slot_game_should_get_displayed() throws Throwable {
		// Clicking on Play Now link
		//WebElement playnow = driver.findElement(By.xpath("//*[contains(@onclick,'machineName=FruitClub&GameId=52')]"));
		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[6]/div[1]/div/div[1]/div"));
		String actual2 = playnow.getText();
		String expected2 = "PLAY NOW";
		Assert.assertEquals(expected2, actual2);
		playnow.click();
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));
		MobileElement balT = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		balT.sendKeys("555");
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 555 ");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String balance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected = "555.00";
		Assert.assertEquals(balance, expected);
		System.out.println("Current balance of the account is: " +balance);
		System.out.println("Transeffered balance and Available balance of the slot game is same. Test case Passed.");
	}

	@Then("^Mobile: PlayNow page should get displayed for that particular game which is clicked$")
	public void mobile_playnow_page_should_get_displayed_for_that_particular_game_which_is_clicked() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}
