package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;

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

public class Mobile_OnlineGames_CardBalance_Login_LogOff_Validations extends Mobile_PashaGlobal_URL_CardLogin  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGames_CardBalance_Login_LogOff_Validations() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_CardLogin();
		}

	@Given("^Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, Account ID, Log off, other modules$")
	public void mobile_Chrome_browser_valid_URL_valid_Card_login_details_Online_games_link_main_balance_Account_ID_Log_off_other_modules() throws Throwable {

	}

	@When("^Mobile: Login to the Pasha Global account and navigate to online game and later to home and verify the account state and after logout from Pasha Global navigate and online Games$")
	public void mobile_Login_to_the_Pasha_Global_account_and_navigate_to_online_game_and_later_to_home_and_verify_the_account_state_and_after_logout_from_Pasha_Global_navigate_and_online_Games() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spaccountid")));

		WebElement ham = driver.findElement(By.id("HambergerMenuBtn"));
		ham.click();
		Thread.sleep(2000);
		WebElement logoff = driver.findElement(By.xpath("//*[@class='mb_show_ac']"));
		System.out.println("Account is in login state, loggoff button is displayed:"+logoff.isDisplayed());

		//Navigating to online game module and navigating to home button and verification of Account state

		WebElement home = driver.findElement(By.cssSelector(".home_icon.Home"));
		home.click();
		Thread.sleep(3000);
		WebElement sportsbetting = driver.findElement(By.className("regidter_pay_game_content"));
		System.out.println("Verifying home button is picked and online sports betting link is displayed for the user:"+sportsbetting.isDisplayed());
		Thread.sleep(1000);

		WebElement onlinegames = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		onlinegames.click();
		Thread.sleep(5000);
		//		WebElement Fruitclub = driver.findElement(By.xpath("//*[contains(normalize-space(@class),'play_now_but all_popup_but') and contains(@onclick,'FruitClub&GameId=52')]"));
		//		Thread.sleep(5000);
		//		System.out.println("Verifying Online button is picked and FruitClub game link is displayed for the user:"+Fruitclub.isDisplayed());
		//		Thread.sleep(1000);

		WebElement AccountID = driver.findElement(By.id("spaccountid"));
		Thread.sleep(2000);
		//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AccountID);
		
		System.out.println("After navigating from home to online module Account is still active:"+ AccountID.isDisplayed());
		Thread.sleep(5000);

		//LogOff from the session and try to navigated to online slotgames 
//		ham.click();
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(6000);
		System.out.println("click is performed");
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.className("login_but"));
		System.out.println("Account is in logoff state, login button is displayed:"+login.isDisplayed());

		home.click();
		Thread.sleep(6000);
		System.out.println("Account still logoff state, login button is displayed:"+login.isDisplayed());

		driver.findElement(By.cssSelector(".main_menu_active.online_Games")).click();
		Thread.sleep(4000);

		driver.switchTo().alert();
//		driver.findElement(By.className("new_ok_but")); 
		//		System.out.println("Account still logoff state, login button is displayed:"+login.isDisplayed());

		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
		playnow.click();
		Thread.sleep(5000);

		driver.switchTo().alert();
		WebElement slectedFlag = driver.findElement(By.className("new_popup_H"));
		System.out.println("Account Login credentials popup is generated:"+slectedFlag.isDisplayed());

		driver.findElement(By.className("new_ok_but")).click();
		Thread.sleep(4000);
	
		WebElement register = driver.findElement(By.id("UserReg"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", register); 
		Thread.sleep(2000);
		
		System.out.println("Register button is displayed:"+ register.isDisplayed());
		System.out.println("User not login to Pasha Global automatically");
	}

	@Then("^Mobile: Verify whether the account is logged off automatically$")
	public void mobile_Verify_whether_the_account_is_logged_off_automatically() throws Throwable {

	}

	@Then("^Mobile: Verify after log off from the Pasha Global navigate to home and online games and verify the account state shoudn't login automatically$")
	public void mobile_Verify_after_log_off_from_the_Pasha_Global_navigate_to_home_and_online_games_and_verify_the_account_state_shoudn_t_login_automatically() throws Throwable {
		driver.quit();
	}
}
