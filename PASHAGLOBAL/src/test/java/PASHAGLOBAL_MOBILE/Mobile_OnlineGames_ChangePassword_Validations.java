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

public class Mobile_OnlineGames_ChangePassword_Validations extends Mobile_PashaGlobal_URL_Login  {
	AppiumDriver<MobileElement> driver;

	public  Mobile_OnlineGames_ChangePassword_Validations() throws InterruptedException, MalformedURLException {
			driver = Mobile_PashaGlobal_URL_Login();
		}
	
	@Given("^Mobile: Chrome browser, valid URL, valid login details, Online games link, change password window, old password textbox, new password textbox, confirm password textbox and submit button$")
	public void mobile_Chrome_browser_valid_URL_valid_login_details_Online_games_link_change_password_window_old_password_textbox_new_password_textbox_confirm_password_textbox_and_submit_button() throws Throwable {
	    
	}

	@When("^Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, click on change password link, enter old password, enter new password, enter confirm password and click on submit button$")
	public void mobile_Open_any_Online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_click_on_change_password_link_enter_old_password_enter_new_password_enter_confirm_password_and_click_on_submit_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".CHANGE_PASSWORD.all_popup_but")).click();
		Thread.sleep(5000);
		
		String pwd = driver.findElement(By.xpath("//*[@id='ChangePassword']/div/h3")).getText();
		String actual = "Change Password";
		Assert.assertEquals(pwd, actual);
		System.out.println("Page Title: " +pwd);
		
		//checking validation for entering wrong old password
		WebElement oldpwd = driver.findElement(By.id("txt_Old_Password"));
		oldpwd.sendKeys("mans@123");
		Thread.sleep(1000);
		
		WebElement newpwd = driver.findElement(By.id("txt_New_password"));
		newpwd.sendKeys("mansoor@123");
		Thread.sleep(1000);
		
		WebElement confpwd = driver.findElement(By.id("txt_chag_Confirm_Password"));
		confpwd.sendKeys("mansoor@123");
		Thread.sleep(1000);
		
		driver.findElement(By.id("changePassword")).click();
		Thread.sleep(3000);
		
		String actual1 = driver.findElement(By.xpath("//*[@id='changePassContent']/p")).getText();
		String expected1= "Not a valid old password!,Please enter a valid password";
		Assert.assertEquals(actual1, expected1);
		Thread.sleep(2000);
		System.out.println("Validation message for entering invalid old password: " +actual1);
		driver.findElement(By.xpath("//*[@id='ChangePassword']/div/h3/label")).click();
		Thread.sleep(2000);
	}

	@Then("^Mobile: System should display validation message for entering wrong old password$")
	public void mobile_System_should_display_validation_message_for_entering_wrong_old_password() throws Throwable {
		//checking validation for new password and confirm password mismatch
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".CHANGE_PASSWORD.all_popup_but")).click();
		Thread.sleep(5000);
			
		WebElement oldpwd = driver.findElement(By.id("txt_Old_Password"));
		oldpwd.sendKeys("mansoor@123");
		Thread.sleep(1000);
		
		WebElement newpwd = driver.findElement(By.id("txt_New_password"));
		newpwd.sendKeys("mansoor1@123");
		Thread.sleep(1000);
		
		WebElement confpwd = driver.findElement(By.id("txt_chag_Confirm_Password"));
		confpwd.sendKeys("mansoor2@123");
		Thread.sleep(1000);
		
		driver.findElement(By.id("changePassword")).click();
		Thread.sleep(3000);
		
		String actual1 = driver.findElement(By.xpath("//*[@id='changePassContent']/div[3]/div")).getText();
		String expected1= "* Password is not same";
		Assert.assertEquals(actual1, expected1);
		Thread.sleep(2000);

		
		newpwd.clear();
		Thread.sleep(1000);
		confpwd.clear();
		Thread.sleep(1000);
		
		newpwd.sendKeys("123456");
		Thread.sleep(1000);
		confpwd.sendKeys("123456");
		Thread.sleep(2000);
		
		driver.findElement(By.id("changePassword")).click();
		Thread.sleep(3000);
		
		String actual2 = driver.findElement(By.xpath("//*[@id='changePassContent']/div[2]/div")).getText();
		String expected2= "*Password Should contain one alpha numaric character along with minimum 6 character";
		Assert.assertEquals(actual2, expected2);
		System.out.println("Validation message for password mismatch(New/Confirm password): " +actual2);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='ChangePassword']/div/h3/label")).click();
		//Thread.sleep(2000);
	
		
		//Changing password successfully
		oldpwd.clear();
		Thread.sleep(1000);
		newpwd.clear();
		Thread.sleep(1000);
		confpwd.clear();
		Thread.sleep(1000);
		
		oldpwd.sendKeys("mansoor@123");
		Thread.sleep(1000);
		newpwd.sendKeys("mans@123");
		Thread.sleep(1000);
		confpwd.sendKeys("mans@123");
		Thread.sleep(2000);
		
		driver.findElement(By.id("changePassword")).click();
		Thread.sleep(3000);
		
		String actual3 = driver.findElement(By.xpath("//*[@id='changePassContent']/p")).getText();
		String expected3= "Password changed successfully";
		Assert.assertEquals(actual3, expected3);
		System.out.println("Confirmation message after changing password: " +actual3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ChangePassword']/div/h3/label")).click();
		Thread.sleep(2000);
		
		//Reverting new password to old password
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("pmansoorktr@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("mans@123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(8000);
		
		
		driver.findElement(By.id("HambergerMenuBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".CHANGE_PASSWORD.all_popup_but")).click();
		Thread.sleep(5000);
		
		WebElement oldpwd1 = driver.findElement(By.id("txt_Old_Password"));
		oldpwd1.sendKeys("mans@123");
		Thread.sleep(1000);
		
		WebElement newpwd1 = driver.findElement(By.id("txt_New_password"));
		newpwd1.sendKeys("mansoor@123");
		Thread.sleep(1000);
		
		WebElement confpwd1 = driver.findElement(By.id("txt_chag_Confirm_Password"));
		confpwd1.sendKeys("mansoor@123");
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("changePassword")).click();
		Thread.sleep(3000);
		
		String actual32 = driver.findElement(By.xpath("//*[@id='changePassContent']/p")).getText();
		String expected32= "Password changed successfully";
		
		System.out.println("Confirmation message after changing password after revert: " +actual32);
		Thread.sleep(1000);
		Assert.assertEquals(actual32, expected32);
		driver.findElement(By.xpath("//*[@id='ChangePassword']/div/h3/label")).click();
		Thread.sleep(2000);
		
		
	}

	@Then("^Mobile: System should display validation message if new password and confirm password are not same$")
	public void mobile_System_should_display_validation_message_if_new_password_and_confirm_password_are_not_same() throws Throwable {
	   Thread.sleep(1000);
	}

	@Then("^Mobile: System should display validation message if the entered password doesn't meet the password policy rules$")
	public void mobile_System_should_display_validation_message_if_the_entered_password_doesn_t_meet_the_password_policy_rules() throws Throwable {
		Thread.sleep(1000);
	}

	@Then("^Mobile: Password should get changed successfully and confirmation message should be displayed if all the entered data is correct and meets the password policy rules$")
	public void mobile_Password_should_get_changed_successfully_and_confirmation_message_should_be_displayed_if_all_the_entered_data_is_correct_and_meets_the_password_policy_rules() throws Throwable {
	   driver.quit();
	}
}