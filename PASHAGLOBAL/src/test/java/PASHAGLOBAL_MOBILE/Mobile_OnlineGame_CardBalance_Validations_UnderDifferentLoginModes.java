package PASHAGLOBAL_MOBILE;

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

public class Mobile_OnlineGame_CardBalance_Validations_UnderDifferentLoginModes {

	AppiumDriver<MobileElement> driver;

	public Mobile_OnlineGame_CardBalance_Validations_UnderDifferentLoginModes() throws InterruptedException {
		this.driver = Mobile_PashaGlobal_URL_Login.getDriver();
	}

	@Given("^Mobile: Chrome browser, valid URL, different Valid login credentials, card details login, card balance and refresh button$")
	public void mobile_Chrome_browser_valid_URL_different_Valid_login_credentials_card_details_login_card_balance_and_refresh_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
	}

	@When("^Mobile: Open the chrome browser, Enter the valid URL, Login via email and switch to card mode of transaction for further playable$")
	public void mobile_Open_the_chrome_browser_Enter_the_valid_URL_Login_via_email_and_switch_to_card_mode_of_transaction_for_further_playable() throws Throwable {

		WebElement dropdown = driver.findElement(By.id("nav-dropbtn"));
		dropdown.click();
		Thread.sleep(1000);

		WebElement cardBal = driver.findElement(By.id("cardRefresh"));
		String cardbal = cardBal.getText();
		System.out.println("Card Account Balance:" +cardbal);

		String cb=null;
		String cardbalance=null;
		if(cardbal.endsWith("0")){
			cb = cardbal.substring(0, cardbal.length() - 1);
			cardbalance = cb.replaceAll("SRD ", "");
			System.out.println(cardbalance);
		}
		else {

			cb = cardbal;
			cardbalance = cb.replaceAll("SRD ", "");
			System.out.println(cardbalance);
			System.out.println("Card Balance amount doesn't ends with '0'.");
		}

		WebElement CardSelect = driver.findElement(By.id("card-active"));
		CardSelect.click();
		Thread.sleep(1500);

		WebElement CardInput = driver.findElement(By.id("card-number"));
		CardInput.sendKeys("2111649489988826");
		Thread.sleep(1000);
		WebElement CardPin = driver.findElement(By.id("pin"));
		CardPin.sendKeys("1125");
		Thread.sleep(1000);
		WebElement Submit = driver.findElement(By.id("CardAuth"));
		Submit.click();
		Thread.sleep(3000);

		WebElement Rbalance = driver.findElement(By.xpath("//*[@id='nav-dropbtn']//following::label"));
		//		String Rbal = Rbalance.getText();
		//		System.out.println("Card Balance: " +Rbal);
		//		
		//		String rbal1 = Rbalance.getText();
		//		System.out.println("Balance before refresh: "+rbal1 );
		WebElement refresh = driver.findElement(By.xpath("(//*[@onclick = 'refreshbalance();'])[2]"));
		refresh.click();
		Thread.sleep(5000);
		refresh.click();
		Thread.sleep(3000);
		String rbal2 = Rbalance.getText();


		String cb1=null;
		if(rbal2.endsWith("0")){
			cb1 = rbal2.substring(0, rbal2.length() - 1);
			System.out.println(cb1);
		}
		else {
			cb1 = rbal2;
			System.out.println("Card Balance amount doesn't ends with '0'.");
		}
		System.out.println("Refresh card balance after switching from online to card:"+cb1);

		//Verify the alert popup shouldn't appear again for multiple switchover between online to card and vice versa
		dropdown.click();
		Thread.sleep(1000);

		WebElement OnlineSelect = driver.findElement(By.id("online-active"));
		OnlineSelect.click();
		Thread.sleep(1500);

		dropdown.click();
		Thread.sleep(1000);
		CardSelect.click();
		Thread.sleep(1500);

		//verifying the alert pop
		Boolean alertpopup = CardInput.isDisplayed();
		Assert.assertFalse(alertpopup);
		System.out.println("On multiple switchover alert pop not generated: "+alertpopup);

		// Logoff from the device 
		WebElement hamburger = driver.findElement(By.id("HambergerMenuBtn"));
		hamburger.click();
		Thread.sleep(2000);
		WebElement logoff = driver.findElement(By.linkText("Log off"));
		logoff.click();
		Thread.sleep(5000);


		//Login via card number
		WebElement login = driver.findElement(By.id("UnserlnkLogin"));
		login.click();
		Thread.sleep(1000);

		driver.findElement(By.id("txt_Login_Email")).sendKeys("2111649489988826");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("1125");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(10000);

		// Fetch the balance when login from card
		WebElement Cbalance = driver.findElement(By.xpath("//*[@id='nav-dropbtn']//following::label"));
		String Cbal = Cbalance.getText();
		System.out.println("Card balance when login via card: "+ Cbal);
		
		//Validation for balance for different login forms for same account id
		Assert.assertEquals(cb1, Cbal);
		System.out.println("Card Balance is same and verifed under different login credentials for same account id" );
		
		//Verify the cashout is available for the user for card login modes
		WebElement cashout = driver.findElement(By.id("UserCashout"));
		System.out.println("Cashout is not present:"+cashout.isDisplayed());
		Thread.sleep(10000);
		

	}

	@Then("^Mobile: Verify the balance in card before and logoff from the session$")
	public void mobile_Verify_the_balance_in_card_before_and_logoff_from_the_session() throws Throwable {
		Thread.sleep(1000);
	}

	@Then("^Movile: Login to the account via card mode and verify the balance$")
	public void movile_Login_to_the_account_via_card_mode_and_verify_the_balance() throws Throwable {
		Thread.sleep(1000);
	}

	@Then("^Mobile: Card balance must be same across different login modes for same account ID in suribet client$")
	public void mobile_Card_balance_must_be_same_across_different_login_modes_for_same_account_ID_in_suribet_client() throws Throwable {
		driver.quit();
		
		
	}
}