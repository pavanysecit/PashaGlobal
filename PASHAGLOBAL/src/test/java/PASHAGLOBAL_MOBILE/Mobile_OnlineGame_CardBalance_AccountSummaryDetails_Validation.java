package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class Mobile_OnlineGame_CardBalance_AccountSummaryDetails_Validation extends Mobile_PashaGlobal_URL_CardLogin{
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGame_CardBalance_AccountSummaryDetails_Validation() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_CardLogin();
		}

	@Given("^Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, Account Summary tab, print button and PDF file$")
	public void mobile_Chrome_browser_valid_URL_valid_Card_login_details_Online_games_link_main_balance_Account_Summary_tab_print_button_and_PDF_file() throws Throwable {

	}

	@When("^Mobile: Open any online slot game by entering the valid URL in browser, enter the valid Card login details, click on Account and print the account summary$")
	public void mobile_Open_any_online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_Card_login_details_click_on_Account_and_print_the_account_summary() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));

		//Fetch the Account ID
		WebElement element = driver.findElement(By.id("spaccountid"));
		String ID = element.getText();
		System.out.println("Account ID:  "+ID);

		// Fetch the current date
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		String date1= dateFormat.format(date);

		element.click();
		Thread.sleep(4000);
		WebElement MainBal = driver.findElement(By.xpath("//*[@id ='nav-dropbtn']/following-sibling::label"));
		String mbal = MainBal.getText();
		System.out.println("Account Main Balance: "+ mbal);

		String cardbalance=mbal+"   SRD";
//		String cardbal=null;
//		if(mbal.endsWith("0")){
//			cardbalance = mbal;
//			cardbal =cardbalance+"   SRD";
//			System.out.println(cardbal);
//		}
//		else {
//			cardbalance = mbal+"0";
//			cardbal = cardbalance+"   SRD";
//			System.out.println(cardbal);
//			System.out.println("Card Balance amount doesn't ends with '0' hence added to verify with the Account Summary.");
//		}

		WebElement AccountSummary = driver.findElement(By.xpath("//*[@id='GridAccountSummary']"));
		System.out.println("Account Summary details for the card login: "+ AccountSummary.getText());

		WebElement Account = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[1]/div[1]"));
		WebElement number = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[1]/div[2]"));
		WebElement Name = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[2]/div[1]"));
		WebElement name = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[2]/div[2]"));
		WebElement Date = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[3]/div[1]"));
		WebElement currentdate = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[3]/div[2]"));
		WebElement Balance = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[4]/div[1]"));
		WebElement balance = driver.findElement(By.xpath("//*[@id='GridAccountSummary']/li[4]/div[2]"));

		//Account Summary contains ',' hence have to replace all ',' to verify with the main balance
		String bal =balance.getText();
		String verifybal = bal.replaceAll(",", "");

		Assert.assertEquals("Account ID", Account.getText());
		Assert.assertEquals("4024953509", number.getText());
		Assert.assertEquals("Name", Name.getText());
		Assert.assertEquals("MOORTHI S,", name.getText());
		Assert.assertEquals("Date", Date.getText());
		Assert.assertEquals(date1, currentdate.getText());
		Assert.assertEquals("Balance", Balance.getText());
		Assert.assertEquals(cardbalance, verifybal);

		System.out.println("Verified the Account Summary details and are validated");

	}

	@Then("^Mobile: Verify the fetched Account Summary deatils is for the logged account$")
	public void mobile_Verify_the_fetched_Account_Summary_deatils_is_for_the_logged_account() throws Throwable {
		driver.quit();
	}
}