package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;
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
import io.appium.java_client.MobileElement;

public class Mobile_OnlineGame_Multiptile_LoginSessions extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_Multiptile_LoginSessions() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, spin button , another game window tab$")
	public void mobile_Chrome_browser_valid_URL_valid_login_details_Online_games_link_balance_transfer_button_Play_Now_link_spin_button_another_game_window_tab() throws Throwable {
	
	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on spin button, open another tab and open game and play ion new tab and switch back to older session$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_transfer_the_amount_click_on_spin_button_open_another_tab_and_open_game_and_play_ion_new_tab_and_switch_back_to_older_session() throws Throwable {
	  
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		String str11 = driver.findElement(By.id("DisplayBalance1")).getText();
		System.out.println("balance: "+str11);
		//Clicking on GameInfo link

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(24000);
		// Clicking on Play Now link
		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
		playnow.click();
		Thread.sleep(5000);
		System.out.println("game click");
		
//		driver.findElement(By.xpath("//*[contains(normalize-space(@class),'play_now_but all_popup_but') and contains(@onclick,'FruitClub&GameId=52')]")).click();
//		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String Mbalance = driver.findElement(By.id("lblshowBalanceforPopup")).getText();
		System.out.println("Main Balance of the account before transfer: "+Mbalance);
		
		MobileElement balT = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		balT.sendKeys("555");
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 555 ");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected = "555.00";
		Assert.assertEquals(Sbalance, expected);
		System.out.println("Current balance of the account is: " +Sbalance);
		
		
		//Clicking on start button
		MobileElement start = driver.findElement(By.id("hud_btnSpin"));
		start.click();
		Thread.sleep(2000);
		
		driver.context("CHROMIUM");
		Thread.sleep(4000);
		
		WebElement playnow1 = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
		playnow1.click();
		Thread.sleep(5000);
		
//		driver.findElement(By.xpath("//*[contains(normalize-space(@class),'play_now_but all_popup_but') and contains(@onclick,'FruitClub&GameId=52')]")).click();
//		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));
		String parentWindow1 = driver.getWindowHandle();
		System.out.println(parentWindow1);
		String Mbalance1 = driver.findElement(By.id("lblshowBalanceforPopup")).getText();
		System.out.println("Main Balance of the account before transfer: "+Mbalance);
		
		MobileElement balT1 = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		balT.sendKeys("555");
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 555 ");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance1 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected1 = "555.00";
		Assert.assertEquals(Sbalance1, expected1);
		System.out.println("Current balance of the account is: " +Sbalance1);
		
		
		//Clicking on start button
		MobileElement start1 = driver.findElement(By.id("hud_btnSpin"));
		start1.click();
		Thread.sleep(2000);
		
//		Set<String>s1=driver.getWindowHandles();
//		System.out.println("Window for slot game is"+" "+s1);
		
	}

	@Then("^Mobile: older session would be terminated with error message 'Session already closed due to multiple logins or network issue' and user is allowed to play with current session in slot game$")
	public void mobile_older_session_would_be_terminated_with_error_message_Session_already_closed_due_to_multiple_logins_or_network_issue_and_user_is_allowed_to_play_with_current_session_in_slot_game() throws Throwable {
		 driver.quit();
	}
}