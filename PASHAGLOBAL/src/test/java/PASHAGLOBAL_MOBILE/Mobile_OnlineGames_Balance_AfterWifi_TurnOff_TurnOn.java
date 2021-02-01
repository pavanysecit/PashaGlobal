package PASHAGLOBAL_MOBILE;

import java.io.File;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Mobile_OnlineGames_Balance_AfterWifi_TurnOff_TurnOn {
	AppiumDriver<MobileElement> driver;

	public Mobile_OnlineGames_Balance_AfterWifi_TurnOff_TurnOn() throws InterruptedException {
		this.driver = Mobile_PashaGlobal_URL_Login.getDriver();
	}
	
	@Given("^Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link and wifi button$")
	public void mobile_Chrome_browser_valid_URL_valid_login_details_Online_games_link_balance_transfer_button_Play_Now_link_and_wifi_button() throws Throwable {
	    
	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, check balance, turn off wifi & turn on wifi after few min, and check amount added to balance$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_transfer_the_amount_check_balance_turn_off_wifi_turn_on_wifi_after_few_min_and_check_amount_added_to_balance() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
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
		
		//Turn OFF the wifi for network interruptions
		ConnectionState state = ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
		Thread.sleep(30000);
		
		//Turn ON the wifi for network interruptions
		ConnectionState state1 = ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		Thread.sleep(4000);
		
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1"))); 
		String Sbalance1 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		System.out.println("Current balance of the account is: " +Sbalance1);
//		driver.findElement(By.xpath("//*[@id='HambergerMenuBtn']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[3]/span[4]/div/ul/li[3]")).click();
//		Thread.sleep(4000);
//		String cap = driver.findElement(By.id("capimgForTopup")).getText();
//		System.out.println(cap);
//		File src = driver.findElement(By.id("capimgForTopup")).getScreenshotAs(OutputType.FILE);
//		
//		String path = System.getProperty("user.dir")+ "/screenshots/captcha.png";
//		
//		FileHandler.copy(src, new File(path));
//		ITesseract image = new Tesseract();
//		String imageText = image.doOCR(new File(path));
//		System.out.println(imageText);
	}

	@Then("^Mobile: Slot game balance should get added to the main balance after wifi turn off and turn off$")
	public void mobile_Slot_game_balance_should_get_added_to_the_main_balance_after_wifi_turn_off_and_turn_off() throws Throwable {
	    Thread.sleep(2000);
		driver.quit();
	}
}
