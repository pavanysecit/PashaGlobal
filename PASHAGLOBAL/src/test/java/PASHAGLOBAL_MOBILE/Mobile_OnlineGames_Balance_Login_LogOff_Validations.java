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


public class Mobile_OnlineGames_Balance_Login_LogOff_Validations extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGames_Balance_Login_LogOff_Validations() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, home button, login and logout buttons$")
	public void mobile_Chrome_browser_valid_URL_valid_login_details_Online_games_link_balance_transfer_button_Play_Now_link_home_button_login_and_logout_buttons() throws Throwable {
	   
	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on logoff button, click on home butotn and login button$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_transfer_the_amount_click_on_logoff_button_click_on_home_butotn_and_login_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));

	}

	@Then("^Mobile:After login, refresh the balance and check it should be same on clicking on refresh button$")
	public void mobile_After_login_refresh_the_balance_and_check_it_should_be_same_on_clicking_on_refresh_button() throws Throwable {
		//Checking the balance of the main account before clicking on the refresh button
		String str1 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str2 = new StringBuffer(str1);
		System.out.println(str2.replace(0,7,""));
		String Cbalance = str2.toString();
		System.out.println("Balance of the main account BEFORE clicking on REFRESH button: " +Cbalance);
		Thread.sleep(2000);
		
		//Checking the balance of the main account after clicking on Refresh button
		WebElement ref = driver.findElement(By.xpath("//*[@id='SwapLoginContent']/div[3]/div/span[3]"));
		ref.isDisplayed();
		ref.click();
		System.out.println(ref.isDisplayed());
		Thread.sleep(1000);
		ref.click();
		Thread.sleep(2000);
		String str3 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str4 = new StringBuffer(str3);
		System.out.println(str4.replace(0,7,""));
		String Refreshbalance = str4.toString();
		System.out.println("Balance of the main account AFTER clicking on REFRESH button: " +Refreshbalance);
		Thread.sleep(2000);
		//Assert.assertEquals(Cbalance, Refreshbalance);
		
		
		// Clicking on Play Now link
		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(12000);
		
		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
		playnow.click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
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
		System.out.println("Current balance of the online game is: " +Sbalance);
		Thread.sleep(3000);
		
		WebElement home = driver.findElement(By.id("hud_btnHome"));
		home.click();
		driver.context("CHROMIUM");
		Thread.sleep(5000);
		
		System.out.println("Context: " + driver.findElement(By.id("DisplayBalance1")).isDisplayed());
		String str5 = driver.findElement(By.id("DisplayBalance1")).getText();
		StringBuffer str6 = new StringBuffer(str5);
		System.out.println(str6.replace(0,7,""));
		String crrBalance = str6.toString();
		System.out.println("Balance of the main account after navigating to home page: " +crrBalance);
		Thread.sleep(8000);
		
		Assert.assertEquals(Cbalance, crrBalance);
		
		boolean login1 = driver.findElement(By.id("DisplayBalance1")).isDisplayed();
		System.out.println(login1);	  
		Assert.assertTrue(login1);
		Thread.sleep(1000);
		System.out.println("User is not logged out after navigating to home page from slot game window. Test case passed. ");	
		
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(6000);
		
		boolean login11 = driver.findElement(By.id("UnserlnkLogin")).isDisplayed();
		System.out.println(login11);	  
		Assert.assertTrue(login11);
		Thread.sleep(2000);
	}


	@Then("^Mobile:After navigating to home page from online games, it should not logout automatically$")
	public void mobile_After_navigating_to_home_page_from_online_games_it_should_not_logout_automatically() throws Throwable {
		//Logging in and checking whether system is getting logout automatically after navigating to home page or perfomring some tasks
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("pmansoorktr@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("mansoor@123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(4000);
		System.out.println("User is not logged out after logging-in & performing some actions ");
		
		//Logged out from the system and checking whether system is logging-in automatically after navigating clicking on online games tab  or perfomring some tasks
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(6000);

		
		WebElement element1 = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element1.click();
		Thread.sleep(12000);
		
		driver.findElement(By.xpath("/html/body/div[15]/div[1]/div/div/div[1]/div[2]/div/h1/label")).click();
		Thread.sleep(3000);
		
		boolean login2 = driver.findElement(By.id("UnserlnkLogin")).isDisplayed();
		Assert.assertTrue(login2);
		Thread.sleep(2000);
		System.out.println("User is not logged-in automatically after logged-out & performing some action on Online games section");
	}

	@Then("^Mobile:After logout, navigating from home page to online games, it should not login automatically$")
	public void mobile_After_logout_navigating_from_home_page_to_online_games_it_should_not_login_automatically() throws Throwable {
		Thread.sleep(1000);
	}

	@Then("^Mobile:Based on the selected category, games should be display under each category like Slots, Fruits, Cards and Roulettes$")
	public void mobile_Based_on_the_selected_category_games_should_be_display_under_each_category_like_Slots_Fruits_Cards_and_Roulettes() throws Throwable {
	    driver.quit();
	}
}
