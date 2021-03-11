package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.List;
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
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.offset.PointOption;


public class Mobile_OnlineGame_CardMainBalance_RefreshBalance_MultipleGame_Sessions extends Mobile_PashaGlobal_URL_CardLogin  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_CardMainBalance_RefreshBalance_MultipleGame_Sessions() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_CardLogin();
		}

	@Given("^Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, transfer button, Play Now link, spin button , multiple tabs and game sessions$")
	public void mobile_Chrome_browser_valid_URL_valid_Card_login_details_Online_games_link_main_balance_transfer_button_Play_Now_link_spin_button_multiple_tabs_and_game_sessions() throws Throwable {

	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button and check the main updated pasha global balance and open another game sessions and play the game and switch to old game session$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_Card_login_details_transfer_the_amount_click_on_spin_button_and_check_the_main_updated_pasha_global_balance_and_open_another_game_sessions_and_play_the_game_and_switch_to_old_game_session() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HambergerMenuBtn")));

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@onclick,'SG_FruitClub.jpg')]/parent::ul/parent::div/parent::div/div/div")));
		driver.findElement(By.xpath("//li[contains(@onclick,'SG_FruitClub.jpg')]/parent::ul/parent::div/parent::div/div/div")).click();
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
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected = "555.00";
		Assert.assertEquals(Sbalance, expected);
		System.out.println("Current balance of the account is: " +Sbalance);

		WebElement tabs = driver.findElement(By.id("com.android.chrome:id/tab_switcher_button"));

		tabs.click();
		Thread.sleep(2000);

		TouchAction action = new TouchAction(driver); 
		action.tap(PointOption.point(260,536)).perform();
		Thread.sleep(2000);

		driver.context("CHROMIUM");
		Thread.sleep(3000);

		//Before refresh
		String str3 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str4 = new StringBuffer(str3);
		System.out.println(str4.replace(0,5,""));
		String Rbalance = str4.toString();
		System.out.println("Balance after tabs switch to main game selection window: " +Rbalance);


		// Calculation for main balance after deductions from slot balance
		double d=Double.parseDouble(Mbalance);
		double d1=Double.parseDouble(amt);
		double d2 = d-d1;
		//		String str = Double.toString(d2);
		DecimalFormat df = new DecimalFormat("#.00");
		String balvalidate = df.format(d2);

		System.out.println(balvalidate);
		//		String balvalidate = String.format("%.02f", Float.valueOf(str));

		//Assert the balance in the main window has to display new balance excluding the slot game balance
		Assert.assertEquals(balvalidate, Rbalance);
		System.out.println("Main balance is updated after transfering amount to slot maching and is: "+Rbalance);
		Thread.sleep(2000);

		//Refresh the main balance and verify the change in balance
		WebElement refresh = driver.findElement(By.xpath("(//*[@onclick = 'refreshbalance();'])[2]"));
		refresh.click();
		Thread.sleep(5000);
		refresh.click();
		Thread.sleep(3000);

		//After refresh
		String str2 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str21 = new StringBuffer(str2);
		System.out.println(str21.replace(0,5,""));
		String Rbalance1 = str21.toString();
		System.out.println("Balance after tabs switch to main game selection window: " +Rbalance1);
		Assert.assertEquals(balvalidate, Rbalance1);
		System.out.println("Main balance is updated after transfering amount to slot maching and after refreshing: "+Rbalance);
		Thread.sleep(2000);

		//Resume the game and play the slot game
		driver.context("NATIVE_APP");
		Thread.sleep(3000);
		tabs.click();
		Thread.sleep(2000);
		action.tap(PointOption.point(374,1720)).perform();
		Thread.sleep(5000);

		MobileElement start = driver.findElement(By.id("hud_btnSpin"));
		start.click();
		System.out.println("Spin is performed after tabs switching the slot games");
		Thread.sleep(2000);

		//Open multiple slot games and ensure the new session is created and older session throws error message of session is killed
		tabs.click();
		Thread.sleep(2000);
		action.tap(PointOption.point(260,536)).perform();
		Thread.sleep(2000);

		driver.context("CHROMIUM");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(normalize-space(@class),'play_now_but all_popup_but') and contains(@onclick,'FrenzyFruits&GameId=47')]")).click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));

		String Mbalance1 = driver.findElement(By.id("lblshowBalanceforPopup")).getText();
		System.out.println("Main Balance of the account before transfer: "+Mbalance1);

		MobileElement balT1 = driver.findElement(By.id("txtTransferedBalance"));
		balT1.clear();
		Thread.sleep(1000);
		String amt1 = "500";
		balT.sendKeys(amt1);
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 500");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance1 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected1 = "500.00";
		Assert.assertEquals(Sbalance1, expected1);
		System.out.println("Current balance of the account is: " +Sbalance1);

		start.click();
		System.out.println("Spin is performed for new slot game sessions");
		Thread.sleep(20000);

		// Switch to old game session and check whether game is resumed
		tabs.click();
		Thread.sleep(2000);
		action.tap(PointOption.point(464,1700)).perform();
		Thread.sleep(5000);

		//spin the old game session
		start.click();
		System.out.println("Spin click fore the old game session");
		Thread.sleep(8000);

		//		WebElement SessionClosed = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View"));
		//		System.out.println("Session Expired message:  "+SessionClosed );
		//		
		//		Assert.assertEquals(closed, SessionClosed);
		//		

		List<MobileElement> balance = driver.findElementsByClassName("android.view.View");
		String closed = "Session already closed due to multiple logins or network issue";
		String bal = "";
		for(MobileElement bl:balance){
			System.out.println(bl);
			if(bl.getText().equals("Session already closed due to multiple logins or network issue")){
				bal = bl.getText();
				Thread.sleep(1000);
			}
		}
		Assert.assertEquals(closed, bal);
		System.out.println("Session closed message is displayed for the older game session and validated");
	}

	@Then("^Mobile: Main Pasha Balance has to be updated to the latest balance$")
	public void mobile_Main_Pasha_Balance_has_to_be_updated_to_the_latest_balance() throws Throwable {

	}

	@Then("^Mobile: New session created and user is allowed to place bet and change over to older sessions should result in 'Session Closed' error popup and game should be terminated$")
	public void mobile_New_session_created_and_user_is_allowed_to_place_bet_and_change_over_to_older_sessions_should_result_in_Session_Closed_error_popup_and_game_should_be_terminated() throws Throwable {
		driver.quit();
	}
}