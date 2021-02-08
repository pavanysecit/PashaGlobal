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

public class Mobile_OnlineGames_Balance_Check_GambleWinAmount_AddedToBalance extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGames_Balance_Check_GambleWinAmount_AddedToBalance() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, spin button , win amount, Red button and collect button$")
	public void mobile_Chrome_browser_valid_URL_valid_login_details_Online_games_link_balance_transfer_button_Play_Now_link_spin_button_win_amount_Red_button_and_collect_button() throws Throwable {
	    
	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on spin button till user win , Click on Gamble button, Click on Red button and check the balance after Gamble win$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_transfer_the_amount_click_on_spin_button_till_user_win_Click_on_Gamble_button_Click_on_Red_button_and_check_the_balance_after_Gamble_win() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		String str11 = driver.findElement(By.id("DisplayBalance1")).getText();
		System.out.println("balance: "+str11);
		
		//Checking the currency type in balance field
		String MbalanceLabel = driver.findElement(By.id("DisplayBalance2")).getText();
		String expectedMBal = "SRD";
		Assert.assertEquals(MbalanceLabel, expectedMBal);
		Thread.sleep(1000);
		System.out.println("Label of the currency for Main Balance field is: " +MbalanceLabel);

		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		// Clicking on Play Now link
//		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
//		playnow.click();
//		Thread.sleep(5000);
		
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
		
		//Checking the currency type in balance field
		String MbalLabel = driver.findElement(By.id("hud_Hud_txtBalance2")).getText();
		String expectedBal = "SRD";
		Assert.assertEquals(MbalLabel, expectedBal);
		Thread.sleep(1000);
		System.out.println("Label of the currency for Balance field is: " +MbalLabel);
		
		//Clicking on start button
		MobileElement start = driver.findElement(By.id("hud_btnSpin"));
		start.click();
		Thread.sleep(2000);

		
		MobileElement winE = driver.findElement(By.id("hud_Hud_txtWin1"));

		String prewin = winE.getText();                   
		String winTex= winE.getText();
	
		while(prewin.isEmpty()){
			start.click();	
			Thread.sleep(8000);	
			winTex = winE.getText();
			prewin= prewin+winTex;
			System.out.println(winTex.isEmpty());		
		}
		System.out.println("Win amount is: " +prewin);	 
		String balance1 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		System.out.println("Balance amount before clicking on gamble link :"+balance1);

		//Checking the currency type in Win field
		String winLabel = driver.findElement(By.id("hud_Hud_txtWin2")).getText();
		String expectedwinLabel = "SRD";
		Assert.assertEquals(winLabel, expectedwinLabel);
		Thread.sleep(1000);
		System.out.println("Label of the currency for Win field is: " +winLabel);
		
		driver.findElement(By.id("hud_btnGamble")).click();	
		Thread.sleep(2000);
		String gAmount = driver.findElement(By.id("gamble_txtGambleAmount")).getText();
		System.out.println("Gamble amount is :"+gAmount);
		Thread.sleep(2000);
		
		String gambleamt = gAmount.replaceAll(" SRD", "");
		System.out.println("Gamble amount after split is :"+gambleamt);

		String colorwin = driver.findElement(By.id("gamble_txtWin")).getText();
		String gamblewin = colorwin.replaceAll(" SRD", "");
		System.out.println("Gamble to win amount after split is :"+gamblewin);
		System.out.println("Gamble to win amount is: " +colorwin);
		driver.findElement(By.id("gamble_btnRed")).click();
		Thread.sleep(1200);
		
		String gAmount1 = driver.findElement(By.id("gamble_txtGambleAmount")).getText();
		String gambleamtafter = gAmount1.replaceAll(" SRD", "");
		System.out.println("Gamble amount after selecting red or black button: "+gambleamtafter);

		if(gamblewin.equalsIgnoreCase(gambleamtafter)) {
			String gAmount11 = driver.findElement(By.id("gamble_txtGambleAmount")).getText();
			String gamble1 = gAmount11.replaceAll(" SRD", "");
			
            /*
             * Here we are comparing the gamble win amount field before and after after winning in the gamble page.
             * Before it is same as win amount in the game screen
             * after winning in the gamble page, gamble amount is doubled and verified with the gamble amount before win. 
             */
			double db1=Double.parseDouble(gamble1);
			double db=Double.parseDouble(gambleamt);
			double expected11 = db*2;
			Assert.assertEquals(Double.doubleToLongBits(expected11), Double.doubleToLongBits(db1));
			
			Thread.sleep(2000);
			driver.findElement(By.id("gamble_btnCollect")).click();
			Thread.sleep(3000);
			String postBalance22 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
			System.out.println("Balance amount After clicking on collect link :"+postBalance22);
			double conValue = Double.parseDouble(balance1) + db1;
			String dbi = String.format("%.2f", conValue);  
			System.out.println("Balance after adding gamble win amount: "+dbi);
			Thread.sleep(2000);
			Assert.assertEquals(dbi, postBalance22);
			Thread.sleep(2000);
		}  
		else
		{     
			Thread.sleep(3000);
			String postBalance33 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText(); 
			System.out.println("It has lost");
			System.out.println("Current balance after loosing in gamble: " +postBalance33);
			Assert.assertEquals(postBalance33, postBalance33);
		}
		System.out.println("The Gamble page testcase has passed");
		
		String Balance = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		System.out.println("Balance before clicking on Home page: "+Balance);		
		
		driver.findElement(By.id("hud_btnHome")).click();
		driver.context("CHROMIUM");
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.id("DisplayBalance1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		
		//Before refresh
		String str3 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str4 = new StringBuffer(str3);
		System.out.println(str4.replace(0,7,""));
		String Rbalance = str4.toString();
		System.out.println("Balance after returning from Gamble page to home page is and before auto refresh: " +Rbalance);
		String Rbalance1 = Rbalance.replaceAll(",", "");
		// Adding slot game final balance + main balance before refreshing should be same as balance after refresh
		double conValue1 = Double.parseDouble(Balance) + Double.parseDouble(Rbalance1);
		String fbal = String.format("%.2f", conValue1); 
		
		//After Refresh - Wait for 3 seconds to auto refresh
		Thread.sleep(5000);
		String str111 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str21 = new StringBuffer(str111);
		System.out.println(str21.replace(0,7,""));
		String ARbalance = str21.toString();
		System.out.println("Balance after refreshing automatically is: " +ARbalance);
		Thread.sleep(5000);
		//Balance should be same
		String fbal1 = fbal.replaceAll(",", "");
		String ARbalance1 = ARbalance.replaceAll(",", "");
		Assert.assertEquals(fbal1, ARbalance1);
	}

	@Then("^Mobile: Gamble Win amount should get added to the main balance after win and balance should get added to the main balance after closing slot game$")
	public void mobile_Gamble_Win_amount_should_get_added_to_the_main_balance_after_win_and_balance_should_get_added_to_the_main_balance_after_closing_slot_game() throws Throwable {
		Thread.sleep(3000);
		driver.quit();
	}
}