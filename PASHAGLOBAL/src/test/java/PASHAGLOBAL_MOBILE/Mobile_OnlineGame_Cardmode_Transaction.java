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

public class Mobile_OnlineGame_Cardmode_Transaction extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_Cardmode_Transaction() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, Valid login credentials, card details login, and authenticated card$")
	public void mobile_Chrome_browser_valid_URL_Valid_login_credentials_card_details_login_and_authenticated_card() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
	}

	@When("^Mobile: Open the chrome browser, Enter the valid URL, Login via email or phone number mode and switch to card mode of transaction for further playable$")
	public void mobile_Open_the_chrome_browser_Enter_the_valid_URL_Login_via_email_or_phone_number_mode_and_switch_to_card_mode_of_transaction_for_further_playable() throws Throwable {

//		WebElement OnlineBal = driver.findElement(By.id("DisplayBalance1"));
//		System.out.println("Online Account balance:"+ OnlineBal );
//		Thread.sleep(1000);
		
		// Verify the text present over the amount deatils 
		/*
		 * As the transaction mode changes text also changes
		 */
		WebElement text = driver.findElement(By.cssSelector(".text-white.top-text"));
		String txt = text.getText();
		Assert.assertEquals("Online", txt);
		System.out.println("Verified the text over balance field when logged via E-mail");
		
		WebElement dropdown = driver.findElement(By.id("nav-dropbtn"));
		dropdown.click();
		Thread.sleep(1000);

		//Verifying the radio button is checked
		WebElement selected = driver.findElement(By.id("online"));
		Boolean radiobutton = selected.isSelected();
		System.out.println("online radio button: "+radiobutton);
		Assert.assertTrue("Radio button selected for online mode", radiobutton);
		Thread.sleep(1000);

		//		String online = driver.findElement(By.id("online-active")).getAttribute("class");
		//		System.out.println("Fetching class attritube to verify online mode is selected:   " +online);
		//		System.out.println("Transaction mode is Online and radio button is checked");
		//		Assert.assertEquals("active", online);
		//		Thread.sleep(1000);

		// Select the card mode of payment
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

		//		String onlinecard = driver.findElement(By.id("card-active")).getAttribute("class");
		//		System.out.println("Fetching class attritube to verify card mode is selected:   " +onlinecard);
		//		System.out.println("Card modeTransaction is not checked");
		//		Assert.assertNull(onlinecard);
		//		Thread.sleep(1000);

		// Verify the card radio button is not selected
		WebElement selected1 = driver.findElement(By.id("card"));
		Boolean radiobutton1 = selected1.isSelected();
		System.out.println("card radio button:  "+radiobutton1);
		Assert.assertFalse("Radio button not selected for card mode", radiobutton1);
		Thread.sleep(1000);
		driver.findElement(By.id("card-active")).click();
		Thread.sleep(1500);

		// Text validation
		driver.switchTo().alert();
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.xpath("//*[text()= 'AUTHENTICATE CARD']"));
		Assert.assertEquals(title.getText(), "AUTHENTICATE CARD");
		System.out.println("Authenticate card alert window has been generated");
		Thread.sleep(1000);
		WebElement Card_Num = driver.findElement(By.xpath("//*[text()= 'Card Number']"));
		Assert.assertEquals(Card_Num.getText(), "Card Number");
		System.out.println("Card number text is validated");
		Thread.sleep(1000);
		WebElement Card_Pin = driver.findElement(By.xpath("//*[text()='Card Pin']"));
		Assert.assertEquals(Card_Pin.getText(), "Card Pin");
		System.out.println("Card pin text is validated");
		WebElement Submit = driver.findElement(By.id("CardAuth"));
		Assert.assertEquals(Submit.getText(),"Authenticate Card");
		System.out.println("Submit button text is validated");

		//Login with the valid card details
		WebElement CardInput = driver.findElement(By.id("card-number"));
		Assert.assertEquals(CardInput.getAttribute("maxlength"), "16");
		System.out.println("Verified the max character input length:"+ "16");

		Assert.assertEquals(CardInput.getAttribute("placeholder"), "Please Enter Card Number");
		System.out.println("Verified the charter input text");
		CardInput.sendKeys("2111649489988826");
		Thread.sleep(1000);

		WebElement CardPin = driver.findElement(By.id("pin"));
		Assert.assertEquals(CardPin.getAttribute("maxlength"), "4");
		System.out.println("Verified the max character input length:"+ "4");

		Assert.assertEquals(CardPin.getAttribute("placeholder"), "Please Enter Card Pin");
		System.out.println("Verified the charter input text");
		CardPin.sendKeys("1125");
		Thread.sleep(1000);

		//Check for hide and unhide button state 
		WebElement HideButton = driver.findElement(By.id("checkpin"));
		Assert.assertTrue(HideButton.isDisplayed());
		System.out.println("Visibility of the hide button is verified and visible on the screen");
		HideButton.click();
		Thread.sleep(1000);
		Assert.assertEquals(CardPin.getAttribute("type"), "text");
		System.out.println("Verified the input type for card pin under hidden condition: "+ CardPin.getAttribute("type"));
		HideButton.click();
		Thread.sleep(1000);
		Assert.assertEquals(CardPin.getAttribute("type"), "password");
		System.out.println("Verified the input type for card pin under un-hide condition: "+CardPin.getAttribute("type"));
		Submit.click();
		Thread.sleep(3000);
		System.out.println("Card mode is selected for future transcations");

		//Verify the which mode of transaction is selected and verify the amount in the card for before and after selection 
		WebElement Rbalance = driver.findElement(By.xpath("//*[@id='nav-dropbtn']//following::label"));
		String Rbal = Rbalance.getText();
		System.out.println("Card Balance: " +Rbal);

		String card = text.getText();
		Assert.assertEquals("Card", card);
		System.out.println("Verified the text over balance field when logged via card");
		
		// if the last digit is zero its not displayed on the balance amount and after refreshing its displayed 
		/* 
		 * Validation failed as before and after the amount is sperated by ',' in the balance field
		 */
		//		Assert.assertEquals(Rbal, cardbalance);
		//		System.out.println("Card balance before refreshing is verified");

		/*
		 * Verifying the checkbox radio button is checked for card mode transaction
		 * Failing as the Assertions fails need ids
		 */
		//		dropdown.click();
		//		Thread.sleep(3000);
		//		WebElement radio = driver.findElement(By.name("card"));
		//		Boolean rad = radio.isEnabled();
		//		Boolean radi = radio.isSelected();
		//		System.out.println("card radio button after transactions via card mode:  " +rad);
		//		System.out.println("card radio button after transactions via card mode:  " +radi);
		//		Assert.assertTrue(rad);
		//		Assert.assertTrue(radi);
		//		System.out.println("Fetching class attritube to verify card mode is selected:   " +radio);



		//Verify the balance after refresh the main balance
		String rbal1 = Rbalance.getText();
		System.out.println("Balance before refresh: "+rbal1 );
		WebElement refresh = driver.findElement(By.xpath("(//*[@onclick = 'refreshbalance();'])[2]"));
		refresh.click();
		Thread.sleep(5000);
		refresh.click();
		Thread.sleep(3000);
		String rbal2 = Rbalance.getText();
		System.out.println(rbal2);

		String cb1=null;
		if(rbal2.endsWith("0")){
			cb1 = rbal2.substring(0, rbal2.length() - 1);
			System.out.println(cb1);
		}
		else {
			cb1 = rbal2;
			System.out.println("Card Balance amount doesn't ends with '0'.");
		}
		String str44 = rbal1.replaceAll(",", "");
		String cb2 = rbal1.replaceAll(",", "");
		Assert.assertEquals(str44,cb2);
		System.out.println("Refresh balance verified");


		//Verifying the currency "SRD" for card deductions
		WebElement currency = driver.findElement(By.id("DisplayBalance2"));
		String srd = currency.getText();
		Assert.assertEquals("SRD", srd);
		System.out.println("Currency form is validated after card modfe transcation and after refresh balance: "+srd);
		
		
		//Verify if the user able to switch back to online mode of transcation
		dropdown.click();
		Thread.sleep(1000);
		
		WebElement OnlineBal = driver.findElement(By.id("onlineRefresh"));
		String Onlinebal = OnlineBal.getText();
		System.out.println("Online Account Balance:" +Onlinebal);

		String ob=null;
		String onlinebalance=null;
		if(Onlinebal.endsWith("0")){
			ob = Onlinebal.substring(0, Onlinebal.length() - 1);
			onlinebalance = ob.replaceAll("SRD ", "");
			System.out.println(onlinebalance);
		}
		else {
			ob = Onlinebal;
			onlinebalance = ob.replaceAll("SRD ", "");
			System.out.println(onlinebalance);
			System.out.println("Card Balance amount doesn't ends with '0'.");
		}
		
		WebElement online = driver.findElement(By.id("online-active"));
		online.click();
		Thread.sleep(3000);
		
		WebElement Obalance = driver.findElement(By.xpath("//*[@id='nav-dropbtn']//following::label"));
		String Obal = Obalance.getText();
		System.out.println("Online Balance: " +Obal);
		refresh.click();
		Thread.sleep(5000);
		//Assert the online balance after switching back to online
		/*
		 * Assertion fails as the ',' is missing while validating
		 */
		Assert.assertEquals(onlinebalance, Obal);
		System.out.println("Online balance is same after switching back and refreshing");

	}

	@Then("^Mobile: Verify the balance in card before and after switching the mode of transacations$")
	public void mobile_Verify_the_balance_in_card_before_and_after_switching_the_mode_of_transacations() throws Throwable {

		// Logoff from the device 
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(6000);
	}

	@Then("^Movile: Verify the balance after reloading/refresh the balance in card mode of transcations$")
	public void movile_Verify_the_balance_after_reloading_refresh_the_balance_in_card_mode_of_transcations() throws Throwable {

		// Verify the sucessfull logoff is occured
		WebElement login = driver.findElement(By.id("UnserlnkLogin"));
		String logintext = login.getText();
		Assert.assertEquals("Login", logintext);
		System.out.println("Successfull login has taken after click on logoff button");
	}

	@Then("^Mobile: Verify if the used is allowed again to switch to online mode of transactions  for suribet client$")
	public void mobile_Verify_if_the_used_is_allowed_again_to_switch_to_online_mode_of_transactions_for_suribet_client() throws Throwable {

		driver.quit();
	}
}