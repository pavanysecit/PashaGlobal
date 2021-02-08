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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class Mobile_OnlineGames_ProfileUpdate_Validation extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGames_ProfileUpdate_Validation() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}

	@Given("^Mobile: Chrome browser, valid URL, valid login details, Profile link, profile tab password, Profile update tab, submit button, successfull message$")
	public void mobile_Chrome_browser_valid_URL_valid_login_details_Profile_link_profile_tab_password_Profile_update_tab_submit_button_successfull_message() throws Throwable {

	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, click on profile link and fill the login credentials and update the profile summary$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_click_on_profile_link_and_fill_the_login_credentials_and_update_the_profile_summary() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));

		WebElement ham = driver.findElement(By.id("HambergerMenuBtn"));
		ham.click();
		Thread.sleep(2000);
		WebElement Profile = driver.findElement(By.id("UserprofileId"));
		Profile.click();
		Thread.sleep(2000);

		driver.switchTo().alert();
		Thread.sleep(2000);

		WebElement Confirmation = driver.findElement(By.xpath("//h1[@class= 'text_align_c']"));
		Assert.assertEquals("User Confirmation", Confirmation.getText());
		System.out.println("User Confirmation alert is present on the screen: "+Confirmation.isDisplayed());
		Thread.sleep(2000);

		// Submit for blank password
		WebElement submit = driver.findElement(By.xpath("//*[@onclick ='CheckUserPassword()']"));
		submit.click();
		Thread.sleep(2000);

		WebElement message = driver.findElement(By.xpath("//*[@class ='userConfPopupMGs']"));
		message.isDisplayed();
		Assert.assertEquals("Please enter password.", message.getText());
		System.out.println("The user message is displayed and the text is validated for null credentials in password field");
		Thread.sleep(1000);

		//Enter the wrong password to verify the wrng password validation message
		WebElement text = driver.findElement(By.id("txtactpassword"));
		text.click();
		Thread.sleep(1000);
		text.sendKeys("mans@1234");
		submit.click();
		Thread.sleep(4000);
		message.isDisplayed();
		Assert.assertEquals("The password entered is wrong", message.getText());
		System.out.println("The user message is displayed and the text is validated for wrong credentials");
		Thread.sleep(1000);

		//Pass the valid credentails to access profile form
		text.clear();
		Thread.sleep(1000);
		text.click();
		Thread.sleep(1000);
		text.sendKeys("mansoor@123");
		submit.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class ='Qr_code_w']/img")));

		//Update the First Name 
		WebElement FirstName = driver.findElement(By.id("profile_first_name"));
		String Before = FirstName.getAttribute("value");
		System.out.println("Before chnaging the name: "+Before );
		Assert.assertEquals("MANSOOR", Before);

		FirstName.click();
		Thread.sleep(1000);
		FirstName.clear();
		Thread.sleep(1000);
		String After = "MANS";
		FirstName.sendKeys(After);
		Thread.sleep(1000);

		// submit the changes
		WebElement update = driver.findElement(By.id("UserProfile"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", update);
		Thread.sleep(2000);
		WebElement UserMsg = driver.findElement(By.id("UserprofileMessage"));

		//Scrolling till the visibility of the Submit and update text 
		WebElement currency = driver.findElement(By.id("UserProfileCurrency"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currency);
		Thread.sleep(1000);
		UserMsg.isDisplayed();
		Assert.assertEquals("Account Details updated successfully", UserMsg.getText());
		System.out.println("User succesfully updated the profile");
		Thread.sleep(2000);

		TouchAction action = new TouchAction(driver); 
		action.tap(PointOption.point(168,1040)).perform();
		action.tap(PointOption.point(168,1040)).perform();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(3000);
		WebElement close = driver.findElement(By.xpath("//*[@id='ProfileDispaly']/form/div/h3/label"));
		close.click();
		Thread.sleep(2000);

		//Verify at the Account Summary for the updated user name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spaccountid")));

		WebElement Account = driver.findElement(By.id("spaccountid"));
		Account.click();
		Thread.sleep(2000);

		driver.switchTo().alert();
		Thread.sleep(2000);

		WebElement Name = driver.findElement(By.xpath("//*[@id ='GridAccountSummary']/li[2]/div[2]"));
		String name = Name.getText();
		Assert.assertEquals("MANS ALI", name);
		System.out.println("User First name changes reflected in Account Summary Name field and validated");

		//Reverting the changes as its Live Accounts 
		ham.click();
		Thread.sleep(2000);
		Profile.click();
		Thread.sleep(2000);
		driver.switchTo().alert();
		Thread.sleep(2000);
		text.sendKeys("mansoor@123");
		submit.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Qr_code_w")));

		//Change the name to older 
		WebElement FirstName1 = driver.findElement(By.id("profile_first_name"));
		FirstName1.click();
		Thread.sleep(1000);
		Assert.assertEquals(After, "MANS");
		Thread.sleep(1000);
		System.out.println("Validated before reverting the name as to verify the name been updated previously");
		Thread.sleep(1000);
		FirstName1.clear();
		Thread.sleep(1000);
		FirstName1.sendKeys("MANSOOR");
		Thread.sleep(1000);
		System.out.println("Updated the old name in the text field");

		WebElement currency1 = driver.findElement(By.id("UserProfileCurrency"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currency1);
		Thread.sleep(1000);
		
		action.tap(PointOption.point(168,1040)).perform();
		action.tap(PointOption.point(168,1040)).perform();
		Thread.sleep(2000);
		
		WebElement update1 = driver.findElement(By.id("UserProfile"));
		js.executeScript("arguments[0].click();", update1);
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(3000);
		WebElement close1 = driver.findElement(By.xpath("//*[@id='ProfileDispaly']/form/div/h3/label"));
		close1.click();
		Thread.sleep(2000);
		System.out.println("Reverting to old name is completed");
	}

	@Then("^Mobile: Fill the profile link with invalid credentials and validate the user message$")
	public void mobile_Fill_the_profile_link_with_invalid_credentials_and_validate_the_user_message() throws Throwable {

	}

	@Then("^Mobile: Updated profile must be reflected in the same Profile tab$")
	public void mobile_Updated_profile_must_be_reflected_in_the_same_Profile_tab() throws Throwable {
		driver.quit();
	}
}