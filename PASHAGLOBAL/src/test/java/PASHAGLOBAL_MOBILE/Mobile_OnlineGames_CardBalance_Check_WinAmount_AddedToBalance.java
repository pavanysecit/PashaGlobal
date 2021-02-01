package PASHAGLOBAL_MOBILE;

import java.time.Duration;
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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Mobile_OnlineGames_CardBalance_Check_WinAmount_AddedToBalance {
	AppiumDriver<MobileElement> driver;

	public Mobile_OnlineGames_CardBalance_Check_WinAmount_AddedToBalance() throws InterruptedException {
		this.driver = Mobile_PashaGlobal_URL_CardLogin.getDriver();
	}
	
	@Given("^Mobile: Chrome browser, valid URL, valid Card login details, Online games link, balance, transfer button, Play Now link, spin button and win amount$")
	public void mobile_Chrome_browser_valid_URL_valid_Card_login_details_Online_games_link_balance_transfer_button_Play_Now_link_spin_button_and_win_amount() throws Throwable {
	    
	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the Card valid login details, transfer the amount to slot game, click on spin button till user win and check the balance after win$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_Card_valid_login_details_transfer_the_amount_to_slot_game_click_on_spin_button_till_user_win_and_check_the_balance_after_win() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		String str11 = driver.findElement(By.id("DisplayBalance1")).getText();
		System.out.println("balance: "+str11);
		//Clicking on GameInfo link

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		// Clicking on Play Now link
//		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
//		playnow.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(normalize-space(@class),'play_now_but all_popup_but') and contains(@onclick,'FruitClub&GameId=52')]")).click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTransferedBalance")));
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String Mbalance = driver.findElement(By.id("lblshowBalanceforPopup")).getText();
		System.out.println("Main Balance of the account before transfer: "+Mbalance);
		
		MobileElement balT = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		balT.sendKeys("555.35");
		Thread.sleep(2000);
		System.out.println("Transferring balance is: 555.35 ");
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String expected = "555.35";
		Assert.assertEquals(Sbalance, expected);
		System.out.println("Current balance of the account is: " +Sbalance);
		
		//Selecting the credit as 1 from the drop down
		driver.findElement(By.id("hud_txtCredit")).click();
		driver.findElement(By.id("hud_CreditPopup41")).click();
		
		String actual1 = driver.findElement(By.id("hud_txtCredit")).getText();
		System.out.println("Selected credit value is : " +actual1);
		String expected1 = "1";
		Assert.assertEquals(actual1, expected1);
		
		//Selecting the bet amount as 10 from the drop down
		driver.findElement(By.id("hud_txtBetAmount")).click();
		driver.findElement(By.id("hud_BetPopup210")).click();
		Thread.sleep(2000);
		
		String actual2 = driver.findElement(By.id("hud_txtBetAmount")).getText();
		String expected2 = "10";
		System.out.println("Selected Bet Amount is : " +actual2);
		Assert.assertEquals(actual2, expected2);
		
		//Clicking on start button
		MobileElement start = driver.findElement(By.id("hud_btnSpin"));
		start.click();
		Thread.sleep(2000);

		//Getting win amount
		MobileElement winE = driver.findElement(By.id("hud_Hud_txtWin1"));
		
		String winTex = winE.getText();
		while(winTex.isEmpty())
		 {
			start.click();
			Thread.sleep(8000);
			winTex=	winE.getText();
			System.out.println(winTex.isEmpty());
		 }
		Thread.sleep(2000);
		System.out.println("The Win is :"+winTex);
		System.out.println(winTex.isEmpty());
		
		String postWin = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String str1 = postWin.replaceAll(",", "");
		System.out.println("Balance before adding win amount is: "+str1);
		Thread.sleep(2000);
		
		driver.findElement(By.id("hud_btnGamble")).click();
		Thread.sleep(3000);

		//Clicking on Collect button
		driver.findElement(By.id("gamble_btnCollect")).click();
		Thread.sleep(6000);
		String Balance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		String str2 = Balance.replaceAll(",", "");
		Thread.sleep(2000);
		//Checking win amount added to the slot game balance
		double conValue = Double.parseDouble(winTex) + Double.parseDouble(str1);
		String dbi = String.format("%.2f", conValue);  
		System.out.println("Balance after adding win amount: "+dbi);
		Thread.sleep(2000);
		Assert.assertEquals(dbi, str2);
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.android.chrome:id/tab_switcher_button")).click();
		Thread.sleep(3000);
		TouchAction swipe = new TouchAction(driver).press(PointOption.point(172,1404)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(860,1404)).release().perform();
		Thread.sleep(2000);
		swipe.press(PointOption.point(172,1404)).release().perform();
		driver.context("CHROMIUM");
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.id("DisplayBalance1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		
		//Before refresh
		String str3 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str4 = new StringBuffer(str3);
		System.out.println(str4.replace(0,5,""));
		String Rbalance = str4.toString();
		System.out.println("Balance after returning from slot game to home page is and before auto refresh: " +Rbalance);
	
		// Adding slot game final balance + main balance before refreshing should be same as balance after refresh
		double conValue1 = Double.parseDouble(dbi) + Double.parseDouble(Rbalance);
		String fbal = String.format("%.2f", conValue1); 
		
		//After Refresh - Wait for 3 seconds to auto refresh
		Thread.sleep(3000);
		String str111 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str21 = new StringBuffer(str111);
		System.out.println(str21.replace(0,5,""));
		String ARbalance = str21.toString();
		System.out.println("Balance after refreshing automatically is: " +ARbalance);
		
		//Balance should be same
		Assert.assertEquals(fbal, ARbalance);
	}

	@Then("^Mobile: Win amount should get added to the main slot balance after win and balance should get added to the main account card balance after closing slot game$")
	public void mobile_Win_amount_should_get_added_to_the_main_slot_balance_after_win_and_balance_should_get_added_to_the_main_account_card_balance_after_closing_slot_game() throws Throwable {
		driver.quit();
	}
}
