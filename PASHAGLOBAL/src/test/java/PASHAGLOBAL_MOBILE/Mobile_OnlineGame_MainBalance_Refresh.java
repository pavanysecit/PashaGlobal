package PASHAGLOBAL_MOBILE;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Mobile_OnlineGame_MainBalance_Refresh {
	AppiumDriver<MobileElement> driver;

	public Mobile_OnlineGame_MainBalance_Refresh() throws InterruptedException {
		this.driver = Mobile_PashaGlobal_URL_Login.getDriver();
	}
	
	@Given("^Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Play Now link and  balance refresh$")
	public void mobile_Chrome_browser_valid_URL_Go_button_valid_login_details_Online_games_link_Play_Now_link_and_balance_refresh() throws Throwable {
	    
	}

	@When("^Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Play Now link on any slot game and go back to main page$")
	public void mobile_Navigate_to_pasha_global_website_by_entering_valid_URL_click_on_online_games_link_click_on_Play_Now_link_on_any_slot_game_and_go_back_to_main_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		//Clicking on GameInfo link

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		// Clicking on Play Now link
		//WebElement playnow = driver.findElement(By.xpath("//*[contains(@onclick,'machineName=FruitClub&GameId=52')]"));
		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[4]/div[1]/div/div[1]/div"));
		playnow.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String Mbalance = driver.findElement(By.id("lblshowBalanceforPopup")).getText();
		System.out.println("Main Balance of the account before transfer: "+Mbalance);
		
		MobileElement balT = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		balT.sendKeys("555");
		Thread.sleep(1000);
		System.out.println("Transferring balance is: 555 ");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(3000);
		driver.context("NATIVE_APP");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected = "555.00";
		Assert.assertEquals(Sbalance, expected);
		System.out.println("Current balance of the account is: " +Sbalance);

		//switch between the tabs
		WebElement home = driver.findElement(MobileBy.AccessibilityId("Home"));
		home.click();
		driver.context("CHROMIUM");
		//driver.switchTo().window(parentWindow);
		Set<String> windows = driver.getWindowHandles();
		System.out.println("No of Windows: "+windows);
		
		String str1 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str2 = new StringBuffer(str1);
		System.out.println(str2.replace(0,7,""));
		String Rbalance = str2.toString();
		System.out.println("Balance after returning from slot game to home page is: " +Rbalance);
		
		double conValue = Double.parseDouble(Mbalance) - Double.parseDouble(Sbalance);
		String Tbalance = String.format("%.2f", conValue);  
		System.out.println("Balance in the main page: "+Tbalance);
		Assert.assertEquals(Tbalance, Rbalance);
		System.out.println("Balance before refresh is happening successfully. Testcase passed");
	}

	@Then("^Mobile: Transeffered amount to slot game should be deducted in the main balance and should be auto refreshed after (\\d+) seconds$")
	public void mobile_Transeffered_amount_to_slot_game_should_be_deducted_in_the_main_balance_and_should_be_auto_refreshed_after_seconds(int arg1) throws Throwable {
		Thread.sleep(3000);
		//driver.quit();
	}
}
