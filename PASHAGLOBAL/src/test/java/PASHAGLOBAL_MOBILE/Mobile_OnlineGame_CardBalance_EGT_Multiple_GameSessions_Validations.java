package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;

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
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Mobile_OnlineGame_CardBalance_EGT_Multiple_GameSessions_Validations extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_CardBalance_EGT_Multiple_GameSessions_Validations() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}

	@Given("^Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, transfer button, EGT Play Now link, spin button , multiple game link, user error message$")
	public void mobile_Chrome_browser_valid_URL_valid_Card_login_details_Online_games_link_main_balance_transfer_button_EGT_Play_Now_link_spin_button_multiple_game_link_user_error_message() throws Throwable {
		System.out.println("Current context:"+driver.getContext());
	}

	@When("^Mobile: Open any online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button and try to open new EGT games and transfer balance to the game$")
	public void mobile_Open_any_online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_Card_login_details_transfer_the_amount_click_on_spin_button_and_try_to_open_new_EGT_games_and_transfer_balance_to_the_game() throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HambergerMenuBtn")));

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		
		WebElement sub = driver.findElement(By.xpath("//*[contains(@src,'40-Hot-and-Cash')]"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", sub);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String Mbalance = driver.findElement(By.id("lblshowBalanceforPopup")).getText();
		System.out.println("Main Balance of the account before transfer: "+Mbalance);

		MobileElement balT = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		String amt =  "555";
		balT.sendKeys(amt);
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 555 ");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		Thread.sleep(20000);

		WebElement tabs = driver.findElement(By.id("com.android.chrome:id/tab_switcher_button"));

		tabs.click();
		Thread.sleep(4000);

		TouchAction action = new TouchAction(driver); 
		action.tap(PointOption.point(260,536)).perform();
		Thread.sleep(2000);

		driver.context("CHROMIUM");
		Thread.sleep(4000);

		WebElement sub1 = driver.findElement(By.xpath("//*[contains(@src,'81-Wins')]"));
		JavascriptExecutor jse1=(JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click();", sub1);
		Thread.sleep(5000);

		balT.clear();
		Thread.sleep(2000);
		balT.sendKeys("50");
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 50");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);

		//Validation for user error message
		WebElement message = driver.findElement(By.id("spnValidateBalance"));
		String msg = message.getText();
		System.out.println("Validation message display to the user: "+ msg);
		String validatemsg = "Pending fund transfers , please try after few mins!";
		Assert.assertEquals(validatemsg, msg);
		System.out.println("Valid message is prompted to user against multiple game sessions");
	}

	@Then("^Mobile: New Game Sessions created should not be allowed and 'Pending fund transfers, please try after few mins!' error message to be displayed to user for disabled creation of new game sessions in EGT games$")
	public void mobile_New_Game_Sessions_created_should_not_be_allowed_and_Pending_fund_transfers_please_try_after_few_mins_error_message_to_be_displayed_to_user_for_disabled_creation_of_new_game_sessions_in_EGT_games() throws Throwable {
		driver.quit();
	}
}